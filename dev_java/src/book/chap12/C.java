package book.chap12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class C {
	
	
	public static void main(String[] args) {
		D	d = new D();
		Collection<String> col = new ArrayList<String>();
		List<String> li = new ArrayList<>();
		ArrayList<String> al = new ArrayList<>();
		Vector<String>  v = new Vector<>();
		
		d.methodD(col);
		d.methodD(li);
		d.methodD(al);
		d.methodD(v);
	}
}
