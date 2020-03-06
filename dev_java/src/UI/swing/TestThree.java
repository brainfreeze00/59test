package UI.swing;

public class TestThree {
/*3. 다음 요구사항을 만족하는 은행 계좌 클래스를 정의하여 소스코드와 결과화면 
  스크린 샷을 제출하시오
   [요구사항]
   가. 속성으로 예금주,계좌번호,잔액을 갖는다.
      예금주는 String,계좌번호 String,잔액은 int로 정의하여라
   나. 메소드로 인출 및 입금 메소드를 갖는다.
       인출 메소드는 인자로 인출할 금액을 받고 잔액이 부족시에는
       “잔액이 부족합니다”라는 메시지를 잔액이 충분할때는 인출한 금액을 출력하는 
       메소드이다
       입금 메소드는 인자로 입금할 금액을 받고 입금액을 잔액에 더하고
       입금한 금액을 출력하는 메소드이다
   다. toString()메소드를 오버라이딩하여 계좌정보 즉 얘금주,계좌번호,잔액을
      출력하는 메소드를 정의하여라
      예]예금주:자바맨,계좌번호:123-456,잔액:1000원

 * 위치 선정
 * 1 클래스
 * 2 변수
 * 3 생성자
 * 4 메소드
 *
 *변수선언 - 고유명사 - 그이름으로 클래스가 연상되는 그런아이들 -전역변수
 * 디폴트생성자
 * 메소드 선언 - 리턴타입과 파라미터
 * DB연동하기 - SELECT , INSERT, UPDATE, DELETE 무조건 먼저 작성하기
 * 쿼리문 안에는 ?가 있다 - 사용자가 입력하는 값을 넣어줄 곳
 * 처리결과를 사용자에게 응답해야한다. - 리턴타입, 리턴값
 * 
 * 
 */
	//전역변수
	String name 	= null; //예금주
	String account 	= null; //계좌
	int cash 		= 0;	//잔액
	
	//디폴트 생성자
	public TestThree() {
		
	}
	
	//생성자 : 초기화
	public TestThree(String name, String account, int cash) { //변수가 3개를 파라미터 이용 
		this.name = name;
		this.account = account;
		this.cash = cash;
	}
	
	// 메소드
	public void print() { 
		System.out.println(this);
	}
	/* toString 
	 * 원래는 부모가 가진 메소드 이므로 별도로 정의하지 않아도 호출할 수 있다.
	 * 그러나 추가로 작성하고 싶은 내용이 있다면 언제든지 재정의 할 수 있다.
	 * 재정의 할 때 반환값을 문자열로 바꾸었으므로 주소번지 대신
	 * 나는 Test3클래스 입니다. 를 출력하게 되는 것이다.
	 * 설계한 클래스의 기본정보를 출력할때 많이 활용된다.
	 * 또한 UI/UX 화면단을 구현해주는 외부 클래스에도 적용할 수 있다.
	 */
	
	@Override
	public String toString() { // 메소드 오버라이드  : 아빠가 가진 기능을 재정의하였다.
		return String.format("예금주: %s, 계좌번호 : %s, 잔액 : %d"
				            ,name
				            ,account
				            ,cash);
		/*순서
		 * return "예금주는 김유신이고 , 계좌번호는 123-456-789 잔액은 30000원 입니다 ";
		 * 변수처리1
		 * String accountINFO = "예금주는 김유신이고 , 계좌번호는 123-456-789 잔액은 30000원 입니다";
		 * return accountINFO;
		 * 변수처리2
		 * String accountINFO = "예금주는"+name+"이고 , 계좌번호는"+account+"잔액은"+cash+"입니다";
		 * return accountINFO;
		 */
	}
	
	//인출메소드
	public void take(int money) {//얼마를 가져갈거니? - 처리는 파라미터 int money    
		if(cash >= money) { 
			cash = cash - money; //출금한후 잔액 
			System.out.println("출금액 : "+money);
			System.out.println("잔액: "+cash);
		}
		else if(cash<money){
			System.out.println("잔액이 부족합니다");
			return;    // if문끝에는 return을 꼭 써라
		}
	}
	
	//입금메소드
	public void deposit(int money) {
		cash += money; // 입금한후 잔액
		System.out.println(" 입금액 : "+money);
		System.out.println(" 잔액 : "+cash);
	}
	
	//메인메소드
	public static void main(String[] args) {
		TestThree tt = new TestThree ("자바맨","123-456",10000);
		tt.deposit(15000);
		tt.take(20000);
		tt.print();

	}

}
