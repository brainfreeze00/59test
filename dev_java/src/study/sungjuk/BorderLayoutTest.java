package study.sungjuk;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest {
	
	JFrame jf = new JFrame(); // ����Ʈ ���̾ƿ��� BorderLayout[���������߾�] 1
	//��ư����2
	JButton jbtn_north  = new JButton("����");
	JButton jbtn_south  = new JButton("����");
	JButton jbtn_west   = new JButton("����");
	JButton jbtn_east   = new JButton("����");
	JButton jbtn_center = new JButton("�߾�");
	
	public BorderLayoutTest() {
		jf.add("North" , jbtn_north);//3
		jf.add("South" , jbtn_south);//3
		jf.add("West" , jbtn_west);//3
		jf.add("East" , jbtn_east);//3
		jf.add("Center" , jbtn_center);//3
		jf.setSize(500, 400); //2
		//ȭ�鿡 JFrame�� ������ּ���
		jf.setVisible(true); // 1
	}
	public static void main(String[] args) {
		new BorderLayoutTest();
	}

}
