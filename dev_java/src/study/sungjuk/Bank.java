package study.sungjuk;
/*
 * 연습문제

다음 요구사항을 만족하는 은행 계좌 클래스를 정의하는 소스를 작성해 보시오.

요구사항

가.속성으로 예금주, 계좌번호, 잔액을 갖는다.
예금주는 String, 계좌번호는 String, 잔액은 int로 정의하시오.

나.메소드로 인출 및 입금 메소드를 구현하시오.
인출 메소드는 인자로 인출할 금액을 받고 잔액이 부족할 때는 "잔액이 부족합니다."
라는 메시지를 잔액이 충분할때는 인출한 금액을 출력하는 메소드이다.
입금 메소드는 인자로 입금할 금액을 받고 입금액을 잔액에 더하고
입금한 금액을 출력하는 메소드이다.

다. toString메소드를 오버라이딩 하여 계좌정보
즉 예금주, 계좌번호, 잔액을 출력하는 메소드를 정의 하시오.
예) 예금주 : 자바사랑
    계좌번호 : 123-456-789
    잔액 : 1000원

라. 위에서 정의한 클래스를 활용하여 
다음 요구사항을 만족하도록 프로그래밍 해보시오,

[요구사항]
가.은행계좌 클래스를 사용하여 객체를 생성한다.
나.객체의 멤버(예금주, 계좌번호,잔액)을 아래처럼
초기화 하시오.

예금주 : 자바사랑
계좌번호 : 123-456-789
잔액 : 10000원

마.15000원을 입금하도록 메소드를 호출하시오.

바.30000원을 출금하도록 메소드를 호출하시오.

 */
public class Bank {
	String name 		= null; // 예금주 전역변수 선언
	String account		= null; // 계좌번호 전역변수 선언
	int cash 			= 0; 	// 잔액을 전역변수 선언
	int money           = 0;    // 출금액을 전역변수 선언
	public Bank() {
		/* this.name = name;
		 * this.account = account;
		 * this.cash= cash;
		 */
	}
	public void print(String name, String account, int cash) {
		System.out.println(this);
	}
	/*모든 클래스의 상위 클래스가 Object인데 이 클래스에는 toString메소드가 정의 되어있다.
	 * 이메소드를 자식 클래스가 재정의해서 사용할수 있는데 이를 오버라이딩이라고 한다.
	 * 리턴값이 String인데 이것을 format형식을 지정하여 출력할수 있도록 지원하고 있다.
	 * 메소드이름은 format이다,
	 * %s는 문자열 형식을 지원하는 예약어이다.
	 * %n은 개행처리를 지원한다.
	 * %s가 세번 나왔으므로 파라미터도 3개가 되어야한다.
	 */
	public String toString() {
		return String.format("예금주 : s%, 계좌번호 : %s, 잔액 : %s%n"
				, name
				,account
				,cash);
	}
	//출금
	public void take(int money) {
		//잔액이 인출금액보다 큰가요?
		//잔액이 부족하면 인출이 안되는거죠?
		if(cash>=money) {
			cash = cash - money;
			System.out.println("출금액 :"+money);
			System.out.println("잔액 :"+cash);
		}
		//잔액이 부족해요 ㅠㅠ
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	/***************************************************************************
	 * 입금처리해봐요
	 * @param money
	 ***************************************************************************/
	//입금
	public void deposit(int money) {
		cash += money;
		System.out.println("입금액 :"+money);
		System.out.println("잔액 :"+cash);
		
	}
	
	//toString
	
	//메인메소드
	public static void main(String[] args) {
	}

}
