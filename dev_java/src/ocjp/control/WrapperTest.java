package ocjp.control;
//��ü������ ���
//���������� ��� -C��� - ������� �����
/*
 * ������ ����
 * 1.������Ÿ��(primative data type) - �θ��� ���� ��ȯ
 * ������ Ÿ���� �ƴ϶� ������ �޼ҵ带 ���� �� ����.
 * 2.������Ÿ��(reference data type) - Sonata, String, Tivoli
 * �θ��� �ּҹ����� ��ȯ��.
 */
public class WrapperTest {
	int i;
	static void methodA() {
		//int i = new int();
		Integer i = new Integer(10);
		//����ڽ� �����߰� : jvm�� �˾Ƽ� ���ش�.
		//���� i�� Ŭ�������̰� ����j�� ������ Ÿ���̶� ���� ���� �ٸ�
		int j = i;
		//����ڽ��� ������������ �ݵ�� ����Ŭ���� Ÿ���� ������ Ÿ������ �ٲپ��ִ�
		//�޼ҵ带 �¿�������
		//String s = i.intValue(); //�ҹ� ��ȯŸ���� �ٸ� int�ε� string���� 
		j = i.intValue();
		Boolean b = new Boolean(false);
		boolean b1 = b;   // jvmó�� ��������
		String str = "false";
		Boolean b2 = Boolean.valueOf(str);
		if(b2) {
			
		}
	}
	public static void main(String[] args) {
		//������ Ÿ�Կ��� 8������ �ִ�.
		//int, boolean, double
		//Integer, Boolean, Double, Wrapper Ŭ���������. ������ �޼ҵ带 ���� �� �ְ� ����
		//������ Ÿ���� int���� �޼ҵ带 ������ �ϰ� �ʹ�.
	}

}
