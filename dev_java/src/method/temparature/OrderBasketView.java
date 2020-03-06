package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class OrderBasketView {
	//선언
	Connection          con = null; // 전역변수선언하기 - 클래스 전역에서 사용가능함.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	JTextField     jtf_date = new JTextField(" "); // 검색상자
	JButton     jbtn_search = new JButton("조회");
	String            cols[] = {" "," "," "}; // 컬럼들
	String          data[][] = new String[4][3]; 
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // 파라미터 2개를 받아서 초기화를 할수있다.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm은 데이터를 갖고있고 테이블은 양식은 있지만 데이터가 없다 그래서 만났다
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //운영체제위에 창을 띄운다.
	JPanel            jp_north = new JPanel(); //속지를 만들어준다.
	JComboBox   	  jcb_year = null; //제이콤보박스 전역변수 선언
	JComboBox   	 jcb_month = null; 
	SeoulTempDAO		stDao  = new SeoulTempDAO(); // initDisplay(); 맨아래에 위치하므로 new A();형태로 선언
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	
	//생성
	public OrderBasketView() {
		
	}
	
	//메인메소드
	public static void main(String[] args) {
		new OrderBasketView();
		
	}

}
