package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

public class TdeptManager extends JFrame {
	
	String cols[] 		  = {"아이디", "사원명", "부서명"}; // 화면 컬럼명
	String data[][] 	  = new String[0][3]; // 스크롤패인을 통해 단점 보안
	//데이터를 갖고 있음 이게 있어야 화면에 데이터를 뿌릴수있고 data와 cols를 받을 객체 생성
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	//표만들기위해 dtm을 담을 객체 생성 
	JTable jtb 			  = new JTable(dtm);
	JScrollPane jsp 	  = new JScrollPane(jtb);
	//드라이버로딩 후 Connection 객체 생성
	Connection con 			= null;
	//쿼리문 객체 생성
	PreparedStatement pstmt = null;
	//결과 받을 객체 생성
	ResultSet rs 			= null;
	//Pool을 사용해서 DB 연결하기
	DBConnectionMgr  dbMgr  = DBConnectionMgr.getInstance(); 
	//디폴트 생성자
	public TdeptManager() {
		
	}
	
	public void initDisplay() {
		this.setTitle("사원정보 조회");
		this.add("Center",jsp);//jtb대신 JScrollPane jsp 를 센터에 추가하여 컬럼 나타나게 해줌
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public ArrayList<TempVO> getDeptList(){ // 메인에서 입양한거임 DB연동처리
		 //ArrayList<OrderBasketVO> al = null; 이게 맞지만 아직 니가 초보라 주석처리함 
			ArrayList<TempVO> al = new ArrayList<TempVO>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT emp_id, emp_name, dept_name      ");
			sql.append(" FROM temp,tdept                         ");
			sql.append(" WHERE temp.dept_code = tdept.dept_code  ");
		    try {
		    	con = dbMgr.getConnection(); //db연동
		    	pstmt = con.prepareStatement(sql.toString());// 쿼리문 스캔
		    	rs = pstmt.executeQuery();//select일때 executeQuery
		    	//VO는 한번에 한개 로우만 담을 수 있어요. 두개 로우는 안되죠.
		    	//VO는 변수 하나에 한개 값만 담는 변수를 선언했기 때문이죠.
		    	TempVO tVO = null;
		    	while(rs.next()) {
		    		tVO = new TempVO();
		    		//오라클에서 꺼낸 값은 rs로 꺼내고 
		    		//위에서 꺼낸 값은 obVO에 선언된 변수 중 indate_vc변수에 값을
		    		//담아주세요
		    		//왜 setter 메소드로 값을 자꾸만 담는거야? 
		    		tVO.setEmp_id(rs.getInt("emp_id")); //rs에서 가져올때 겟 스트링
		    		tVO.setEmp_name(rs.getString("emp_name")); // rs에서 가져올때 겟 인트
		    		//tVO.setDept_name(rs.getString("dept_name")); // rs에서 가져올때 겟 인트
		    	    al.add(tVO); //어레이 리스트에 넣어야하니 add 합시다  al = new ArrayLis();
		    	}
			} catch (SQLException se) { //오라클에서 발생되는 에러메세지
				//자바 에러는 이클립스에서 잡고 오라클에러는 토드에서 잡는게 낫겠다.
				System.out.println(se.toString()); //java.sql.SQLException: 부적합한 열 이름 힌트줌
			} catch(Exception e) {//자바전천에서 발생되는 에러메세지 잡기
				System.out.println(e.toString()); //자바도 에러잡자
			}
			return al; // al=null; al이 null수도 있잖아? 그러니 al이 뭔지 확인 해야해 에러 뜬다면 
		}
		
	
	public static void main(String[] args) {
		 TdeptManager tm = new TdeptManager();
		 tm.initDisplay();
	}

}
