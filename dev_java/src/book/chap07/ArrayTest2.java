package book.chap07;
/*
 * 문법에러-규칙만지키면됨
 * 런타임에러-실행오류(논리의 오류)
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		int is[][] = new int[2][3];
		for(int i=0;i<is.length;i++) { //2
			for(int j=0;j<is[0].length;j++) { //3 컬럼의 개수
				System.out.println("is["+i+"]["+j+"]"+is[i][j]);
			}
		}
	}

}
