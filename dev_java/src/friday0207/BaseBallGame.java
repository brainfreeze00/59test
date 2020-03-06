package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * �̺�Ʈó������
 * 1. �̺�Ʈ �ҽ��� �����ϴ� �̺�Ʈ ó�� �������̽��� implements�Ѵ�.
 * ���� �Ǿ��ְ� ������ ���� �ȵǾ��ִ� �޼ҵ带 �߻�޼ҵ�� �Ѵ�.
 * 2. ActionListener�� �����ϰ� �ִ� �߻� �޼ҵ带 �������ϱ�
 * 3.jbtn_exit.addActionListener(this) ȣ���Ͽ�
 * �̺�Ʈ �ҽ��� �̺�Ʈó���� ����ϴ� Ŭ������ �����ϱ�
 */
public class BaseBallGame implements ActionListener {
	//ȭ��� ���õ� �ڵ��߰� ����
	JFrame   jf_bbgame = new JFrame();
	//JMenuBar�� JFrame�ȿ� �޴��ٸ� �߰��ϱ�
	JMenuBar jmb_bbgame = new JMenuBar();
	//JMenu�� JMenuBar�ȿ� �� �޴� �߰��ϱ�
	JMenu       jm_game = new JMenu("����");
	//JMenuItem�� JMenu�Ʒ��� �� �޴������..
	JMenuItem   jmi_next = new JMenuItem("������");
	JMenuItem   jmi_clear = new JMenuItem("�����");
	JMenuItem   jmi_dap= new JMenuItem("����");
	JMenuItem   jmi_exit = new JMenuItem("������");
	JMenu       jm_info = new JMenu("����");
	JTextArea jta_display = new JTextArea("");
	JScrollPane jsp_display = new JScrollPane(jta_display);
	JTextField jtf_input = new JTextField();
	JButton    jbtn_next = new JButton("������");
	JButton    jbtn_clear = new JButton("�����");
	JButton    jbtn_dap = new JButton("����");
	JButton    jbtn_exit = new JButton("������");
	//JTextArea�� JTextField�� ���� ���� �߰��ϱ�
	JPanel     jp_center = new JPanel();
	//��ư 4���� ���� ���� �߰��ϱ�
	JPanel     jp_east   = new JPanel();	
	//ȭ��� ���õ� �ڵ��߰� ��
	
	int com[] = new int[3];
	int my[] = new int[3]; //my[0]= 0   my[1]= 0   my[2]= 0  
	//����Ʈ ������ �����ϱ�
	public BaseBallGame() {
	//������ �ȿ��� �޼ҵ带 ȣ���ϸ� �ν��Ͻ�ȭ ���̵� ȣ���� �����ϴ�.
		initDisplay();
	}
	//������ ��ư ó��
	//�޼ҵ� �߽��� �ڵ��� �����Ͻÿ� ���뼺�� ���̴� �ڵ带 �ۼ��ϱ� ù�ܰ�
	public void exitGame() {
		System.exit(0);
	}
	//ȭ��ó���ϱ�
	public void initDisplay() {
		//�̺�Ʈ�ҽ��� �̺�Ʈó�� Ŭ���� ����
		jbtn_exit.addActionListener(this);
		jmi_exit.addActionListener(this);
		//System.out.println("ȭ��ó�� ����");
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center",jsp_display);		
		jp_center.add("South",jtf_input);
		jp_east.setLayout(new GridLayout(4,1));
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
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		jf_bbgame.add("Center", jp_center);
		jf_bbgame.add("East",jp_east);
		/////////////////////�޴��� �߰�����/////////////////////
		jm_game.add(jmi_next);
		jm_game.add(jmi_clear);
		jm_game.add(jmi_dap);
		jm_game.add(jmi_exit);
		//�޴��� �޴��ٿ� �ٿ���
		jmb_bbgame.add(jm_game);
		jmb_bbgame.add(jm_info);
		jf_bbgame.setJMenuBar(jmb_bbgame);
		/////////////////////�޴��� �߰���/////////////////////
		jf_bbgame.setTitle("�߱����ڰ���");
		jf_bbgame.setSize(300, 200);
		jf_bbgame.setVisible(true);
		
	}
	// ���ڸ� ���ڸ� ä���ϴ� �޼ҵ��Դϴ�. ������ ��ư�� �����ų� ���� ������ �ٽ� �����Ҷ� ȣ��˴ϴ�.
	public void ranCom() {
		Random r = new Random(); // 0.0~ // �������ʴ� Random Ŭ���� ���
		com[0]= r.nextInt(10); //0.0~10.0
		do {
			com[1] = r.nextInt(10);
		}while(com[0]==com[1]);
		do {
			com[2] = r.nextInt(10);			
		}while(com[0]==com[2]||com[1]==com[2]); //(ù��° �氪�� ����° ä���� ���ڰ� ����?) || (�ι�°�氪�� ����° ä���� ���ڰ� ����?)
	}
	//insert here - account method ����///////////////////////
	public String account(String user) {
		int temp = Integer.parseInt(user);
		my[0] = temp/100; // 123/100 = 1
		my[1] = (temp%100)/10; // 2
		my[2] = temp%10; // 3
		for(int me : my) {
			System.out.println("me:"+me); // 0 0 0 
		}
		int strike = 0;
		int ball = 0;
		for(int i =0 ; i<com.length ; i++) {
			for(int j=0; j<my.length ; j++) {
				if(com[i]==my[j]) { //���� �Է��� �����߿� ���Ϳ� �� ���ڰ� �ִ�?
					if(i==j) {// Ȥ�� �׼��ڰ� �ڸ��� ��ġ�ϴ°ž�?
						strike++;
					}//��Ʈ����ũ ����
					else {
						ball++;
					}
				}////��ī��Ʈ Ȯ��
			}///////////end of inner for
		} //////////////end of outer for
		if(strike==3) {
			return "�����Դϴ� �����մϴ�";
		}
		return strike+"��"+ball+"��";  // 0�� 2�� -> ����� ������  
		
	}
	//////////////////////////////////////////////////////// 
	public static void main(String[] args) {
		BaseBallGame bbGame = new BaseBallGame();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈó��
		//JVM�� ������ �̺�Ʈ �ҽ�[jbtn_exit, jtf_input]�κ��� 
		Object obj = e.getSource(); //���� Object�� JButton���� ����
		//�� �׸� �Ұž�?
		if(obj==jbtn_exit) {
			exitGame();
		}
		if(obj==jmi_exit) {
			//�ڹٰ���ӽŰ� �� �����ϰ��� ������� ����
			exitGame();
		}
	} 

}
