package book.chap02;

public class SungJuk {
	/*
	 내안에 있는 메소드라 하더라도 메소드 선언시 static이 없으면 main메소드에서 
	 호출할수 없다. 
	 총점을 구해주는 메소드가 있다. 이름은 hap임.
	 파라미터가 있다 | 없다 
	 
	 함수정의하기
	 함수 반환형<int, double, String....> 함수이름  (매개변수<int num1>, <int num2>) {
	 int result; 
	 result = int1 + int2;
	 예약어 <return> result;
	 }
	 */
	int hap(int kor, int eng) {
		int tot = 0;
		tot = kor+eng; // 140
		return tot;
		}//////end hap
	
	double avg(int tot, int subject) { 
		int avg;
		return tot/subject;
	
		/*
	 29-32-33(국어)-34(영어)-35-10(메소드가 거기 있어 80점과 60점을 가지고감 값이 복사됨)-11-12-13-14(hap끝)
	 36[140]-38-18[140복사됨]-16-17-39
	 */
	}//end of avg
	//평균은 소수점이 나올수 있다.
	//리턴값은 double(실수형)으로 선언한다.
	//메소드 선언하기
	//반환타입 메소드이름(파라미터1 , 파라미터2)
	public static void main(String[] args) {
		//insert here - hap메소드에서 합을 구한 값을 여기서 사용하고 싶어요
		//어떡하지?
		SungJuk sj = new SungJuk();
		int kor = 80;
		int eng = 65;
		int tot = sj.hap(kor, eng);
		int subject = 0; // 여기는 과목수를 담을 거야
		subject = 2;
		System.out.println("성적총합 = "+ tot);
		//위에서 계산한 결과인 tot변수를 avg메소드에서 사용하고 싶다.
		double avg = sj.avg(tot,subject);
		System.out.println("성적평균 = "+ avg); // 
		
	}

}
