package ocjp.control;
/*
 * 반복문 사용할때 주의할점. 
 * 무한반복을 방지하는 코드를 반드시 작성할것.
 * 서버가 다운될 수 있다.
 * for문 보다는 while문에서 자주 발생
 * while문에 증감연산자가 있는지 반드시 확인할것
 */
public class Q58 {

	public static void main(String[] args) {
		int i = 0;
		//while 문은 조건을 먼저 확인함
		while(i>3) { // 거짓이라 실행은 안됨
			System.out.println("여기 "+i);
		}
		//do while 문은 조건을 나중에 확인함
		//하지만 조건을 나중에 확인하니깐.... 무조건 한번은 실행된다.
		do {
			System.out.println("저기 "+i);
			//i = i+4;
		}while(i>3);  
		//for문은 증감연산자가 있으니 변화하지만 
		//while은 꼭 증감연산자 확인해라 
	}

}
