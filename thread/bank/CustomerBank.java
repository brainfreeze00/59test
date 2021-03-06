package thread.bank;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerBank extends JFrame {
	Socket socket = null;
	ObjectInputStream ois = null;//읽기 - 듣기
	ObjectOutputStream oos = null;//말하기 - 쓰기
	String mem_id = null; //선언
	JPanel jp_south = new JPanel(); // 화면에 timer 붙일거임 맨 아래에
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER); // 타임클라이언트에서 입양 init에서 써야하니까
	JTextArea jta_clog = new JTextArea(8,30);
	JScrollPane jsp_clog = new JScrollPane(jta_clog
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public CustomerBank() {
		mem_id = JOptionPane.showInputDialog("아이디를 입력하세요.");
		if(mem_id == null) { //이게 있어야 화면을 열어준다.
			return; //생성자 탈출 - 아래 메소드2개는 호출이 안돼요.
		}
		initDisplay();
		connect_process();
	}
	
	//화면
	private void initDisplay() {
		jp_south.setLayout(new BorderLayout()); //배치를위한 설정 - 중앙, 남쪽
		jp_south.add("Center",jsp_clog); 
		jp_south.add("South",jlb_time);
		this.setTitle(mem_id +"님 계좌입니다."); // 전역변수 mem_id
		//this.add("Center",jsp_clog);
		this.add("South",jp_south); // 시간 아래 붙이장
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	//서버에 접속하기 구현
	public void connect_process() {                                    //    TimeClient 입양
		try {                                                          //    TimeClient
			socket = new Socket("192.168.0.240",3000);//서버 ip,port     //    TimeClient
			oos  = new ObjectOutputStream(socket.getOutputStream());   //    TimeClient
			//클라이언트가 말한 내용을 듣기                            //    							 TimeClient
			ois = new ObjectInputStream(socket.getInputStream());      //    TimeClient
			oos.writeObject(100+"#"+mem_id); // 카톡사진에 있는 그 문장     			 TimeClient
		} catch (Exception ie) {                                       //    TimeClient
			System.out.println("은행 서버에 접속할 수 없습니다.");     //  			 TimeClient
		}	                                                           //    TimeClient
	}
	
	//타임에 접속하기 구현
	public void time_process() {
		
	}
	
	//메인
	public static void main(String[] args) {
		CustomerBank cb = new CustomerBank();
		
	}

}
