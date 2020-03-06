package study.sungjuk;
/*	오버로딩(Overloading) : 같은 이름의 메소드를 여러 개 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
	오버라이딩(Overriding) : 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의 해서 사용한다.
	   
	   구분	      오버로딩		     오버라이딩
	메소드이름		 동일				 동일
	매개변수,타입	 다름				 동일 
	리턴타입	        상관없음			 동일
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SungJuk implements ActionListener {
	//선언부
	JFrame jf_sungjuk       = new JFrame(); //화면
	JLabel jlb_su         	= new JLabel("인원수");
	JLabel jlb_inwon        = new JLabel("명");
	JTextField jtf_inwon  	= new JTextField(15); // 15 크기
	JTextField jtf_inwon2   = new JTextField();
	JButton jbtn_data  		= new JButton("데이터호출");
	JButton jbtn_account    = new JButton("성적처리");
	JButton jbtn_exit  		= new JButton("종료");
	JPanel jp_north         = new JPanel(); // 속지는 Jpanel
	JPanel jp_south         = new JPanel();//디폴트 레이아웃이 FlowLayout
	JPanel jp_west          = new JPanel();
	JPanel jp_east          = new JPanel();
	JPanel jp_center        = new JPanel();
	//테이블 처리 코드 추가
	String           	 	  cols[] = {"이름","국어","영어","수학","총점","평균","석차"}; // 컬럼들
	String          		data[][] = null;  
	DefaultTableModel 	 dtm_sungjuk = null; // 파라미터 2개를 받아서 초기화를 할수있다.
	JTable            	 jt_sungjuk  = null;//dtm은 데이터를 갖고있고 테이블은 양식은 있지만 데이터가 없다 그래서 만났다
	JScrollPane       	 jsp_sungjuk = null;
	//사용자가 입력한 인원수를 담을 변수입니다.
	//전역변수로 한 이유는 인원수를 듣기는 jtf_inwon에서 엔터 쳤을때 값이 결정되는것
	//그때 결정된 3이 jbtn_account에서도 필요합니다.
	//왜냐하면 총점을 기준으로 석차를 구하기로 결정되었으므로 총점과 석차를 같이 관리할 2차배열을
	//선언하였기 때문이다.
	int inwon = 0; //성적처리 했을때 유지되어야하니까 전역
	int imsi[][] = null;
	//생성자
	SungJuk(){
		start();
	}
	//총점을 구하는 메소드 구현
	public double total() {
		return 0.0; //미정이지만 더블타입이라 실수형태로 적기
	}
	//평균을 구하는 메소드 구현
	public double average() {
		return 0.0;
	}
	//석차를 구하는 메소드 구현
	public int[] ranking() {
		//return null; //클래스급 레퍼런스 에 null로 입력해도됨
		return new int[2];
	}
	//이벤트 소스와 이벤트처리 클래스를 맵핑
	public void start() {
		//엔터 쳤을때 감지하고 콜백메소드를 호출하자
		jtf_inwon.addActionListener(this);
		//데이터가져오기 이벤트연결
		jbtn_data.addActionListener(this);
		//성적처리 이벤트연결
		jbtn_account.addActionListener(this);
		//종료 이벤트연결
		jbtn_exit.addActionListener(this);
	}
	//나가기 
	public void exitSungJuk() {
		System.exit(0);
	}
	//화면처리부
	public void initDisplay() {
		
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jlb_su);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb_inwon); // 
		
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_data); //버튼화면에 넣기
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		
		jf_sungjuk.add("North", jp_north);
		jf_sungjuk.add("South", jp_south);// 이거 없으면 버튼 안보임
		jf_sungjuk.setTitle("성적처리 프로그램 ver 1.0");	
		jf_sungjuk.setSize(600, 600);
		jf_sungjuk.setVisible(true); // 띄우기	
		//jf_sungjuk.pack();		
	}
	//메인메소드
	public static void main(String[] args) {
	 JFrame.setDefaultLookAndFeelDecorated(true); // 화면변신
	 SungJuk sj = new SungJuk();
	 sj.initDisplay();
	 
	}
	//@Overrid는 (@은 어노테이션이고)   읽음- ActionListener가 가진 추상메소드를
	//그대로 가져다가 재정의해서 사용하시오.
	//
	//추상메소드 : void methodA(); 이런 형태 , 특징 : 이름은 정해졌지만 기능은 정해진게 없음 고로 기능을 담을수없다.
	@Override
	public void actionPerformed(ActionEvent e) {//반드시 부모가 갖고있는 기능을 선언해서 써라 바꾸면 에러
		//insert here  actionPerformed method는 여기만 건들어라 
		Object obj = e.getSource(); //이벤트가 감지된 버튼의 주소번지를  읽어오는 메소드임.
		if(obj == jbtn_account) {
			//총점과 석차가 들어갈 공간을 할당하기
			//인원수는 어떻게 가져오지? - 전역변수로 선언하고 사용하는게 좋겠어
			//왜냐면 다른 이벤트에서도 필요하기 때문이지
			int imsi[][] = new int[inwon][2];
			for(int i=0;i<inwon;i++) {
				int tot = Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 1))
						 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 2))
						 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 3));
				//구한 총점을 DefaultTableModel객체에 담기
				dtm_sungjuk.setValueAt(tot, i, 4); //이벤트가 감지된 버튼의 주소번지를 사용하는 메소드임
				double avg = 0.0;
				avg = tot/3.0;
				dtm_sungjuk.setValueAt(avg, i, 5);
				imsi[i][0] = tot;
				imsi[i][1] = 1; //조건을 수렴하지 않을 경우가 발생할 수 있다.
				//이때 0등이 나오면 안되니까 초기화를 1로 변경하였다.
				//석차 매기기
			}//end of for
				for(int i=0;i<inwon;i++) {
					for(int j=0;j<inwon;j++) {
						//imsi[0][0] < imsi[0][0]
						//imsi[0][0] < imsi[1][0]
						//imsi[0][0] < imsi[2][0]
						//3<3, 3<1, 3<2
						if(imsi[i][0] < imsi[j][0]) {
							imsi[i][1]++;
						}
					}
				}//end of for
				for(int i=0;i<inwon;i++) {
					dtm_sungjuk.setValueAt(imsi[i][1], i, 6);
				}
		}
		else if(obj== jbtn_data) { // 감지된 데이터 버튼
			String data[][] = {
					 {"이상희","30","35","30"}
					,{"박만성","50","55","50"}
					,{"노용택","45","40","45"}	
			};
			//초기화 할 수 있니?
			//2중 for문 활용할 수 있는거야? 
			for(int i=0;i<3;i++) {
				for(int j=0;j<4;j++) {
					dtm_sungjuk.getValueAt(i, j); //값을 불러옴
					dtm_sungjuk.setValueAt(data[i][j], i, j); //값, row, column
					/*tot = Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 1))
					 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 2))
					 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 3));
					System.out.println("총점 "+i+":"+tot);*/
				} 
			}
		}
		if(obj== jtf_inwon) {
			
			inwon = Integer.parseInt(jtf_inwon.getText()); // 이거 분석해야함
			data = new String[inwon][7]; 
			dtm_sungjuk = new DefaultTableModel(data,cols); // 파라미터 2개를 받아서 초기화를 할수있다.
			jt_sungjuk  = new JTable(dtm_sungjuk);//dtm은 데이터를 갖고있고 테이블은 양식은 있지만 데이터가 없다 그래서 만났다
			jsp_sungjuk = new JScrollPane(jt_sungjuk);
			jf_sungjuk.add("Center",jsp_sungjuk); 
			jf_sungjuk.pack(); 
			Dimension di 
			= Toolkit.getDefaultToolkit().getScreenSize();//1280x768
			//현재 내가 그린 화면의 크기 가져오기 
			Dimension di2 = jf_sungjuk.getSize();
			jf_sungjuk.setLocation//프레임 위치
			((int)(di.getWidth()/2-di2.getWidth()/2), // 1280/2 - a/2
			(int)(di.getHeight()/2-di2.getHeight()/2));//768/2 - b/2
		}
		else if(obj == jbtn_exit) {
			System.out.println("나가기 버튼 호출 성공");
			System.exit(0);// 메소드 호출
		}
	}////////end of acrtionPerFormed

}
