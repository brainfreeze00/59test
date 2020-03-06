package book.chap12;
//10	ACCOUNTING	NEW YORK
//20	RESEARCH	DALLAS
//30	SALES	CHICAGO
//40	OPERATIONS	BOSTON
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListNMapTest2 {
	//������ public�� Ÿ�� List<Map<String, Object>>�� �޼ҵ� getDeptList()
	public List<Map<String, Object>> getDeptList(){
		//List<Map<String, Object>>�� deptList�� new ArrayList<Map<String,Object>>() ����
		List<Map<String, Object>> deptList = new ArrayList<Map<String,Object>>();
		//Map<String, Object>�� pMap�� new HashMap<>()����
		Map<String, Object> pMap = new HashMap<String, Object>();
		//pMap�� ("deptno", 10) key,value�� �ִ´�.
		pMap.put("deptno", 10);
		//pMap�� ("dname", "ACCOUNTING") key,value�� �ִ´�.
		pMap.put("dname", "ACCOUNTING");
		//pMap�� ("loc", "NEW YORK") key,value�� �ִ´�.
		pMap.put("loc", "NEW YORK");
		//deptList�� pMap�� �ִ´�.
		deptList.add(pMap);
		//pMap�� ������ �ν��Ͻ�ȭ
		pMap = new HashMap<String, Object>();
		pMap.put("deptno", 20);
		pMap.put("dname", "RESEARCH");
		pMap.put("loc", "DALLAS");
		deptList.add(pMap);
		pMap = new HashMap<String, Object>();
		pMap.put("deptno", 30);
		pMap.put("dname", "SALES");
		pMap.put("loc", "CHICAGO");
		deptList.add(pMap);
		//���ϰ��� deptList
		return deptList;
	}
	public static void main(String[] args) {
		//�޼ҵ� ȣ���ϱ����ؼ��� �޼ҵ带 ���� Ŭ������ �ν��Ͻ�ȭ
		ListNMapTest2 lmt = new ListNMapTest2();
		//�������̽��� �߻�޼ҵ� ȣ���� ���ϰ��� �ּҹ���.�޼ҵ�ȣ��();
		List<Map<String, Object>> deptList = lmt.getDeptList();
		//�ѵΰ� �ƴ϶� for������ ������ 
		for(int i=0;i<deptList.size();i++) {
			//Map<String, Object>�� pMap�� deptList�ּҹ����� �ִ� i�� ������
			Map<String, Object> pMap = deptList.get(i);
			//ObjectŬ������ keys �迭�� pMap�ּҹ����� �ִ� key������ �迭 ���·� ��ȯ�ϰ� �����Ѵ�.
			Object keys[] = pMap.keySet().toArray(); 
		//List<Map<String, Object>>�� key�� value�� ����ϱ����� for���� ������.
		for(int j=0;j<keys.length;j++) {
			//pMap�ּҹ����� �ִ� keys�迭�� �ִ� j������ ������ ���
			System.out.print(pMap.get(keys[j])+"   ");
		}
		System.out.println();
		}
	}
}
