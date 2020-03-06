package method.temparature;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.ZipCodeVO;

public class SeoulTempView implements ActionListener {
	//선언부 
	Connection          con = null; // 전역변수선언하기 - 클래스 전역에서 사용가능함.
	//오라클서버에 쿼리문을 전달하고 너가 좀 처리해줄래? 용도
	PreparedStatement pstmt = null;
	//오라클에는 일꾼이 살고 있는데 이름은 옵티마이저라고 부른다.
	//데이터를 찾을 때는 커서를 움직이면서 조회 결과가 존재하는지 확인하고 그 로우에 있는 값들을 
	//RAM메모리 영역에 올려준다.커서를 조작하면서 해당로우에 있는 값을 꺼낼수 있다.
	ResultSet      rs       = null;
	JTextField     jtf_date = new JTextField("날짜를 입력하세요"); // 검색상자
	JButton     jbtn_search = new JButton("조회");
	//테이블 양식 그려줌
	//오라클에서 조회한 결과를 담을 클래스 선언및 생성하기
	//테이블의 헤더 설정하기
	String            cols[] = {"날짜","최저온도","최고온도"}; // 컬럼들
	String          data[][] = new String[4][3]; 
	//생성자에는 파라미터를 가질수있다.
	//첫번째 파라미터는 데이터영역을 표시하는 주소번지
	//두번째 파라미터는 테이블 헤더영역에 해당하는 주소번지
	//파라미터의 개수에 따라서 서로 다른 생성자를 선언하는것도 가능하다는 것인가?
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // 파라미터 2개를 받아서 초기화를 할수있다.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm은 데이터를 갖고있고 테이블은 양식은 있지만 데이터가 없다 그래서 만났다
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	//JTableHeader 색바꾸기 
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //운영체제위에 창을 띄운다.
	JPanel            jp_north = new JPanel(); //속지를 만들어준다.
	JComboBox   	  jcb_year = null; //제이콤보박스 전역변수 선언
	JComboBox   	 jcb_month = null; 
	String             years[] = null; //오라클서버 경유해서 반환받는 값으로 초기화
	String			   months[] = null;
	SeoulTempDAO		stDao  = new SeoulTempDAO(); // initDisplay(); 맨아래에 위치하므로 new A();형태로 선언
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//생성자 - 리턴타입이 무조건 없다 그리고 클래스 이름과 동일하다. - 메소드 아님 
	//생성자
	public SeoulTempView() { //생성자에서 메소드 호출할수 있다.
		//오라클서버 경유하기
		//주소번지.10년정보 가져오는 메소드 호출하기();
		 years = stDao.getYearList();
		//오라클서버 경유하고나서 받은 리턴값으로 콤보박스 인스턴스화 하기
		jcb_year = new JComboBox(years);
		//메소드호출
		initDisplay();
	}
	//화면 처리부
	public void initDisplay() {
		System.out.println("initDisplay 호출성공");
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(22,22,100));//파라미터를 추가해서 표현
		jth_zip.setForeground(Color.white); // 색지원
		jth_zip.setFont(new Font("맑은고딕",Font.BOLD,20));//파라미터3개 필요 글꼴, 글두께, 글자크기
		jt_zip.setGridColor(Color.BLUE); //그리드 색상
		//그리드의 높이 변경하기
		jt_zip.setRowHeight(20);
		//컬럼의 너비조정하기
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350); //컬럼
		//선택한 로우의 배경색이나 글자색 변경하기
		jt_zip.setSelectionBackground(new Color(186,186,241));
		jt_zip.setSelectionForeground(new Color(22,22,241));
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerformed메소드)를 연결해준다 actionPerformed - 이벤트처리 담당
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_search를 붙인다.
		//이렇게 동,서,남,북,중앙에 버튼을 배치하고싶으면 BorderLayout 사용해야함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.red);
		jp_north.add(jcb_year); // JComboBox 다잉테스트
		jp_north.add("Center", jtf_date);
		jp_north.add("East", jbtn_search); // 버튼 붙임 라벨은 조회하고 
		jbtn_search.addActionListener(this); // 나자신을 가리키는 예약어
		jtf_date.addActionListener(this);
		jf_zip.setTitle("서울기후통계 검색");
		//JFrame판넬 위에 북쪽에 jp_north 속지를 붙이자
		//속지안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다
		jf_zip.add("North", jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	//전체조회 혹은 조건 검색 하기 구현
	//insert here
	public void refreshData(String myDong) {
		getConnection();
		System.out.println("refreshData호출성공"+myDong);
		String sql = "";
		sql+="SELECT address, zipcode";
		sql+="   FROM zipcode_t";
		if(myDong!=null || myDong.length()>0) {
			sql+="   WHERE dong LIKE '%'||?||'%'";  // ? 로적어 			
		}
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, myDong); //?들어갈 동이름이 결정됨.
			rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO zcVOS[] = null; 
			ZipCodeVO zcVO = null; 
			while(rs.next()) { //커서이동, 커서이동
				zcVO = new ZipCodeVO();
				zcVO.setAddress(rs.getString("address")); //직관적으로 하기위해 "address"
				zcVO.setZipcode(rs.getInt("zipcode"));
				v.add(zcVO);
				//System.out.println("while문 :"+rs.next());//커서이동
			}
			zcVOS = new ZipCodeVO[v.size()];
			v.copyInto(zcVOS); //벡터 자료 구조에 들어있는 정보를 복사하기  형태: 소유주.메소드()
			System.out.println("v.size():"+v.size()+","+zcVOS.length);
			if(v.size()>0) {
			//조회결과가 있다면 데이터를 DefaultTableModel에 담아주어야 합니다.
			//그래야 JTable에서 그리드에 출력된 결과를 볼 수 있기 때문입니다.
			//그런데 컬럼을 하나씩 각각 개발자가 일일이 초기화 해주는건 너무 불편하다.
				for(int x=0; x<v.size();x++) {
			//그래서 for문 안에서 벡터를 하나 더생성했어요
			//addRow라는 메소드가 있는데 이 파라미터에 Vector를 넣으면 한개로우씩
			//추가 해준다고함
					Vector oneRow = new Vector(); // 한개로우씩 넣어주고 싶어서 
					oneRow.add(0, zcVOS[x].getAddress());//addRow메소드가 받아준다
					oneRow.add(1, zcVOS[x].getZipcode());
					dtm_zip.addRow(oneRow);
				}
			}
		}catch(SQLException se) {
			//테이블이 존재하지 않습니다. - 테이블을 만들지 않았네
			//혹은 부적합한 식별자 - 컬럼명이 맞지 않습니다
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//그밖에 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
	}
	private void getConnection() {
		// TODO Auto-generated method stub
		
	}
	//메인메소드
	public static void main(String[] args) {
		 new SeoulTempView(); // 인스턴스화없이 스태틱이없으므로 생성자에서 메소드 호출 우리집에 있음
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
