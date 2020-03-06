package oracle.jdbc2;

public class ZipCodeVOSimulation {
//저장할땐 set 읽어올땐 get
	static	void methodA() {
		ZipCodeVO zcVOS[] = new ZipCodeVO[2]; // 컬렉션과 제네릭공부
		ZipCodeVO zcVO = new ZipCodeVO();
		//삼각형 안에 zipcode 변수에 값 넣기
		zcVO.setZipcode(21548); // 우편번호를 [각각-7번, 인스턴스화] 담았다
		zcVOS[0] = zcVO; //사각형에 삼각형 넣기 0번자리에
		zcVO = new ZipCodeVO();
		zcVO.setZipcode(23598); // 우편번호를 [각각-11번, 인스턴스화]담았다
		zcVOS[1] = zcVO; //사각형에 삼각형 넣기  1번자리에
		//메소드호출
		printZcVOS(zcVOS); //메소드 파라미터로 주소번지[]배열 넘겨주기
	}
	
	static void printZcVOS(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zcVO : zcVOS) {
			System.out.println(zcVO.getZipcode());
		}
	}
	
	
	public static void main(String[] args) {
		ZipCodeVOSimulation.methodA();
		ZipCodeVO zcVO = new ZipCodeVO();
		//zcVO.uid_no = 10; 문법에러
		zcVO.setUid_no(10); //void     쓰기  0 -> 10
		zcVO.setUid_no(30); //void        10 -> 30
		int uid_no = zcVO.getUid_no(); //int
		System.out.println("?"+uid_no);//10-?30 오버라잇
		zcVO.setAddress("서울시 금천구 가산동");
		String address = zcVO.getAddress();
		System.out.println(""+address);
		
		
		zcVO.setZipcode(21548);
		int zipcode = zcVO.getZipcode();
		System.out.println(zipcode);
		
	}

}
