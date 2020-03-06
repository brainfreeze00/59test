package ocjp.basic;

public class A {
	int x; //3 클래스명 밑에 선언했으니 전역변수 
	boolean check() { //7메소드 선언하기 
		x++; // 9  0->1->2
		return true; //8
	}
	void zzz() { //2
		x = 0; //4 
		// 앞에 괄호에서 결과가 True 이므로 뒤에 명제가 참이든 거짓이든 상관없이 실행문은 반드시 실행됨.
		if((check() | check()) || check()) {//5.6   연산하듯 괄호에 의해 순서가 바뀔수 있기에 조건에도 우선순위를 정한다.(2+3)*5
			x++; //5     2->3  현재 변수 x값은 유지되고 있다.
		}
		System.out.println("x ===>"+x); //10
	}
	public static void main(String[] args) {
		new A().zzz(); //1
		
	}

}
