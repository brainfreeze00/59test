package UI.swing;

public class TestTwo {
/*2. 1���� 1000���� ������ 2�� ��� �̰ų� 5�� ����� ������ ���� ���ϴ� 
   �ҽ��ڵ�� ���ȭ�� ��ũ�� ���� �����Ͻÿ�
    [�䱸����] 
   ��. ��, 2�� 5�� ������� ��� ����
   ��, while�� ������  for�� �������� �ΰ��� �ҽ��ڵ带 �ۼ��Ͻÿ�
   
   while�� ���� ���� ���� �ڵ�   break, continue ���� ����
   
 * 
 */
	public void whileM() {
		int num1=1, sum1=0;
		int num2=1, sum2=0;

		 while(num1<=1000) {
		  if(num1%2==0 || num1%5==0)  
		  {
		  sum1=sum1+num1;
		  }
		  num1++;
		 }

		 while(num2<=1000) {
		  if(num2%2==0 && num2%5==0)   
		  {
		  sum2=sum2+num2;
		  }
		  num2++;
		 }
		 System.out.println("while�� 2�� ��� �̰ų� 5�� ����� ������ �� - 2�� 5�� ������� ��  : "+(sum1-sum2));
	}
	public void forM() {
		int sum4 = 0;
		  for(int j=1; j<=1000; j++){

		   if((j % 2 == 0) || (j % 5 == 0)){

		    sum4 += j;

		   }

		  }
		
		  int sum3=0;
		  for(int i=1; i<=1000; i++){

		   if((i % 2 == 0) && (i % 5 == 0)){

		    sum3 += i;

		   }
		  }
		  System.out.println("for�� 2�� ��� �̰ų� 5�� ����� ������ �� - 2�� 5�� ������� ��  : "+(sum4-sum3));
	}
	
	public static void main(String[] args) {
		TestTwo tt = new TestTwo();
		tt.whileM();
		tt.forM();
		
//		int dap1=0, dap2 = 0;
//		int i=0;
//		for(i=1;i<=1000;i++) {
//			if(i%2==0 && i%5==0) {
//				//����
//				continue; //�̹��� �糢�� ������ �Ͷ�
//			}else if(i%2==0 || i%5==0) {
//				dap1 = dap1+i;
//			}
//		}/////////////end of for
//		
//		i=1; /////// �ʱ�ȭ  ��Ȱ��
//		
//		while(i<=1000) {
//			if(i%2==0 && i%5==0) {
//				//����
//				continue; //�̹��� �糢�� ������ �Ͷ�
//			}else if(i%2==0 || i%5==0) {
//				dap2 = dap2+i;
//			}
//			i++;////////// ���ѷ��� �����ڵ� 
//		}/////////////////////end of while
//		System.out.println(dap1);
//		System.out.println(dap2);
	}//////////////////////////end of main
	/*�� ����
	 * ���θ޼ҵ� ��
	 * int dap1 , dap2 = 0;
	 * for() {
	 * if() {
	 * 
	 * }
	 * 
	 */
}
