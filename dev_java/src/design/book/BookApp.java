package design.book;
//MVC 패턴 검색
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

import javafx.scene.image.Image;
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
	//DB커넥션 연결하기
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//이미지 경로 추가
	String imgPath = "src\\design\\book\\"; //이미지가 존재하는 경로 
	URL bookURL = getClass().getResource("book.jpg"); // 파일 이름
	ImageIcon bicon = new ImageIcon(bookURL); 
	//메뉴바 추가하기
		JMenuBar jmb_book 	= new JMenuBar();
		JMenu	 jm_file 	= new JMenu("File");
		JMenuItem jmi_open	= new JMenuItem("Open File");	//file
		JMenuItem jmi_exit	= new JMenuItem("Exit");    	//file
		JMenuItem jmi_db	= new JMenuItem("DB연결");   	//file
		JSeparator js_file 	= new JSeparator(); 	// 구분선
		JMenu	 jm_edit 	= new JMenu("Edit"); 	//5가지 메뉴를
		JMenuItem jmi_all   = new JMenuItem("전체조회");  	//edit
		JMenuItem jmi_sel   = new JMenuItem("상세조회",new ImageIcon(imgPath+"detail.gif"));  	//edit
		JMenuItem jmi_ins   = new JMenuItem("입력",new ImageIcon(imgPath+"new.gif"));      	//edit
		JMenuItem jmi_upd   = new JMenuItem("수정",new ImageIcon(imgPath+"update.gif"));      	//edit
		JMenuItem jmi_del   = new JMenuItem("삭제",new ImageIcon(imgPath+"delete.gif"));      	//edit
	static BookApp ba 		= null; //메인메소드 static때문에 외부 접근이 안되어 따로 전역변수 선언
	//파라미터가 없는 생성자는 디폴드로 지원해주지만 있는 경우는 예측불가이므로 지원불가함
	BookDialog bd 			= new BookDialog(); //바깥쪽에 처리하기위해 직접 파라미터에 입력
	//jp_north속지는 JFrame 북쪽에 배치
	JPanel      jp_north 	= new JPanel();
	//아래 버튼은 jp_north속지에 차례대로 배치 단 위치는 왼쪽부터
	JToolBar    jtbar		= new JToolBar();
	JButton     jbtn_db 	= new JButton("DB연결"); //
	JButton     jbtn_all 	= new JButton("전체조회");
	JButton     jbtn_sel 	= new JButton("상세조회");
	JButton     jbtn_ins 	= new JButton("입력");
	JButton     jbtn_upd 	= new JButton("수정");
	JButton     jbtn_del 	= new JButton("삭제");
	JLabel      jlb_time2   = new JLabel("현재시간",JLabel.CENTER);
	TimeClient  tc 			= null; //클라이언트에서 듣고 앱에서 출력하기위해 전역변수로 선언후 
	String cols[] = {"도서번호","도서명","저자","출판사"};              		   //set
	String data[][] = new String[0][4];                                    //set
	DefaultTableModel dtm_book = new DefaultTableModel(data, cols);        //set
	JTable jtb_book = new JTable(dtm_book);                                //set
	JScrollPane jsp_book = new JScrollPane(jtb_book);                      //set
	BookDao bDao = new BookDao();
	BookController bCtrl = new BookController(this);
	
	//이벤트 소스와 이벤트 헨들러 클래스 연결하기
	public void eventMapping() {
		//db연결 버튼 이벤트 철
		jbtn_db.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
				
			}
		});
		jmi_db.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
				
			}
		});
//		jmi_all.addActionListener(this);
//		jbtn_all.addActionListener(this);
	}
	protected void dbActionPerformed(ActionEvent ae) { //DB연결 확인
		System.out.println("db연결 테스트");
		Connection con = null;
		con = dbMgr.getConnection();
		System.out.println(con.toString());
	}
	// initDisplay에 인스턴스화하여 start메소드 호출
	//화면 그리기
	public void initDisplay() {
		jm_file.setMnemonic('F'); //단축키 이용
		jm_file.setMnemonic('E'); //단축키 이용
		jm_file.add(jmi_db);
		jm_file.add(jmi_open);
		jm_file.add(js_file); // 구분선 위치
		jm_file.add(jmi_exit);
		jm_edit.add(jmi_all);
		jm_edit.add(jmi_sel);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jmb_book.add(jm_file);
		jmb_book.add(jm_edit);
		this.setJMenuBar(jmb_book); // j메뉴바 적용(jmb_book을 어디에?)
		//실제로 타임서버로 부터 시간정보를 듣기는 TimeClient에서 진행 되지만 
		//생성자의 파라미터를 통해서 BookApp jlb_time 원본의 주소번지를
		//넘겼으므로 TimeClient에서는 원본에 직접 써주면 화면에 보임.
		tc = new TimeClient(jlb_time2); 
		tc.start();
		//insert here
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif")); //
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));    //
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif")); //
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif")); //
		jbtn_sel.setToolTipText("상세조회"); // 버튼에 마우스커서 올리면 설명보임
		jbtn_ins.setToolTipText("입력");     //버튼에 마우스커서 올리면 설명보임
		jbtn_upd.setToolTipText("수정");     //버튼에 마우스커서 올리면 설명보임
		jbtn_del.setToolTipText("삭제");     //버튼에 마우스커서 올리면 설명보임
		jtbar.add(jbtn_db);  //jp_north -> jtbar
		jtbar.add(jbtn_all);  //jp_north -> jtbar
		jtbar.add(jbtn_sel);  //jp_north -> jtbar
		jtbar.add(jbtn_ins);  //jp_north -> jtbar
		jtbar.add(jbtn_upd);  //jp_north -> jtbar
		jtbar.add(jbtn_del);  //jp_north -> jtbar
		//아래코드가 JFrame의 자원을 회수함
		//부모 자원이 회수 될때 JDialog도 같이 회수됨
		this.add("Center", jsp_book); //도서번호 도서명 저자 출판사 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //main+sub둘다 닫기 ->자원회수
		this.setTitle("도서관리시스템");
		this.add("North",jtbar);//JPanel 화면 넣기 //jp_north -> jtbar로 변경했다. 연습하도록
		this.add("South",tc.jlb_time2);//타이머 넣기
		this.setSize(700, 500);
		this.setIconImage(bicon.getImage());//이미지 첨부
		this.setVisible(true);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TimeServer ts = new TimeServer();//파라미터 - 소켓 client
		/*지속적으로 1초에 한번씩 기다렸다 찍어야할때 쓰레드가 필요하다.
		 *쓰레드 : 기다림을 메소드로 지원  1000 = 1초 sleep 기다려 
		 */
		ts.initDisplay(); //화면을 그리고  난뒤 스레드 대기를 타도록 해야함
		Thread th = new Thread(ts);
		th.start();//java.lang.Thread 스레드의 run메소드를 호출하는 메소드 - 쓰레드를 동작시킴
		ba = new BookApp(); // 스태틱때문에 타입이랑 같이 인스턴스화 하면 안되징!
		ba.initDisplay(); //화면 처리부분
		ba.eventMapping(); //이벤트연결 - 익명클래스 처리 이벤트맵핑호출
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
			//Map<String,Object> rMap = new HashMap<>();
			//bd.set("입력",true, true, rMap, ba);
			BookVO bVO = null;
			bd.set("입력",true, true, bVO, ba);
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
			bd.set("수정",true, true, rMap, ba);
		}
		else if(obj==jbtn_sel) {
			System.out.println("상세조회호출성공");
			Map<String, Object> rMap = null; //조회한 후에 담아야함
			int indexs[] = jtb_book.getSelectedRows();
			if(indexs.length==0) {
				JOptionPane.showMessageDialog(this, "상세조회 할 로우를 선택하세요.");
				return; // 빠져나가야함
			}
			else {
				int b_no = Integer.parseInt(
						dtm_book.getValueAt(indexs[0], 0).toString()); //도서의 인덱스 0
				System.out.println("b_no : "+b_no); // 도서번호출력    //2
				BookVO pbVO = new BookVO();
				pbVO.setCommand("detail");
				pbVO.setB_no(b_no);
				BookVO rbVO = bCtrl.send(pbVO);
				bd.set("상세보기",true, false, rbVO, ba);
			}
			//bd.set(jbtn_sel.getText(),true, false, rMap, ba);
		}
		else if(obj==jbtn_del) {
			System.out.println("삭제호출성공");
			
		}
		else if(obj==jbtn_all) {
			System.out.println("전체조회 호출성공");
			refreshData();
		}
	}
	public void refreshData() {
		System.out.println("refreshData 호출 성공");
		List<BookVO> bookList = null;
		BookVO pbVO = new BookVO();
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		//기존에 조회된  결과를 출력한 화면은 삭제처리한다.
		while(dtm_book.getRowCount()>0) {// bookList.size() 숫자와 동일
			dtm_book.removeRow(0); // 계속 로우수만큼 반복하면서 첫번째 로우 즉 0번 계속 지워준다.
		}
		//삭제한 후 다시 출력하기
		for(int i=0;i<bookList.size();i++) { // 사용자에게 응답을 하는 부분
			BookVO bVO = bookList.get(i);
			Vector<Object> v = new Vector<>();
			v.add(bVO.getB_no());
			v.add(bVO.getB_name());
			v.add(bVO.getB_author());
			v.add(bVO.getB_publish());
			//JTable에 추가하는 것이 아니다. -JTable은 양식일 뿐이고
			//실제 데이터를 갖는 클래스는 DefaultTableModel 이다 - DataSet 지원함 DataSet : 데이터들의 집합
			//한개로우는 Vector에 담고 그 벡터를 for문안에서 반복 추가해줌
			dtm_book.addRow(v);
		}
	}///end of refreshData
}//class
