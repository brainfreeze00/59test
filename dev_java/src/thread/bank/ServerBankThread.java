package thread.bank;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;


public class ServerBankThread extends Thread {
	ServerBank sb = null;
	ObjectOutputStream oos = null; // 듣다가 끊길수 있으니까 예외처리
	ObjectInputStream ois = null; // 말하다가 멈출수 있으니까 생성자에서 try..catch 안에서 인스턴스(서버의 소켓의 겟스트림)
	String nickName = null; // 닉네임 뭘로 할지 모르니깐 null
	//생성자에 파라미터 자리에 있는 클래스와 의존관계에 있다.
	String mem_name = null;
	public ServerBankThread(ServerBank sb) {
		this.sb = sb;
		try {
			oos = new ObjectOutputStream(sb.socket.getOutputStream());//웬만해선 말하기부터먼저
			ois = new ObjectInputStream(sb.socket.getInputStream());
			//서버측에서 클라이언트가 보낸 메세지 청취완료
			String msg = (String)ois.readObject();
			sb.jta_log.append(msg+"\n");
			//메세지 분할해서 보내야하니까
			StringTokenizer st = null;
			//msg 100#진아 100#정훈 100#진완 클래스와 변수는 하나이지만 쓰레드마다 닉넴을 따로 저장해야한다.
			//문제 닉넴은 지역변수니? 전역변수니? - 정답: 스레드를 통해서 구분해야하므로 전역변수로 해야함

			//			for(ServerBankThread sbt:sb.globalList) {// 진완에게 기존에 먼저 왔던 진아, 정훈의 스레드를 전달
			//				sbt.nickName?
			//			}
			if(msg!=null) {
				st = new StringTokenizer(msg,"#");
			}
			st.nextToken();// 100
			//로그인과 관련된 구간
			nickName = st.nextToken();// 진아, 정훈, 진완 - 고로 nickName에 담아준다.
			login(nickName);
			
			
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		}
	}
	//로그인 처리 구현
	public void login(String mem_id) {
		Map<String, Object> rMap = null; 
		rMap = sb.cDao.login(mem_id); // SeverBank에서 인스턴스화 했으니까 sb.붙임
		if(rMap !=null) {//로그인 성공했을때 100
			String currentName = null;
			String msg2 = null;
			//아무도 접속하지않았으니  크기가 정해지지않았기에 for문이 돌지 못하고 null을 출력하게 된다.
			//그러므로 3문장을 for문에서 벗어난다
			currentName = rMap.get("mem_name").toString();
			msg2 = 100+"#"+currentName;
			mem_name =msg2;
			for(ServerBankThread sbt:sb.globalList) {// 진완에게 기존에 먼저 왔던 진아, 정훈의 스레드를 전달
				//currentName = sbt.nickName;
				//msg2 = 100+"#"+currentName;
				// this.send(msg2);
				this.send(sbt.mem_name); 
			}
			Vector<String> v = new Vector<>();
			v.add(setTimer());
			v.add(nickName);
			v.add(100+"#"+rMap.get("mem_name").toString()); // v.add(100+"#"+mem_id);
			v.add("로그인");
			sb.dtm_history.addRow(v);
			sb.globalList.add(this); //ServerBankThread this=진완스레드
			this.broadCasting(100+"#"+rMap.get("mem_name").toString());//msg = 100#진완 을 넘긴다.
		}
		else {//실패 했을때 110
			for(ServerBankThread sbt:sb.globalList) {// 진완에게 기존에 먼저 왔던 진아, 정훈의 스레드를 전달
				this.send(110+"#"+mem_id+"님은 로그인 실패입니다.");
			}
			this.broadCasting(110+"#"+mem_id+"님은 로그인 실패입니다.");//msg = 100#진완 을 넘긴다.
		}
	}
	//현재 서버에 접속한 모든 사용자에게 시간정보를 방송하기 구현 여러명에게 전달
	
	public void broadCasting(String msg) {
			//현재 서버에 몇 사람이 있는지 출력하기
			sb.jta_log.append("현재 인원수 : "+sb.globalList.size());
			synchronized(this) {//다른 스레드가 인터셉트 하는 것을 방어하기 위해 동기화처리
				for(ServerBankThread sbt:sb.globalList) { // 기존에 있던 사람들도 전달이 되어야 하므로
					sbt.send(msg); // this 쓸때 -지금들어온너에게만 전달  
				}
			}
		}//////broadCasting
		//서버에서 클라이언트에게 전송하는 메세지 구현
	public void send(String msg) {
			try {
				oos.writeObject(msg);
			} catch (Exception e) {
				e.printStackTrace(); //예외 발생시 에러 메세지 history출력
			}
		}///////send
	//서버는 클라이언트와는 달리 들은 내용을 즉시(입장해 있는 사람들) 전달해야 하므로
	//run메소드에서 듣기ois와 말하기oos를 동시에 진행함
	public void run() {
		sb.jta_log.append(sb.socket+"님의 정보를 관리해야함.-생성자에서 추가");//sb의 소켓
	}
	public String setTimer() {
		Calendar cal = Calendar.getInstance(); //class 카렌다는 이런식의 인스턴스를 해야함
		int yyyy = cal.get(Calendar.YEAR);
		int mm 	 = cal.get(Calendar.MONTH)+1;
		int day  = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY); //1~24
		int min  = cal.get(Calendar.MINUTE);
		int sec  = cal.get(Calendar.SECOND);
		return yyyy+"-"+
			(mm < 10 ? "0"+mm:""+mm)+":"+ 
			(day < 10 ? "0"+day:""+day)+" "+ 
			(hour < 10 ? "0"+hour:""+hour)+":"+ 
			(min < 10 ? "0"+min:""+min)+":"+ 
			(sec < 10 ? "0"+sec:""+sec); 
	}
}
