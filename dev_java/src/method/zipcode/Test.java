package method.zipcode;

public class Test {
	//�޼ҵ带 ���ؼ� �ν��Ͻ�ȭ�� �ϴ� ������ ����?
	//�޼ҵ带 ����ؼ� ��ü ������ �޴� ��� ������ �� �� �� �ֳ�?
	static Test t2 = null; // ����
	public static Test getInstance() { //�޼ҵ带 ���ؼ� ��ü�� ��ȯ�Ҽ��ִ�. , �̹������̰� �ֱ⶧����..
		if(t2==null) {
			t2 = new Test(); // null���� üũ���ϰ� ��ü�� �����Ҽ��ִ�.
		}
		return t2;
	}
	String setName() {
		return "�̼���";
	}
	public static void main(String[] args) {
		Test t = getInstance();
		System.out.println(t); //�޼ҵ带 �̿��ؼ� �ּҹ����� �������ִ�. 
		Test t1 = new Test(); // ���ο��� ��ü ������ �޼ҵ忡�� ��ü�����̶� ���� �ٸ��� ������
		System.out.println(t1);  //�ٸ��� ���� : ǳ�� �� ¥���� �� ���
		//insert here �̼��� ����غ���
		//�̷� ��� ������ �ִ� ��ü�� ����Ͽ� �޼ҵ尡 ȣ���
		//�� ���ʿ��� ��ü�� �� �������� �ʾ���.
		System.out.println(t.setName());
		//�̷��� �� ��� ���ο� ��ü�� �� ��������� �޼ҵ尡 ȣ���
		//�ּҹ����� �����Ƿ� �ٸ� �޼ҵ带 ȣ���Ҷ��� ������ �����Ҽ�����.
		System.out.println(new Test().setName());//Ŭ���� ��ü�� �����ϴ� ���ÿ� setName�޼ҵ带 ȣ��
		//�޼ҵ带 ���ؼ� ��ü�� �����ϹǷ� null�� ��츸 ���� �����ϰ�
		//������ �����ǰ� �ִٸ� ���� ������������
		System.out.println(Test.getInstance().setName());//Ŭ����.getInstance().setName()
	}
}
