package oracle.jdbc2;
/* VO = ��������Ʈ 
 * �ڹٴ� �� Ÿ���� ǥ���ϱ� ���� �Һ� Ŭ������ ����� ����Ѵ�. �Һ� Ŭ�������
 * readOnly Ư¡�� ������. ���� ���ڸ� String, Integer, Color Ŭ�������� �ִ�.
 * �̷��� Ŭ������ ���� ��� �����غ��ڸ� Red�� ǥ���ϱ����ؼ��� Color.RED��� ���� ����
 * ǥ���ϱ� ����  getter ���(�޼ҵ�)���� �����Ѵ�.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao2 {
	//Ŀ�ؼ����� con�� null����� ���� �ʱ� : �ڹٿ� ����Ŭ������ �������ִ� ����
	Connection 				con 	= null;    // 
	//���������� pstmt�� null����� ���ÿ� �ʱ�ȭ : �������� ��ȯ��Ű�� ����
	PreparedStatement		pstmt 	= null;
	//����Ʈ���� rs�� null����� ���ÿ� �ʱ�ȭ :  SELECT���� ������ ���� ������� ����ִ� ����
	ResultSet 				rs 	    = null;
	//�������� dbmgr�� DBConnectionMgrŬ������ getInstance�޼ҵ带 �����Ѵ�. (DBConeection(static) dbMgr �� null�̸� ���� �ν��Ͻ�ȭ �ϰ�  �ƴѰܿ� �ִ±״�� ���д�.)
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//public ��� ���� �����ϸ�  DeptVO[]��ȯŸ���� int deptno �Ķ������ deptList�޼ҵ�
	public DeptVO[] deptList(int deptno) {
		// DeptVO�� �迭��  dvos�� null�� ����� ���ÿ� �ʱ�ȭ  ->
		DeptVO[] dvos = null;
		// StringBuilder���� sb�� �ν��Ͻ�ȭ �Ѵ� (���� sb�� �������� �����Ŵ�)
		StringBuilder sb = new StringBuilder(); //������
		//sb�� append�޼ҵ带 ����Ͽ� .deptno,dname, loc�� ã�°��ε� dept�κ��� deptno = ?�� ��������  
		sb.append(" SELECT deptno, dname, loc FROM dept WHERE deptno = ? ");
		//try - �� �ڵ带 �����Ͽ�����
		try {
			//con�� dbMgr.getConnection�� ���ϰ��� �����Ѵ�.
			 con = dbMgr.getConnection(); 
			 //pstmt�� con.prepareStatement(sb�� toString�޼ҵ带 ����Ͽ� sb.toString()�� ���ϰ��� �����°�)�� ����
	         pstmt = con.prepareStatement(sb.toString());
	         //���ʸ� �������·� ����ϱ����� ����� ���ÿ� �ʱ�ȭ
	         int i = 0;
	         //�Ű����� �� ���� + �Ű����� ��ȣȭó��
	         pstmt.setInt(++i, deptno); //23�� ? �̴ϱ�  setInt�޼ҵ� ������ �Ķ���͸� ������ Java int ������ �����մϴ�.
	         //PreparedStatement ��ü���� SQL ������ �����ϰ� ������ ���� ���� �� ResultSet ��ü�� ��ȯ�մϴ�.
	         rs = pstmt.executeQuery(); 
	         //DeptVO���� dVO�� ����� ���ÿ� null�� �ʱ�ȭ
	         DeptVO dVO = null;
	         //���� DeptVOŬ������ ���� Vector Ŭ������ v�� ����� ���ÿ� �ʱ�ȭ
	         Vector<DeptVO> v= new Vector<>();
            
	         while(rs.next()) {
            	dVO = new DeptVO();
            	// dVO�� �K�� �޼ҵ带 �����Ѵ�.�׾ȿ� ���ڷ� RS.GETINT("DEPTNO")�� �����Ѵ�. DEPTNO�� �÷��̸��̴�.
            	dVO.setDeptno(rs.getInt("deptno")); 
            	// dVO�� �K�� �޼ҵ带 �����Ѵ�.�׾ȿ� ���ڷ� RS.GETSTRING("DNAME")�� �����Ѵ�. DNAME�� �÷��̸��̴�.
            	dVO.setDname(rs.getString("dname")); 
            	// dVO�� �K�� �޼ҵ带 �����Ѵ�.�׾ȿ� ���ڷ� RS.GETSTRING("LOC")�� �����Ѵ�. LOC�� �÷��̸��̴�.
            	dVO.setLoc(rs.getString("loc")); 
            	//v�� dVO�� �߰��Ѵ�.
                v.add(dVO);  
            }//dvos �� ���ο� ��ü�� �����Ѵ�. DeptVO���� �迭��. ũ���  v�� row�� ��ŭ �����Ѵ�.
	         dvos = new DeptVO[v.size()];
	         //
	         v.copyInto(dvos);
            
            //catch - ������ �ִٸ� ������ �����Ͽ���  
		} catch (Exception e) {
			// TODO: handle exception
		} finally { //������ �߻��ϴ��� �ڿ��ݳ��� ������ �� ���ּ���.
			dbMgr.freeConnection(con, pstmt, rs); //�ڿ��ݳ��ϱ�
		}
		return dvos;
	}
}