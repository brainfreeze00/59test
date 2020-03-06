package UI.swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao {
	//오라클 서버와 연결통로를 만드는데 필요한 인터페이스입니다.
	Connection con = null;
	//연결통로가 만들어지면 그 길을  따라 select문을 오라클에게 전달해 줄 클래스가 필요하죠
	//그 아이가 PreparedStatement 입니다.
	PreparedStatement pstmt = null;
	//조회결과를 오라클 서버로부터 꺼내려면 커서가 필요하데 그 커서를 조작할수 있도록
	//자바에서 제공되는 인터페이스가 ResultSet입니다.
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//메소드의 리턴타입은 배열로 했어요. 왜냐하면 그 배열은  JComboBox에 생성자
	//파라미터로 넘겨야 하기 때문에 리턴타입이 꼭 필요한거죠.
	public String[] getDeptList() {
		//부서명을 담을 배열을 선언했어요. 그런데 생성하는건 안될거 같아요.
		//왜냐하면 오라클에서 꺼낸값이 몇건인지 알아야 배열의 크기를 정할수 있기 때문이죠.
		String depts[] = null; 
		//쿼리문을 작성할때 여러 로우가 나올수 있는데 String 을 사용하면 원본이 바뀌지 
		//않아서 자바성능튜닝팀에서 못쓰게합니다.
		//대신 StringBuilder 를 사용하라고 권장하죠
		//이 클래스는 원본이 바뀌기 때문에 불필요한 자원낭비를 막을수 있데요.
		//서버 입장에서는 동시 접속자 수가 많아서 작은 양이지만 큰 문제를 일으킬수도 있다고
		//합니다.
		StringBuilder sb = new StringBuilder();   // String대신 쿼리문 작성시 StringBuilder 클래스 사용
		//쿼리문 작성하기
		sb.append("SELECT dname FROM dept");
		//예외가 발생되면 시스템이 멈춰 서 있게 됩니다.
		//무한히 기다리는 상황이 발생하므로 다음 사람도 이용 할 수 없다.
		try {//물리적으로 떨어져 있는 서버에 IP주소로 접근하니까 예외가 발생할 가능성이 있음.  즉 진행은 유지되어야 한다.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString()); 
			rs = pstmt.executeQuery(); //select문을 처리해줘~
			Vector<String> v = new Vector<>();
			//커서를 한줄씩 넘기면서 커서위치에 값을 변수에 담는다.
			while(rs.next()) { // while을 다돌아야 크기를 정하고 방의 개수가 정해진다.
				String dname = rs.getString("dname");
				//조회된 값을 백터 클래스에 추가한다.
				v.add(dname);
			}
			//오라클 서버에서 조회된 결과 만큼 추가된 벡터의 크기값을 가지고
			//배열을 생성한다.
			depts = new String[v.size()]; // null로 했기에 인스턴스화 해야한다. 
			//벡터에 들어 있는 정보를 String배열에 복사한다.
			v.copyInto(depts); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return depts;
	}
	public static void main(String[] args) {
		DeptDao dd = new DeptDao();
		String depts[] = dd.getDeptList();
		for(String dept:depts) {
			System.out.println(dept);
		}
	}

}
