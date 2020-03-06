package book.chap08;

public class CarTest {

	public static void main(String[] args) {
		//myCar로 접근할수 있는 변수의 개수는 몇개일까요? - 1개
		//myCar로 호출할수 있는 메소드의 개수는 몇개일까요? - 1개
		//Car로 객체를 생성한 경우에는 메소드 한개만 호출 할수 있어요
		//*myCar의 타입이 Car타입이어서 Tivoli타입의 변수나
		//메소드는 한개도 접근, 호출 불가합니다.
		//이것은 new Tivoli()로 인스턴스화 한 경우에도 동일하게 적용됩니다.
		//다시 말하지만 타입이 Car타입이어서 생성부의 이름이 설사 Tivoli가 온다 하더라도
		//Tivoli타입의 변수나 메소드는 접근, 호출이 불가하다는것이죠
		//이런경우 메소드는 부모와 자식 클래스 모두에 선언해놓으면[오버라이드] 호출은 가능합니다.
		/*만일 부모에는 존재하고 자식에는 존재하지 않는 메소드의 경우 둘다 무조건 부모 메소드가 
		 *호출된다.
		 *객체생성은 무조건 생성부 이름으로 생성되는 것이다. 
		 */
		//그러나 변수는?
		Car myCar = new Car(); //myCar 주소번지
		System.out.println(myCar.speed);
		myCar.stop();
		myCar = null;//버리기  JVM이 알아서 하기는 하지만 빠르게 처리하기위해 null씀
		myCar = new Tivoli();//새로 만들기 20번에서 21번으로 진행되는 과정에서 candidate상태 : 모아두었다가 한꺼번에 처리
		System.out.println(myCar.speed);
		myCar.stop();
		
		
		
		//herCar로 접근할수 있는 변수의 개수는 몇개일까요? - 3개
		//herCar로 호출할수 있는 메소드의 개수는 몇개일까요? -3개
		Tivoli herCar = null;
	}

}
