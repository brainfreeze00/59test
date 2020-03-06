package book.chap02;
/********************************************************
 * 나는 클래스에서 변수의 선언 위치에 대해 말할 수 있다.
 * 클래스 선언한 바로 다음 자리 - 전역변수
 **********************************************************/
public class Sonata {
	//insert here
	String carColor = null; //참조형(refernce type - 주소번지 출력) 타입을 선언할때 쓰는 예약어
	int speed = 50; //전역변수 - 초기화를 생략 할수 있다. 왜 안해도 될까 ?- 생성자가 해주니까
	public static void main(String[] args) {
		//선언
		int wheelNum; //지역변수-반드시 초기화를 해야 된다. 초기화를 생략할수없다.
		//초기화
		//변수의 장애 - 변수는 한번에 하나만 담을 수 있다. - 동시에 두개를 담을수없다.
		wheelNum = 0;
		wheelNum = 4; //기초+활용
		
		System.out.println(wheelNum);// 0 or 4
		//carColor의 초기화를 빨강으로 해보시오
		//전역변수는 클래스 전역에서 사용할 수 있는데 왜 에러가 나는 걸까요
		Sonata hercar = new Sonata();
		hercar.carColor ="RED";
		System.out.println(hercar.carColor); // 변수 
		System.out.println("빨강"); // 상수 
		//소나타 클래스안에서 티볼리안에 있는 변수나 메소드를 누릴(호출) 수 있다.
		Tivoli yourCar = new Tivoli();
		System.out.println(yourCar);
		
		
		
	}//end of main

}
