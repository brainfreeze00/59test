package book.chap06;

import javax.swing.JOptionPane;

public class P181 {
	void methodA() {
		System.out.println("methodAȣ�� ����");
	}	
	public static void main(String[] args) {
	
		String input = JOptionPane.showInputDialog("���ڸ� �Է��ϼ���.");
		int i = Integer.parseInt("20");
		//P181.methodA(); �޼ҵ� ����� static�� ������� �ʾ����Ƿ� �����߻�
		//static�� ���� �޼ҵ带 ȣ���Ҷ� �ݵ�� �ν��Ͻ�ȭ �Ұ�.
		//���� static�� �ִٸ� Ŭ���� Ÿ��.�޽����
		P181 p = new P181();
		p.methodA();
		//"30" ====> 30
		System.out.println(Integer.parseInt(input)+10); // Integer.parseInt() String -> int 
	}

}
