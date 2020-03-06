package ocjp.basic;

public class X {
	public static void modify(String s) {
		
	}
	public static void main(String[] args) {
		//String 타입은 절대로 원본이 바뀌지않는 녀석이다
		String s = new String("Hello");//일반 참조형 타입 선언문
		String s1 = "Hello"; // 원시형타입
		System.out.println(s1+" world!!!");
		//s1=s1+" world!!!";
		//s1+=" world!!!";
		System.out.println(s1);
		if(s==s1) {//주소번지가 같니? s와 s1이 참조형 타입
			System.out.println("주소번지가 같아요");
		}
		else {
			System.out.println("주소번지가 달라요");
		}
		//주소번지가 가리키는 값을 비교함 .equals()
		if(s.equals(s1)) {//주소번지가 가리키는 값이 같은거야?
			System.out.println("주소번지가 같은지 비교함");			
		}
		else {
			System.out.println("주소번지가 가리키는 값이 다르다");
		}
	}
}
