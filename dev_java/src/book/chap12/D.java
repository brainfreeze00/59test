package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class D {
	
	public void methodD(Collection<String> col) {
		System.out.println("methodD Collection ȣ�� ���� : # 1 ");	
	}
	public void methodD(List<String> li) {
		System.out.println("methodD List ȣ�� ���� : # 2 ");	
		
	}
	public void methodD(ArrayList<String> al) {
		System.out.println("methodD ArrayList ȣ�� ���� : # 3 ");	
		
	}
	public void methodD(Vector<String> v) {
		System.out.println("methodD Vector ȣ�� ���� : # 4 ");	
		
	}
}
