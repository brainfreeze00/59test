package method.zipcode;

public class Diamond {

	public static void main(String[] args) {
		//다이아몬드
		int a = 0;
		for(int i=1;i<=9;i++) {
			if(i<=5)
				a++;
			else 
				a--;
			for(int j=1;j<=5-a;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=2*a-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("");
		
		//직사각형
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
		
		//왼쪽반 삼각형
		for(int i=1;i<5;i++) {
			for(int j=4;j>0;j--) {
				if(i<j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		
		for(int i=5;i>1;i--) {
			for(int j=0;j<6;j++) {
				if(i>j) {
				System.out.print("");
				}
				else {
			System.out.print("*");
				}
			}
		System.out.println("");
		}
		System.out.println("");
	
		for(int i=0;i<4;i++){
			for(int j=0;j<3-i;j++) {
			System.out.print(" ");
		}
		for(int j=0;j<2*i+1;j++) {
			System.out.print("*");
		}
		System.out.println("");
		}
	}
	
}
