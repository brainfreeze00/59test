package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class D {
	
	public void methodD(Collection<String> col) {
		System.out.println("methodD Collection 호출 성공 : # 1 ");	
	}
	public void methodD(List<String> li) {
		System.out.println("methodD List 호출 성공 : # 2 ");	
		
	}
	public void methodD(ArrayList<String> al) {
		System.out.println("methodD ArrayList 호출 성공 : # 3 ");	
		
	}
	public void methodD(Vector<String> v) {
		System.out.println("methodD Vector 호출 성공 : # 4 ");	
		
	}
}
