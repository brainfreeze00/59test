package study.sungjuk;
/*	�����ε�(Overloading) : ���� �̸��� �޼ҵ带 ���� �� �����鼭 �Ű������� ������ ������ �ٸ����� �ϴ� ���
	�������̵�(Overriding) : ���� Ŭ������ ������ �ִ� �޼ҵ带 ���� Ŭ������ ������ �ؼ� ����Ѵ�.
	   
	   ����	      �����ε�		     �������̵�
	�޼ҵ��̸�		 ����				 ����
	�Ű�����,Ÿ��	 �ٸ�				 ���� 
	����Ÿ��	        �������			 ����
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SungJuk implements ActionListener {
	//�����
	JFrame jf_sungjuk       = new JFrame(); //ȭ��
	JLabel jlb_su         	= new JLabel("�ο���");
	JLabel jlb_inwon        = new JLabel("��");
	JTextField jtf_inwon  	= new JTextField(15); // 15 ũ��
	JTextField jtf_inwon2   = new JTextField();
	JButton jbtn_data  		= new JButton("������ȣ��");
	JButton jbtn_account    = new JButton("����ó��");
	JButton jbtn_exit  		= new JButton("����");
	JPanel jp_north         = new JPanel(); // ������ Jpanel
	JPanel jp_south         = new JPanel();//����Ʈ ���̾ƿ��� FlowLayout
	JPanel jp_west          = new JPanel();
	JPanel jp_east          = new JPanel();
	JPanel jp_center        = new JPanel();
	//���̺� ó�� �ڵ� �߰�
	String           	 	  cols[] = {"�̸�","����","����","����","����","���","����"}; // �÷���
	String          		data[][] = null;  
	DefaultTableModel 	 dtm_sungjuk = null; // �Ķ���� 2���� �޾Ƽ� �ʱ�ȭ�� �Ҽ��ִ�.
	JTable            	 jt_sungjuk  = null;//dtm�� �����͸� �����ְ� ���̺��� ����� ������ �����Ͱ� ���� �׷��� ������
	JScrollPane       	 jsp_sungjuk = null;
	//����ڰ� �Է��� �ο����� ���� �����Դϴ�.
	//���������� �� ������ �ο����� ���� jtf_inwon���� ���� ������ ���� �����Ǵ°�
	//�׶� ������ 3�� jbtn_account������ �ʿ��մϴ�.
	//�ֳ��ϸ� ������ �������� ������ ���ϱ�� �����Ǿ����Ƿ� ������ ������ ���� ������ 2���迭��
	//�����Ͽ��� �����̴�.
	int inwon = 0; //����ó�� ������ �����Ǿ���ϴϱ� ����
	int imsi[][] = null;
	//������
	SungJuk(){
		start();
	}
	//������ ���ϴ� �޼ҵ� ����
	public double total() {
		return 0.0; //���������� ����Ÿ���̶� �Ǽ����·� ����
	}
	//����� ���ϴ� �޼ҵ� ����
	public double average() {
		return 0.0;
	}
	//������ ���ϴ� �޼ҵ� ����
	public int[] ranking() {
		//return null; //Ŭ������ ���۷��� �� null�� �Է��ص���
		return new int[2];
	}
	//�̺�Ʈ �ҽ��� �̺�Ʈó�� Ŭ������ ����
	public void start() {
		//���� ������ �����ϰ� �ݹ�޼ҵ带 ȣ������
		jtf_inwon.addActionListener(this);
		//�����Ͱ������� �̺�Ʈ����
		jbtn_data.addActionListener(this);
		//����ó�� �̺�Ʈ����
		jbtn_account.addActionListener(this);
		//���� �̺�Ʈ����
		jbtn_exit.addActionListener(this);
	}
	//������ 
	public void exitSungJuk() {
		System.exit(0);
	}
	//ȭ��ó����
	public void initDisplay() {
		
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jlb_su);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb_inwon); // 
		
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_data); //��ưȭ�鿡 �ֱ�
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		
		jf_sungjuk.add("North", jp_north);
		jf_sungjuk.add("South", jp_south);// �̰� ������ ��ư �Ⱥ���
		jf_sungjuk.setTitle("����ó�� ���α׷� ver 1.0");	
		jf_sungjuk.setSize(600, 600);
		jf_sungjuk.setVisible(true); // ����	
		//jf_sungjuk.pack();		
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
	 JFrame.setDefaultLookAndFeelDecorated(true); // ȭ�麯��
	 SungJuk sj = new SungJuk();
	 sj.initDisplay();
	 
	}
	//@Overrid�� (@�� ������̼��̰�)   ����- ActionListener�� ���� �߻�޼ҵ带
	//�״�� �����ٰ� �������ؼ� ����Ͻÿ�.
	//
	//�߻�޼ҵ� : void methodA(); �̷� ���� , Ư¡ : �̸��� ���������� ����� �������� ���� ��� ����� ����������.
	@Override
	public void actionPerformed(ActionEvent e) {//�ݵ�� �θ� �����ִ� ����� �����ؼ� ��� �ٲٸ� ����
		//insert here  actionPerformed method�� ���⸸ �ǵ��� 
		Object obj = e.getSource(); //�̺�Ʈ�� ������ ��ư�� �ּҹ�����  �о���� �޼ҵ���.
		if(obj == jbtn_account) {
			//������ ������ �� ������ �Ҵ��ϱ�
			//�ο����� ��� ��������? - ���������� �����ϰ� ����ϴ°� ���ھ�
			//�ֳĸ� �ٸ� �̺�Ʈ������ �ʿ��ϱ� ��������
			int imsi[][] = new int[inwon][2];
			for(int i=0;i<inwon;i++) {
				int tot = Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 1))
						 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 2))
						 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 3));
				//���� ������ DefaultTableModel��ü�� ���
				dtm_sungjuk.setValueAt(tot, i, 4); //�̺�Ʈ�� ������ ��ư�� �ּҹ����� ����ϴ� �޼ҵ���
				double avg = 0.0;
				avg = tot/3.0;
				dtm_sungjuk.setValueAt(avg, i, 5);
				imsi[i][0] = tot;
				imsi[i][1] = 1; //������ �������� ���� ��찡 �߻��� �� �ִ�.
				//�̶� 0���� ������ �ȵǴϱ� �ʱ�ȭ�� 1�� �����Ͽ���.
				//���� �ű��
			}//end of for
				for(int i=0;i<inwon;i++) {
					for(int j=0;j<inwon;j++) {
						//imsi[0][0] < imsi[0][0]
						//imsi[0][0] < imsi[1][0]
						//imsi[0][0] < imsi[2][0]
						//3<3, 3<1, 3<2
						if(imsi[i][0] < imsi[j][0]) {
							imsi[i][1]++;
						}
					}
				}//end of for
				for(int i=0;i<inwon;i++) {
					dtm_sungjuk.setValueAt(imsi[i][1], i, 6);
				}
		}
		else if(obj== jbtn_data) { // ������ ������ ��ư
			String data[][] = {
					 {"�̻���","30","35","30"}
					,{"�ڸ���","50","55","50"}
					,{"�����","45","40","45"}	
			};
			//�ʱ�ȭ �� �� �ִ�?
			//2�� for�� Ȱ���� �� �ִ°ž�? 
			for(int i=0;i<3;i++) {
				for(int j=0;j<4;j++) {
					dtm_sungjuk.getValueAt(i, j); //���� �ҷ���
					dtm_sungjuk.setValueAt(data[i][j], i, j); //��, row, column
					/*tot = Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 1))
					 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 2))
					 +Integer.parseInt((String)dtm_sungjuk.getValueAt(i, 3));
					System.out.println("���� "+i+":"+tot);*/
				} 
			}
		}
		if(obj== jtf_inwon) {
			
			inwon = Integer.parseInt(jtf_inwon.getText()); // �̰� �м��ؾ���
			data = new String[inwon][7]; 
			dtm_sungjuk = new DefaultTableModel(data,cols); // �Ķ���� 2���� �޾Ƽ� �ʱ�ȭ�� �Ҽ��ִ�.
			jt_sungjuk  = new JTable(dtm_sungjuk);//dtm�� �����͸� �����ְ� ���̺��� ����� ������ �����Ͱ� ���� �׷��� ������
			jsp_sungjuk = new JScrollPane(jt_sungjuk);
			jf_sungjuk.add("Center",jsp_sungjuk); 
			jf_sungjuk.pack(); 
			Dimension di 
			= Toolkit.getDefaultToolkit().getScreenSize();//1280x768
			//���� ���� �׸� ȭ���� ũ�� �������� 
			Dimension di2 = jf_sungjuk.getSize();
			jf_sungjuk.setLocation//������ ��ġ
			((int)(di.getWidth()/2-di2.getWidth()/2), // 1280/2 - a/2
			(int)(di.getHeight()/2-di2.getHeight()/2));//768/2 - b/2
		}
		else if(obj == jbtn_exit) {
			System.out.println("������ ��ư ȣ�� ����");
			System.exit(0);// �޼ҵ� ȣ��
		}
	}////////end of acrtionPerFormed

}
