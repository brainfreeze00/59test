package book.chap07;

import java.util.ArrayList;

class Book1{
	
	public String b_title = null;
	public String b_author = null;
}

public class BookTest {

	public static void main(String[] args) {
		//ArrayList는 읽기 쓰기(저장)를 위해 존재한다
		//다이아몬드 연산자를 사용하여 제네릭을 표현한다.
		//제네릭 안에는 클래스 설계가능함.
		ArrayList<Book1> library	= new ArrayList<Book1>(); // 어레이리스트<Book1>를 변수 library에 인스턴스화 
		Book1 b1 = new Book1(); // Book1의 선언과 초기화 
		b1.b_title = "태백산맥"; // b1의  b_title에 "태백산맥" String타입 값을 대입
		b1.b_author = "조정래"; // b1의  b_author에 "조정래" String타입 값을 대입
		library.add(b1);
		String title = library.get(0).b_title;
		String author = library.get(0).b_author;
		System.out.println("책제목 : "+title);
		System.out.println("책저자 : "+author);
	}

}
