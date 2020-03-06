package book.chap05;
//Member[] - 객체배열     클래스명[] 형태
public class MemberSimulation {

	public static void main(String[] args) {
	//String mem_name=null;
	Member mem = new Member();  // 인스턴스화
	//before
	System.out.println("before "+mem.mem_name);
	mem.mem_name="김유신";//초기화 null ==> 김유신
	mem = null;
	//after	
	//System.out.println("after "+mem.mem_name); // 김유신 출력 -> 출력안됨 11번때메
 	mem = new Member(); // 복제품 즉 주소번지 다름 
	mem.mem_name = "이순신";
	System.out.println("after "+mem.mem_name); // 이순신 출력
	
	//Member mem1 = new Member("이정훈", 14);
	}

}
