package book.chap08;

public class MallardDuck extends Duck {
	
	@Override
	public void swimming(String sw) {
		System.out.println(sw+"�ϸ鼭 �߸� ���");
	}
//	@Override
//	public void swimming() {
//		System.out.println("û�տ����� ������ �߱⵵ �ϰ� ����� �����մϴ�.");
//	}
	public void fly(String f) {
		System.out.println("������"+f+"��");
	}
//	public void fly() {
//		System.out.println("���� ���� �־��.");
//	}
	@Override
	public void quack(String qu) {
		System.out.println(qu+"�Ҹ��� ����?");
	}
}
