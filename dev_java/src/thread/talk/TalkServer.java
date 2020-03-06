package thread.talk;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import thread.bank.ServerBankThread;

public class TalkServer extends JFrame implements Runnable {
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
	List<Login> globalList = null;
	TalkServerThread tst = null;
	TalkDao tDao = new TalkDao();

	public static void main(String[] args) {//서버는 로그인 안하니까 당연 있어야함
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts);
		th.start();
	}
	//서버 소켓과 클라이언트측 소켓을 연결하기
	@Override
	public void run() {
		globalList = new Vector<Login>();
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
				tst = new TalkServerThread(this);//부모 클래스 정보받기위해- 그사람의 정보를 관리해야하기에 this-ServerBank자신 -원본
				tst.start();//스레드에 구현된 run() 호출
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
			this.setTitle("TalkServer 로그창");
			this.add("West",jsp_log);
			this.add("Center",jsp_history);
			this.setSize(900, 400);
			this.setVisible(true);
		}

}
