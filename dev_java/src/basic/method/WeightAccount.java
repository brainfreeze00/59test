package basic.method;


public class WeightAccount {

	public static void main(String[] args) {
		System.out.println("����� �����Ը� �Է��ϼ���.");
		java.util.Scanner scan = new java.util.Scanner(System.in);
		double d_ew=0; //������ ������ 
		d_ew = scan.nextDouble();
		System.out.println("����� �Է��� ���� "+d_ew);
		//���� �����Ը� ���� ������ �ʿ��ϴ�
		double d_mw=0; // ���� ������
		//17% 
		//d_mw=(d_ew*17)/100.0;
		d_mw=(d_ew*17)/(double)100;
		System.out.println("���� ������ :"+d_mw);
	}

}
