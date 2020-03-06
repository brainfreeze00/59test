package ocjp.basic;

public class ArrayTest1 {
	static void methodA(int is[]) {
		System.out.println("is:"+is); //main is
		//파라미터로 넘어온 is배열의 원본에 세번째 방에있는 값을 0에서 10으로 오버라이트(씌워진다)
		is[2] = 10;
	}
	public static void main(String[] args) {
		//배열 선언과 생성하기 - 방이 세개 만들어짐.
		//변수 is는 배열타입이고 배열의 변수명이다.
		int is[] = new int[3];//is[0]=0, is[1]=0, is[2]=0
		//배열의 주소번지 출력해보기
		System.out.println("main is : "+is); //메인is와 is의 주소번지가 왜같은지?
		//methodA(is)호출할때 is배열의 주소번지를 메소드의 파라미터로 넘겨줌.
		//is의 주소번지는  원본을 빌리는것 
		methodA(is); // 이 메소드에서 is[2]방에 0값 대신 10으로 재정의함.
		//for(초기화; 조건식; 증감연산자)
		//for(int x=0 ; x<3 ; ++x) {먼저 대입하고 적음 고로 영향이 없다
		for(int x=0 ; x<3 ; x++) {
			System.out.println("is["+x+"]"+is[x]);
		}
		System.out.println("==============");
		//개선된 for문 -배열에 있는 모든 정보를 다 출력할때
		for(int a:is) {
			System.out.println(a);
		}
	}

}
