package book.chap02;

public class Tivoli {
	int speed = 0;
	String speedUp() {
		String h = "���α׷���";	
		speed = speed + 1; //1
		return h;
	}
	/*
	 * �ڹٰ���ӽ��� �����ϴ� ������� ��ȣ�� �Űܺ���?
	 * 13-21-22[�ּҹ��� ���]-23[�ʱ�ȭ-30]-25
	 */
	//entry point - ���ϸ��� ����Ǵ� �κ�
	public static void main(String[] args) {
		/*
		 * ��������
		 * non-static Ÿ���� speed������  static���ִ� ���� �޼ҵ�ȿ��� ������ �Ұ�
		 * �ذ��� - �����? How
		 * �ν��Ͻ�ȭ�ϸ� �ȴ�.
		 * 
		 */
		Tivoli gnom = new Tivoli();
		System.out.println("gnom�� �ּҹ����� "+ gnom);// 16����ǥ�� 0 1 2 3 4 5 6 7 8 9 a b c d e f #aabbcc
		gnom.speed = 30;
		System.out.println(gnom.speedUp());
		//insert here 
		System.out.println(gnom.speed);
	}

}
