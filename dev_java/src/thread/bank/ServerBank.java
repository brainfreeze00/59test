package thread.bank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//인터페이스를 추가하면 반드시 구현체 클래스가 되기 위해서 추상메소드를 재정의해야한다. - 규칙
//run 메소드를 오버라이딩해야 한다는 거다.
//이 메소드 안에서는 무엇을 하지? - 기다리는거[Thread.sleep(1000) 1초] 
//, 듣기[ois.readObject()]와 말하기[oos.writeObject("메세지")] 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class ServerBank extends JFrame implements Runnable {
	//전역변수 선언하기 시작
	Socket socket = null; //복사본이 아니라 원본을 사용할거니까 반드시 null로 초기화 개인의 소켓 여러개가 된다.
	//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠
	int port = 3000; //서버파트에 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea(12,30); // 12크기에 30자
	JScrollPane jsp_log = new JScrollPane(jta_log // 스크롤바 
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // 이건 찾아봐라
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER은 화면에 직접 적용 안한다는 거임
	String cols[] = {"접속시간","접속자","메세지","상태"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm_history = new DefaultTableModel(data,cols);
	JTable jtb_history = new JTable(dtm_history); 
	JScrollPane jsp_history = new JScrollPane(jtb_history
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//클라이언트에서 접속해온 사용자에 대한 스레드를 담기위한 List선언
	//일단 선언만 해두었다가 서버 소켓이 개설되기 직전에 인스턴스화한다.
	//List는 인터페이스이므로 단독으로 인스턴스화 불가하니까 구현체 클래스중에서
	//여러 사람을 손실없이 관리 할 수 있는 Vector객체를 생성 할 것
	//클라이언트가 접속을 했을때 스레드를 가동 시킨다.
	//ServerBankThread가 서버측에서 생성한 클래스이지만 그 안에 담긴 정보는 클라이언트에
	//대한 정보를 담고 있다.
	//클라이언트가 접속 성공하면 일반소켓에게 서버소켓이 수집한 정보를 넘김
	//이 정보를 넘겨받으면 그 안에 클라이언트 정보가 담김
	//스레드가 생성되었을때 그때 Vector안에 add처리 할것 그래야 그사람 정보를 유지가능
	//담는 작업은 스레드가 생성되었을때 거의 동시에 일어나는 사건이므로 생성자 안에서 처리
	List<ServerBankThread> globalList = null;
	ServerBankThread sbt = null; // accept 했을때 인스턴스화 run() 안에
	CustomerDao cDao = new CustomerDao(); // 이안에 this를 쓰는 순간 부모에게 의존도가 생김
	//메인메소드는 entry point이다.
	//메인 스레드라고도 한다. - 경합이 벌어진다.
	//화면처리와 서버개통하기 사이에 경합 이것을 방지하기위해 인터페이스 Runnable 추가
	//스레드 클래스의 run메소드는 어떻게 호출하지?
	
	public static void main(String[] args) {
		ServerBank sb = new ServerBank(); // 인스턴스화
		sb.initDisplay(); // 화면이 run보다 먼저 호출
		//어떻게 해결하지? - 일단 Thread를 인스턴스화 하고 생성자에 구현체클래스를 넣어줌
		Thread th = new Thread(sb); // 스레드 인스턴스화
		//sb.start();  호출불가임 왜냐하면 스레드를 상속받지 않았으니까 - 결국 난 스레드가 아님
		th.start(); // 이런식으로 Thread의 start메소드 = run메소드를 호출한다
	}

	@Override
	public void run() {//서버소켓이 생성하고 기다리는 기능
		globalList = new Vector<ServerBankThread>();
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
				//그사람의 정보를 관리해야하기에 this-ServerBank자신 -원본-생성자호출
				sbt = new ServerBankThread(this);//부모 클래스 정보받기위해- 그사람의 정보를 관리해야하기에 this-ServerBank자신 -원본
				sbt.start();//스레드에 구현된 run() 호출
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	//화면이용
	public void initDisplay() { //TimeServer의 init에서 입양
		//윈도우 창에서 X버튼 클릭했을 때 이벤트처리
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {//사용 자원 반납하기
					server.close();
					socket.close();
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		this.setTitle("ServerBank 로그창");
		this.add("West",jsp_log);
		this.add("Center",jsp_history);
		this.setSize(900, 400);
		this.setVisible(true);
	}
}
