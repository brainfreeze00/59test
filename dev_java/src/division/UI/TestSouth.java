package division.UI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
//JPanel�� �ܵ����� â�� ���� ����.
//ȥ�������δ� ���� ���� �� ����.
//TestViewŬ������ �����ؾ� ȭ�鿡 ��Ÿ���� �ִ�.-������ ����
public class TestSouth extends JPanel {
	JTextField jtf_msg = new JTextField(20);
	
	//�信 �ν��Ͻ�ȭ���� ������ ����
	public TestSouth() {
		initDisplay();
	}
	
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center",jtf_msg);
	}
}
