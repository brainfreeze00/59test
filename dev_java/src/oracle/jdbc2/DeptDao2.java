package oracle.jdbc2;
/* VO = 값오브젝트 
 * 자바는 값 타입을 표현하기 위해 불변 클래스를 만들어 사용한다. 불변 클래스라면
 * readOnly 특징을 가진다. 예를 들자면 String, Integer, Color 클래스등이 있다.
 * 이러한 클래스를 예로 들어 설명해보자면 Red를 표현하기위해서는 Color.RED등과 같이 값을
 * 표현하기 위해  getter 기능(메소드)만이 존재한다.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao2 {
	//커넥션형인 con을 null선언과 동시 초기 : 자바와 오라클서버를 연결해주는 역할
	Connection 				con 	= null;    // 
	//프리패형인 pstmt를 null선언과 동시에 초기화 : 쿼리문을 전환시키는 역할
	PreparedStatement		pstmt 	= null;
	//리절트형인 rs를 null선언과 동시에 초기화 :  SELECT문을 썼을때 쿼리 결과값을 담아주는 역할
	ResultSet 				rs 	    = null;
	//디비시형인 dbmgr을 DBConnectionMgr클래스의 getInstance메소드를 실행한다. (DBConeection(static) dbMgr 이 null이면 새로 인스턴스화 하고  아닌겨우 있는그대로 놔둔다.)
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//public 모두 접근 가능하며  DeptVO[]반환타입의 int deptno 파라미터의 deptList메소드
	public DeptVO[] deptList(int deptno) {
		// DeptVO형 배열인  dvos를 null로 선언과 동시에 초기화  ->
		DeptVO[] dvos = null;
		// StringBuilder형인 sb에 인스턴스화 한다 (변수 sb에 쿼리문을 담을거다)
		StringBuilder sb = new StringBuilder(); //쿼리문
		//sb의 append메소드를 사용하여 .deptno,dname, loc를 찾는것인데 dept로부터 deptno = ?인 조건으로  
		sb.append(" SELECT deptno, dname, loc FROM dept WHERE deptno = ? ");
		//try - 이 코드를 실행하였을때
		try {
			//con에 dbMgr.getConnection의 리턴값을 대입한다.
			 con = dbMgr.getConnection(); 
			 //pstmt에 con.prepareStatement(sb의 toString메소드를 사용하여 sb.toString()의 리턴값을 가져온것)을 대입
	         pstmt = con.prepareStatement(sb.toString());
	         //차례를 변수형태로 사용하기위해 선언과 동시에 초기화
	         int i = 0;
	         //매개변수 값 대입 + 매개변수 유호화처리
	         pstmt.setInt(++i, deptno); //23번 ? 이니까  setInt메소드 지정된 파라미터를 지정된 Java int 값으로 설정합니다.
	         //PreparedStatement 객체에서 SQL 쿼리를 실행하고 쿼리에 의해 생성 된 ResultSet 객체를 반환합니다.
	         rs = pstmt.executeQuery(); 
	         //DeptVO형의 dVO를 선언과 동시에 null로 초기화
	         DeptVO dVO = null;
	         //오직 DeptVO클래스만 담을 Vector 클래스형 v를 선언과 동시에 초기화
	         Vector<DeptVO> v= new Vector<>();
            
	         while(rs.next()) {
            	dVO = new DeptVO();
            	// dVO의 셋덷노 메소드를 실행한다.그안에 인자로 RS.GETINT("DEPTNO")를 실행한다. DEPTNO는 컬럼이름이다.
            	dVO.setDeptno(rs.getInt("deptno")); 
            	// dVO의 셋덷노 메소드를 실행한다.그안에 인자로 RS.GETSTRING("DNAME")를 실행한다. DNAME는 컬럼이름이다.
            	dVO.setDname(rs.getString("dname")); 
            	// dVO의 셋덷노 메소드를 실행한다.그안에 인자로 RS.GETSTRING("LOC")를 실행한다. LOC는 컬럼이름이다.
            	dVO.setLoc(rs.getString("loc")); 
            	//v에 dVO를 추가한다.
                v.add(dVO);  
            }//dvos 에 새로운 객체를 생성한다. DeptVO형인 배열로. 크기는  v의 row수 만큼 생성한다.
	         dvos = new DeptVO[v.size()];
	         //
	         v.copyInto(dvos);
            
            //catch - 문제가 있다면 다음을 실행하여라  
		} catch (Exception e) {
			// TODO: handle exception
		} finally { //에러가 발생하더라도 자원반납은 무조건 꼭 해주세요.
			dbMgr.freeConnection(con, pstmt, rs); //자원반납하기
		}
		return dvos;
	}
}