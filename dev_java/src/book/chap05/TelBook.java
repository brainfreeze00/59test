package book.chap05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame; // javax.swing. �ݺ�����
import javax.swing.JPanel;

public class TelBook {
//�����
	int width = 600; // ���������� �������پ˾ƾ��Ѵ�.
	int height = 500;
	String title = "��ȭ��ȣ��";
	JPanel jp_nroth = new JPanel();
	JButton jbtn = new JButton("��ȭ�������� ����");
	//�̼� �� 4�� ��ü�迭�� �ٲ㺸�ƶ�
	JButton jbtn_sel = new JButton("��ȸ");
	JButton jbtn_ins = new JButton("�Է�");
	JButton jbtn_upd = new JButton("����");
	JButton jbtn_del = new JButton("����");
	GridLayout glay = new GridLayout(1,4); // 1/n 
	
	//������
public String toString() {
		return "���� TelBook�׽�Ʈ Ŭ������.";
	} // �ٸ��� ������ �κ��� �������̴�. �� ������ �ƹ��� Object�� �ƴ� ���� ����
	
//ȭ��ó����
public void display() {
	System.out.println("display ȣ�⼺��"); // �����׽�Ʈ
	//������ ȭ�鿡 â�� ������ִ� Ŭ�����Դϴ�. ���μ��� ���氡�� , ���� �ٲܼ��ִ�.
	JFrame jf_tel = new JFrame();
	//������ ���̾ƿ��� GridLayout 1,4 �ο� �Ѱ� �÷� 4���� n����
	jp_nroth.setLayout(glay);
	jp_nroth.add(jbtn_sel);
	jp_nroth.add(jbtn_ins);
	jp_nroth.add(jbtn_upd);
	jp_nroth.add(jbtn_del);
	//ȭ���� ũ�⸦ �����ּ���. 600, 500
	//setSize�޼ҵ带 ȣ���غ�����.   returnŸ�԰� �Ķ���Ͱ� �߿�
	jf_tel.setSize(width, height); // �Ķ������ ������ ������Ѵ�.
	//jf_tel.setSize(400, 600); //����
	jf_tel.setTitle(title);
	jf_tel.add("North",jp_nroth);
	jf_tel.add("Center", jbtn);
	jf_tel.setVisible(true); // ������ true false�� �����ִ°�?  false�̸� ��Ȱ��ȭ�� �Ⱥ���.
}
//���θ޼ҵ�
	public static void main(String[] args) {
		TelBook tb = new TelBook(); // �ν��Ͻ�
		tb.display(); //�θ���
	}

}
