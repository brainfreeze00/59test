package ocjp.basic;
/*
 * ����
 * �ν��Ͻ� ������ ȣ�� �Ҽ��ִ�.
 * 
 * ����
 * �ν��Ͻ� ������ ȣ�� �Ҽ�����.
 *
 */
public class A1 {
	//�ڹٿ����� ����Ÿ���� ����Ʈ���� �ִ�. double 0.0  boolean false
	int x; // ������ �ʱ�ȭ�� �����Ҽ� �ִ�. �ֳ��ϸ� �����ڰ� ���ִϱ�
	boolean check() { // �޼ҵ� ����  
		x++; // x=1
		return true; 
	}
	public static void main(String[] args) {
		new A1().check();
		A1 a1 = new A1(); //�ǻ��� �������� ��� �ٸ�. 
		a1.check(); 
		System.out.println("x : "+a1.x);// x=0 -> 1 19���� ����
		//int y = 10;//����=�޼ҵ�ȿ��� ������ ������ ��������
		//System.out.println("y : "+a1.y); ��� ����
	}

}
