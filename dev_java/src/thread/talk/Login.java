package thread.talk;

import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;

import thread.bank.ServerBankThread;

public class Login extends JFrame {
	TalkServer ts = null;
	String mem_id = null;
	String nickName = null;
	TalkServerThread tst = null;
	public Login(String mem_id) {
		this.mem_id=mem_id;
		}
	public void login(String mem_id) {
		Map<String, Object> rMap = null; 
		rMap = ts.tDao.login(mem_id); // SeverBank에서 인스턴스화 했으니까 sb.붙임
		if(rMap !=null) {//로그인 성공했을때 100
			String currentName = null;
			String msg2 = null;
			//아무도 접속하지않았으니  크기가 정해지지않았기에 for문이 돌지 못하고 null을 출력하게 된다.
			//그러므로 3문장을 for문에서 벗어난다
			currentName = rMap.get("mem_name").toString();
			msg2 = 100+"#"+currentName;
			mem_id =msg2;
//			for(TalkServerThread tst:ts.globalList) {// 진완에게 기존에 먼저 왔던 진아, 정훈의 스레드를 전달
//				//currentName = sbt.nickName;
//				//msg2 = 100+"#"+currentName;
//				// this.send(msg2);
//				this.tst.send(tst.mem_name); 
//			}
			Vector<String> v = new Vector<>();
			v.add(tst.setTimer());
			v.add(nickName);
			v.add(100+"#"+rMap.get("mem_name").toString()); // v.add(100+"#"+mem_id);
			v.add("로그인");
			ts.dtm_history.addRow(v);
			ts.globalList.add(this); //ServerBankThread this=진완스레드
			this.tst.broadCasting(100+"#"+rMap.get("mem_name").toString());//msg = 100#진완 을 넘긴다.
		}
		else {//실패 했을때 110
//			for(TalkServerThread sbt:ts.globalList) {// 진완에게 기존에 먼저 왔던 진아, 정훈의 스레드를 전달
//				this.tst.send(110+"#"+mem_id+"님은 로그인 실패입니다.");
//			}
			this.tst.broadCasting(110+"#"+mem_id+"님은 로그인 실패입니다.");//msg = 100#진완 을 넘긴다.
		}
	}
	public static void main(String[] args) { // 덕분에 TalkClient, Thread는 메인메소드 필요없어짐
		TalkClient tc = new TalkClient();
		
	}

}
