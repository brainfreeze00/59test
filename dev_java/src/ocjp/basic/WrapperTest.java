package ocjp.basic;
/*
 * ���� �߷��� ������ �߷��� 17%�� ���� ����� �����Դ� ? 
 */
public class WrapperTest {

	public static void main(String[] args) {
		int i = 5;
		//8���� ���� i�� ���� WrapperŬ��������Ѵ�.
		Integer oi = new Integer(5);
		//������ Ÿ�� i�� �޼ҵ带 ȣ�� �Ҽ� ����.
//System.out.println(i.intValue()); �ҹ�
		System.out.println(oi.intValue()); // �չ�
		int j = 6;
		j = i;
		Double pi = new Double(3.14); // Ŭ����Ÿ��
		double d = pi.doubleValue(); // pi �޼ҵ�� ���� ȣ��
		double d1 = pi; // ����ڽ� - �ڵ����� �������� ������ ���̿� Ÿ���� ������
		System.out.println(d1);
		Boolean b = new Boolean(false);
	}

}
