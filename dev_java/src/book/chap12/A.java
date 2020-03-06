package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class A {
//클래스 A에서 클래스 B에 있는 메소드 호출 해봐
	public static void main(String[] args) {
		
		B b = new B();
		
		Collection<String> col = new ArrayList<>(); //Collection과 List 둘은 구현이 안되어 있기에 같이 인스턴스화 안됨
		List<String> li = new ArrayList<>(); //싱글스레드 안전 - 동기화 구현이 안되어있다  (동기화:서로맞춘다)-속도빠름   상위 인터페이스 = new 하위 인터페이스
		List<String> li2 = new Vector<>();   //멀티스레드안전 - 동기화 구현 한다 - 속도는 느림  단톡방,채팅방,도서관            상위 인터페이스 = new 하위 인터페이스
		ArrayList<String> al = new ArrayList<>();  
		Vector<String> v = new Vector<>();
		// Collection >> List >> ArrayList  
		// Collection >> List >> Vector
		
		b.methodA(col);
		b.methodA(li);
		b.methodA(li2);
		b.methodA(al);
		b.methodA(v);
		
 	}
}
