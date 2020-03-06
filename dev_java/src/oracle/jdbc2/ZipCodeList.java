package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList {//클래스내부에서 사용할 데이터 타입을 나중에 인스턴스화 할때 확정하는 것을 제네릭이라 한다.

	public static void main(String[] args) {
		Vector<Object> v2 = new Vector<Object>();
		//Vector v2 = new Vector(); 제네릭을 생략하는 경우도 캐스팅을 붙여야 한다.
		v2.add("사과");
		v2.add("딸기");
		v2.add(1,"바나나"); // 끼워넣기 배열은 안됨 그래서 쓴다.	
		Vector<String> v = new Vector<String>();
		v.add("사과");
		v.add("딸기");
		v.add(1,"바나나"); // 끼워넣기 배열은 안됨 그래서 쓴다.
		v2.remove(2);
		//v2.remove(2)(index); //메소드 오버로딩의 개념기준 같은 메소드 이름을 가질수는 있다
		for(int i=0;i<v2.size();i++) { // v.size() 로 하게되면 v2는 2번방이 없어진 상태가 출력 에러 index out of bounds exception이 뜸 고로 v2.size()로 맞춰라
			//String f = v2.get(i);//타입이 Object라서 담을수가 없어요. 타입이 맞지 않죠
			String f = (String)v2.get(i); // 타입을 맞추거나 타입을 변경해서 맞춤
			System.out.println("v: "+v.get(i));
		}		
		
	}

}
