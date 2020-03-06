package book.chap07;
/*
 * 1차배열, 2차배열 - 초기화하는 방법, 꺼내서 사용하기
 * 배열에 담긴 정보를 꺼낼수 있다.(반복문과 조건문을 활용)
 * 개선된 for문 연습 - 컬렉션 프레임워크 
 * 객체배열 따로 정리하기
 * 
 * 성적처리 방법
 * jumsus[i][j]
 * 변수 i는 row의 수를 의미 - 사람 구분하는 식별자로 사용가능
 * 변수 j는 컬럼의 수를 의미 - 과목을 구분하는 식별자로 사용가능
 * 총점구하기 
 * for문 한개로 가능하다 | 아니다                    //2개이여야한다.
 * 만일 아니다라면 2개일 것이다.
 * 만일 강호동의 총점을 구한다면 i가 고정된상태에서 j가 변해야 한다 | 아니다 j가 고정된 상태에서 i가 변해야한다  -> 판단해보아라 i가 고정
 * 
 * 메소드를 사용할것인가?   
 * 1단계 - main method안에만 코딩한다.
 * 2단계- 메소드로 꺼내보기 : 재사용성과 이식성을 높이는 코드를 작성하기
 * 
 * 총점과 평균 구하기에 배열을 사용할것인가?
 * 총점
 * int korTotal = 0;
 * int engTotal = 0;
 * int mathTotal = 0;
 * 
 * 평균은 계산한 결과를 바로 출력하기
 */
public class SungJuk {
	int jumsus[][] = {   //먼저 점수부터 
			{100,80,90} // 1row - 강호동           j부터 바뀌어야함
			,{60,70,90} // 2row - 유재석
			,{80,70,70} // 3row - 강감찬
			,{90,90,90} // 4row - 김유신
			,{80,80,80} // 5row - 이성계
	};
	String names[] = {"강호동","유재석","강감찬","김유신","이성계"}; // 이름배열 
	String subjects[] = {"국어","영어","수학"}; // 과목배열
	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		System.out.println(" no  kor  eng   math  tot  avg");
		System.out.println("===============================");
		int i=0;
		int j=0;
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		for(i=0 ; i<sj.jumsus.length ; i++) {   // i의 범위지정  i값이 변함 j값은 고정 즉 row가 변함
			int sum = 0; // 
			double avg = 0;
			korTotal = korTotal+sj.jumsus[i][0];   //j를 고정
			engTotal = engTotal+sj.jumsus[i][1];
			mathTotal = mathTotal+sj.jumsus[i][2];
			System.out.print(" "+(i+1)+" ");
			for(j=0 ; j<sj.jumsus[i].length; j++) { // j의 범위지정 i값은 고정 j값은 변함 즉 그 row에 있는 각방을 추적
				sum = sum+sj.jumsus[i][j]; // 점수를 더해야함
				avg =(double)sum/sj.jumsus[i].length; // int 정수타입이라 double 실수타입으로 형변환 
				System.out.print("   "+ sj.jumsus[i][j] +"   ");  
			}//end of inner 과목수가 끝나는 위치
			System.out.println("	"+sum+"    "+avg);
		}// end of outer
		System.out.println("===============================");
		
		System.out.println("총점  "+korTotal+"  "+engTotal+"  "+mathTotal);
		
		//System.out.println("o i:"+i+",j:"+j); // 3이니까 4번째방을 말하는 것 그러나 4번째방은 없다.
			//for문에서 증감연산자는 반복문이 진행되는 동안 계속 증감이 일어난다
			//for문에 있는 조건문에서 비교할 때  
				//System.out.println("i i:"+i+",j:"+j);
				
		 
	}

}
