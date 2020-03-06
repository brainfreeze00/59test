package book.chap12;

public class ParentTest {

	public static void main(String[] args) {
		/*자바에서는 생성부의 이름으로 객체가 생성된다.
		 * 따라서 부모클래스타입으로 양쪽의 있는 메소드가 호출되면 아들 타입에 
		 * 정의된 메소드가 호출된다. 부모클래스의 메소드는 은닉메소드가 된다.
		 * 그러나 만일 아들에 동일한(methodA()) 메소드가 존재하지 않으면 생성된 객체는
		 * 아들 객체지만 부모에 있는 메소드가 호출된다.
		 * 
		 */
		Parent2 p = new Son();
		p.methodA();
	}

}
