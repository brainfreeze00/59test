package method.zipcode;

public class B {

	public static void main(String[] args) {
		int i = 0;
		//i =100/0;
		try {
			//���� ���ܰ� �߻����������� ���°Ͱ� ������ ����
			i =100/0; // ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �ۼ���.
		} catch(Exception e) {
			System.out.println("0���� �������� ��� �� �� ���ݾ�"); 
		}
		System.out.println("���� i�� "+i);
	}

}
