package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class A {
//Ŭ���� A���� Ŭ���� B�� �ִ� �޼ҵ� ȣ�� �غ�
	public static void main(String[] args) {
		
		B b = new B();
		
		Collection<String> col = new ArrayList<>(); //Collection�� List ���� ������ �ȵǾ� �ֱ⿡ ���� �ν��Ͻ�ȭ �ȵ�
		List<String> li = new ArrayList<>(); //�̱۽����� ���� - ����ȭ ������ �ȵǾ��ִ�  (����ȭ:���θ����)-�ӵ�����   ���� �������̽� = new ���� �������̽�
		List<String> li2 = new Vector<>();   //��Ƽ��������� - ����ȭ ���� �Ѵ� - �ӵ��� ����  �����,ä�ù�,������            ���� �������̽� = new ���� �������̽�
		ArrayList<String> al = new ArrayList<>();  
		Vector<String> v = new Vector<>();
		// Collection >> List >> ArrayList  
		// Collection >> List >> Vector
		
		b.methodA(col);
		b.methodA(li);
		b.methodA(li2);
		b.methodA(al);
		b.methodA(v);
		
 	}
}
