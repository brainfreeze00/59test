package book.chap06;
/*
 * 10�� 12�� 14���� �ּҹ��� ��� �ٸ� ���� ���̴�.
 * 10�� 12���� ������ 14�� �ٸ� ���̴�.
 * 10�� 12�� 14�� ��� ���� �ٸ� �ּҰ��� �������̴�.
 */
public class Tivoli {
	public int speed = 0; // �������� ����
	//����Ʈ ������ �����ϱ� - �Ķ���Ͱ� ���� ��������
	//JVM�� ��� ����� �� �� �ִ� ������ - �Ķ���͸� �������� �ʾƵ� �Ǵϱ� ����������.
	Tivoli() {	
	//this - �ڱ� �ڽ��� �ּҹ���
	//this() - �ڱ� �ڽ��� �����ڸ� ȣ��� ���� �ִ�.
		this(50); //������ ȣ���ϱ� 0->50���� �ʱ�ȭ  ���⸦ �ּ�ó���ϸ� 0���� �ȴ� �� 50�� �������� 
	}
	Tivoli(int speed) {	
		this.speed = speed;
	}
	public static void main(String[] args) {
		Tivoli myCar = new Tivoli(); // ��ü����  , ����Ʈ ������ ȣ���ϱ� -11-14(50)-
		//myCar.speed = 30; // �ʱ�ȭ 1
		System.out.println("myCar ��.�� :"+myCar); // �ֹ�
		System.out.println("myCar ��.�� :"+myCar.speed+"���� ���� ���̾�"); // 30   ������ ������ 50
		//�ڹٿ����� ���� �̸��� ������ �ߺ������� �� ����
		myCar = new Tivoli(); // �׷��� Tivoli ������ + 10�� ¥�� ���纻 50  new -> ���ο�� ������� ������ �ٸ� , �ּҹ��� �޶��� �ֳĸ� ������ ������ ���ڸ���
		myCar.speed = 50; // �ʱ�ȭ 2
		System.out.println("myCar2 ��.�� :"+myCar);
		System.out.println("myCar ��.�� :"+myCar.speed+"�ӵ��� ���� �־�");
		Tivoli herCar = new Tivoli();// ��ü���� 10�� 18���������̸��� �ٲ����ϱ� ��� �������� �翬�� �̸��� �ٸ��� �ּҹ��� �ٸ� (���� �Ϸù�ȣ�� ����)
		myCar.speed = 100; // �ʱ�ȭ 3
		System.out.println("herCar ��.�� :"+herCar);
		System.out.println("myCar ��.�� :"+myCar.speed+"�ӵ��� �޸��� �־�");
		
		
	}

}
