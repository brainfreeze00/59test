package basic.method;

import java.util.Scanner;

public class WeightAccount2 {
	double d_ew = 0.0;
	double d_mw = 0.0;	
	double moon(double d_ew) {
		d_mw=(d_ew*17)/(double)100;
		return d_mw;
	}
	
	public static void main(String[] args) {
		WeightAccount2 wa2 = new WeightAccount2();
		System.out.println("당신의 몸무게를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		wa2.d_ew = scan.nextDouble();
		wa2.d_mw = wa2.moon(wa2.d_ew);
		System.out.println("당신이 입력한 값은 "+wa2.d_ew);
		System.out.println("달의 몸무게 :"+wa2.d_mw);
	}

}
