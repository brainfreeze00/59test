package method.temparature;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

import oracle.jdbc2.ZipCodeVO;

public class SeoulTempView implements ActionListener {
	//����� 
	Connection          con = null; // �������������ϱ� - Ŭ���� �������� ��밡����.
	//����Ŭ������ �������� �����ϰ� �ʰ� �� ó�����ٷ�? �뵵
	PreparedStatement pstmt = null;
	//����Ŭ���� �ϲ��� ��� �ִµ� �̸��� ��Ƽ��������� �θ���.
	//�����͸� ã�� ���� Ŀ���� �����̸鼭 ��ȸ ����� �����ϴ��� Ȯ���ϰ� �� �ο쿡 �ִ� ������ 
	//RAM�޸� ������ �÷��ش�.Ŀ���� �����ϸ鼭 �ش�ο쿡 �ִ� ���� ������ �ִ�.
	ResultSet      rs       = null;
	JTextField     jtf_date = new JTextField("��¥�� �Է��ϼ���"); // �˻�����
	JButton     jbtn_search = new JButton("��ȸ");
	//���̺� ��� �׷���
	//����Ŭ���� ��ȸ�� ����� ���� Ŭ���� ����� �����ϱ�
	//���̺��� ��� �����ϱ�
	String            cols[] = {"��¥","�����µ�","�ְ�µ�"}; // �÷���
	String          data[][] = new String[4][3]; 
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
	JComboBox   	  jcb_year = null; //�����޺��ڽ� �������� ����
	JComboBox   	 jcb_month = null; 
	String             years[] = null; //����Ŭ���� �����ؼ� ��ȯ�޴� ������ �ʱ�ȭ
	String			   months[] = null;
	SeoulTempDAO		stDao  = new SeoulTempDAO(); // initDisplay(); �ǾƷ��� ��ġ�ϹǷ� new A();���·� ����
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//������ - ����Ÿ���� ������ ���� �׸��� Ŭ���� �̸��� �����ϴ�. - �޼ҵ� �ƴ� 
	//������
	public SeoulTempView() { //�����ڿ��� �޼ҵ� ȣ���Ҽ� �ִ�.
		//����Ŭ���� �����ϱ�
		//�ּҹ���.10������ �������� �޼ҵ� ȣ���ϱ�();
		 years = stDao.getYearList();
		//����Ŭ���� �����ϰ��� ���� ���ϰ����� �޺��ڽ� �ν��Ͻ�ȭ �ϱ�
		jcb_year = new JComboBox(years);
		//�޼ҵ�ȣ��
		initDisplay();
	}
	//ȭ�� ó����
	public void initDisplay() {
		System.out.println("initDisplay ȣ�⼺��");
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
		jp_north.setBackground(Color.red);
		jp_north.add(jcb_year); // JComboBox �����׽�Ʈ
		jp_north.add("Center", jtf_date);
		jp_north.add("East", jbtn_search); // ��ư ���� ���� ��ȸ�ϰ� 
		jbtn_search.addActionListener(this); // ���ڽ��� ����Ű�� �����
		jtf_date.addActionListener(this);
		jf_zip.setTitle("���������� �˻�");
		//JFrame�ǳ� ���� ���ʿ� jp_north ������ ������
		//�����ȿ� ��ư�� �ؽ�Ʈ�ʵ尡 �پ� �����ϱ� ���� ����´�
		jf_zip.add("North", jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	//��ü��ȸ Ȥ�� ���� �˻� �ϱ� ����
	//insert here
	public void refreshData(String myDong) {
		getConnection();
		System.out.println("refreshDataȣ�⼺��"+myDong);
		String sql = "";
		sql+="SELECT address, zipcode";
		sql+="   FROM zipcode_t";
		if(myDong!=null || myDong.length()>0) {
			sql+="   WHERE dong LIKE '%'||?||'%'";  // ? ������ 			
		}
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, myDong); //?�� ���̸��� ������.
			rs = pstmt.executeQuery();//����Ŭ �������� ó���� ��û��.
			Vector<ZipCodeVO> v = new Vector<>();
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
	}
	private void getConnection() {
		// TODO Auto-generated method stub
		
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		 new SeoulTempView(); // �ν��Ͻ�ȭ���� ����ƽ�̾����Ƿ� �����ڿ��� �޼ҵ� ȣ�� �츮���� ����
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
