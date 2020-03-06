package oracle.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao {
	Connection 				con 	= null;
	PreparedStatement		pstmt 	= null;
	ResultSet 				rs 	    = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//�μ� ���տ��� ��ȸ�ϴ� �޼ҵ� �����ϱ�
	//SELECT deptno, dname, loc FROM dept WHERE deptno = 10; 10�� ?��
	//�μ� ���տ��� ��ȸ�ϴ� �޼ҵ� �����ϱ�
	public DeptVO[] deptList(int deptno) {
		//��ȸ����� n���� �� �����Ƿ� ��ü�迭�� �޾ƾ��Ѵ�.
		DeptVO[] dvos = null;
		//�������� �ۼ��Ҷ� String��� StringBuilder�� �־���Ѵ�
		StringBuilder sb = new StringBuilder(); //������
		sb.append(" SELECT deptno, dname, loc FROM dept WHERE deptno = ? ");
		try {
			 con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sb.toString());
	         int i = 0;
	         pstmt.setInt(++i, deptno); //23�� ? �̴ϱ�
	         rs = pstmt.executeQuery(); 
	         DeptVO dVO = null;
	         Vector<DeptVO> v= new Vector<>();
            
	         while(rs.next()) {
            	dVO = new DeptVO();
            	dVO.setDeptno(rs.getInt("deptno"));
            	dVO.setDname(rs.getString("dname"));
            	dVO.setLoc(rs.getString("loc"));
                v.add(dVO);
            }
            dvos = new DeptVO[v.size()];
            v.copyInto(dvos);
            
		} catch (Exception e) {
			// TODO: handle exception
		} finally { //������ �߻��ϴ��� �ڿ��ݳ��� ������ �� ���ּ���.
			//����� �ڿ��� �ݳ����ּ���.
			dbMgr.freeConnection(con, pstmt, rs); //�ڿ��ݳ��ϱ�
		}
		return dvos;
	}
	//�޼ҵ� �����ε��̶�� �Ѵ�.
	//������ �Ķ������ ������ �ٸ��ų� Ȥ�� �Ķ������ Ÿ���� �޶�� �Ѵ�.
	//SELECT deptno, dname, loc FROM dept WHERE deptno>10 AND dname=?;
	public DeptVO[] deptList(int deptno, String dname) {
		return null;
	}
	//INSERT INTO dept(deptno,dname,loc) values(?,?,?);
	//�ű� �μ� ������ ����ϴ� �޼ҵ� �����ϱ�
	public int  deptInsert(int deptno,String dname,String loc) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //������
		sb.append(" INSERT INTO dept(deptno,dname,loc) values(?,?,?) ");
		try {
			con = dbMgr.getConnection();//������θ� ����°� ����� ���ɻ�� �ٵ���־���Ѵ�.
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
	        pstmt.setInt(++i, deptno); 
	        pstmt.setString(++i, dname); 
	        pstmt.setString(++i, loc); 
	        result = pstmt.executeUpdate(); 
		} catch (Exception e) {
			// TODO: handle exception
		}finally { //������ �߻��ϴ��� �ڿ��ݳ��� ������ �� ���ּ���.
			//����� �ڿ��� �ݳ����ּ���.
			dbMgr.freeConnection(con, pstmt); //�ڿ��ݳ��ϱ�
		}
		return result;
	}
	//���� �μ� ������ �����ϴ� �޼ҵ� �����ϱ�
	//UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?
	public int deptUpdate(String dname,String loc,int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //������
		sb.append(" UPDATE dept SET dname = ?, loc = ? WHERE deptno = ? ");
		try {
			con = dbMgr.getConnection();//������θ� ����°� ����� ���ɻ�� �ٵ���־���Ѵ�.
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
	        pstmt.setString(++i, dname); 
	        pstmt.setString(++i, loc);
	        pstmt.setInt(++i, deptno);
	        result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sb.toString());
		}finally { //������ �߻��ϴ��� �ڿ��ݳ��� ������ �� ���ּ���.
			//����� �ڿ��� �ݳ����ּ���.
			dbMgr.freeConnection(con, pstmt); //�ڿ��ݳ��ϱ�
		}
		return result;
	}
	//����� �μ� ���� �ݿ��ϴ� �޼ҵ� �����ϱ�
	//DELETE FROM dept WHERE deptno = ?
	public int deptDelete(int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //������
		sb.append(" DELETE FROM dept WHERE deptno = ? ");
		try {
			con = dbMgr.getConnection();//������θ� ����°� ����� ���ɻ�� �ٵ���־���Ѵ�.
			pstmt = con.prepareStatement(sb.toString());
			int i = 0;
	        pstmt.setInt(++i, deptno);
	        result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sb.toString());
			//delete���� ������ �߻������� delete���� ����ϴ� ������ �ۼ��� �� �ִµ�
			//�̶� ���� sb�� ����Ҽ� �ִ� |����
		}finally { //������ �߻��ϴ��� �ڿ��ݳ��� ������ �� ���ּ���.
			//����� �ڿ��� �ݳ����ּ���.
			dbMgr.freeConnection(con, pstmt); //�ڿ��ݳ��ϱ�
		}
		return result;
	}
}
