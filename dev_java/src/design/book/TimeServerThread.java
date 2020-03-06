package design.book;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TimeServerThread extends Thread {
	TimeServer ts = null;
	ObjectInputStream ois = null;//읽기 - 듣기
	ObjectOutputStream oos = null;//말하기 - 쓰기
	String time = "10:20:35";
	public TimeServerThread(TimeServer ts) { // 생성자에서 호출하면 한번만 
		this.ts = ts; // 전역변수 ts에 파라미터 ts를 대입한다.
		try {
			oos  = new ObjectOutputStream(ts.socket.getOutputStream()); //개인의 소켓
			//클라이언트가 말한 내용을 듣기
			ois = new ObjectInputStream(ts.socket.getInputStream());
			//TimeServer에서 정의한 setTimer메소드에서 현재 장치에 시간정보 가져오기
			time = ts.setTimer();
			oos.writeObject(time);
			//내가 입장하기 전에 있던 친구들에게 전송하기
			for(TimeServerThread tst : ts.globalList) { //개선for문  클래스타입 변수 : 수식이나 주소번지
				this.send(time);//니가 오기전에 있던 기존 아이들의 정보를 니에게 말해주는것
			}
			ts.globalList.add(this); // 스레드 그사람클래스를 리스트에 add한다. 
			this.broadCasting(time); // 현재 들어와있는 사람스레드  = this  - 사용자가 이용할때마다 인스턴스
		} catch (Exception e) {
			System.out.println("TimeServerThread:"+e.toString());
		}
	}
	//현재 서버에 접속한 모든 사용자에게 시간정보를 방송하기 구현 여러명에게 전달
	
	public void broadCasting(String msg) {
		//현재 서버에 몇 사람이 있는지 출력하기
		ts.jta_log.append("현재 인원수 : "+ts.globalList.size());
		synchronized(this) {//다른 스레드가 인터셉트 하는 것을 방어하기 위해 동기화처리
			for(TimeServerThread tst:ts.globalList) { // 기존에 있던 사람들도 전달이 되어야 하므로
				tst.send(msg); // this 쓸때 -지금들어온너에게만 전달  
				//, tst 쓸때 다른거임 - 기존에 있는 사람들+들어온 너에게 모두전달
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
	public void run() {
		while(true) {
			try {
				//TimeServer에서 정의한 setTimer메소드에서 현재 장치에 시간정보 가져오기
				time = ts.setTimer();
				oos.writeObject(time);
				sleep(1000); //1초동안 지연시키기
			}catch (IOException ie) {	
				System.out.println(ie.toString());
			} catch (InterruptedException ie) {
				System.out.println("다른 쓰레드가 새치기를 했을 때");
			}
		}//while
	}//run
}//class
