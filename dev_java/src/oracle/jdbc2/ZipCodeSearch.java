package oracle.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

public class ZipCodeSearch {
	//�����
	//����̹� Ŭ������ �ʿ��ϴ�. -JDBCTest���� ��������.	
	//URL������ JDBCTest���� ���� �� �� �ִ�. + user�� pw�� �����Ҽ� �ִ�. - ��?
	Connection          con = null; //���Ϳ�
	PreparedStatement pstmt = null; // ����Ŭ ������ �������ְ� ó�����ִ� PreparedStatement
	ResultSet            rs = null; // ������� ������������
	//����Ŭ ������ ������� ����⸦ �޼ҵ�� ����������.
	//�޼ҵ� �ڿ� Exception�� ���̴� �� ����̺� Ŭ������ �߸� �ۼ��Ͽ� ������ �ƴ�
	//��Ÿ�ӿ��� �� ClassNotFoundException�� ������ �ֱ⶧���� �����Ͽ���.
	public Connection getcoConnection() throws Exception { 
		System.out.println("getConnectionȣ�� ����");
		//����Ŭ ȸ�� ������ ������.
		Class.forName(JDBCTest._DRIVER);
		con = DriverManager.getConnection(JDBCTest._URL, JDBCTest._USER, JDBCTest._PW); 
		return con;
	}
	//main()-userInput[���̸� ����]-getZipCodeList('��굿')
	public ZipCodeVO[] getZipCodeList(String userDong) throws Exception{ //����Ŭ�������� select���� �����ϰ� ����ޱ� getZipCodeList
		 //���ܰ� �߻��ϸ� ���� ȣ���� ������ ó���� ��������.
		//����ó���� ���� �����ʰ� �̷��.
		System.out.println("getZipCodeList ȣ�� ����"+userDong);
		ZipCodeVO zcVOS[] = null;
		ZipCodeVO zcVO = new ZipCodeVO();
		String sql = "";
		sql+="SELECT address, zipcode"; 
		sql+=" FROM zipcode_t"; // ���� �ϵ��� �����ϰ� FROM��
		sql+=" WHERE dong LIKE '%'||?||'%'"; //��ȸ����� 3���� ���
		//����Ŭ������ ��û�� ������
		getcoConnection();
		pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, userDong); //?�� ���̸��� ������.
		rs = pstmt.executeQuery();//����Ŭ �������� ó���� ��û��.
		Vector<ZipCodeVO> v = new Vector<>();
		while(rs.next()) { //Ŀ���̵�, Ŀ���̵�
			zcVO = new ZipCodeVO(); 
			zcVO.setAddress(rs.getString("address")); //���������� �ϱ����� "address"
			zcVO.setZipcode(rs.getInt("zipcode"));
			v.add(zcVO);
			//System.out.println("while�� :"+rs.next());//Ŀ���̵�
		}
		zcVOS = new ZipCodeVO[v.size()];
		v.copyInto(zcVOS); //���� �ڷ� ������ ����ִ� ������ �����ϱ�  ����: ������.�޼ҵ�()
		System.out.println("while�� Ż��"); // ��������� SELECT���� �������� ��ó������ �˼�����  �������� false�� �߸鼭 while���� Ż��
		//������ ��û �ϱ����� ����ڷκ��� ���̸��� ���� �Է� �޾ƾ��Ѵ�.
		//zcVO.uid_no = 10; �������� Ŭ�������� ���پ������ϰ� private���� ���Ҵ� ������ ã�ƺ��ƶ�. ���� : private - ���̳� �ۿ��� ���� ����ڰ� ������ �����Ǹ� �ȵ�.
		zcVO.setUid_no(10); //����Ҽ��ִ� . �ʱ�ȭ�Ҽ��ִ�
		printZipCode(zcVOS); //�޼ҵ� ȣ��ÿ��� Ÿ��ǥ�� ����. [] Type�� ǥ�þ���
		return zcVOS;
	}
	//��ȸ�� �����ȣ ����� ����غ���
	public void printZipCode(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zVO:zcVOS) {
			System.out.println(zVO.getAddress()+"    "+zVO.getZipcode());
		}
	}
	//����ڷκ��� ���� �Է¹޴� �޼ҵ带 ������ ���ÿ�.
	public String userInput() {
		//JDBCTest._USER="hr"; static�� �����ϱ� �����̸� ���氡����.  
		//JDBCTest._DRIVER="hr"; �Ұ� final ����� ����Ǿ�	 �Ұ�����.	
		Scanner scan = new Scanner(System.in);
		String userDong = null; // ������������
		userDong = scan.nextLine();
		return userDong; //Ȯ��
		//return "��굿"; Ȯ��
	}	
	//���θ޼ҵ�
	/*
	 * 23(�������ȣ��-entry pointer-main ������)-25(��������:��������)-26-27
	 * 28(�޼ҵ�ȣ��)-11(�Ķ���ʹ� ���� : ������ �ִ�.)-12-13-14-15-16(�Է¹�����Ȯ��)
	 * 28(���ϰ����� ����)-
	 */
	public static void main(String[] args) throws Exception{
		System.out.println("���� �Է����ּ���.");
		String userDong = null; //�ν��� ���� ����
		ZipCodeSearch zs = new ZipCodeSearch(); // static �� ���⿡ �ν��Ͻ�ȭ 
		userDong = zs.userInput(); //�޼ҵ� ȣ��� �ʱ�ȭ  �޼ҵ忡�� ����Ÿ���� ���� �̰� �ٽ�
		if(userDong==null) {
			System.out.println("�ݵ�� ���� �Է��ؾ��մϴ�.");
		return; //������ Ż���ϰ� ��
		}else {
			System.out.println("�����"+userDong+"�� �Է��ϼ̽��ϴ�."); 
			//��º����� ���� �޼ҵ带 ���� ������ �ൿ�� ��ø�Ǿ� ����� n��ŭ �Է��ؾ��ϴ� ��Ȳ�߻� ��� ȣ��� ���ÿ� �ʱ�ȭ�ؾ��Ѵ�.
			ZipCodeVO zcVOS[] = zs.getZipCodeList(userDong);
		}
	}

}
