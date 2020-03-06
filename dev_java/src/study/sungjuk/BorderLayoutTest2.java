package study.sungjuk;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutTest2 {
	
	JFrame jf_sungjuk = new JFrame(); // ����Ʈ ���̾ƿ��� BorderLayout[���������߾�] 1
	//��ư����2 -> �гη� ����
	JPanel jp_north  = new JPanel();
	JLabel jlb_su    = new JLabel("�ο���"); // �ο��� �Ķ���Ͱ� �ִ� Ŭ���� Ÿ�԰� ���� ������ Ŭ���� west
	JLabel jlb_su2    = new JLabel("�ο���"); // �ο��� �Ķ���Ͱ� �ִ� Ŭ���� Ÿ�԰� ���� ������ Ŭ���� west
	JLabel jlb_inwon = new JLabel("��"); // �ο��� �Ķ���Ͱ� �ִ� Ŭ���� Ÿ�԰� ���� ������ Ŭ���� west
	JTextField jtf_inwon = new JTextField(); //�ο� center
	JTextField jtf_inwon2 = new JTextField(15); //�ο� center  ������ �ȵż� 2���� ĭũ��
	JPanel jp_south  = new JPanel();//����Ʈ ���̾ƿ��� FlowLayout
	JPanel jp_west   = new JPanel();
	JPanel jp_east   = new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_data = new JButton("�����Ϳ�û"); //�ν��Ͻ�ȭ ���ÿ� ��ư ��
	JButton jbtn_account = new JButton("ó��");
	JButton jbtn_exit = new JButton("����");
	
	public BorderLayoutTest2() { 
		//���� FlowLayout�̾��µ� �̰��� BorderLayout���� �����ϱ�
		jp_north.setLayout(new BorderLayout());
		jp_north.setBackground(Color.ORANGE); //orange static
		jp_south.setBackground(Color.cyan);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south.add(jlb_su2);  // �޴����߰�
		jp_south.add(jtf_inwon2); //
		jp_south.add(jlb_inwon);//
		jp_south.add(jbtn_data); //��ưȭ�鿡 �ֱ�
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		
		jp_west.setBackground(Color.GREEN);
		jp_east.setBackground(Color.BLUE);
		jp_center.setBackground(Color.darkGray);
		
		jp_north.add("West", jlb_su); // ���ʿ� �ο���
		jp_north.add("Center", jtf_inwon); // ���Ϳ� �ο�
		
		jbtn_account.setBackground(Color.lightGray);
		jbtn_data.setBackground(Color.red);
		jbtn_exit.setBackground(Color.white);
		
		jf_sungjuk.add("North" , jp_north);//3
		jf_sungjuk.add("South" , jp_south);//3
		jf_sungjuk.add("West" , jp_west);//3
		jf_sungjuk.add("East" , jp_east);//3
		jf_sungjuk.add("Center" , jp_center);//3
		jf_sungjuk.setSize(500, 400); //2
		//ȭ�鿡 JFrame�� ������ּ���
		jf_sungjuk.setVisible(true); // 1
	}
	public static void main(String[] args) {
		new BorderLayoutTest2();
	}

}
