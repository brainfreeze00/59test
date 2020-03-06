package book.chap06;
/*
 * 10번 12번 14번의 주소번지 모두 다른 값일 것이다.
 * 10번 12번은 같지만 14은 다를 것이다.
 * 10번 12번 14번 모두 서로 다른 주소값을 가질것이다.
 */
public class Tivoli {
	public int speed = 0; // 전역변수 선언
	//디폴트 생성자 구현하기 - 파라미터가 없는 생성자임
	//JVM이 대신 만들어 줄 수 있는 생성자 - 파라미터를 결정하지 않아도 되니까 제공가능함.
	Tivoli() {	
	//this - 자기 자신의 주소번지
	//this() - 자기 자신의 생성자를 호출로 쓸수 있다.
		this(50); //생성자 호출하기 0->50으로 초기화  여기를 주석처리하면 0으로 된다 즉 50을 못데려감 
	}
	Tivoli(int speed) {	
		this.speed = speed;
	}
	public static void main(String[] args) {
		Tivoli myCar = new Tivoli(); // 객체생성  , 디폴트 생성자 호출하기 -11-14(50)-
		//myCar.speed = 30; // 초기화 1
		System.out.println("myCar 주.번 :"+myCar); // 주번
		System.out.println("myCar 주.번 :"+myCar.speed+"으로 가는 중이야"); // 30   생성자 수업후 50
		//자바에서는 같은 이름의 변수를 중복선언할 수 없다
		myCar = new Tivoli(); // 그래서 Tivoli 빼야함 + 10번 짜름 복사본 50  new -> 새로운거 만들어짐 기존과 다름 , 주소번지 달라짐 왜냐면 원본이 상주함 그자리에
		myCar.speed = 50; // 초기화 2
		System.out.println("myCar2 주.번 :"+myCar);
		System.out.println("myCar 주.번 :"+myCar.speed+"속도를 내고 있어");
		Tivoli herCar = new Tivoli();// 객체생성 10과 18번은변수이름이 바꼈으니까 고로 각각선언 당연히 이름이 다르니 주소번지 다름 (고유 일련번호로 구분)
		myCar.speed = 100; // 초기화 3
		System.out.println("herCar 주.번 :"+herCar);
		System.out.println("myCar 주.번 :"+myCar.speed+"속도로 달리고 있어");
		
		
	}

}
