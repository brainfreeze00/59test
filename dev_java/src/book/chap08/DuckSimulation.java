package book.chap08;

public class DuckSimulation {
/*
 * ������� Ÿ�԰� �������� Ÿ���� �ٸ� �� �ִ�.
 * ��� : ������ Ÿ������ ��ü�� �����ȴ�.(heap ������ �ö󰣴�.)
 * �׷��� ����� Ÿ���� �� �޼ҵ带 �����ϰ� ���� ������ �ڽ� Ŭ�����ȿ� 
 * �׸޼ҵ尡 ����Ǿ� �ִ� �ϴ��� ȣ�� �� �� ����.
 * ���� ��� : ������ �θ� Ÿ�Կ� ����� �޼ҵ常 ȣ���Ҽ��ִ�.
 */
	public static void main(String[] args) {
		
		Duck d 		= new Duck();
		Duck dw 	= new WoodDuck();
		Duck dr 	= new RubberDuck();
		Duck dm 	= new MallardDuck();
		//ȣ������ �ּҹ���.�޼ҵ�(�ּҹ���.����)
		System.out.println("����----------------------------------");
		d.swimming(d.sw);
		dw.swimming(dw.sw);
		dr.swimming(dr.sw);
		dm.swimming(dm.sw);
		System.out.println("�Ҹ�----------------------------------");
		d.quack(d.qu);
		dr.quack(dr.qu);
		dm.quack(dm.qu);
		System.out.println("����----------------------------------");
		d.fly(d.f);
		dm.fly(dm.f);
	}

}
