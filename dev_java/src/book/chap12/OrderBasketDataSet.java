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
	DBConnectionMgr  dbMgr  = DBConnectionMgr.getInstance(); // db�����Ҷ� DBC�ν��Ͻ�
	//main�޼ҵ带 ���� ��Ʈ�� �� �� ����. JVM
	public ArrayList<OrderBasketVO> getList2(){ // ���ο��� �Ծ��Ѱ��� DB����ó��
	 //ArrayList<OrderBasketVO> al = null; �̰� ������ ���� �ϰ� �ʺ��� �ּ�ó���� 
		ArrayList<OrderBasketVO> al = new ArrayList<OrderBasketVO>();
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT                                              ");
	   	sql.append("	decode(b.rno,1,a.indate_vc,2,'�Ѱ�')	indate_vc    ");
	   	sql.append("	,sum(a.qty_nu) t_qty              				 ");
	   	sql.append("	,sum(a.qty_nu*price_nu) t_price 				 ");
	    sql.append(" FROM t_orderbasket a                                ");
	    sql.append("    ,(SELECT rownum rno FROM dept WHERE rownum <3)b  ");
	    sql.append(" GROUP BY decode(b.rno,1,a.indate_vc,2,'�Ѱ�')        ");
	    sql.append(" ORDER BY decode(b.rno,1,a.indate_vc,2,'�Ѱ�')        ");
	    try {
	    	con = dbMgr.getConnection(); //db����
	    	pstmt = con.prepareStatement(sql.toString());// ������ ��ĵ
	    	rs = pstmt.executeQuery();//select�϶� executeQuery
	    	//VO�� �ѹ��� �Ѱ� �ο츸 ���� �� �־��. �ΰ� �ο�� �ȵ���.
	    	//VO�� ���� �ϳ��� �Ѱ� ���� ��� ������ �����߱� ��������.
	    	OrderBasketVO obVO = null;
	    	while(rs.next()) {
	    		obVO = new OrderBasketVO();
	    		//����Ŭ���� ���� ���� rs�� ������ 
	    		//������ ���� ���� obVO�� ����� ���� �� indate_vc������ ����
	    		//����ּ���
	    		//�� setter �޼ҵ�� ���� �ڲٸ� ��°ž�? 
	    	    obVO.setIndate_vc(rs.getString("indate_vc")); //rs���� �����ö� �� ��Ʈ��
	    	    obVO.setT_qty(rs.getInt("t_qty")); // rs���� �����ö� �� ��Ʈ
	    	    obVO.setT_price(rs.getInt("t_price")); // rs���� �����ö� �� ��Ʈ
	    	    al.add(obVO); //��� ����Ʈ�� �־���ϴ� add �սô�  al = new ArrayLis();
	    	}
		} catch (SQLException se) { //����Ŭ���� �߻��Ǵ� �����޼���
			//�ڹ� ������ ��Ŭ�������� ��� ����Ŭ������ ��忡�� ��°� ���ڴ�.
			System.out.println(se.toString()); //java.sql.SQLException: �������� �� �̸� ��Ʈ��
		} catch(Exception e) {//�ڹ���õ���� �߻��Ǵ� �����޼��� ���
			System.out.println(e.toString()); //�ڹٵ� ��������
		}
		return al; // al=null; al�� null���� ���ݾ�? �׷��� al�� ���� Ȯ�� �ؾ��� ���� ��ٸ� 
	}
	
	public ArrayList<OrderBasketVO> getList() // ���ο��� �Ծ��Ѱ��� ���ó��
	{
		ArrayList<OrderBasketVO> al = new ArrayList();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);        // �����ƴ� �߰��Ȱɷ� �Է�
		obVO.setT_price(560000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);;
		obVO.setT_price(360000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("�Ѱ�");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		return al;
	}

	public static void main(String[] args) {
		//ArrayList<Integer>   al2 = new ArrayList<Integer>(); �̷��ŵ� �ִٶ������
 		ArrayList<OrderBasketVO> al = new ArrayList();
		OrderBasketVO obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-19");
		obVO.setT_qty(150);        // �����ƴ� �߰��Ȱɷ� �Է�
		obVO.setT_price(560000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("2020-02-20");
		obVO.setT_qty(105);;
		obVO.setT_price(360000);;
		al.add(obVO);
		obVO = new OrderBasketVO();
		obVO.setIndate_vc("�Ѱ�");
		obVO.setT_qty(255);
		obVO.setT_price(920000);
		al.add(obVO);
		for(OrderBasketVO obVO2:al) { //����for�� ���� ���� �ߺ����� �Ҽ� ���� ��� 2 ����
			System.out.print(obVO2.getIndate_vc()
					+"    "+obVO2.getT_qty()
					+"    "+obVO2.getT_price()+"\n"); //���� �����Ŵ� ln���� ��¥����ؔg 
		}
		
		
	}

}
