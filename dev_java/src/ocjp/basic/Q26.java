package ocjp.basic;

public class Q26 {
/*
 alt + shift + a Ű ������ ������ ��������
 */
	public static void main(String[] args) {
		 int i = 1; // i=1
		 int j = i++;  // j=1 , i =2
		 if((i == ++j) | (i++ == j)) { 
			 //(2==2) or (3==2) i=3 j=2 ||�̿����� i=2
		 i += j;  // 5 ������ ����� i=i+j;
		 }
		 System.out.println("i = " + i);
		// || �̸� 4 & && | �϶� i�� 5
	}

}
