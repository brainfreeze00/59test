package book.chap02;
/********************************************************
 * ���� Ŭ�������� ������ ���� ��ġ�� ���� ���� �� �ִ�.
 * Ŭ���� ������ �ٷ� ���� �ڸ� - ��������
 **********************************************************/
public class Sonata {
	//insert here
	String carColor = null; //������(refernce type - �ּҹ��� ���) Ÿ���� �����Ҷ� ���� �����
	int speed = 50; //�������� - �ʱ�ȭ�� ���� �Ҽ� �ִ�. �� ���ص� �ɱ� ?- �����ڰ� ���ִϱ�
	public static void main(String[] args) {
		//����
		int wheelNum; //��������-�ݵ�� �ʱ�ȭ�� �ؾ� �ȴ�. �ʱ�ȭ�� �����Ҽ�����.
		//�ʱ�ȭ
		//������ ��� - ������ �ѹ��� �ϳ��� ���� �� �ִ�. - ���ÿ� �ΰ��� ����������.
		wheelNum = 0;
		wheelNum = 4; //����+Ȱ��
		
		System.out.println(wheelNum);// 0 or 4
		//carColor�� �ʱ�ȭ�� �������� �غ��ÿ�
		//���������� Ŭ���� �������� ����� �� �ִµ� �� ������ ���� �ɱ��
		Sonata hercar = new Sonata();
		hercar.carColor ="RED";
		System.out.println(hercar.carColor); // ���� 
		System.out.println("����"); // ��� 
		//�ҳ�Ÿ Ŭ�����ȿ��� Ƽ�����ȿ� �ִ� ������ �޼ҵ带 ����(ȣ��) �� �ִ�.
		Tivoli yourCar = new Tivoli();
		System.out.println(yourCar);
		
		
		
	}//end of main

}
