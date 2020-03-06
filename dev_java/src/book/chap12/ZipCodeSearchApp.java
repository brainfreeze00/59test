package book.chap12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.ZipCodeVO;
import oracle.jdbc2.JDBCTest;
public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
	String zdos[] = null; // 
	String zdo = null;
	JComboBox jcb_zdo = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection          con = null; // �������������ϱ� - Ŭ���� �������� ��밡����.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	JTextField     jtf_dong = new JTextField("���̸��� �Է��ϼ���"); // �˻�����
	JButton     jbtn_search = new JButton("��ȸ");
	JButton     jbtn_del 	= new JButton("����");
	
	String            cols[] = {"�ּ�","�����ȣ"}; // �÷���
	String          data[][] = new String[0][2]; 
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // �Ķ���� 2���� �޾Ƽ� �ʱ�ȭ�� �Ҽ��ִ�.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm�� �����͸� �����ְ� ���̺��� ����� ������ �����Ͱ� ���� �׷��� ������
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //�ü������ â�� ����.
	JPanel            jp_north = new JPanel(); //������ ������ش�.
	
	public ZipCodeSearchApp() {
		zdos = getZDOList(); //���ȿ� �ִ� �޼ҵ��̴ϱ� �ν��Ͻ� ���ϰ� �ٷ� ȣ��
		jcb_zdo = new JComboBox(zdos);
		System.out.println("���� �Ķ���Ͱ� ���� ����Ʈ �����ڶ�� ��.");
		System.out.println("���� �ν��Ͻ�ȭ�ϸ� �ڵ����� ȣ�� �Ǵ°ž�");
	}
	public ZipCodeSearchApp(String str, int i) {		
	}
	//Map���� ����
	public List<Map<String, Object>> refreshData(String zDO,String myDong) { // �޼ҵ� �����
		con = dbMgr.getConnection(); // con�� �޾ƾ� 
		System.out.println("refreshDataȣ�⼺��"+myDong+","+zDO);
		StringBuilder sql = new StringBuilder(); // StringBuilder
		sql.append(" SELECT address, zipcode");
		sql.append(" FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zDO!=null && zDO.length()>0) {
			sql.append(" AND zdo=? ");  // ? ������ 			
		}
		if(myDong!=null && myDong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");  // ? ������ 			
		}
		int i = 1;
		 List<Map<String, Object>>  addrList = new ArrayList<>(); // �ν��Ͻ�  
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(zDO!=null && zDO.length()>0) {
				pstmt.setString(i++, zDO);  // ? ������
				} 
			if(myDong!=null && myDong.length()>0) {
				pstmt.setString(i++, myDong); //?�� ���̸��� ������.				 			
			}
			rs = pstmt.executeQuery();//����Ŭ �������� ó���� ��û��.
			addrList = new Vector<>(); // �ν��Ͻ�
			Map<String, Object> rMap = null; 
			while(rs.next()) { //Ŀ���̵�, Ŀ���̵�
				rMap = new HashMap<>();
				rMap.put("address",rs.getString("address")); //���������� �ϱ����� "address"
				rMap.put("zipcode",rs.getInt("zipcode")); //���������� �ϱ����� "address"
				addrList.add(rMap); // n���� �о�־��ְ�
			}
			System.out.println("v.size():"+addrList.size());
			if(addrList.size()>0) {
				while(dtm_zip.getRowCount()>0) {
					dtm_zip.removeRow(0);
				}//�ߺ������ʰ� ���� ��µǴ� �ڵ�
				for(int x=0; x<addrList.size();x++) {
					Map<String, Object> map = addrList.get(x);
					Vector oneRow = new Vector(); // �Ѱ��ο쾿 �־��ְ� �; 
					oneRow.add(0, map.get("address"));//addRow�޼ҵ尡 �޾��ش�
					oneRow.add(1, map.get("zipcode"));//addRow�޼ҵ尡 �޾��ش�
					dtm_zip.addRow(oneRow);
				}
			}
		}catch(SQLException se) {
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//�׹ۿ� ������ �߻��� ��� ����ش�.
			System.out.println("[[Exception]]"+e);
		}
		return addrList;
	} // Map�� ������ ���ƶ�
	public void intiDisplay() {
		jcb_zdo.addItemListener(this); // ȭ�鿡 addItemListener�� ����
		jbtn_search.requestFocus(); // ��ư�� ��Ŀ���� �ű�
		jtf_dong.addFocusListener(this);
		System.out.println("initDisplay ȣ�� ����");
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(22,22,100));//�Ķ���͸� �߰��ؼ� ǥ��
		jth_zip.setForeground(Color.white); // ������
		jth_zip.setFont(new Font("�������",Font.BOLD,20));//�Ķ����3�� �ʿ� �۲�, �۵β�, ����ũ��
		jt_zip.setGridColor(Color.BLUE); //�׸��� ����
		jt_zip.setRowHeight(20);
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350); //�÷�
		jt_zip.setSelectionBackground(new Color(186,186,241));
		jt_zip.setSelectionForeground(new Color(22,22,241));
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.green);
		jp_north.add(jcb_zdo);
		jp_north.add(jtf_dong);
		jp_north.add(jbtn_search); // ��ư ���� ���� ��ȸ�ϰ� 
		jp_north.add(jbtn_del); //��ư ���� ������ư
		jbtn_search.addActionListener(this); // ���ڽ��� ����Ű�� �����  ��ġ��ư �̺�Ʈ ó��Ȱ��
		jbtn_del.addActionListener(this); // ���� ��ư �̺�Ʈ ó��Ȱ��
		jtf_dong.addActionListener(this);
		jf_zip.setTitle("�����ȣ �˻�");
		jf_zip.add("North", jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	
		
	void actionPerformed(){
		
	}
	public String[] getZDOList() {
		String zdos[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select '��ü' zdo from dual  ");
		sb.append("union all                   ");
		sb.append("select zdo                  ");
		sb.append("from (                      ");
		sb.append("select distinct(zdo) zdo    ");
		sb.append("from zipcode_t              ");
		sb.append("order by zdo asc)           ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
	//stack ������ �����Ǵ� �����޼��� ������ ���ι�ȣ�� �̷±��� �������
			e.printStackTrace();
		}
		return zdos;
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearchApp zipAPP = new ZipCodeSearchApp();
		zipAPP.intiDisplay();
	}
	//
	@Override
	public void actionPerformed(ActionEvent ae) { //�������̵�  �����ǰ� ������ -����� �ٲ�
		//�̺�Ʈ�� ������ ��ư�� �ּҹ�����  �о���� �޼ҵ���.
		Object obj = ae.getSource();
		if((obj == jbtn_search)||(obj == jtf_dong)) {
			String myDong = jtf_dong.getText();
			String zDO = zdos[jcb_zdo.getSelectedIndex()];
			refreshData(zDO, myDong); //Ÿ�� ������ �޶� ������
		}
		else if(obj == jbtn_del) { //���� �̺�Ʈ
			int index[]  = jt_zip.getSelectedRows(); // 
			for(int row:index) {   //row��ȣ index�ּҹ�ȣ
				JOptionPane.showMessageDialog(jf_zip, row);
			}
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==jtf_dong) {//��Ŀ���� �̵������� �����ؾ���
			jtf_dong.setText(""); // ���ڸ� �־��ּ���
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == jcb_zdo) { //�޺��ڽ��� �Ͼ�ٴ� ��
			if(e.getStateChange()==ItemEvent.SELECTED) {// ���õǾ��°�?
				System.out.println(zdos[jcb_zdo.getSelectedIndex()]); // ����Ÿ�� int
				zdo = zdos[jcb_zdo.getSelectedIndex()];
				
			} //zdos[]�� �������� ����� ���� ���
		}
	} // End of ZipCodeSearchApp
}
