package book.chap05;

public class MemberSimulation2 {
	public static void main(String[] args) {
		//Member클래스를 두개 만들 수 있는 방을 선언해봐요
		Member mems[] = null;                   // 아직 방이 할당되지 않음
		//선언한 객체배열을 생성하기 입니다. 크기는 2로 했어요
		//왜냐하면 이순신과 김유신 두사람만 기억하면 되니까....
	 	mems = new Member[2];                   // 생성하기
	 	//여기를 지나면 입장할수있어요.
	 	Member mem = new Member(); // 인스턴스화
	 	//Member안에 있는 mem_name에 김유신을 저장했어요
	 	mem.mem_name="김유신";                    // 김유신으로 초기화
	 	mem.mem_id="ghost";
	 	mem.mem_pw="123";
	 	//앗 mem 주소번지를 잘라내려고 해요....
	 	//잘리기 전에 담아두어야 합니다. 일단null이 되고 나면 가비지 컬렉터가
	 	//넌 쓰레기값이야 라고 딱지를 붙입니다. 그러면 접근을 못해요ㅠㅠ
	 	//그래서 반드시 그전에 담아두어야하는군요
	 	mems[0] = mem;
	 	mem = null;
	 	mem = new Member();
	 	mem.mem_name="이순신";
	 	mem.mem_id="nono";
	 	mem.mem_pw="333";
	 			mems[1]=mem;
	 	for(int i=0;i<mems.length;i++) {
	 		String id = mems[i].mem_id; // 활용빈도 높음 패턴도 같음
	 		String pw = mems[i].mem_pw;
	 		String name = mems[i].mem_name;
	 		System.out.println("id====> "+id);
	 		System.out.println("pw====> "+pw);
	 		System.out.println("name====> "+name);
		//Member mem1 = new Member("이정훈", 14);
		}

	}

}
