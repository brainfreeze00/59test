package thread.talk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.StringTokenizer;

import thread.bank.Protocol;
import thread.bank.ServerBankThread;

public class TalkServerThread extends Thread {
	Login l = null;
	public TalkServer ts = null;
	ObjectOutputStream oos = null; // 듣다가 끊길수 있으니까 예외처리
	ObjectInputStream ois = null; // 말하다가 멈출수 있으니까 생성자에서 try..catch 안에서 인스턴스(서버의 소켓의 겟스트림)
	String nickName = null; // 닉네임 뭘로 할지 모르니깐 null
	//생성자에 파라미터 자리에 있는 클래스와 의존관계에 있다.
	String mem_name = null;
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.socket.getOutputStream());//웬만해선 말하기부터먼저
			ois = new ObjectInputStream(ts.socket.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,"#");
			}
			st.nextToken();// 100
			nickName = st.nextToken();// 진아, 정훈, 진완 - 고로 nickName에 담아준다.
			l.login(nickName);
			
			
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		}
	}
	public void run() {
		boolean isStop = false;
		while(!isStop) { //while(true) { 이런 while 코드는 하수임
			int protocol = 0;
			switch(protocol) {
			case Protocol.LOGIN:{
				
			}break;
			case Protocol.EXIT:{
				
			}break;
			}//switch
		}//while
	}
	public void broadCasting(String msg) {
		//현재 서버에 몇 사람이 있는지 출력하기
		ts.jta_log.append("현재 인원수 : "+ts.globalList.size());
		synchronized(this) {//다른 스레드가 인터셉트 하는 것을 방어하기 위해 동기화처리 : 클라이언트들에게 맞는 순서대로 하기위해 동기화 처리
//			for(TalkServerThread tst:ts.globalList) { // 기존에 있던 사람들도 전달이 되어야 하므로
//				tst.send(msg); // this 쓸때 -지금들어온너에게만 전달  
//			}
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
