package UI.swing;
// 틀린거 찾아봐라 이게 목표임
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.util.DBConnectionMgr;

public class JComboBoxTest00 implements ItemListener {
	//선언부
	JFrame jf = new JFrame();
	String data[] = null; // 선언
	JComboBox jcb_dept = null;  // nullpointexception 에러 고치기
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//생성자
	JComboBoxTest00() {
		//insert here
		data = getDeptList(); //내안에 있는 메소드이니까 인스턴스 안하고 바로 호출
		jcb_dept = new JComboBox(data);
		jcb_dept.addItemListener(this); //인터페이스의 이름은 달라졌지만 처리방식은 같기에  그리고 내안에 있기에 this 
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE); // 상속 받아야 사용가능 고로 주석
		JFrame jf = new JFrame();
		jf.add("North",jcb_dept); // JComboBox 변수 대입
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setTitle("부서");
	}
	/*
	 * 오라클서버에서 dept 테이블에 있는 정보를 조회하시오.
	 * 조회된 정보를 data배열에 초기화하시오.
	 */
	public String[] getDeptList() {
			String depts[] = null; 
			StringBuilder sb = new StringBuilder();   // String대신 쿼리문 작성시 StringBuilder 클래스 사용
			
			sb.append("SELECT dname FROM dept");
			
			try {//물리적으로 떨어져 있는 서버에 IP주소로 접근하니까 예외가 발생할 가능성이 있음.  즉 진행은 유지되어야 한다.
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sb.toString()); 
				rs = pstmt.executeQuery(); //select문을 처리해줘~
				Vector<String> v = new Vector<>();
				while(rs.next()) { // while을 다돌아야 크기를 정하고 방의 개수가 정해진다.
					String dname = rs.getString("dname");
					v.add(dname);
				}
				depts = new String[v.size()]; // null로 했기에 인스턴스화 해야한다. 
				v.copyInto(depts); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			return depts;
		}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true); // 화 면 변 신
		new JComboBoxTest();
	}
	/* ItemListener의 공식 명칭은 인터페이스이다.
	 * 인터페이스는 추상메소드를 가지고 있으므로 반드시 구현해 주어야한다.
	 * 이때 부모가 가진 메소드의 원형을 절대로 훼손해서는 안된다. 변수나 파라미터 변경 ㄴㄴ
	 */
	@Override
	public void itemStateChanged(ItemEvent ie) { // 
		Object obj = ie.getSource();
		if(obj == jcb_dept) { //콤보박스가 일어났다는 뜻
			if(ie.getStateChange()==ItemEvent.SELECTED) {// 선택되었는가?
				System.out.println(jcb_dept.getSelectedIndex()); // 리턴타입 int
			}
		}
	}

}
