package division.UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestView extends JFrame {
	TestSouth ts = new TestSouth();
	//TestEvent���� ts�� �ѱ�� TestSouth�� ������ ������ this�� �ѱ�� TestView�� TestSouth ��� ������ �ִ�.
	TestEvent te = new TestEvent(this);
	//TestSouth ts2 = new TestSouth(this); this�� �ְԵǸ� 
	JPanel jp_north = new JPanel();
	JButton jbtn_change = new JButton("����");
	
	public TestView() {
		initDisplay();
	}
	
	public void initDisplay() {
		//�ڵ��� �������� ������
		ts.jtf_msg.addActionListener(te); // ��콺���� �ؾ��� �� �� �̺�Ʈ ó���� �̺�Ʈ���� �ϰ� �ȴ�.
		jbtn_change.addActionListener(te); // te�� �ִ� ActionListener�� �̺�Ʈ ó��-��ư ����
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));//�г��� ����
		jp_north.add(jbtn_change); //��ư ����
		this.add("North",jp_north); // �����ư�� ���� �г�
		this.add("South",ts); // JPanel�� ��ӹ��� TestSouth Ŭ������ JTextField�� �ҷ��� ts�ּҹ���
	//	this.add("South",ts.jtf_); // JPanel�� ��ӹ��� TestSouth Ŭ������ JTextField�� �ҷ��� ts�ּҹ���
		this.setVisible(true);
		this.setTitle("View");
		this.setSize(500, 500);
	}
	
	public static void main(String[] args) {
		new TestView();
		
	}
}
