package UI.swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao {
	//����Ŭ ������ ������θ� ����µ� �ʿ��� �������̽��Դϴ�.
	Connection con = null;
	//������ΰ� ��������� �� ����  ���� select���� ����Ŭ���� ������ �� Ŭ������ �ʿ�����
	//�� ���̰� PreparedStatement �Դϴ�.
	PreparedStatement pstmt = null;
	//��ȸ����� ����Ŭ �����κ��� �������� Ŀ���� �ʿ��ϵ� �� Ŀ���� �����Ҽ� �ֵ���
	//�ڹٿ��� �����Ǵ� �������̽��� ResultSet�Դϴ�.
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//�޼ҵ��� ����Ÿ���� �迭�� �߾��. �ֳ��ϸ� �� �迭��  JComboBox�� ������
	//�Ķ���ͷ� �Ѱܾ� �ϱ� ������ ����Ÿ���� �� �ʿ��Ѱ���.
	public String[] getDeptList() {
		//�μ����� ���� �迭�� �����߾��. �׷��� �����ϴ°� �ȵɰ� ���ƿ�.
		//�ֳ��ϸ� ����Ŭ���� �������� ������� �˾ƾ� �迭�� ũ�⸦ ���Ҽ� �ֱ� ��������.
		String depts[] = null; 
		//�������� �ۼ��Ҷ� ���� �ο찡 ���ü� �ִµ� String �� ����ϸ� ������ �ٲ��� 
		//�ʾƼ� �ڹټ���Ʃ�������� �������մϴ�.
		//��� StringBuilder �� ����϶�� ��������
		//�� Ŭ������ ������ �ٲ�� ������ ���ʿ��� �ڿ����� ������ �ֵ���.
		//���� ���忡���� ���� ������ ���� ���Ƽ� ���� �������� ū ������ ����ų���� �ִٰ�
		//�մϴ�.
		StringBuilder sb = new StringBuilder();   // String��� ������ �ۼ��� StringBuilder Ŭ���� ���
		//������ �ۼ��ϱ�
		sb.append("SELECT dname FROM dept");
		//���ܰ� �߻��Ǹ� �ý����� ���� �� �ְ� �˴ϴ�.
		//������ ��ٸ��� ��Ȳ�� �߻��ϹǷ� ���� ����� �̿� �� �� ����.
		try {//���������� ������ �ִ� ������ IP�ּҷ� �����ϴϱ� ���ܰ� �߻��� ���ɼ��� ����.  �� ������ �����Ǿ�� �Ѵ�.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString()); 
			rs = pstmt.executeQuery(); //select���� ó������~
			Vector<String> v = new Vector<>();
			//Ŀ���� ���پ� �ѱ�鼭 Ŀ����ġ�� ���� ������ ��´�.
			while(rs.next()) { // while�� �ٵ��ƾ� ũ�⸦ ���ϰ� ���� ������ ��������.
				String dname = rs.getString("dname");
				//��ȸ�� ���� ���� Ŭ������ �߰��Ѵ�.
				v.add(dname);
			}
			//����Ŭ �������� ��ȸ�� ��� ��ŭ �߰��� ������ ũ�Ⱚ�� ������
			//�迭�� �����Ѵ�.
			depts = new String[v.size()]; // null�� �߱⿡ �ν��Ͻ�ȭ �ؾ��Ѵ�. 
			//���Ϳ� ��� �ִ� ������ String�迭�� �����Ѵ�.
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
