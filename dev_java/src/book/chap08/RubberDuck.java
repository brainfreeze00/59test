package book.chap08;

public class RubberDuck extends Duck{
	
	@Override
	public void swimming(String sw) {
		System.out.println(sw+"�ϸ鼭 �ߴ���");
	}
//	public void fly() {
//		System.out.println("���� ���� ���մϴ�.");
//	}
//	@Override
//	public void swimming() {
	//������ 
//		System.out.println("���� ������ �� �������� ����� �Ұ����մϴ�.");
//	}
	
	@Override
	public void quack(String qu) {
		System.out.println(qu+"�Ҹ�����?");
	}
}
