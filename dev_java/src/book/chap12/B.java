package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
/*
 * �޼ҵ� �����ε��� ������ �Ķ������ ������ �Ķ������ Ÿ���� �޶���Ѵ�
 * �̰��� �ڹ� �� ���� �̸��� �޼ҵ带 ������ ��� �� �ֵ��� �����ϱ� ���ؼ�
 * �߰��� ��Ģ�̴�. ��Ģ���ݽ� ������ ����
 * 
 */
public class B {
	
	void methodA(Collection<String> col) {
		System.out.println("methodA(Collection)ȣ�� ���� - #14");
	}
	void methodA(List<String> li) {
		System.out.println("methodA(List)ȣ�� ���� - #17");
	}
	void methodA(ArrayList<String> al) {
		System.out.println("methodA(ArrayList)ȣ�� ���� - #20");
	}
	void methodA(Vector<String> v) {
		System.out.println("methodA(Vector)ȣ�� ���� - #23");
	}
}
