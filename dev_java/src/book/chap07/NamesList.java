package book.chap07;

public class NamesList {

	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		//for(배열안에 들어있는 타입 String name:배열의 주소번지 sj.names) {
		for(String name:sj.names) {
			System.out.println(name);
		}
		//여기서 국어총점을 출력해보자
		//주소번지.변수이름은 전역변수만 할 수 있다 | 아니다 지역변수도 가능하다 -> 맞춰봐랑
		//int k_tot = sj.korTotal;
		System.out.println();
	}

}
