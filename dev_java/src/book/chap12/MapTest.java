package book.chap12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
/*
 * �������̽��� �ܵ����� �ν��Ͻ�ȭ �� �� �� ����
 * �ݵ�� ����ü Ŭ������ �־�� �Ѵ�
 * �÷��������ӿ�ũ���� �����Ǵ� ��� Ŭ������ ��üŸ�Ը� ���� �� �ִ�.
 */ 
	Map<String,Object> pMap = new HashMap<>(); //value���� Object Ÿ�Ը� ������ �ִ�
	public void showAllDept2() { //
		Object keys[] = pMap.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			String key = (String)keys[i];
			System.out.println(key+", "+pMap.get(key));
		}
	}
	public void showAllDept() {
	 	Iterator<String> ir = null;//IteratorŬ������ Map�� ��� ������ �����µ� �ʿ��� �޼ҵ带 �����Ѵ�
	 	Set<String> keys = pMap.keySet();
	 	ir = keys.iterator();
	 	int deptno = 0;
	 	String dname = null;
	 	String loc = null;
	 	while(ir.hasNext()) { // �׸޼ҵ尡 hasNext()
	 		String key = ir.next();//deptno, dname, loc
	 		if(pMap.get(key) instanceof Integer ) {
	 			deptno = Integer.parseInt(pMap.get(key).toString());
	 		}
	 		if(pMap.get(key) instanceof String ) {
	 			if("dname".equals(key)) {
	 				dname = (pMap.get(key).toString());
	 			}else if("loc".equals(key)) {
	 				loc = (pMap.get(key).toString());
	 			}/////end of else if
	 		}//////end of if
	 	}////////////end of while
	 	System.out.println(deptno+", "+dname+", "+loc);
	}/////////////////end of showAllDept
	public static void main(String[] args) {
		//Map<String,Object> mt.pMap = new Map<>(); // �ܵ� �ν��Ͻ�ȭ �Ұ�
		//Map<Stirng,String> mt.pMap = new Map<>();
		MapTest mt = new MapTest();
		mt.pMap.put("deptno",10); // put()�����Ѵ�
		mt.pMap.put("dname","ACCOUNTING");
		mt.pMap.put("loc","NEW YORK");
		mt.showAllDept();
//		System.out.println(mt.pMap.get("deptno")); //get()������
//		System.out.println(mt.pMap.get("dname"));
//		System.out.println(mt.pMap.get("loc"));
		
	}

}
