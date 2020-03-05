package design.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapTest {

	public static void main(String[] args) {
		List<Map<String, Object>> lm = null;
		lm = new ArrayList<>();
		Map<String, Object> rMap = null;
		rMap = new HashMap<>();
		rMap.put("b_title","자바의 정석");
		rMap.put("b_author","남궁성");
		rMap.put("b_publish","도우출판");
		lm.add(rMap);
		System.out.println(lm);
		for(int i=0;i<lm.size();i++) {
			Map<String, Object> pMap = lm.get(i);
			Object keys[] = pMap.keySet().toArray();
		for(int j=0;j<keys.length;j++) {
			System.out.println(pMap.get(keys[j])+"");
		}
		System.out.println();
		}
	}
}
