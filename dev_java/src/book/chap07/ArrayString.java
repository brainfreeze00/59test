package book.chap07;

public class ArrayString {

	public static void main(String[] args) {
		String nameList[] = {"김혜인","전진완","이정훈","이진아"};
		String nameList2[][] = {
				{"김혜인","전진완","이정훈","이진아"},
				{"25","26","27","28"}
		};
		String nameList3[][]= {
				{"김혜인","전진완","이정훈","이진아"},
				{"25","26","27","28"},// 취미는 로우3번째에 고정되었기에 컬럼을 바꿔라
				{"바둑","수영","당구","싸이클"}
		};
		for(int i=0; i<nameList3[2].length;i++) {
			System.out.print(nameList3[2][i]+" ");
		}
		System.out.println("\n======================================================");
		// nameList3은 배열의 이름이고 여기에 length이면 로우의 수이다.
		for(int i=0; i<nameList3.length;i++) {
			for(int j=0; j<nameList3[i].length;j++) {
				if(i==2) { // 친구들의 취미니?
					System.out.print(nameList3[i][j]+" ");
				}
			} 
		}
		//취미정보만 4가지를 출력하고 싶다. for문으로 해봐라
	}

}
