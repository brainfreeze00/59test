package book.chap08;

public class Child extends Parent{//extends ����Ŭ���� 
	//private String book = null; - ��ӹ޾����Ƿ�  �ʿ����
	public String car = null;
	public Child() {
		System.out.println("Child ����Ʈ ������ ȣ�� ����");
	}
	//�޼ҵ� �������̵��� �θ��� �޼ҵ带 �������ϴ� ���̴�.
	//����δ� �ݵ�� ��ġ�ؾ��Ѵ�.(����Ÿ�԰� �Ķ����)
	@Override 
	public void bookRead() { 
		System.out.println("1�޿� 3�Ǿ� å�� �н��ϴ�.");
	}
	//���� �������̵尡 �ƴմϴ�.-�ֳ��ϸ� �θ𿡰� ���� �޼ҵ��̴ϱ�
	public void carDrive() {
		System.out.println("���־ƿ﷿���� ������ ���ϴ�.");
	}
}
