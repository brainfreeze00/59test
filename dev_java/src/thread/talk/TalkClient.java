package thread.talk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import thread.bank.CustomerBankThread;

public class TalkClient extends JFrame {
	Socket socket = null; // 소켓 - 전역변수
	ObjectInputStream ois = null;//읽기 - 듣기
	ObjectOutputStream oos = null;//말하기 - 쓰기
	String mem_id = null; //선언
	JPanel jp_center = new JPanel();
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_nickName = new DefaultTableModel(data,cols);
	JTable jtb_nickName = new JTable(dtm_nickName); 
	JScrollPane jsp_nickName = new JScrollPane(jtb_nickName
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_south = new JPanel(); // 화면에 timer 붙일거임 맨 아래에
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER); // 타임클라이언트에서 입양 init에서 써야하니까
	JTextArea jta_clog = new JTextArea(8,30);
	JScrollPane jsp_clog = new JScrollPane(jta_clog
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public TalkClient(){
		mem_id = JOptionPane.showInputDialog("아이디를 입력하세요.");
		if(mem_id == null) { //이게 있어야 화면을 열어준다.
			return; //생성자 탈출 -즉 아이디가 null일때 아래 메소드2개는 호출이 안돼요.
		}
		initDisplay(); // 생성자에서 화면 호출
		connect_process(); // 생성자에서 타임접속호출
	}
	public void initDisplay() {
		jp_south.setLayout(new BorderLayout()); //배치를위한 설정 - 중앙, 남쪽
		jp_center.setLayout(new GridLayout(1,2)); //배치를위한 설정 - 중앙, 남쪽
		jp_center.add(jsp_nickName);
		jp_south.add("Center",jsp_clog); //센터방향에 JSCrollpane 붙임
		jp_south.add("South",jlb_time); // South방향에 현재시간 붙임
		this.setTitle(mem_id +"님의 채팅창입니다."); // 전역변수 mem_id
		this.add("Center",jp_center);
		this.add("South",jp_south); // 시간 아래 붙이장
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public void connect_process() {
		try {                                                          //    TimeClient
			socket = new Socket("192.168.0.240",3000);//서버 ip,port     //    TimeClient
			oos  = new ObjectOutputStream(socket.getOutputStream());   //    TimeClient
			//클라이언트가 말한 내용을 듣기                            //    							 TimeClient
			ois = new ObjectInputStream(socket.getInputStream());      //    TimeClient
			oos.writeObject(100+"#"+mem_id); // 카톡사진에 있는 그 문장     			 TimeClient
			//커스텀뱅크스레드 인스턴스화 후 start()호출
			TalkClientThread tct = new TalkClientThread(this); 
			tct.start();
		} catch (Exception ie) {                                       //    TimeClient
			System.out.println("은행 서버에 접속할 수 없습니다.");     //  			 TimeClient
		}	                                                      	
	}
}
