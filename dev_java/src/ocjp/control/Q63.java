package ocjp.control;

public class Q63 {

	public static void main(String[] args) {
		int i;  // 선언을 for문에서 벗어나면 오류 방지
		for (i=0 ; i<= 10 ; i++){  //
			int j = 10; 
			if( i>6) break;      //i=7이면 탈출
		}
		//요기로 탈출
			System.out.println(i);  //오류
			int j = 5;
			System.out.println(j); //j는 못빠져나와서 출력 x
	}
}