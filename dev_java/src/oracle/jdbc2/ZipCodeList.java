package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList {//Ŭ�������ο��� ����� ������ Ÿ���� ���߿� �ν��Ͻ�ȭ �Ҷ� Ȯ���ϴ� ���� ���׸��̶� �Ѵ�.

	public static void main(String[] args) {
		Vector<Object> v2 = new Vector<Object>();
		//Vector v2 = new Vector(); ���׸��� �����ϴ� ��쵵 ĳ������ �ٿ��� �Ѵ�.
		v2.add("���");
		v2.add("����");
		v2.add(1,"�ٳ���"); // �����ֱ� �迭�� �ȵ� �׷��� ����.	
		Vector<String> v = new Vector<String>();
		v.add("���");
		v.add("����");
		v.add(1,"�ٳ���"); // �����ֱ� �迭�� �ȵ� �׷��� ����.
		v2.remove(2);
		//v2.remove(2)(index); //�޼ҵ� �����ε��� ������� ���� �޼ҵ� �̸��� �������� �ִ�
		for(int i=0;i<v2.size();i++) { // v.size() �� �ϰԵǸ� v2�� 2������ ������ ���°� ��� ���� index out of bounds exception�� �� ��� v2.size()�� �����
			//String f = v2.get(i);//Ÿ���� Object�� �������� �����. Ÿ���� ���� ����
			String f = (String)v2.get(i); // Ÿ���� ���߰ų� Ÿ���� �����ؼ� ����
			System.out.println("v: "+v.get(i));
		}		
		
	}

}
