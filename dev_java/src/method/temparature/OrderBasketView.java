package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

public class OrderBasketView {
	//����
	Connection          con = null; // �������������ϱ� - Ŭ���� �������� ��밡����.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	JTextField     jtf_date = new JTextField(" "); // �˻�����
	JButton     jbtn_search = new JButton("��ȸ");
	String            cols[] = {" "," "," "}; // �÷���
	String          data[][] = new String[4][3]; 
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // �Ķ���� 2���� �޾Ƽ� �ʱ�ȭ�� �Ҽ��ִ�.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm�� �����͸� �����ְ� ���̺��� ����� ������ �����Ͱ� ���� �׷��� ������
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //�ü������ â�� ����.
	JPanel            jp_north = new JPanel(); //������ ������ش�.
	JComboBox   	  jcb_year = null; //�����޺��ڽ� �������� ����
	JComboBox   	 jcb_month = null; 
	SeoulTempDAO		stDao  = new SeoulTempDAO(); // initDisplay(); �ǾƷ��� ��ġ�ϹǷ� new A();���·� ����
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	
	//����
	public OrderBasketView() {
		
	}
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		new OrderBasketView();
		
	}

}
