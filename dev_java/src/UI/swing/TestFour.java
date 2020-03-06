package UI.swing;

public class TestFour extends TestThree {
/*4. 3번에서 정의한 클래스를 사용하여 
   아래 요구사항을 만족하도록 프로그래밍을 하여 소스코드와 결과화면 스크린 샷을
 * 제출하시오
   [요구사항]
   가. 은행계좌 클래스를 사용하여 객체를 생성한다
   나. 객체의 멤버(예금주,계좌번호,잔액)를 아래처럼 초기화 하여라
      예금주: 자바맨
      계좌번호: 123-456
      잔액:10000

   다. 15000원을 입금하도록 메소드를 호출하여라
   라. 30000원을 출금하도록 메소드를 호출하여라
 */
	public TestFour(String name, String account, int cash) {
		super(name, account, cash);
		
	}
	@Override
	public String toString() {
		return String.format("예금주: %s, 계좌번호 : %s, 잔액 : %d"
				            ,name
				            ,account
				            ,cash);
	}
	public void take(int money) {
		if(cash >= money) {
			cash = cash - money;
			System.out.println("출금액 : "+money);
			System.out.println("잔액: "+cash);
		}
		else if(cash<money){
			System.out.println("잔액이 부족합니다");
			return;
		}
	}
	public void deposit(int money) {
		cash += money;
		System.out.println(" 입금액 : "+money);
		System.out.println(" 잔액 : "+cash);
	}
	public static void main(String[] args) {
		TestFour tf = new TestFour ("자바맨","123-456",10000);
		tf.deposit(15000);
		tf.take(30000);
	}

}
