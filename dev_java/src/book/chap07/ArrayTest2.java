package book.chap07;
/*
 * ��������-��Ģ����Ű���
 * ��Ÿ�ӿ���-�������(���� ����)
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		int is[][] = new int[2][3];
		for(int i=0;i<is.length;i++) { //2
			for(int j=0;j<is[0].length;j++) { //3 �÷��� ����
				System.out.println("is["+i+"]["+j+"]"+is[i][j]);
			}
		}
	}

}
