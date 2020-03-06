package UI.swing;

public class TestTwo {
/*2. 1부터 1000까지 숫자중 2의 배수 이거나 5의 배수인 숫자의 합을 구하는 
   소스코드와 결과화면 스크린 샷을 제출하시오
    [요구사항] 
   가. 단, 2와 5의 공배수인 경우 제외
   나, while문 버전과  for문 버전으로 두가지 소스코드를 작성하시오
   
   while문 무한 루프 방지 코드   break, continue 쓰는 습관
   
 * 
 */
	public void whileM() {
		int num1=1, sum1=0;
		int num2=1, sum2=0;

		 while(num1<=1000) {
		  if(num1%2==0 || num1%5==0)  
		  {
		  sum1=sum1+num1;
		  }
		  num1++;
		 }

		 while(num2<=1000) {
		  if(num2%2==0 && num2%5==0)   
		  {
		  sum2=sum2+num2;
		  }
		  num2++;
		 }
		 System.out.println("while문 2의 배수 이거나 5의 배수인 숫자의 합 - 2와 5의 공배수의 합  : "+(sum1-sum2));
	}
	public void forM() {
		int sum4 = 0;
		  for(int j=1; j<=1000; j++){

		   if((j % 2 == 0) || (j % 5 == 0)){

		    sum4 += j;

		   }

		  }
		
		  int sum3=0;
		  for(int i=1; i<=1000; i++){

		   if((i % 2 == 0) && (i % 5 == 0)){

		    sum3 += i;

		   }
		  }
		  System.out.println("for문 2의 배수 이거나 5의 배수인 숫자의 합 - 2와 5의 공배수의 합  : "+(sum4-sum3));
	}
	
	public static void main(String[] args) {
		TestTwo tt = new TestTwo();
		tt.whileM();
		tt.forM();
		
//		int dap1=0, dap2 = 0;
//		int i=0;
//		for(i=1;i<=1000;i++) {
//			if(i%2==0 && i%5==0) {
//				//제외
//				continue; //이번산 재끼고 다음산 와라
//			}else if(i%2==0 || i%5==0) {
//				dap1 = dap1+i;
//			}
//		}/////////////end of for
//		
//		i=1; /////// 초기화  재활용
//		
//		while(i<=1000) {
//			if(i%2==0 && i%5==0) {
//				//제외
//				continue; //이번산 재끼고 다음산 와라
//			}else if(i%2==0 || i%5==0) {
//				dap2 = dap2+i;
//			}
//			i++;////////// 무한루프 방지코드 
//		}/////////////////////end of while
//		System.out.println(dap1);
//		System.out.println(dap2);
	}//////////////////////////end of main
	/*쌤 정답
	 * 메인메소드 안
	 * int dap1 , dap2 = 0;
	 * for() {
	 * if() {
	 * 
	 * }
	 * 
	 */
}
