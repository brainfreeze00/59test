package oracle.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 변수이름앞에 final이 붙으면 상수가 됨.
 * 상수는 다른 값으로 재정이 불가함.
 * 오라클서버에서 접속하기위해 작성해놓은 것
 * 클래스를 누가 먼저 선점하느냐
 */
public class JDBCTest {
	//이 클래스를 읽어야 오라클 제품인것을 확인가능함.
	public static final String _DRIVER 
		= "oracle.jdbc.driver.OracleDriver"; // 클래스이름 오라클회사에서 제공 
	//물리적으로 떨어져있는 오라클 서버에 URL정보 추가
	public static final String _URL 
		= "jdbc:oracle:thin:@192.168.0.240:1521:orcl11"; //sid 명 orcle11
	public static String _USER = "scott"; // final은 안넣음 바꿀거라
	public static String _PW = "tiger"; //
	Connection con = null; 
	java.sql.PreparedStatement pstmt = null; //  java.sql. - 패키지 이름.클래스 이름
	//오라클에 살고 있는 커서를 조작하는 클래스를 제공함.
	//커서 위치에 로우가 존재하면 true, 조회된 결과가 없으면 false를 리턴한다.
	//java.lang폴더를 제외하고는 모두다 import해주어야 JMV이 그 클래스를 찾는다.
	java.sql.ResultSet rs =null;
	public String currentTime() throws Exception {
		Class.forName(_DRIVER); //forName 호출 - 오라클 제조사 정보를 가지고 있음.
		String sql = "select to_char(sysdate, 'HH24:MI:SS') from dual";
		//아래 메소드가 호출되면 오라클 서버와 연결통로를 갖게 되는것.
		//이 연결통로를 통해서 select문을 전령클래스가 가지고 들어가야함. 반드시 커넥션문을 갖고 있어야한다. 집합이름과 컬럼이름만 바뀐다. 외워서 써도됨.
		con = DriverManager.getConnection(_URL, _USER, _PW); // 돌연변이 getConnection 
		pstmt = con.prepareStatement(sql); //메소드가 아닌데 PreparedStatement를 주입해준다.
		rs = pstmt.executeQuery(); // 오라클 서버에게 처리를 요청함.
		if(rs.next()) {
			return rs.getString(1);
		}
		return "15:09:49";
	}
	public static void main(String[] args) throws Exception {
		//java.lang 패키지에 클래스는 모두 찾지만 그 외 패캐지는 찾을수 없다.
		//Scanner scan = new Scanner(System.in);
		JDBCTest jt = new JDBCTest();
		String ctime = jt.currentTime();
		System.out.printf("현재시간은 %s입니다.\n",ctime);
	}

}
