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
			System.out.println("�Էµ� ���ڿ� : "+input); 
			if(input.equals("q")) {   // ������ 
				break;				
			}
		}
		System.out.println("����");
	} 

}
