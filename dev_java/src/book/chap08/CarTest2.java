package book.chap08;

public class CarTest2 {

	public static void main(String[] args) {
		
		//myCar�� �����Ҽ� �ִ� ������ ������ ��ϱ��? - 1��
		//myCar�� ȣ���Ҽ� �ִ� �޼ҵ��� ������ ��ϱ��? - 1��
		Car myCar = null;   // ����
		myCar = new Tivoli(); // �ν��Ͻ�ȭ
		myCar.stop(); //�޼ҵ� ȣ��
		System.out.println(myCar.speed); //�����
		
		System.out.println("-----------------------");
		
		myCar = new Car();
		myCar.stop();
		System.out.println(myCar.speed);
		System.out.println("-----------------------");
		
		//herCar�� �����Ҽ� �ִ� ������ ������ ��ϱ��? - 3��
		//herCar�� ȣ���Ҽ� �ִ� �޼ҵ��� ������ ��ϱ��? -3��
		Tivoli herCar = null;
		herCar = new Tivoli();
		herCar.stop();
		herCar.VolumnUp();
		herCar.VolumnUp();

		herCar.VolumnUp();
		System.out.println(herCar.carColor);
		System.out.println(herCar.volumn);
		
		System.out.println("-----------------------");
		
		Car himCar = null;
		himCar = new Car();
		himCar.stop();
		System.out.println(himCar.speed);
		
	}

}
