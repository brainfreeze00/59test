package method.zipcode;

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
//implements �ڿ� ���� �̸� ��� �������̽�
//�������̽��� �߻�޼ҵ常 ������ �ִ�. �޼ҵ�ڿ� �����ݷ����� ������.
//void�̰ų� int methodA();
//�������̽��� �ܵ����� �ν��Ͻ�ȭ�� �� �� ����.
//ItemListener item = new ItemListener(); �Ұ�
//ItemListener item = new ZipCodeSearchApp();�չ�
//�������̽��� �ݵ�� ����ü Ŭ������ �־�� �Ѵ�.
//����ü Ŭ������ �Ǳ� ���� �ʿ������� �ݵ�� �߻�޼ҵ带 �������־���Ѵ�. @Override
public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
	//�����-���������� �ʱ�ȭ�� �����ڰ� ���ش�.
	/*��� Ŭ������ ���θ޼ҵ尡 �ִٸ� �̸޼ҵ尡 �������̴�.
	 *�̰ͺ��� ���� �ʱ�ȭ �Ǵ� �ڵ���� �ִ� �̰��� �����̴�
	 */
	String zdos[] = null; // 
	//����ڰ� �޺��ڽ����� ������ ������ ���� ���� ����
	//������ �̺�Ʈ �ʿ��� ó���ǹǷ� ���������� �ؾ� �װ��� ������ �� �ְ�
	//�� ��ȸ�޼ҵ忡�� �� ���� ����Ҽ� �������̴�.
	String zdo = null;
	JComboBox jcb_zdo = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection          con = null; // �������������ϱ� - Ŭ���� �������� ��밡����.
	//����Ŭ������ �������� �����ϰ� �ʰ� �� ó�����ٷ�? �뵵
	PreparedStatement pstmt = null;
	//����Ŭ���� �ϲ��� ��� �ִµ� �̸��� ��Ƽ��������� �θ���.
	//�����͸� ã�� ���� Ŀ���� �����̸鼭 ��ȸ ����� �����ϴ��� Ȯ���ϰ� �� �ο쿡 �ִ� ������ 
	//RAM�޸� ������ �÷��ش�.Ŀ���� �����ϸ鼭 �ش�ο쿡 �ִ� ���� ������ �ִ�.
	ResultSet      rs       = null;
	JTextField     jtf_dong = new JTextField("���̸��� �Է��ϼ���"); // �˻�����
	JButton     jbtn_search = new JButton("��ȸ");
	JButton     jbtn_del 	= new JButton("����");
	
	//���̺� ��� �׷���
	//����Ŭ���� ��ȸ�� ����� ���� Ŭ���� ����� �����ϱ�
	//���̺��� ��� �����ϱ�
	String            cols[] = {"�ּ�","�����ȣ"}; // �÷���
	String          data[][] = new String[0][2]; 
	//�����ڿ��� �Ķ���͸� �������ִ�.
	//ù��° �Ķ���ʹ� �����Ϳ����� ǥ���ϴ� �ּҹ���
	//�ι�° �Ķ���ʹ� ���̺� ��������� �ش��ϴ� �ּҹ���
	//�Ķ������ ������ ���� ���� �ٸ� �����ڸ� �����ϴ°͵� �����ϴٴ� ���ΰ�?
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // �Ķ���� 2���� �޾Ƽ� �ʱ�ȭ�� �Ҽ��ִ�.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm�� �����͸� �����ְ� ���̺��� ����� ������ �����Ͱ� ���� �׷��� ������
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	//JTableHeader ���ٲٱ� 
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //�ü������ â�� ����.
	JPanel            jp_north = new JPanel(); //������ ������ش�.
	
	//������ - ����Ÿ���� ������ ���� �׸��� Ŭ���� �̸��� �����ϴ�. - �޼ҵ� �ƴ� 
	public ZipCodeSearchApp() {
		zdos = getZDOList(); //���ȿ� �ִ� �޼ҵ��̴ϱ� �ν��Ͻ� ���ϰ� �ٷ� ȣ��
		jcb_zdo = new JComboBox(zdos);
		//�ν��Ͻ�ȭ�� �Ҷ����� �����ڵ� ���� Ƚ����ŭ ȣ���� �Ͼ��
		//new A()���� ������ ��ü�� RAM�� �ε�(���� : ���)�Ǹ鼭 ���ÿ� �����ڰ� ȣ��ȴ�.
		System.out.println("���� �Ķ���Ͱ� ���� ����Ʈ �����ڶ�� ��.");
		System.out.println("���� �ν��Ͻ�ȭ�ϸ� �ڵ����� ȣ�� �Ǵ°ž�");
	}
	//����Ŭ�������� zipcode_t�� �ִ� ������ ��ȸ�Ͻÿ�
	//��ȸ�� ������ data�迭�� �ʱ�ȭ�Ͻÿ�
	public ZipCodeSearchApp(String str, int i) {		
	}
	//���ΰ�ħ ����� �����غ��� - SELECT // void����  Vector<ZipCodeVO>���� ��ȯŸ���� ���� return ���� v
	//Map ����
	public Vector<ZipCodeVO> refreshData(String zDO,String myDong) { // �޼ҵ� �����
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
		Vector<ZipCodeVO> v = null; //���� 
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(zDO!=null && zDO.length()>0) {
				pstmt.setString(i++, zDO);  // ? ������
				} 
			if(myDong!=null && myDong.length()>0) {
				pstmt.setString(i++, myDong); //?�� ���̸��� ������.				 			
			}
			rs = pstmt.executeQuery();//����Ŭ �������� ó���� ��û��.
			v = new Vector<>(); // �ν��Ͻ�
			ZipCodeVO zcVOS[] = null; 
			ZipCodeVO zcVO = null; 
			while(rs.next()) { //Ŀ���̵�, Ŀ���̵�
				zcVO = new ZipCodeVO();
				zcVO.setAddress(rs.getString("address")); //���������� �ϱ����� "address"
				zcVO.setZipcode(rs.getInt("zipcode"));
				v.add(zcVO);
				//System.out.println("while�� :"+rs.next());//Ŀ���̵�
			}
			zcVOS = new ZipCodeVO[v.size()];
			v.copyInto(zcVOS); //���� �ڷ� ������ ����ִ� ������ �����ϱ�  ����: ������.�޼ҵ�()
			System.out.println("v.size():"+v.size()+","+zcVOS.length);
			if(v.size()>0) {
				while(dtm_zip.getRowCount()>0) {
					dtm_zip.removeRow(0);
				}//�ߺ������ʰ� ���� ��µǴ� �ڵ�
			//��ȸ����� �ִٸ� �����͸� DefaultTableModel�� ����־�� �մϴ�.
			//�׷��� JTable���� �׸��忡 ��µ� ����� �� �� �ֱ� �����Դϴ�.
			//�׷��� �÷��� �ϳ��� ���� �����ڰ� ������ �ʱ�ȭ ���ִ°� �ʹ� �����ϴ�.
				for(int x=0; x<v.size();x++) {
			//�׷��� for�� �ȿ��� ���͸� �ϳ� �������߾��
			//addRow��� �޼ҵ尡 �ִµ� �� �Ķ���Ϳ� Vector�� ������ �Ѱ��ο쾿
			//�߰� ���شٰ���
					Vector oneRow = new Vector(); // �Ѱ��ο쾿 �־��ְ� �; 
					oneRow.add(0, zcVOS[x].getAddress());//addRow�޼ҵ尡 �޾��ش�
					oneRow.add(1, zcVOS[x].getZipcode());
					dtm_zip.addRow(oneRow);
				}
			}
		}catch(SQLException se) {
			//���̺��� �������� �ʽ��ϴ�. - ���̺��� ������ �ʾҳ�
			//Ȥ�� �������� �ĺ��� - �÷����� ���� �ʽ��ϴ�
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//�׹ۿ� ������ �߻��� ��� ����ش�.
			System.out.println("[[Exception]]"+e);
		}
		return v;
	} // Map�� ������ ���ƶ�
	//ȭ��׸���
	public void intiDisplay() {
		jcb_zdo.addItemListener(this); // ȭ�鿡 addItemListener�� ����
		jbtn_search.requestFocus(); // ��ư�� ��Ŀ���� �ű�
		jtf_dong.addFocusListener(this);
		System.out.println("initDisplay ȣ�� ����");
		//���̺� ��� ������ ���� �ٲ㺼��?
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(22,22,100));//�Ķ���͸� �߰��ؼ� ǥ��
		jth_zip.setForeground(Color.white); // ������
		jth_zip.setFont(new Font("�������",Font.BOLD,20));//�Ķ����3�� �ʿ� �۲�, �۵β�, ����ũ��
		jt_zip.setGridColor(Color.BLUE); //�׸��� ����
		//�׸����� ���� �����ϱ�
		jt_zip.setRowHeight(20);
		//�÷��� �ʺ������ϱ�
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350); //�÷�
		//������ �ο��� �����̳� ���ڻ� �����ϱ�
		jt_zip.setSelectionBackground(new Color(186,186,241));
		jt_zip.setSelectionForeground(new Color(22,22,241));
		//�̺�Ʈ�� �Ͼ �ҽ��� �̺�Ʈ�� ó���ϴ� Ŭ����(actionPerformed�޼ҵ�)�� �������ش� actionPerformed - �̺�Ʈó�� ���
		//jp_north�������� �߾ӿ� jtf_dong�� ���̰� ���ʿ��� jbtn_search�� ���δ�.
		//�̷��� ��,��,��,��,�߾ӿ� ��ư�� ��ġ�ϰ������ BorderLayout ����ؾ���.
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
		//JFrame�ǳ� ���� ���ʿ� jp_north ������ ������
		//�����ȿ� ��ư�� �ؽ�Ʈ�ʵ尡 �پ� �����ϱ� ���� ����´�
		jf_zip.add("North", jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	
		
	void actionPerformed(){
		
	}
	//�޺��ڽ��� �ѷ��� ZDO �÷��� ������ ����Ŭ �������� ��������
	public String[] getZDOList() {
		//����Ÿ���� 1�� �迭�� �����Ƿ� 1���迭 �����ϱ�
		String zdos[] = null;
		//����Ŭ �������� ���� select�� �ۼ��ϱ�
		//String�� ������ �ٲ��� ����
		StringBuilder sb = new StringBuilder();
		//�ڹ��ڵ�� ��Ŭ�������� ������ϰ� select���� ��忡�� ������ϱ�
//		sb.append("	SELECT                "); ��ü �ֱ���
//		sb.append("     distinct(zdo) zdo ");
//		sb.append(" FROM zipcode_t         ");
//		sb.append(" ORDER BY zdo asc         ");
		sb.append("select '��ü' zdo from dual "); //��ü ������
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
			//�ڹٿ����� ���� �̸��� �޼ҵ带 ���� �Ҽ� �ִ�.
			//�� �Ķ������ ������ �ٸ��ų� �Ķ����Ÿ���� �ݵ�� �޶���Ѵ�.
//			if(jcb_zdo.getSelectedItem().equals("��ü")) {
//				zdo=null;
//			}
			refreshData(zDO, myDong); //Ÿ�� ������ �޶� ������
		}
		else if(obj == jbtn_del) { //���� �̺�Ʈ
			int index[]  = jt_zip.getSelectedRows(); // 
			for(int row:index) {   //row��ȣ index�ּҹ�ȣ
				JOptionPane.showMessageDialog(jf_zip, row);
			}
		}
		/*
		if(obj == jbtn_search) {//�� �����ȣ �˰� �;�? obj == jbtn_search �ּҹ����� �ĺ��Ѵ� 
			//ó�������� �޶����°��� ���� ���ϴ� ������ �����ϴ�
			System.out.println("��ȸ ��ư Ŭ���Ѱž�?"+jtf_dong.getText());
		}else if(obj == jtf_dong) {
			System.out.println("����ģ�ž�?"+jtf_dong.getText());
			refreshData();
			
		}
		*/
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
