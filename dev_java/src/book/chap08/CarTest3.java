package book.chap08;

public class CarTest3 {

	public static void main(String[] args) {
		Car myCar = null; 
		Tivoli herCar = new Tivoli();
		myCar = herCar;
		//���  : �κ����� ���� �ּҹ����� ���´�
		System.out.println(myCar+","+herCar);
		//�ּҹ����� ���ٴ°��� Ȯ���Ͽ���. @15db9742
		myCar.speed = 15;
		herCar.speed = 100;
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);
		if(myCar instanceof Car) {
			System.out.println("myCar�� CarŬ���� Ÿ���Դϴ�.");
		}else {
		System.out.println("myCar�� CarŬ���� Ÿ���Դϴ�.");
		}
		if(herCar instanceof Car) {
			System.out.println("herCar�� CarŬ���� Ÿ���Դϴ�.");
		}
		if(herCar instanceof Tivoli) {
			System.out.println("herCar�� TivoliŬ���� Ÿ���Դϴ�.");
		}else {
			System.out.println("herCar�� CarŬ���� Ÿ�Ծƴϴ�.");
		}//�θ�Ŭ����Ÿ�Ե� Ŭ����Ÿ�� �ڽ�Ŭ����Ÿ�Ե� Ŭ����Ÿ��
	}

}
