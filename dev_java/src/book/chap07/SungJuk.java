package book.chap07;
/*
 * 1���迭, 2���迭 - �ʱ�ȭ�ϴ� ���, ������ ����ϱ�
 * �迭�� ��� ������ ������ �ִ�.(�ݺ����� ���ǹ��� Ȱ��)
 * ������ for�� ���� - �÷��� �����ӿ�ũ 
 * ��ü�迭 ���� �����ϱ�
 * 
 * ����ó�� ���
 * jumsus[i][j]
 * ���� i�� row�� ���� �ǹ� - ��� �����ϴ� �ĺ��ڷ� ��밡��
 * ���� j�� �÷��� ���� �ǹ� - ������ �����ϴ� �ĺ��ڷ� ��밡��
 * �������ϱ� 
 * for�� �Ѱ��� �����ϴ� | �ƴϴ�                    //2���̿����Ѵ�.
 * ���� �ƴϴٶ�� 2���� ���̴�.
 * ���� ��ȣ���� ������ ���Ѵٸ� i�� �����Ȼ��¿��� j�� ���ؾ� �Ѵ� | �ƴϴ� j�� ������ ���¿��� i�� ���ؾ��Ѵ�  -> �Ǵ��غ��ƶ� i�� ����
 * 
 * �޼ҵ带 ����Ұ��ΰ�?   
 * 1�ܰ� - main method�ȿ��� �ڵ��Ѵ�.
 * 2�ܰ�- �޼ҵ�� �������� : ���뼺�� �̽ļ��� ���̴� �ڵ带 �ۼ��ϱ�
 * 
 * ������ ��� ���ϱ⿡ �迭�� ����Ұ��ΰ�?
 * ����
 * int korTotal = 0;
 * int engTotal = 0;
 * int mathTotal = 0;
 * 
 * ����� ����� ����� �ٷ� ����ϱ�
 */
public class SungJuk {
	int jumsus[][] = {   //���� �������� 
			{100,80,90} // 1row - ��ȣ��           j���� �ٲ�����
			,{60,70,90} // 2row - ���缮
			,{80,70,70} // 3row - ������
			,{90,90,90} // 4row - ������
			,{80,80,80} // 5row - �̼���
	};
	String names[] = {"��ȣ��","���缮","������","������","�̼���"}; // �̸��迭 
	String subjects[] = {"����","����","����"}; // ����迭
	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		System.out.println(" no  kor  eng   math  tot  avg");
		System.out.println("===============================");
		int i=0;
		int j=0;
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		for(i=0 ; i<sj.jumsus.length ; i++) {   // i�� ��������  i���� ���� j���� ���� �� row�� ����
			int sum = 0; // 
			double avg = 0;
			korTotal = korTotal+sj.jumsus[i][0];   //j�� ����
			engTotal = engTotal+sj.jumsus[i][1];
			mathTotal = mathTotal+sj.jumsus[i][2];
			System.out.print(" "+(i+1)+" ");
			for(j=0 ; j<sj.jumsus[i].length; j++) { // j�� �������� i���� ���� j���� ���� �� �� row�� �ִ� ������ ����
				sum = sum+sj.jumsus[i][j]; // ������ ���ؾ���
				avg =(double)sum/sj.jumsus[i].length; // int ����Ÿ���̶� double �Ǽ�Ÿ������ ����ȯ 
				System.out.print("   "+ sj.jumsus[i][j] +"   ");  
			}//end of inner ������� ������ ��ġ
			System.out.println("	"+sum+"    "+avg);
		}// end of outer
		System.out.println("===============================");
		
		System.out.println("����  "+korTotal+"  "+engTotal+"  "+mathTotal);
		
		//System.out.println("o i:"+i+",j:"+j); // 3�̴ϱ� 4��°���� ���ϴ� �� �׷��� 4��°���� ����.
			//for������ ���������ڴ� �ݺ����� ����Ǵ� ���� ��� ������ �Ͼ��
			//for���� �ִ� ���ǹ����� ���� ��  
				//System.out.println("i i:"+i+",j:"+j);
				
		 
	}

}
