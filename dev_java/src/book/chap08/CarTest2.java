package book.chap08;

public class CarTest2 {

	public static void main(String[] args) {
		
		//myCar로 접근할수 있는 변수의 개수는 몇개일까요? - 1개
		//myCar로 호출할수 있는 메소드의 개수는 몇개일까요? - 1개
		Car myCar = null;   // 선언
		myCar = new Tivoli(); // 인스턴스화
		myCar.stop(); //메소드 호출
		System.out.println(myCar.speed); //값출력
		
		System.out.println("-----------------------");
		
		myCar = new Car();
		myCar.stop();
		System.out.println(myCar.speed);
		System.out.println("-----------------------");
		
		//herCar로 접근할수 있는 변수의 개수는 몇개일까요? - 3개
		//herCar로 호출할수 있는 메소드의 개수는 몇개일까요? -3개
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
