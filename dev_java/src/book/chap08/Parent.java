package book.chap08;
//Child에서는 파라미터 두개 짜리 메소드는 재정의하지않음 
public class Parent {
	public String book = null;
	public Parent() {
		System.out.println("Parent 디폴트 생성자 호출 성공");
	}
	public void bookRead() { 
		System.out.println("1달에 2권씩 책을 읽습니다.");
	}
	//메소드 오버로딩이라고 한다.
	//반드시 파라미터의 타입과 개수가 다르면 같은 이름의 메소드를 중복 선언할수 있다.
	public void bookRead(String book1 , String book2) {
		System.out.println("이달에는 "+book1+"과 "+book2+"를 읽습니다.");
	}
}
