package book.chap06;

public class CompanyTest {

	public static void main(String[] args) {
		Company myCompany1 = Company.getInstance(); // Ŭ�����̸����� getInstance() ȣ���Ͽ� ���� ������ ����
		Company myCompany2 = Company.getInstance();
		System.out.println(myCompany1 == myCompany2); //�κ����� ���� �ּ����� Ȯ��
	}
}
