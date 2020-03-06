package basic_inout;

public class Printf {

	public static void main(String[] args) {
		int value = 123;
		System.out.printf("상품의 가격 :%d원\n",value);
		System.out.printf("상품의 가격 :%6d원\n",value);
		System.out.printf("상품의 가격 :%-6d원\n",value);
		System.out.printf("상품의 가격 :%06d원\n",value); // 칸 이동
		String name = "홍길동";
		String job = "도적"; // 1 | 홍길동  |           도적
		System.out.printf("%6d | %-10s | %10s\n",1,name,job);  //개수만큼 파라미터 삽입
	}

}
