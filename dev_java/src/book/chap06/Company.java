package book.chap06;
	
public class Company {
	private static Company instance = new Company(); //�����ϰ� ������ �ν��Ͻ�
	private Company() {
	
	}
	public static Company getInstance() { //�ν��Ͻ��� �ܺο��� �����Ҽ��ִ� public get()�޼��� ����
		if(instance == null) {
			instance = new Company();
		}
		return instance; //�����ϰ� ������ �ν��Ͻ� ��ȯ
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
