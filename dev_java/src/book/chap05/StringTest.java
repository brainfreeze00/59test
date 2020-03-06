package book.chap05;
/*
 * �������� �ۼ��Ҷ� String�� ����ϸ� �ȵǴ�  ������ ���� ���Ҽ��ִ�.
 * String�� ������ ����� �ٲ��� �ʴ´�.
 * ���� �����Ϸ��� �ݵ�� ���ο� ������ �� ���� �ٽ� ��ƾ��Ѵ�.
 * �̷���  �Ǹ� ���� �̸��� ������ n�� ��ŭ �����ǹǷ� ��ȿ�����̴�.
 * ���� �̷����� StringBuider�� �������
 * 
 */
public class StringTest {
	
//�ּҹ����� ���Ѵ�.
//�ּҹ����� ����Ű�� ���� ���Ѵ�.	
	public static void main(String[] args) {
		String s1 = "apple"; // s1�� �� -���� ==�� �ּҹ����� ����Ű�°�
		String s2 = "apple"; // s2�� �� -���� ==�� �ּҹ����� ����Ű�°�
		String s3 = new String("apple"); // s3�� ��� �ּ�
		String s4 = new String("apple"); // s4�� ��� �ּ� 
		System.out.println(s1==s2);//true, false -> true  ��-����  ���� : s2�� s1�� �ּҹ����� ���� �� ������? 
		//�ּҹ����� ����?
		System.out.println(s3==s4);//true, false -> false �ּҹ���
		//�� �ּҹ����� ����Ű�� ���� ����? = ������Ʈ�� ������ ���ڸ� ��Ÿ���� ��� �����  ��
		System.out.println(s3.equals(s4));//true, false ->
		s1.replace('p', '1'); 
		//s1 = s1.replace('p','1'); //15��s1 24��s1  �ΰ��� ���������, �׷��ϱ� ���� Ÿ���� ���� �� ���� �����Ѵ�
		System.out.println(s1);//a11le �� ���ñ�?
		StringBuilder sb = new StringBuilder("hello");
		sb.append("world");//������ �ٿ����⸦ �Ѱ�쿡 �ش�ǹǷ� �޸𸮻���� ���డ��
		System.out.println(sb.toString());
	}

}
