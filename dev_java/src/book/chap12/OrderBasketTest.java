package book.chap12;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//JFrame을 상속받았으므로 자식 클래스인 OrderBasketTest 클래스의 인스턴스 변수로
//부모가 가진 변수나 메소드를 누릴 수 있다.
public class OrderBasketTest extends JFrame {
	String cols[] 		  = {"날짜", "판매수량", "매출액"}; // 화면 컬럼명
	String data[][] 	  = new String[0][3]; // 스크롤패인을 통해 단점 보안
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
//서로 의존도가 있는 클래스 사이에서 별도의 메소드나 코딩없이 
	//생성자의 파라미터를 통해서 값을 초기화할 수 있다.
	JTable jtb 			  = new JTable(dtm);
	JScrollPane jsp 	  = new JScrollPane(jtb);
	
	public OrderBasketTest() {
		
	}
	
	public void initDisplay() {
		this.add("Center",jsp);//jtb대신 JScrollPane jsp 를 센터에 추가하여 컬럼 나타나게 해줌
		this.setSize(500, 500);
		this.setVisible(true);
		dataSetMapping(); // 특이사항 없음
	}
	public void dataSetMapping() { // OrderBasketDataSet클래스 인스턴스화 후 어레이 리스트 사용
		OrderBasketDataSet ds = new OrderBasketDataSet();
		ArrayList<OrderBasketVO> al = ds.getList2();
		for(int x=0;x<al.size();x++) {
			Vector v = new Vector();
			v.add(al.get(x).getIndate_vc());// al.get(x)이 getIndate_vc()의 위치
			v.add(al.get(x).getT_qty()); // al.get(x)이 getT_qty()의 위치
			v.add(al.get(x).getT_price());// al.get(x)이 getT_price()의 위치
			dtm.addRow(v);//dtm에 v값을넣은 Row를 추가한다.
		}
	}
	public static void main(String[] args) {
		OrderBasketTest obt = new OrderBasketTest();
		obt.initDisplay();
	}

}
