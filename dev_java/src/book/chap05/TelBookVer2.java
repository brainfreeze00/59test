package book.chap05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame; // javax.swing. �ݺ�����
import javax.swing.JPanel;

public class TelBookVer2 { //��ü�迭���
//�����
	int width = 600; // ���������� �������پ˾ƾ��Ѵ�.
	int height = 500;
	String title = "��ȭ��ȣ��-��ü�迭����";
	JPanel jp_nroth = new JPanel();
	JButton jbtn = new JButton("��ȭ�������� ����");
	//insert here - ����� �������� ����̳� ���๮�� ������ ����.
	JButton jbtns[] = new JButton[4];
	String jbtn_label[] = {"��ȸ","�Է�","����","����"};
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
	for(int i=0; i<jbtns.length;i++) {
		jbtns[i] = new JButton(jbtn_label[i]);
		jp_nroth.add(jbtns[i]); // 2�� ������ �׷��� [i] ���̴°���
	}
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
		TelBookVer2 tb = new TelBookVer2(); // �ν��Ͻ�
		tb.display(); //�θ���
	}

}
