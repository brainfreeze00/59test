package book.chap02;

public class SungJuk {
	/*
	 ���ȿ� �ִ� �޼ҵ�� �ϴ��� �޼ҵ� ����� static�� ������ main�޼ҵ忡�� 
	 ȣ���Ҽ� ����. 
	 ������ �����ִ� �޼ҵ尡 �ִ�. �̸��� hap��.
	 �Ķ���Ͱ� �ִ� | ���� 
	 
	 �Լ������ϱ�
	 �Լ� ��ȯ��<int, double, String....> �Լ��̸�  (�Ű�����<int num1>, <int num2>) {
	 int result; 
	 result = int1 + int2;
	 ����� <return> result;
	 }
	 */
	int hap(int kor, int eng) {
		int tot = 0;
		tot = kor+eng; // 140
		return tot;
		}//////end hap
	
	double avg(int tot, int subject) { 
		int avg;
		return tot/subject;
	
		/*
	 29-32-33(����)-34(����)-35-10(�޼ҵ尡 �ű� �־� 80���� 60���� ������ ���� �����)-11-12-13-14(hap��)
	 36[140]-38-18[140�����]-16-17-39
	 */
	}//end of avg
	//����� �Ҽ����� ���ü� �ִ�.
	//���ϰ��� double(�Ǽ���)���� �����Ѵ�.
	//�޼ҵ� �����ϱ�
	//��ȯŸ�� �޼ҵ��̸�(�Ķ����1 , �Ķ����2)
	public static void main(String[] args) {
		//insert here - hap�޼ҵ忡�� ���� ���� ���� ���⼭ ����ϰ� �;��
		//�����?
		SungJuk sj = new SungJuk();
		int kor = 80;
		int eng = 65;
		int tot = sj.hap(kor, eng);
		int subject = 0; // ����� ������� ���� �ž�
		subject = 2;
		System.out.println("�������� = "+ tot);
		//������ ����� ����� tot������ avg�޼ҵ忡�� ����ϰ� �ʹ�.
		double avg = sj.avg(tot,subject);
		System.out.println("������� = "+ avg); // 
		
	}

}
