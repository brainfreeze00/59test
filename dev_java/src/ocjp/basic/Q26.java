package ocjp.basic;

public class Q26 {
/*
 alt + shift + a 키 누르면 범위를 지정가능
 */
	public static void main(String[] args) {
		 int i = 1; // i=1
		 int j = i++;  // j=1 , i =2
		 if((i == ++j) | (i++ == j)) { 
			 //(2==2) or (3==2) i=3 j=2 ||이였으면 i=2
		 i += j;  // 5 무조건 실행됨 i=i+j;
		 }
		 System.out.println("i = " + i);
		// || 이면 4 & && | 일때 i는 5
	}

}
