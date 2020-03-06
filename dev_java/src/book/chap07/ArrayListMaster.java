package book.chap07;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMaster {
	
	//선언부
	
	
	
	//디폴트 생성자
	public	ArrayListMaster() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10); // index 0 - 10 // 엘리먼트를 추가할때는 add 메소드를 사용합니다. add는 단순히 배열뒤에 데이터를 더하기 때문에 빠릅니다.
		numbers.add(20); // index 1 - 20
		numbers.add(30); // index 2 - 30
		numbers.add(40); // index 3 - 40
		System.out.println("add(값)");
		System.out.println(numbers);
		
		
		/* index 0 - 10
		 * index 1 - 50 numbers.add(1, 50);에 의해 삽입
		 * index 2 - 20 numbers.add(1, 50);에 의해 인덱스가 밀림
		 * index 3 - 30
		 * index 4 - 40
		 */
		numbers.add(1, 50); 
		System.out.println("\nadd(인덱스, 값)");
		System.out.println(numbers);
		
		numbers.remove(2);   // index 2 를 제거  즉 index2에 가진 정보 삭제
		System.out.println("\nremove(인덱스)");
		System.out.println(numbers);
		
		System.out.println("\nget(인덱스)");
		System.out.println(numbers.get(2)); //그거 가져와

		System.out.println("\nsize()");
		System.out.println(numbers.size());//인덱스 몇개냐
		
		System.out.println("\nindexOf()");
		System.out.println(numbers.indexOf(30)); // 30의 인덱스 뭐냐
		
		Iterator it = numbers.iterator(); // 어레이 배열 순차 결정 클래스 
        System.out.println("\niterator");
        while (it.hasNext()) {  
            int value = (int) it.next();
            if (value == 30) { // 값이 30 일때 30 라인을 제거 
                it.remove();
            }
            System.out.println(value);
        }
        System.out.println(numbers);

        System.out.println("\nfor each");
        for (int value : numbers) {
            System.out.println(value);
        }
        System.out.println("\nfor");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
		
	}
	//메소드
	
	//메인 메소드
	public static void main(String[] args) {
		new ArrayListMaster();
	}
}
