package oracle.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * �����̸��տ� final�� ������ ����� ��.
 * ����� �ٸ� ������ ������ �Ұ���.
 * ����Ŭ�������� �����ϱ����� �ۼ��س��� ��
 * Ŭ������ ���� ���� �����ϴ���
 */
public class JDBCTest {
	//�� Ŭ������ �о�� ����Ŭ ��ǰ�ΰ��� Ȯ�ΰ�����.
	public static final String _DRIVER 
		= "oracle.jdbc.driver.OracleDriver"; // Ŭ�����̸� ����Ŭȸ�翡�� ���� 
	//���������� �������ִ� ����Ŭ ������ URL���� �߰�
	public static final String _URL 
		= "jdbc:oracle:thin:@192.168.0.240:1521:orcl11"; //sid �� orcle11
	public static String _USER = "scott"; // final�� �ȳ��� �ٲܰŶ�
	public static String _PW = "tiger"; //
	Connection con = null; 
	java.sql.PreparedStatement pstmt = null; //  java.sql. - ��Ű�� �̸�.Ŭ���� �̸�
	//����Ŭ�� ��� �ִ� Ŀ���� �����ϴ� Ŭ������ ������.
	//Ŀ�� ��ġ�� �ο찡 �����ϸ� true, ��ȸ�� ����� ������ false�� �����Ѵ�.
	//java.lang������ �����ϰ�� ��δ� import���־�� JMV�� �� Ŭ������ ã�´�.
	java.sql.ResultSet rs =null;
	public String currentTime() throws Exception {
		Class.forName(_DRIVER); //forName ȣ�� - ����Ŭ ������ ������ ������ ����.
		String sql = "select to_char(sysdate, 'HH24:MI:SS') from dual";
		//�Ʒ� �޼ҵ尡 ȣ��Ǹ� ����Ŭ ������ ������θ� ���� �Ǵ°�.
		//�� ������θ� ���ؼ� select���� ����Ŭ������ ������ ������. �ݵ�� Ŀ�ؼǹ��� ���� �־���Ѵ�. �����̸��� �÷��̸��� �ٲ��. �ܿ��� �ᵵ��.
		con = DriverManager.getConnection(_URL, _USER, _PW); // �������� getConnection 
		pstmt = con.prepareStatement(sql); //�޼ҵ尡 �ƴѵ� PreparedStatement�� �������ش�.
		rs = pstmt.executeQuery(); // ����Ŭ �������� ó���� ��û��.
		if(rs.next()) {
			return rs.getString(1);
		}
		return "15:09:49";
	}
	public static void main(String[] args) throws Exception {
		//java.lang ��Ű���� Ŭ������ ��� ã���� �� �� ��ĳ���� ã���� ����.
		//Scanner scan = new Scanner(System.in);
		JDBCTest jt = new JDBCTest();
		String ctime = jt.currentTime();
		System.out.printf("����ð��� %s�Դϴ�.\n",ctime);
	}

}
