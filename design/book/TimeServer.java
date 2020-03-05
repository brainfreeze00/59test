package design.book;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/* 서버소켓에 접근할려면 ip , port num 필요
 * 서버소켓 : 물리적 거리를 해결해줌 
 * 대문 : 포트번호
 * 
 * 자바에서는 단일 상속만 가능함.
 * 다중 상속이 필요할 땐 인터페이스로 대신한다.
 * 여기서 처럼 JFrame을 이미 상속 받은 경우 Thread를 또 상속받을수 없다.
 * 이런경우를 지원하기 위해서 Runnable이라는 인터페이스를 지원함.
 * 
 */
public class TimeServer extends JFrame implements Runnable {
	Socket socket = null; //복사본이 아니라 원본을 사용할거니까 반드시 null로 초기화 개인의 소켓 여러개가 된다.
	//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠
	int port = 3000; //서버파트에 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // 이건 찾아봐라
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER은 화면에 직접 적용 안한다는 거임
	List<TimeServerThread> globalList = null;
	TimeServerThread tst = null;
	//생성자
	public TimeServer() {
	}
	//시간 찍어주는 메소드
	public String setTimer() {
		Calendar cal = Calendar.getInstance(); //class 카렌다는 이런식의 인스턴스를 해야함
		int hour = cal.get(Calendar.HOUR_OF_DAY); //1~24
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour:""+hour)+":"+ 
			   (min < 10 ? "0"+min:""+min)+":"+ 
			   (sec < 10 ? "0"+sec:""+sec); 
	}
	public void run() {//지연처리 가능, 들은 정보를 내보낼수 있다, 1초에 한번씩 시간정보를 내보낸다.
		globalList = new Vector<>();
		try {
			server = new ServerSocket(port); //접속가능하게하고 기다리는중..클라이언트가 언제올까?(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true) { //while(true){}무한루프 - 탈출불가 
			try { // 네트워크라 예외 처리 꼭해야함
		//클라이언트 측에서 접속해온 정보를 client 소켓에게 넘김
				socket = server.accept();//대기 클라이언트 응대 - accept() 그사람의 소켓에 스트림에 저장 
				jta_log.append("TimeServer started successfully.....\n");//다잉테스트
				jta_log.append("New Client connected...."+socket.toString()+"\n");//클라이언트의 정보가 출력
				tst = new TimeServerThread(this);//부모 클래스 정보받기위해
				tst.start();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	/*
	 * main 메소드 안에서 만들어진 정보를 run 메소드에서 사용하려면 생성자를 통해서
	 * 초기화를 해주어야한다.
	 * 복사본을 사용하는 것이 아니라 메인에서 접속한 클라이언트의 원본을 사용해야하니까
	 */
	public static void main(String[] args) {
	 TimeServer ts =	new TimeServer();
	 ts.initDisplay();
	 Thread th = new Thread(ts);
	 th.start();
	}//main
	public void initDisplay() {
		this.setTitle("TimeServer 로그");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
}
