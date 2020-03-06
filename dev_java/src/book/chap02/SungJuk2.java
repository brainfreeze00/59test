package book.chap02;

public class SungJuk2 {

	int hap(int num1, int num2) {
		int result = 0;
		result = num1 + num2;
		return result;
	}
	double avg(int result) {
		int avg;
		return result/2;
	}
	public static void main(String[] args) {
	
		SungJuk2 sj = new SungJuk2();
		int num1 = 73;
		int num2 = 85;
		int result = sj.hap(num1, num2);
		System.out.println("รัวี="+result);
		
		double avg = sj.avg(result);
		
		
	}

}
