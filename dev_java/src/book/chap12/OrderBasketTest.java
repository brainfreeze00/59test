package book.chap12;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//JFrame�� ��ӹ޾����Ƿ� �ڽ� Ŭ������ OrderBasketTest Ŭ������ �ν��Ͻ� ������
//�θ� ���� ������ �޼ҵ带 ���� �� �ִ�.
public class OrderBasketTest extends JFrame {
	String cols[] 		  = {"��¥", "�Ǹż���", "�����"}; // ȭ�� �÷���
	String data[][] 	  = new String[0][3]; // ��ũ�������� ���� ���� ����
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
//���� �������� �ִ� Ŭ���� ���̿��� ������ �޼ҵ峪 �ڵ����� 
	//�������� �Ķ���͸� ���ؼ� ���� �ʱ�ȭ�� �� �ִ�.
	JTable jtb 			  = new JTable(dtm);
	JScrollPane jsp 	  = new JScrollPane(jtb);
	
	public OrderBasketTest() {
		
	}
	
	public void initDisplay() {
		this.add("Center",jsp);//jtb��� JScrollPane jsp �� ���Ϳ� �߰��Ͽ� �÷� ��Ÿ���� ����
		this.setSize(500, 500);
		this.setVisible(true);
		dataSetMapping(); // Ư�̻��� ����
	}
	public void dataSetMapping() { // OrderBasketDataSetŬ���� �ν��Ͻ�ȭ �� ��� ����Ʈ ���
		OrderBasketDataSet ds = new OrderBasketDataSet();
		ArrayList<OrderBasketVO> al = ds.getList2();
		for(int x=0;x<al.size();x++) {
			Vector v = new Vector();
			v.add(al.get(x).getIndate_vc());// al.get(x)�� getIndate_vc()�� ��ġ
			v.add(al.get(x).getT_qty()); // al.get(x)�� getT_qty()�� ��ġ
			v.add(al.get(x).getT_price());// al.get(x)�� getT_price()�� ��ġ
			dtm.addRow(v);//dtm�� v�������� Row�� �߰��Ѵ�.
		}
	}
	public static void main(String[] args) {
		OrderBasketTest obt = new OrderBasketTest();
		obt.initDisplay();
	}

}
