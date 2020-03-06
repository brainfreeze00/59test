package UI.swing;
// Ʋ���� ã�ƺ��� �̰� ��ǥ��
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.util.DBConnectionMgr;

public class JComboBoxTest00 implements ItemListener {
	//�����
	JFrame jf = new JFrame();
	String data[] = null; // ����
	JComboBox jcb_dept = null;  // nullpointexception ���� ��ġ��
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//������
	JComboBoxTest00() {
		//insert here
		data = getDeptList(); //���ȿ� �ִ� �޼ҵ��̴ϱ� �ν��Ͻ� ���ϰ� �ٷ� ȣ��
		jcb_dept = new JComboBox(data);
		jcb_dept.addItemListener(this); //�������̽��� �̸��� �޶������� ó������� ���⿡  �׸��� ���ȿ� �ֱ⿡ this 
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE); // ��� �޾ƾ� ��밡�� ��� �ּ�
		JFrame jf = new JFrame();
		jf.add("North",jcb_dept); // JComboBox ���� ����
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setTitle("�μ�");
	}
	/*
	 * ����Ŭ�������� dept ���̺� �ִ� ������ ��ȸ�Ͻÿ�.
	 * ��ȸ�� ������ data�迭�� �ʱ�ȭ�Ͻÿ�.
	 */
	public String[] getDeptList() {
			String depts[] = null; 
			StringBuilder sb = new StringBuilder();   // String��� ������ �ۼ��� StringBuilder Ŭ���� ���
			
			sb.append("SELECT dname FROM dept");
			
			try {//���������� ������ �ִ� ������ IP�ּҷ� �����ϴϱ� ���ܰ� �߻��� ���ɼ��� ����.  �� ������ �����Ǿ�� �Ѵ�.
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sb.toString()); 
				rs = pstmt.executeQuery(); //select���� ó������~
				Vector<String> v = new Vector<>();
				while(rs.next()) { // while�� �ٵ��ƾ� ũ�⸦ ���ϰ� ���� ������ ��������.
					String dname = rs.getString("dname");
					v.add(dname);
				}
				depts = new String[v.size()]; // null�� �߱⿡ �ν��Ͻ�ȭ �ؾ��Ѵ�. 
				v.copyInto(depts); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			return depts;
		}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true); // ȭ �� �� ��
		new JComboBoxTest();
	}
	/* ItemListener�� ���� ��Ī�� �������̽��̴�.
	 * �������̽��� �߻�޼ҵ带 ������ �����Ƿ� �ݵ�� ������ �־���Ѵ�.
	 * �̶� �θ� ���� �޼ҵ��� ������ ����� �Ѽ��ؼ��� �ȵȴ�. ������ �Ķ���� ���� ����
	 */
	@Override
	public void itemStateChanged(ItemEvent ie) { // 
		Object obj = ie.getSource();
		if(obj == jcb_dept) { //�޺��ڽ��� �Ͼ�ٴ� ��
			if(ie.getStateChange()==ItemEvent.SELECTED) {// ���õǾ��°�?
				System.out.println(jcb_dept.getSelectedIndex()); // ����Ÿ�� int
			}
		}
	}

}
