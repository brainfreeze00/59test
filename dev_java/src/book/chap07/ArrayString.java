package book.chap07;

public class ArrayString {

	public static void main(String[] args) {
		String nameList[] = {"������","������","������","������"};
		String nameList2[][] = {
				{"������","������","������","������"},
				{"25","26","27","28"}
		};
		String nameList3[][]= {
				{"������","������","������","������"},
				{"25","26","27","28"},// ��̴� �ο�3��°�� �����Ǿ��⿡ �÷��� �ٲ��
				{"�ٵ�","����","�籸","����Ŭ"}
		};
		for(int i=0; i<nameList3[2].length;i++) {
			System.out.print(nameList3[2][i]+" ");
		}
		System.out.println("\n======================================================");
		// nameList3�� �迭�� �̸��̰� ���⿡ length�̸� �ο��� ���̴�.
		for(int i=0; i<nameList3.length;i++) {
			for(int j=0; j<nameList3[i].length;j++) {
				if(i==2) { // ģ������ ��̴�?
					System.out.print(nameList3[i][j]+" ");
				}
			} 
		}
		//��������� 4������ ����ϰ� �ʹ�. for������ �غ���
	}

}
