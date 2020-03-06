package basic_inout;

import java.util.Scanner;

public class ScannerTest {

	int i = 0;
	int result;
	public int doIt() {
		for(i=0; i<5 ; i++) {
			result += i;
		} result++;
		return result;
	}
	
	public static void main(String[] args) {
		ScannerTest st = new ScannerTest();
		st.doIt();
		System.out.println(st.doIt());
		Scanner scan = new Scanner(System.in);
		String input = null;  // 
		while(true) {
			input = scan.nextLine();  // 
			System.out.println("입력된 문자열 : "+input); 
			if(input.equals("q")) {   // 끝내기 
				break;				
			}
		}
		System.out.println("종료");
	} 

}
