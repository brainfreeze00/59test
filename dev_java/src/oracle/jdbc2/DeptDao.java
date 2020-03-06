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
	//부서 집합에서 조회하는 메소드 선언하기
	//SELECT deptno, dname, loc FROM dept WHERE deptno = 10; 10을 ?로
	//부서 집합에서 조회하는 메소드 선언하기
	public DeptVO[] deptList(int deptno) {
		//조회결과가 n건일 수 있으므로 객체배열로 받아야한다.
		DeptVO[] dvos = null;
		//쿼리문을 작성할때 String대신 StringBuilder가 있어야한다
		StringBuilder sb = new StringBuilder(); //쿼리문
		sb.append(" SELECT deptno, dname, loc FROM dept WHERE deptno = ? ");
		try {
			 con = dbMgr.getConnection();
	         pstmt = con.prepareStatement(sb.toString());
	         int i = 0;
	         pstmt.setInt(++i, deptno); //23번 ? 이니까
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
		} finally { //에러가 발생하더라도 자원반납은 무조건 꼭 해주세요.
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt, rs); //자원반납하기
		}
		return dvos;
	}
	//메소드 오버로딩이라고 한다.
	//무조건 파라미터의 개수가 다르거나 혹은 파라미터의 타입이 달라야 한다.
	//SELECT deptno, dname, loc FROM dept WHERE deptno>10 AND dname=?;
	public DeptVO[] deptList(int deptno, String dname) {
		return null;
	}
	//INSERT INTO dept(deptno,dname,loc) values(?,?,?);
	//신규 부서 정보를 등록하는 메소드 선언하기
	public int  deptInsert(int deptno,String dname,String loc) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //쿼리문
		sb.append(" INSERT INTO dept(deptno,dname,loc) values(?,?,?) ");
		try {
			con = dbMgr.getConnection();//연결통로를 만드는건 공통된 관심사는 다들어있어야한다.
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
	        pstmt.setInt(++i, deptno); 
	        pstmt.setString(++i, dname); 
	        pstmt.setString(++i, loc); 
	        result = pstmt.executeUpdate(); 
		} catch (Exception e) {
			// TODO: handle exception
		}finally { //에러가 발생하더라도 자원반납은 무조건 꼭 해주세요.
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt); //자원반납하기
		}
		return result;
	}
	//기존 부서 정보를 수정하는 메소드 선언하기
	//UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?
	public int deptUpdate(String dname,String loc,int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //쿼리문
		sb.append(" UPDATE dept SET dname = ?, loc = ? WHERE deptno = ? ");
		try {
			con = dbMgr.getConnection();//연결통로를 만드는건 공통된 관심사는 다들어있어야한다.
			pstmt = con.prepareStatement(sb.toString());
			int i=0;
	        pstmt.setString(++i, dname); 
	        pstmt.setString(++i, loc);
	        pstmt.setInt(++i, deptno);
	        result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sb.toString());
		}finally { //에러가 발생하더라도 자원반납은 무조건 꼭 해주세요.
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt); //자원반납하기
		}
		return result;
	}
	//사라진 부서 정보 반영하는 메소드 선언하기
	//DELETE FROM dept WHERE deptno = ?
	public int deptDelete(int deptno) {
		int result = 0;
		StringBuilder sb = new StringBuilder(); //쿼리문
		sb.append(" DELETE FROM dept WHERE deptno = ? ");
		try {
			con = dbMgr.getConnection();//연결통로를 만드는건 공통된 관심사는 다들어있어야한다.
			pstmt = con.prepareStatement(sb.toString());
			int i = 0;
	        pstmt.setInt(++i, deptno);
	        result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sb.toString());
			//delete문에 에러가 발생했을때 delete문을 출력하는 문장을 작성할 수 있는데
			//이때 변수 sb를 사용할수 있다 |없다
		}finally { //에러가 발생하더라도 자원반납은 무조건 꼭 해주세요.
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt); //자원반납하기
		}
		return result;
	}
}
