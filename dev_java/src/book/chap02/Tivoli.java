package book.chap02;

public class Tivoli {
	int speed = 0;
	String speedUp() {
		String h = "프로그래머";	
		speed = speed + 1; //1
		return h;
	}
	/*
	 * 자바가상머신이 동작하는 순서대로 번호를 매겨볼까?
	 * 13-21-22[주소번지 출력]-23[초기화-30]-25
	 */
	//entry point - 제일먼저 실행되는 부분
	public static void main(String[] args) {
		/*
		 * 문제제기
		 * non-static 타입의 speed변수는  static이있는 메인 메소드안에서 접근이 불가
		 * 해결방법 - 어떡하지? How
		 * 인스턴스화하면 된다.
		 * 
		 */
		Tivoli gnom = new Tivoli();
		System.out.println("gnom의 주소번지는 "+ gnom);// 16진수표현 0 1 2 3 4 5 6 7 8 9 a b c d e f #aabbcc
		gnom.speed = 30;
		System.out.println(gnom.speedUp());
		//insert here 
		System.out.println(gnom.speed);
	}

}
