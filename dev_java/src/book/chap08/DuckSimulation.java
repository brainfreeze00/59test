package book.chap08;

public class DuckSimulation {
/*
 * 선언부의 타입과 생성부의 타입이 다를 수 있다.
 * 결론 : 생성부 타입으로 객체가 생성된다.(heap 영역에 올라간다.)
 * 그런데 선언부 타입이 그 메소드를 선언하고 있지 않으면 자식 클래스안에 
 * 그메소드가 선언되어 있다 하더라도 호출 할 수 없다.
 * 최종 결론 : 무조건 부모 타입에 선언된 메소드만 호출할수있다.
 */
	public static void main(String[] args) {
		
		Duck d 		= new Duck();
		Duck dw 	= new WoodDuck();
		Duck dr 	= new RubberDuck();
		Duck dm 	= new MallardDuck();
		//호출형태 주소번지.메소드(주소번지.변수)
		System.out.println("수영----------------------------------");
		d.swimming(d.sw);
		dw.swimming(dw.sw);
		dr.swimming(dr.sw);
		dm.swimming(dm.sw);
		System.out.println("소리----------------------------------");
		d.quack(d.qu);
		dr.quack(dr.qu);
		dm.quack(dm.qu);
		System.out.println("난다----------------------------------");
		d.fly(d.f);
		dm.fly(dm.f);
	}

}
