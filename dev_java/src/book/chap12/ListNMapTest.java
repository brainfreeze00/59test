package book.chap12;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ListNMapTest {
	public List<Map<String, Object>> getDeptList() {
		List<Map<String, Object>> deptList = new ArrayList<Map<String,Object>>();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptno",10); // put()�����Ѵ�
		pMap.put("dname","ACCOUNTING");
		pMap.put("loc","NEW YORK");
		deptList.add(pMap);
	    pMap = new HashMap<>();
		pMap.put("deptno",20); // put()�����Ѵ�
		pMap.put("dname","RESEARCH");
		pMap.put("loc","DALLAS");
		deptList.add(pMap);
		pMap = new HashMap<>();
		pMap.put("deptno",30); // put()�����Ѵ�
		pMap.put("dname","SALES");
		pMap.put("loc","CHICAGO");
		deptList.add(pMap);
		return deptList;
	}
	public static void main(String[] args) {
		ListNMapTest lmt = new ListNMapTest();
		List<Map<String, Object>> deptList = lmt.getDeptList(); // return���� deptList �̴ϱ� deptList��lmt.getDeptList()�����Ѵ�   ��, deptList ���������� Ÿ�԰� ���� 
		for(int i=0;i<deptList.size();i++) {
			Map<String, Object> pMap = deptList.get(i); //3���� i
			Object keys[] = pMap.keySet().toArray(); // ������ 2�� key�� ������ �迭�� keys[]�� ����
			for(int j=0; j<keys.length;j++) { // j
				System.out.print(pMap.get(keys[j])+"  ");
				//System.out.println(pMap.keySet().toString());
			}
			System.out.println();// ����ó��-�ٹٲ�ó��
		}
	}

}
