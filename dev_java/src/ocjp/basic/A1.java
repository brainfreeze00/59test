package ocjp.basic;
/*
 * 전변
 * 인스턴스 변수로 호출 할수있다.
 * 
 * 지변
 * 인스턴스 변수로 호출 할수없다.
 *
 */
public class A1 {
	//자바에서는 원시타입의 디폴트값이 있다. double 0.0  boolean false
	int x; // 전변은 초기화를 생략할수 있다. 왜냐하면 생성자가 해주니까
	boolean check() { // 메소드 선언  
		x++; // x=1
		return true; 
	}
	public static void main(String[] args) {
		new A1().check();
		A1 a1 = new A1(); //또생김 복제본임 고로 다름. 
		a1.check(); 
		System.out.println("x : "+a1.x);// x=0 -> 1 19번이 적용
		//int y = 10;//지변=메소드안에서 선언한 변수는 지역변수
		//System.out.println("y : "+a1.y); 고로 못씀
	}

}
