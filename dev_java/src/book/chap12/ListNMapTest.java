package book.chap12;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ListNMapTest {
	public List<Map<String, Object>> getDeptList() {
		List<Map<String, Object>> deptList = new ArrayList<Map<String,Object>>();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptno",10); // put()저장한다
		pMap.put("dname","ACCOUNTING");
		pMap.put("loc","NEW YORK");
		deptList.add(pMap);
	    pMap = new HashMap<>();
		pMap.put("deptno",20); // put()저장한다
		pMap.put("dname","RESEARCH");
		pMap.put("loc","DALLAS");
		deptList.add(pMap);
		pMap = new HashMap<>();
		pMap.put("deptno",30); // put()저장한다
		pMap.put("dname","SALES");
		pMap.put("loc","CHICAGO");
		deptList.add(pMap);
		return deptList;
	}
	public static void main(String[] args) {
		ListNMapTest lmt = new ListNMapTest();
		List<Map<String, Object>> deptList = lmt.getDeptList(); // return값이 deptList 이니까 deptList에lmt.getDeptList()대입한다   단, deptList 지역변수라 타입과 같이 
		for(int i=0;i<deptList.size();i++) {
			Map<String, Object> pMap = deptList.get(i); //3개라서 i
			Object keys[] = pMap.keySet().toArray(); // 접근이 2번 key의 집합을 배열로 keys[]에 대입
			for(int j=0; j<keys.length;j++) { // j
				System.out.print(pMap.get(keys[j])+"  ");
				//System.out.println(pMap.keySet().toString());
			}
			System.out.println();// 개행처리-줄바꿈처리
		}
	}

}
