package book.chap07;

public class SungJuk2 {
	int jumsus[][] = {   //1
			{100,80,90} 
			,{60,70,90} 
			,{80,70,70} 
			,{90,90,90} 
			,{80,80,80} 
	};//1
	String names[] = {"강호동","유재석","강감찬","김유신","이성계"};//2  
	String subjects[] = {"국어","영어","수학"}; //2
	public static void main(String[] args) {
		SungJuk2 sj = new SungJuk2();//3
		System.out.println(" no  kor  eng   math  tot  avg");//4
		System.out.println("===============================");//5
		int i=0;//6
		int j=0;//7
		int korTotal = 0; // 국어 총합 초기화
		int engTotal = 0; // 영어 총합 초기화
		int mathTotal = 0;// 수학 총합 초기화
		for(i=0 ; i<sj.jumsus.length ; i++) {//8   
			int sum = 0;   // 
			double avg = 0;
			korTotal = korTotal+sj.jumsus[i][0];  
			engTotal = engTotal+sj.jumsus[i][1];
			mathTotal = mathTotal+sj.jumsus[i][2];
			System.out.print(" "+(i+1)+" ");
			for(j=0 ; j<sj.jumsus[i].length; j++) {//9
				sum = sum+sj.jumsus[i][j]; //인물점수 총합
				avg =(double)sum/sj.jumsus[i].length;  //인물점수 평균 
				System.out.print("   "+ sj.jumsus[i][j] +"   ");  
			}//9
			System.out.println("	"+sum+"    "+avg);
		}//8
		System.out.println("===============================");
		
		System.out.println("총점  "+korTotal+"  "+engTotal+"  "+mathTotal);
	}

}
