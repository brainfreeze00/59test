package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.util.DBConnectionMgr;
/*Main 에서 결정된 정보들 예를 들면 입력버튼, 수정버튼, 그리고 또.....
 * 한 건을 조회한 결과를 담고 있는  BookVO객체 혹은  Map객체까지도 담을수 있는
 * set메소드를 추가하시오
 * 
 * BookMain을 인스턴스화 할 대 전역변수에 선언된  BookDialog도 같이 인스턴스화를 한다.
 * 이때 파라미터로 넘어간 boolea,String은 값이 이미 결정된 상태이므로 아무리 버튼을
 * 바꾸어눌렀어도 title의 값은 변하지 않는 것이다.
 * 
 * 생성자가 호출되는 시점과 이벤트가 감지되는 시점사이의 차이가 발생하였다.
 * 
 * public void set(제목,수정유무,Map){}  
 */

public class BookApp extends JFrame implements ActionListener {
	//선언부
	static BookApp ba 		= null; //메인메소드 static때문에 외부 접근이 안되어 따로 전역변수 선언
	//파라미터가 없는 생성자는 디폴드로 지원해주지만 있는 경우는 예측불가이므로 지원불가함
	BookDialog bd 			= new BookDialog(); //바깥쪽에 처리하기위해 직접 파라미터에 입력
	DBConnectionMgr dbMgr   = DBConnectionMgr.getInstance();
	Connection          con = null; // 전역변수선언하기 - 클래스 전역에서 사용가능함.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	//jp_north속지는 JFrame 북쪽에 배치
	JPanel      jp_north 	= new JPanel();
	//아래 버튼은 jp_north속지에 차례대로 배치 단 위치는 왼쪽부터
	JButton     jbtn_all 	= new JButton("전체조회");
	JButton     jbtn_sel 	= new JButton("상세조회");
	JButton     jbtn_ins 	= new JButton("입력");
	JButton     jbtn_upd 	= new JButton("수정");
	JButton     jbtn_del 	= new JButton("삭제");
	JLabel jlb_time 		= new JLabel("현재시간",JLabel.CENTER);
	TimeClient tc 			= null; //클라이언트에서 듣고 앱에서 출력하기위해 전역변수로 선언후 
	// initDisplay에 인스턴스화하여 start메소드 호출
	
	//화면 그리기
	public void initDisplay() {
		//실제로 타임서버로 부터 시간정보를 듣기는 TimeClient에서 진행 되지만 
		//생성자의 파라미터를 통해서 BookApp jlb_time 원본의 주소번지를
		//넘겼으므로 TimeClient에서는 원본에 직접 써주면 화면에 보임.
		tc = new TimeClient(jlb_time); 
		tc.start();
		String time = null;
		con = dbMgr.getConnection(); 
		//insert here
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_all);
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		//아래코드가 JFrame의 자원을 회수함
		//부모 자원이 회수 될때 JDialog도 같이 회수됨
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //main+sub둘다 닫기
		this.setTitle("도서관리시스템");
		this.add("North",jp_north);//JPanel 화면 넣기
		this.add("South",jlb_time);//JPanel 화면 넣기
		this.setSize(700, 500);
		this.setVisible(true);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
	}
	//메인메소드
	public static void main(String[] args) {
		TimeServer ts = new TimeServer();//파라미터 - 소켓 client
		/*지속적으로 1초에 한번씩 기다렸다 찍어야할때 쓰레드가 필요하다.
		 *쓰레드 : 기다림을 메소드로 지원  1000 = 1초 sleep 기다려 
		 */
		ts.initDisplay(); //화면을 그리고  난뒤 스레드 대기를 타도록 해야함
		Thread th = new Thread(ts);
		th.start();//java.lang.Thread 스레드의 run메소드를 호출하는 메소드 - 쓰레드를 동작시킴
		ba = new BookApp(); // 스태틱때문에 타입이랑 같이 인스턴스화 하면 안되징!
		ba.initDisplay();
	}
//JButton에 대한 이벤트를 지원하는 인터페이스가 ActionListener임.
	//클래스 뒤에 implements할것 
	//ActionListener에 정의된 추상메소드를 재정의할것
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 클래스의 주소번지 받기
		Object obj = e.getSource();
		//입력버튼을 누른거니?
		if(obj==jbtn_ins) {
			System.out.println("입력호출성공");
			bd.set(jbtn_ins.getText(),true, true, null, ba);
			//initDisplay를 호출한 이유는 setTitle("입력")과 setVisible(true)
			//때문이었다. 그런데 그 둘을 set메소드로 이전하였다.
			//insert here
		}
		else if(obj==jbtn_upd) {//수정시에는 먼저 기본 정보를 조회하고 화면이동처리
			System.out.println("수정호출성공");
			//select처리한 후 한 개 로우를 받아서 Map에 저장
			Map<String, Object> rMap = null; //조회한 후에 담아야함
			rMap = new HashMap<>();
			rMap.put("b_title", "자바의 정석");
			rMap.put("b_author", "남궁성");
			rMap.put("b_publish", "도우출판");
			bd.set(jbtn_upd.getText(),true, true, rMap, ba);
		}
		else if(obj==jbtn_sel) {
			System.out.println("상세조회호출성공");
			Map<String, Object> rMap = null; //조회한 후에 담아야함
			bd.set(jbtn_sel.getText(),true, false, rMap, ba);
		}
		else if(obj==jbtn_del) {
			System.out.println("삭제호출성공");
			
		}
		else if(obj==jbtn_all) {
			System.out.println("전체조회호출성공");
			
		}
	}
	public void refreshData() {
		System.out.println("refreshData 호출 성공");
	}

}
