package thread.bank;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//인터페이스를 추가하면 반드시 구현체 클래스가 되기 위해서 추상메소드를 재정의해야한다. - 규칙
//run 메소드를 오버라이딩해야 한다는 거다.
//이 메소드 안에서는 무엇을 하지? - 기다리는거[Thread.sleep(1000) 1초] 
//, 듣기[ois.readObject()]와 말하기[oos.writeObject("메세지")] 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import design.book.TimeServerThread;

public class ServerBank extends JFrame implements Runnable {
	//전역변수 선언하기 시작
	Socket socket = null; //복사본이 아니라 원본을 사용할거니까 반드시 null로 초기화 개인의 소켓 여러개가 된다.
	//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠
	int port = 3000; //서버파트에 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea(); // 화면
	JScrollPane jsp_log = new JScrollPane(jta_log // 스크롤바 
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // 이건 찾아봐라
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER은 화면에 직접 적용 안한다는 거임
	//메인메소드는 entry point이다.
	//메인 스레드라고도 한다. - 경합이 벌어진다.
	//화면처리와 서버개통하기 사이에 경합 이것을 방지하기위해 인터페이스 Runnable 추가
	//스레드 클래스의 run메소드는 어떻게 호출하지?
	public static void main(String[] args) {
		ServerBank sb = new ServerBank();
		sb.initDisplay(); // 화면이 run보다 먼저 호출
		//어떻게 해결하지? - 일단 Thread를 인스턴스화 하고 생성자에 구현체클래스를 넣어줌
		Thread th = new Thread(sb);
		//sb.start();  호출불가임 왜냐하면 스레드를 상속받지 않았으니까 - 결국 난 스레드가 아님
		th.start(); // 이런식으로 Thread의 start메소드 = run메소드를 호출한다
	}

	@Override
	public void run() {//서버소켓이 생성하고 기다리는 기능
		JOptionPane.showMessageDialog(this, "run호출 성공  - 스레드 가동 중"); //다이얼로그 창뜸
		try {
			server = new ServerSocket(port); //접속가능하게하고 기다리는중..클라이언트가 언제올까?(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}
		jta_log.append("ServerBank started successfully.....\n");//다잉테스트
		while(true) { //while(true){}무한루프 - 탈출불가 
			try { // 네트워크라 예외 처리 꼭해야함
		//클라이언트 측에서 접속해온 정보를 client 소켓에게 넘김
				socket = server.accept();//대기 클라이언트 응대 - accept()
				jta_log.append("New Client connected...."+socket.toString()+"\n");//클라이언트의 정보가 출력
//				tst = new TimeServerThread(this);//부모 클래스 정보받기위해
//				tst.start();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	//화면이용
	public void initDisplay() { //TimeServer의 init에서 입양
		this.setTitle("ServerBank 로그창");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
}
