package ocjp.basic;

public class X {
	public static void modify(String s) {
		
	}
	public static void main(String[] args) {
		//String Ÿ���� ����� ������ �ٲ����ʴ� �༮�̴�
		String s = new String("Hello");//�Ϲ� ������ Ÿ�� ����
		String s1 = "Hello"; // ������Ÿ��
		System.out.println(s1+" world!!!");
		//s1=s1+" world!!!";
		//s1+=" world!!!";
		System.out.println(s1);
		if(s==s1) {//�ּҹ����� ����? s�� s1�� ������ Ÿ��
			System.out.println("�ּҹ����� ���ƿ�");
		}
		else {
			System.out.println("�ּҹ����� �޶��");
		}
		//�ּҹ����� ����Ű�� ���� ���� .equals()
		if(s.equals(s1)) {//�ּҹ����� ����Ű�� ���� �����ž�?
			System.out.println("�ּҹ����� ������ ����");			
		}
		else {
			System.out.println("�ּҹ����� ����Ű�� ���� �ٸ���");
		}
	}
}
