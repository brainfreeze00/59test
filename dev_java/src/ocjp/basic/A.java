package ocjp.basic;

public class A {
	int x; //3 Ŭ������ �ؿ� ���������� �������� 
	boolean check() { //7�޼ҵ� �����ϱ� 
		x++; // 9  0->1->2
		return true; //8
	}
	void zzz() { //2
		x = 0; //4 
		// �տ� ��ȣ���� ����� True �̹Ƿ� �ڿ� ������ ���̵� �����̵� ������� ���๮�� �ݵ�� �����.
		if((check() | check()) || check()) {//5.6   �����ϵ� ��ȣ�� ���� ������ �ٲ�� �ֱ⿡ ���ǿ��� �켱������ ���Ѵ�.(2+3)*5
			x++; //5     2->3  ���� ���� x���� �����ǰ� �ִ�.
		}
		System.out.println("x ===>"+x); //10
	}
	public static void main(String[] args) {
		new A().zzz(); //1
		
	}

}
