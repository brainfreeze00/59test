package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.util.DBConnectionMgr;

public class OrderBasketDataSet {
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	DBConnectionMgr  dbMgr  = DBConnectionMgr.getInstance(); // db연결할때 DBC인스턴스
	//main메소드를 직접 컨트롤 할 수 없다. JVM
	public ArrayList<OrderBasketVO> getList2(){ // 메인에서 입양한거임 DB연동처리
	 //ArrayList<OrderBasketVO> al = null; 이게 맞지만 아직 니가 초보라 주석처리함 
		ArrayList<OrderBasketVO> al = new ArrayList<OrderBasketVO>();
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT                                              ");
	   	sql.append("	decode(b.rno,1,a.indate_vc,2,'총계')	indate_vc    ");
	   	sql.append("	,sum(a.qty_nu) t_qty              				 ");
	   	sql.append("	,sum(a.qty_nu*price_nu) t_price 				 ");
	    sql.append(" FROM t_orderbasket a                                ");
	    sql.append("    ,(SELECT rownum rno FROM dept WHERE rownum <3)b  ");
	    sql.append(" GROUP BY decode(b.rno,1,a.indate_vc,2,'총계')        ");
	    sql.append(" ORDER BY decode(b.rno,1,a.indate_vc,2,'총계')        ");
	    try {
	    	con = dbMgr.getConnection(); //db연동
	    	pstmt = con.prepareStatement(sql.toString());// 쿼리문 스캔
	    	rs = pstmt.executeQuery();//select일때 executeQuery
	    	//VO는 한번에 한개 로우만 담을 수 있어요. 두개 로우는 안되죠.
	    	//VO는 변수 하나에 한개 값만 담는 변수를 선언했기 때문이죠.
	    	OrderBasketVO obVO = null;
	    	while(rs.next()) {
	    		obVO = new OrderBasketVO();
	    		//오라클에서 꺼낸 값은 rs로 꺼내고 
	    		//위에서 꺼낸 값은 obVO에 선언된 변수 중 indate_vc변수에 값을
	    		//담아주세요
	    		//왜 setter 메소드로 값을 자꾸만 담는거야? 
	    	    obVO.setIndate_vc(rs.getString("indate_vc")); //rs에서 가져올때 겟 스트링
	    	    obVO.setT_qty(rs.getInt("t_qty")); // rs에서 가져올때 겟 인트
	    	    obVO.setT_price(rs.getInt("t_price")); // rs에서 가져올때 겟 인트
	    	    al.add(obVO); //어레이 리스트에 넣어야하니 add 합시다  al = new ArrayLis();
	    	}
		} catch (SQLException se) { //오라클에서 발생되는 에러메세지
			//자바 에러는 이클립스에서 잡고 오라클에러는 토드에서 잡는게 낫겠다.
			System.out.println(se.toString()); //java.sql.SQLException: 부적합한 열 이름 힌트줌
		} catch(Exception e) {//자바전천에서 발생되는 에러메세지 잡기
			System.out.println(e.toString()); //자바도 에러잡자
		}
		return al; // al=null; al이 null수도 있잖아? 그러니 al이 뭔지 확인 해야해 에러 뜬다면 
	}
	
	public ArrayList<OrderBasketVO> getList() // 메인에서 입양한거임 상수처리
	{
		ArrayList<OrderBasketVO> al = new ArrayList();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);        // 기존아닌 추가된걸로 입력
		obVO.setT_price(560000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);;
		obVO.setT_price(360000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("총계");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		return al;
	}

	public static void main(String[] args) {
		//ArrayList<Integer>   al2 = new ArrayList<Integer>(); 이런거도 있다라는정도
 		ArrayList<OrderBasketVO> al = new ArrayList();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);        // 기존아닌 추가된걸로 입력
		obVO.setT_price(560000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);;
		obVO.setT_price(360000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("총계");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		for(OrderBasketVO obVO2:al) { //개선for문 같은 수는 중복정의 할수 없다 고로 2 붙임
			System.out.print(obVO2.getIndate_vc()
					+"    "+obVO2.getT_qty()
					+"    "+obVO2.getT_price()+"\n"); //옆에 찍을거니 ln삭제 날짜출력해봥 
		}
		
		
	}

}
