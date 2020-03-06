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
	//접근자 public의 타입 List<Map<String, Object>>의 메소드 getDeptList()
	public List<Map<String, Object>> getDeptList(){
		//List<Map<String, Object>>의 deptList에 new ArrayList<Map<String,Object>>() 생성
		List<Map<String, Object>> deptList = new ArrayList<Map<String,Object>>();
		//Map<String, Object>의 pMap에 new HashMap<>()생성
		Map<String, Object> pMap = new HashMap<String, Object>();
		//pMap에 ("deptno", 10) key,value를 넣는다.
		pMap.put("deptno", 10);
		//pMap에 ("dname", "ACCOUNTING") key,value를 넣는다.
		pMap.put("dname", "ACCOUNTING");
		//pMap에 ("loc", "NEW YORK") key,value를 넣는다.
		pMap.put("loc", "NEW YORK");
		//deptList에 pMap을 넣는다.
		deptList.add(pMap);
		//pMap을 새로이 인스턴스화
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
		//리턴값은 deptList
		return deptList;
	}
	public static void main(String[] args) {
		//메소드 호출하기위해서는 메소드를 가진 클래스를 인스턴스화
		ListNMapTest2 lmt = new ListNMapTest2();
		//인터페이스의 추상메소드 호출은 리턴값에 주소번지.메소드호출();
		List<Map<String, Object>> deptList = lmt.getDeptList();
		//한두개 아니라 for문으로 돌린다 
		for(int i=0;i<deptList.size();i++) {
			//Map<String, Object>의 pMap에 deptList주소번지에 있는 i를 꺼낸다
			Map<String, Object> pMap = deptList.get(i);
			//Object클래스의 keys 배열에 pMap주소번지에 있는 key집합을 배열 형태로 변환하고 대입한다.
			Object keys[] = pMap.keySet().toArray(); 
		//List<Map<String, Object>>의 key와 value를 출력하기위해 for문을 돌린다.
		for(int j=0;j<keys.length;j++) {
			//pMap주소번지에 있는 keys배열에 있는 j값들을 꺼내고 출력
			System.out.print(pMap.get(keys[j])+"   ");
		}
		System.out.println();
		}
	}
}
