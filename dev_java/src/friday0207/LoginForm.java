package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.util.DBConnectionMgr;


//ȭ���� �̿��ؼ� ����Ÿ�԰� �Ķ���� �����ϱ�
public class LoginForm implements ActionListener { //�̺�Ʈó�� ���� ,�������ִ� �������̽�
	//�����
	Connection          con = null; //���������� �������ִ� ������ ������θ����
	PreparedStatement pstmt = null; //�������� �ۼ��ϱ� - ?
	ResultSet            rs = null;
	//��Ŭ�� ������  Ȱ���Ͽ� ��ü ���Թޱ� - �ϳ��� ������ ����.
	DBConnectionMgr   dbMgr = DBConnectionMgr.getInstance();//friendly ���´� ���� �ٸ� ��Ű���� ���� �Ұ� 
	JFrame jf_login  		= new JFrame();
	JPanel jp_first  		= new JPanel();
	//jp_first �����ȿ� ���ʿ� jlb_id, �߾ӿ� jtf_id
	JLabel jlb_id 			= new JLabel("�� �� ��");
	JTextField jtf_id 		= new JTextField();
	JPanel jp_second 		= new JPanel();
	JTextField jtf_pw 		= new JTextField();
	JLabel jlb_pw			= new JLabel("��й�ȣ");
	JPanel jp_third  		= new JPanel();
	JButton jbtn_login      = new JButton("�α���");
	//������
	LoginForm() {
		initDisplay();
	}
	//�α��� ó�� �޼ҵ� ���� �Ķ���� 2�� ���̵� ��� 
	public String[] login(String u_id, String u_pw) {
		String result[] = new String[2];
		String db_id = null; // �� ���̵�� ��񿡼� �����°� db_
		String mem_name = null;
		String status = null;
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb2 = new StringBuilder("");
		try { //��������� �ٸ� ������ ���� ����Ǿ�� �����ϴ�.
			sb.append("	SELECT                       ");
	        sb.append("	NVL((SELECT 1 FROM member    ");
	        sb.append("	   WHERE mem_id = ?) 		 ");
	        sb.append("	   ,-1) status 				 ");	        
	        sb.append("	   FROM dual                 ");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {//��ȸ����� �ִ°ž�? ���� : next - Ŀ���̵��ɷ�, Ŀ����
				status = rs.getString("status");
			}
			System.out.println("status:"+status);
			if("1".equals(status)) {//���̵� �����ϴ�?
			sb2.append("	SELECT                               ");
		    sb2.append("    NVL((SELECT mem_name                 "); //�ŷڵ��� ���ؼ� ��񿡼� ��������
		    sb2.append("         FROM   member                   ");
		    sb2.append("         WHERE  mem_id = ?               ");
		    sb2.append("         AND    mem_pw = ?),0) mem_name  ");
		    sb2.append(" FROM dual                               ");
		    pstmt = null;
		    pstmt = con.prepareStatement(sb2.toString());
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_pw);
			rs = null;
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mem_name = rs.getString("mem_name");
				db_id = u_id;
				result[0] = mem_name; //ù��° �濡 �̸��� ��Ҵ�.
				result[1] = db_id; //�ι�°�濡 ����ڰ� �Է��� ���̵� ��Ҵ�.
			}
//�Ʒ����� ��й�ȣ�� ���� �ʽ��ϴ�. �޽����� result�迭�� ��ܾ� �մϴ�.
//�ֳ��ϸ� ����Ÿ���� String���� String[]�� �ٲپ��� �� �ٲ� ������ if������ ��
//�ؾ� �ϴϱ� ���̻� mem_name�� ���� if������ ������ ������������.
//��й�ȣ�� ���� �ʽ��ϴ�. �� result[0]�� ����־�� �մϴ�.
			if(mem_name.equals("0")) {
				result[0] = "��й�ȣ�� ���� �ʽ��ϴ�."; //mem_name�� ����θ� ����� �ȵ� �ʱ�ȭ
			}
			}
			else if("-1".equals(status)) {//���̵� ���°ǰ�?
				result[0] = "���̵� �������� �ʽ��ϴ�."; // mem_name ����θ� ����� �ȵ� �ʱ�ȭ
			}
		} catch (Exception e) {
			//������ �ذ��ϱ� ���ؼ��� �ִ��� ���� ��Ʈ�� �����ƾ��մϴ�.
			//�����޽����� JVM�� stack������ �����ϴµ� �� �̷°� ���ι�ȣ�� ����
			//�������
			e.printStackTrace();//e.printStackTrace(); �̳��� �ܿ����� �˰��־���� 
			System.out.println("sql:"+sb.toString());
			System.out.println(e.toString());//���ܰ� �߻��ϸ� ��Ʈ�� ������ �־��
		}
		return result;
	}
	//ȭ��ó����
	public void initDisplay() {
		//�α��� ��ư�� ������ �� �̺�Ʈ ������ �Ǹ� actionPerformed�޼ҵ带 ȣ���ϴµ�
		//�� �޼ҵ带 �����ϴ� Ŭ������ �����ϱ�
		jbtn_login.addActionListener(this);
		jf_login.setLayout(new GridLayout(3,1));
		
		jp_first.setBackground(Color.green);
		jp_first.setLayout(new BorderLayout());
		jp_first.add("West",jlb_id);
		jp_first.add("Center",jtf_id);
		
		jp_second.setBackground(Color.gray); // ��й�ȣ ����
		jp_second.setLayout(new BorderLayout());
		jp_second.add("West",jlb_pw);
		jp_second.add("Center",jtf_pw);
		
		jp_third.setBackground(Color.red);	
		jp_third.add(jbtn_login);
		
		jf_login.add(jp_first);
		jf_login.add(jp_second);
		jf_login.add(jp_third);
		jf_login.setSize(500, 500);
		jf_login.setVisible(true);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		new LoginForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//Object obj = new Object();
		//�α��� ��ư�� �����ž�?
		if(obj == jbtn_login) {
			String u_id = jtf_id.getText();//�ؽ�Ʈ �ʵ忡 �Է��� ���̵�
			String u_pw = jtf_pw.getText();//�ؽ�Ʈ �ʵ忡 �Է��� ���
			String result[] = login(u_id,u_pw);
			System.out.println("mem_name :"+result[0]);
			if(result[0].equals("��й�ȣ�� ���� �ʽ��ϴ�.") // 83
					||result[0].equals("���̵� �������� �ʽ��ϴ�.")) { // 86
					JOptionPane.showMessageDialog(jf_login, result[0]);//�ܼ��� �˸�â�� ��� �� �ִ� �Լ���.
			//if������ return�� ������ �� �޼ҵ带 Ż�� �� �� �ִ�.
					return;
			}
			else {
				new BaseBallGameView(result); //str���� �迭�� �ٲ��� ���� ��� ������Ʈ
				jf_login.dispose(); //�α��μ����� �α���â�ڵ����� ������ �߱����ӿ�
			}
		}
	}

} // �� �ε��������� sql���� Ȯ�� �غ����Ѵ�.
