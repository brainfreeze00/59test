package book.chap08;

public class ChildSmulation2 {
//상속관계를 이용하면 재사용성이 높아지므로 코딩량이 줄어든다.
//코딩량이 줄어야 오타발생도 줄어들것이다.
//업무의 내용이 변경된다 하더라도 가능한 코드를 적게 수정하도록 클래스 설계를 하여야한다.
	public static void main(String[] args) {
		int i = 5;
		double d = i;
		Parent p = new Parent();
		Child c = new Child();
		//오른쪽 타입이 왼쪽 타입보다 상위클래스가 올수 없다.
		//항상 하위클래스만 가능하다.
		p = c; // p = new Child(); // O  자식은 부모의 기능을 사용이 가능하므로 패스?
		//insert here 만일 p로 bookRead메소드르 호출 하였다면 어떤 클래스의 메소드가 호출되었을까?
		//12번 라인에서 원래 Parent 객체를 가리켰으나 Child 객체로 변경 되었다.
		p.bookRead();
		//c = p; // c = new Parent(); X  부모는 자식만의 기능을 사용 못하므로 에러? 
	}

}
