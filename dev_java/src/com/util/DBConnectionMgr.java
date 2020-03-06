package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc2.JDBCTest;

public class DBConnectionMgr {
	Connection          con = null;
	public static final String _DRIVER  //DB������ �ʿ���
		= "oracle.jdbc.driver.OracleDriver"; // Ŭ�����̸� ����Ŭȸ�翡�� ���� 
	//���������� �������ִ� ����Ŭ ������ URL���� �߰�
	public static final String _URL 
		= "jdbc:oracle:thin:@192.168.0.240:1521:orcl11"; //sid �� orcle11
	public static String _USER = "scott"; // final�� �ȳ��� �ٲܰŶ�
	public static String _PW = "tiger"; 
	//static - Ŭ�������̴�. - ����(�ϳ���-��������)
	private static DBConnectionMgr dbMgr = null;
	private DBConnectionMgr() {}
	//�̱��� �������� ��ü �����ϱ� - �ν��Ͻ�ȭ �����̴�
	public static DBConnectionMgr getInstance() {
		if(dbMgr == null) {   // ��ȯŸ���� ���� 
			dbMgr = new DBConnectionMgr(); // 19�� null�� new DBConnectionMgr();���� 
		}
		return dbMgr; 
	}
	//���������� ������ �ִ� ����Ŭ ������ ������� �����
	//�ν��Ͻ�ȭ�� ���ִ� �޼ҵ� ���� - connection�� �����ϰ� �ִ�.
	public Connection getConnection() {
		System.out.println("getConnectionȣ�� ����");
		//����Ŭ ȸ�� ������ ������.
		try {
			Class.forName(_DRIVER);
			//con = new Connection(); �ݵ�� ����ü Ŭ������ �־���Ѵ�.
			con = DriverManager.getConnection(_URL, _USER, _PW); 
		} catch(ClassNotFoundException ce) {
			System.out.println("����̹� Ŭ���� �̸��� ã���� �����");
		} catch(Exception e) {
			System.out.println("���ܰ� �߻�����. ���������� ó���� �ȵ�");
		}
		return con; //con�� null�� �ƴϸ� �� ����Ȱ���
	}
	/* DBConnectionMgr �� ���� �������� �������� ����ϴ� Ŭ���� �Դϴ�.
	 * ����� �ڿ�(Connection, PreparedStatment, ResultSet)�� �ݵ�� �ݳ��� �ϵ����մϴ�.
	 * ���� ������ ���� ���� �ý��ۿ��� �ڿ������ �� �޸𸮶� ����ǹǷ�
	 * ������ �ٿ�ǰų� �ý��� ��� �߻��� ������ �˴ϴ�.
	 */
	public void freeConnection(Connection con
			, PreparedStatement pstmt
			, ResultSet rs) {
		try {
			//����ڿ��� ���� �������� ��ȯ�Ұ�.
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				rs.close();
			}
			if(con != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Exception :"+ e.toString());
		}
	}
	//�ڹٿ����� ���� �̸��� �޼ҵ带 ������ ���� �� �ִ�.
	//1)�޼ҵ� �����ε� - �Ķ���� ���� ,Ÿ���� �޶���Ѵ�
	//2)�޼ҵ� �������̵�
	public void freeConnection(Connection con
			, PreparedStatement pstmt) {
		try {
			//����ڿ��� ���� �������� ��ȯ�Ұ�.
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Exception :"+ e.toString());
		}
	}
}
