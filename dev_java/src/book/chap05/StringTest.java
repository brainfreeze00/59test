package book.chap05;
/*
 * 쿼리문을 작성할때 String을 사용하면 안되는  이유에 대해 말할수있다.
 * String은 원본이 절대로 바뀌지 않는다.
 * 따라서 변경하려면 반드시 새로운 변수에 그 값을 다시 담아야한다.
 * 이렇게  되면 같은 이름의 변수가 n번 만큼 생성되므로 비효율적이다.
 * 따라서 이럴때는 StringBuider를 사용하자
 * 
 */
public class StringTest {
	
//주소번지를 비교한다.
//주소번지가 가리키는 값을 비교한다.	
	public static void main(String[] args) {
		String s1 = "apple"; // s1의 값 -오답 ==은 주소번지를 가리키는것
		String s2 = "apple"; // s2의 값 -오답 ==은 주소번지를 가리키는것
		String s3 = new String("apple"); // s3이 담긴 주소
		String s4 = new String("apple"); // s4가 담긴 주소 
		System.out.println(s1==s2);//true, false -> true  값-오답  정답 : s2와 s1은 주소번지가 같다 왜 같은가? 
		//주소번지가 같니?
		System.out.println(s3==s4);//true, false -> false 주소번지
		//그 주소번지가 가리키는 값이 같니? = 오브젝트와 동일한 문자를 나타내는 경우 결과가  참
		System.out.println(s3.equals(s4));//true, false ->
		s1.replace('p', '1'); 
		//s1 = s1.replace('p','1'); //15번s1 24번s1  두개가 만들어져요, 그러니까 같은 타입의 변수 두 개를 관리한다
		System.out.println(s1);//a11le 로 나올까?
		StringBuilder sb = new StringBuilder("hello");
		sb.append("world");//원본에 붙여쓰기를 한경우에 해당되므로 메모리사용을 절약가능
		System.out.println(sb.toString());
	}

}
