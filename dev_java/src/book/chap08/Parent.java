package book.chap08;
//Child������ �Ķ���� �ΰ� ¥�� �޼ҵ�� �������������� 
public class Parent {
	public String book = null;
	public Parent() {
		System.out.println("Parent ����Ʈ ������ ȣ�� ����");
	}
	public void bookRead() { 
		System.out.println("1�޿� 2�Ǿ� å�� �н��ϴ�.");
	}
	//�޼ҵ� �����ε��̶�� �Ѵ�.
	//�ݵ�� �Ķ������ Ÿ�԰� ������ �ٸ��� ���� �̸��� �޼ҵ带 �ߺ� �����Ҽ� �ִ�.
	public void bookRead(String book1 , String book2) {
		System.out.println("�̴޿��� "+book1+"�� "+book2+"�� �н��ϴ�.");
	}
}
