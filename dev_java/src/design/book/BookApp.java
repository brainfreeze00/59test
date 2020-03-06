package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.util.DBConnectionMgr;
/*Main ���� ������ ������ ���� ��� �Է¹�ư, ������ư, �׸��� ��.....
 * �� ���� ��ȸ�� ����� ��� �ִ�  BookVO��ü Ȥ��  Map��ü������ ������ �ִ�
 * set�޼ҵ带 �߰��Ͻÿ�
 * 
 * BookMain�� �ν��Ͻ�ȭ �� �� ���������� �����  BookDialog�� ���� �ν��Ͻ�ȭ�� �Ѵ�.
 * �̶� �Ķ���ͷ� �Ѿ boolea,String�� ���� �̹� ������ �����̹Ƿ� �ƹ��� ��ư��
 * �ٲپ��� title�� ���� ������ �ʴ� ���̴�.
 * 
 * �����ڰ� ȣ��Ǵ� ������ �̺�Ʈ�� �����Ǵ� ���������� ���̰� �߻��Ͽ���.
 * 
 * public void set(����,��������,Map){}  
 */

public class BookApp extends JFrame implements ActionListener {
	//�����
	static BookApp ba 		= null; //���θ޼ҵ� static������ �ܺ� ������ �ȵǾ� ���� �������� ����
	//�Ķ���Ͱ� ���� �����ڴ� ������� ������������ �ִ� ���� �����Ұ��̹Ƿ� �����Ұ���
	BookDialog bd 			= new BookDialog(); //�ٱ��ʿ� ó���ϱ����� ���� �Ķ���Ϳ� �Է�
	DBConnectionMgr dbMgr   = DBConnectionMgr.getInstance();
	Connection          con = null; // �������������ϱ� - Ŭ���� �������� ��밡����.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	//jp_north������ JFrame ���ʿ� ��ġ
	JPanel      jp_north 	= new JPanel();
	//�Ʒ� ��ư�� jp_north������ ���ʴ�� ��ġ �� ��ġ�� ���ʺ���
	JButton     jbtn_all 	= new JButton("��ü��ȸ");
	JButton     jbtn_sel 	= new JButton("����ȸ");
	JButton     jbtn_ins 	= new JButton("�Է�");
	JButton     jbtn_upd 	= new JButton("����");
	JButton     jbtn_del 	= new JButton("����");
	JLabel jlb_time 		= new JLabel("����ð�",JLabel.CENTER);
	TimeClient tc 			= null; //Ŭ���̾�Ʈ���� ��� �ۿ��� ����ϱ����� ���������� ������ 
	// initDisplay�� �ν��Ͻ�ȭ�Ͽ� start�޼ҵ� ȣ��
	
	//ȭ�� �׸���
	public void initDisplay() {
		//������ Ÿ�Ӽ����� ���� �ð������� ���� TimeClient���� ���� ������ 
		//�������� �Ķ���͸� ���ؼ� BookApp jlb_time ������ �ּҹ�����
		//�Ѱ����Ƿ� TimeClient������ ������ ���� ���ָ� ȭ�鿡 ����.
		tc = new TimeClient(jlb_time); 
		tc.start();
		String time = null;
		con = dbMgr.getConnection(); 
		//insert here
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_all);
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		//�Ʒ��ڵ尡 JFrame�� �ڿ��� ȸ����
		//�θ� �ڿ��� ȸ�� �ɶ� JDialog�� ���� ȸ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //main+sub�Ѵ� �ݱ�
		this.setTitle("���������ý���");
		this.add("North",jp_north);//JPanel ȭ�� �ֱ�
		this.add("South",jlb_time);//JPanel ȭ�� �ֱ�
		this.setSize(700, 500);
		this.setVisible(true);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		TimeServer ts = new TimeServer();//�Ķ���� - ���� client
		/*���������� 1�ʿ� �ѹ��� ��ٷȴ� �����Ҷ� �����尡 �ʿ��ϴ�.
		 *������ : ��ٸ��� �޼ҵ�� ����  1000 = 1�� sleep ��ٷ� 
		 */
		ts.initDisplay(); //ȭ���� �׸���  ���� ������ ��⸦ Ÿ���� �ؾ���
		Thread th = new Thread(ts);
		th.start();//java.lang.Thread �������� run�޼ҵ带 ȣ���ϴ� �޼ҵ� - �����带 ���۽�Ŵ
		ba = new BookApp(); // ����ƽ������ Ÿ���̶� ���� �ν��Ͻ�ȭ �ϸ� �ȵ�¡!
		ba.initDisplay();
	}
//JButton�� ���� �̺�Ʈ�� �����ϴ� �������̽��� ActionListener��.
	//Ŭ���� �ڿ� implements�Ұ� 
	//ActionListener�� ���ǵ� �߻�޼ҵ带 �������Ұ�
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� ������ Ŭ������ �ּҹ��� �ޱ�
		Object obj = e.getSource();
		//�Է¹�ư�� �����Ŵ�?
		if(obj==jbtn_ins) {
			System.out.println("�Է�ȣ�⼺��");
			bd.set(jbtn_ins.getText(),true, true, null, ba);
			//initDisplay�� ȣ���� ������ setTitle("�Է�")�� setVisible(true)
			//�����̾���. �׷��� �� ���� set�޼ҵ�� �����Ͽ���.
			//insert here
		}
		else if(obj==jbtn_upd) {//�����ÿ��� ���� �⺻ ������ ��ȸ�ϰ� ȭ���̵�ó��
			System.out.println("����ȣ�⼺��");
			//selectó���� �� �� �� �ο츦 �޾Ƽ� Map�� ����
			Map<String, Object> rMap = null; //��ȸ�� �Ŀ� ��ƾ���
			rMap = new HashMap<>();
			rMap.put("b_title", "�ڹ��� ����");
			rMap.put("b_author", "���ü�");
			rMap.put("b_publish", "��������");
			bd.set(jbtn_upd.getText(),true, true, rMap, ba);
		}
		else if(obj==jbtn_sel) {
			System.out.println("����ȸȣ�⼺��");
			Map<String, Object> rMap = null; //��ȸ�� �Ŀ� ��ƾ���
			bd.set(jbtn_sel.getText(),true, false, rMap, ba);
		}
		else if(obj==jbtn_del) {
			System.out.println("����ȣ�⼺��");
			
		}
		else if(obj==jbtn_all) {
			System.out.println("��ü��ȸȣ�⼺��");
			
		}
	}
	public void refreshData() {
		System.out.println("refreshData ȣ�� ����");
	}

}
