package book.chap05;

public class PersonTest {

	public static void main(String[] args) {
		//�Ķ���Ͱ� �ִ� �����ڰ� �Ѱ��� ������ �ڵ����� �������� �ʾƿ�
		//�����ڰ� �Ѱ��� ������ JVM�� ����Ʈ �����ڴ� ������������
		//�Ѱ��� ������ �������� �ʾƿ�.
		Person p = new Person("��ȣ��");
		//p.name = "�̼���"; 
		p.height = 180.f;
		p.weight = 80.5f;
		System.out.println(p.name+", "+p.height+", "+p.weight); // �̼��� �ֳĸ� ���������
		p.setName("���缮");
		p.setHeight(175.2f);
		p.setWeight(75.2f);
		System.out.println(p.name+", "+p.height+", "+p.weight); // �������� ������ �Ҽ��ִ�.
		
	}

}
