package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView extends JFrame { //��� JFrame �޼ҵ� �̿밡�� ��� �ּҹ���.�� ������ �ȴ�
		BaseBallGameLogic bbLogic = new BaseBallGameLogic(); //����
	//ȭ��� ���õ� �ڵ��߰� ����
		//JMenuBar�� JFrame�ȿ� �޴��ٸ� �߰��ϱ�
		JMenuBar jmb_bbgame = new JMenuBar();
		//JMenu�� JMenuBar�ȿ� �� �޴� �߰��ϱ�
		JMenu       jm_game = new JMenu("����");
		//JMenuItem�� JMenu�Ʒ��� �� �޴������..
		JMenuItem   jmi_next = new JMenuItem("������");
		JMenuItem   jmi_clear = new JMenuItem("�����");
		JMenuItem   jmi_dap= new JMenuItem("����");
		JMenuItem   jmi_oracle = new JMenuItem("����Ŭ�׽�Ʈ");
		JMenuItem   jmi_exit = new JMenuItem("������");
		JMenu       jm_info = new JMenu("����");
		JTextArea jta_display = new JTextArea("");
		JScrollPane jsp_display = new JScrollPane(jta_display);
		JTextField jtf_input = new JTextField(); //jta_area ���� 
		JButton    jbtn_next = new JButton("������");
		JButton    jbtn_clear = new JButton("�����");
		JButton    jbtn_hint = new JButton("��Ʈ");
		JButton    jbtn_dap = new JButton("����");
		JButton    jbtn_exit = new JButton("������");
		//JTextArea�� JTextField�� ���� ���� �߰��ϱ�
		JPanel     jp_center = new JPanel();
		//��ư 4���� ���� ���� �߰��ϱ�
		JPanel     jp_east   = new JPanel();
		String mem_name = null;
		String result[] = null; // �������� ����
		//���������� �����Ͽ� ������ �ذ��� ���־��.
		//�������� �Ķ���ͷ� �迭�� �ּҹ����� �ް� �Ǵµ� �� ���� ����ϴ� ����
		//������ �ȿ����� �ƴ϶� initDisplay�޼ҵ� �ȿ� setTitle �޼ҵ忡��
		//����ؾ��ϱ� ������ �Ķ���ͷ� �Ѿ�� ���� �ݵ�� ������ �ʱ�ȭ�ؾ� �մϴ�
		//�Ķ�����ڸ��� ������ �����ϴ� �ڸ� �Դϴ�.
		//�ʱ�ȭ�� �Ͼ�� �ʾƿ�  - �����ϴ� �ڸ��� �ƴմϴ�.
		public BaseBallGameView(String result[]) {
			this.result = result;  //result�� ������? �ٸ��ǰ�?
			if(this.result==null) { //this.result ����
				this.result = new String[2]; //null ������ ���� �ν��Ͻ�
				this.result[0] = ""; // ������ ���� �ʱ�ȭ
				this.result[1] = ""; // ������ ���� �ʱ�ȭ
			}
 			System.out.println("�α��� ���� "+this.result[0]+","+this.result[1]);
			//������ �ȿ��� �޼ҵ带 ȣ���ϸ� �ν��Ͻ�ȭ ���̵� ȣ���� �����ϴ�.
			if(this.result[0]!=null) { // �ᱹ result[0]�� ������ �ִ°� ��
				//initDisplay�� result[]�� �Ű����� �ѱ��. 
				initDisplay(); // 
				bbLogic.ranCom(); // ȣ��
			}
		}
		/////////////////ȭ��ó������///////////////////////
		public void initDisplay() {
			//�̺�Ʈ�ҽ��� �̺�Ʈó�� Ŭ���� ����
			/*���� ���������� friday0131�ҽ� �̺�Ʈó���� ���� �Ͽ���. -ActionListener  
			 */
			//����Ʈ �����ڴ� JVM�� ������ټ� �־��. �ֳ��ϸ� �Ķ���Ͱ� ���� ��������
			//�Ķ���Ͱ� �ִ� �����ڴ� ���� ����� �ټ� ����. �ֳĸ� �� ������ �� �˼������ϱ�
			BaseBallGameEvent bbEvent = new BaseBallGameEvent(this); //�ν��Ͻ�ȭ  ���� ����
			jtf_input.addActionListener(bbEvent);
			jbtn_clear.addActionListener(bbEvent); //�̺�Ʈ�� �������ִ� �� 
			jbtn_dap.addActionListener(bbEvent); //�̺�Ʈ�� �������ִ� �� 
			jbtn_next.addActionListener(bbEvent);
			jbtn_exit.addActionListener(bbEvent);
			jmi_oracle.addActionListener(bbEvent);
			jmi_exit.addActionListener(bbEvent);
			//System.out.println("ȭ��ó�� ����");
			jp_center.setLayout(new BorderLayout());
			jp_center.add("Center",jsp_display);		
			jp_center.add("South",jtf_input);
			jp_east.setLayout(new GridLayout(5,1));
			jbtn_next.setBackground(new Color(158,9,9)); //Color 3��°���� import
			jbtn_next.setForeground(new Color(212,212,212)); //Color 3��°���� import
			jbtn_clear.setBackground(new Color(7,84,170)); 
			jbtn_clear.setForeground(new Color(212,212,212)); 
			jbtn_dap.setBackground(new Color(27,48,50)); 
			jbtn_dap.setForeground(new Color(212,212,212));
			jbtn_exit.setBackground(new Color(57,94,70)); 
			jbtn_exit.setForeground(new Color(250,180,200)); 
			jp_east.add(jbtn_next);
			jp_east.add(jbtn_clear);
			jp_east.add(jbtn_hint);
			jp_east.add(jbtn_dap);
			jp_east.add(jbtn_exit);
			add("Center", jp_center);
			add("East",jp_east);
			/////////////////////�޴��� �߰�����/////////////////////
			jm_game.add(jmi_next);
			jm_game.add(jmi_clear);
			jm_game.add(jmi_dap);
			jm_game.add(jmi_oracle);
			jm_game.add(jmi_exit);
			//�޴��� �޴��ٿ� �ٿ���
			jmb_bbgame.add(jm_game);
			jmb_bbgame.add(jm_info);
			//jf_bbgame�� setJMenuBar 
			setJMenuBar(jmb_bbgame);
			/////////////////////�޴��� �߰���/////////////////////
			//jf_bbgame�� setTitle���� result[0],result[1]�� �Ű������� �ѱ��.
			setTitle("�߱����ڰ���-"+result[0]+"["+result[1]+"]");
			//jf_bbgame�� setSize ���� �Ű����� 600,600 
			setSize(600, 600);
			//jf_bbgame�� setVisible �Ű����� true  - true(â����) false(â�Ⱥ���) �ǹ�  
			setVisible(true);
		}
		///ȭ��ó����
	public static void main(String[] args) { //ȭ���� �־�� ������ ����
		 new BaseBallGameView(null);
	}
		/* object oriented programming   ?
		 * procedural programming    ?
		 * ���� �����Ǿ� �ִ� �Լ��� �������� ��üȭ �ϴ� ������ �׷����ϰ� ����Ѵ�.
		 * ��⿡ �Լ����� �������ν� ���������ؼ� ������ �ڵ带 �ܼ�ȭ
		 * ��ü Object - Ŭ���� + �ν��Ͻ�(����) 
		 * class �� �����ؼ� �ν��Ͻ�(Ŭ������ �Ȱ��� ������ �Լ��� ���Ե�)�� ����� 
		 * �ν��Ͻ� 
		 */
}
