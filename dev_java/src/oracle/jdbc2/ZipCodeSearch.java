package oracle.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

public class ZipCodeSearch {
	//선언부
	//드라이버 클래스가 필요하다. -JDBCTest에서 꺼내쓰자.	
	//URL정보도 JDBCTest에서 꺼내 쓸 수 있다. + user와 pw는 생략할수 있다. - 왜?
	Connection          con = null; //오와열
	PreparedStatement pstmt = null; // 오라클 서버에 전령해주고 처리해주는 PreparedStatement
	ResultSet            rs = null; // 여기까지 전역변수선언
	//오라클 서버와 연결통로 만들기를 메소드로 꺼내보세요.
	//메소드 뒤에 Exception을 붙이는 건 드라이블 클래스를 잘못 작성하여 에러가 아닌
	//런타임에러 즉 ClassNotFoundException을 맞을수 있기때문에 선언하였다.
	public Connection getcoConnection() throws Exception { 
		System.out.println("getConnection호출 성공");
		//오라클 회사 정보를 수집함.
		Class.forName(JDBCTest._DRIVER);
		con = DriverManager.getConnection(JDBCTest._URL, JDBCTest._USER, JDBCTest._PW); 
		return con;
	}
	//main()-userInput[동이름 결정]-getZipCodeList('당산동')
	public ZipCodeVO[] getZipCodeList(String userDong) throws Exception{ //오라클서버에게 select문을 전달하고 응답받기 getZipCodeList
		 //예외가 발생하면 나를 호출한 곳에서 처리를 받으세요.
		//예외처리를 내가 하지않고 미룬다.
		System.out.println("getZipCodeList 호출 성공"+userDong);
		ZipCodeVO zcVOS[] = null;
		ZipCodeVO zcVO = new ZipCodeVO();
		String sql = "";
		sql+="SELECT address, zipcode"; 
		sql+=" FROM zipcode_t"; // 띄어쓰기 하도록 구분하게 FROM을
		sql+=" WHERE dong LIKE '%'||?||'%'"; //조회결과가 3건일 경우
		//오라클서버에 요청을 보내기
		getcoConnection();
		pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, userDong); //?들어갈 동이름이 결정됨.
		rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
		Vector<ZipCodeVO> v = new Vector<>();
		while(rs.next()) { //커서이동, 커서이동
			zcVO = new ZipCodeVO(); 
			zcVO.setAddress(rs.getString("address")); //직관적으로 하기위해 "address"
			zcVO.setZipcode(rs.getInt("zipcode"));
			v.add(zcVO);
			//System.out.println("while문 :"+rs.next());//커서이동
		}
		zcVOS = new ZipCodeVO[v.size()];
		v.copyInto(zcVOS); //벡터 자료 구조에 들어있는 정보를 복사하기  형태: 소유주.메소드()
		System.out.println("while문 탈출"); // 출력했을때 SELECT문이 문제없이 잘처리됨을 알수있음  없어지면 false가 뜨면서 while문을 탈출
		//서버에 요청 하기전에 사용자로부터 동이름을 먼저 입력 받아야한다.
		//zcVO.uid_no = 10; 문법에러 클래스에서 갖다쓰지못하게 private으로 막았다 이유를 찾아보아라. 이유 : private - 웹이나 앱에서 동시 사용자가 많을때 변조되면 안됨.
		zcVO.setUid_no(10); //기억할수있다 . 초기화할수있다
		printZipCode(zcVOS); //메소드 호출시에는 타입표시 안함. [] Type등 표시안함
		return zcVOS;
	}
	//조회된 우편번호 목록을 출력해보기
	public void printZipCode(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zVO:zcVOS) {
			System.out.println(zVO.getAddress()+"    "+zVO.getZipcode());
		}
	}
	//사용자로부터 동을 입력받는 메소드를 구현해 보시오.
	public String userInput() {
		//JDBCTest._USER="hr"; static만 있으니까 계정이름 변경가능함.  
		//JDBCTest._DRIVER="hr"; 불가 final 상수로 선언되어	 불가능함.	
		Scanner scan = new Scanner(System.in);
		String userDong = null; // 지역변수선언
		userDong = scan.nextLine();
		return userDong; //확정
		//return "당산동"; 확정
	}	
	//메인메소드
	/*
	 * 23(가장먼저호출-entry pointer-main 스레드)-25(변수선언:지역변수)-26-27
	 * 28(메소드호출)-11(파라미터는 없다 : 리턴은 있다.)-12-13-14-15-16(입력받은값확정)
	 * 28(리턴값으로 받음)-
	 */
	public static void main(String[] args) throws Exception{
		System.out.println("동을 입력해주세요.");
		String userDong = null; //인식을 위한 선언
		ZipCodeSearch zs = new ZipCodeSearch(); // static 이 없기에 인스턴스화 
		userDong = zs.userInput(); //메소드 호출과 초기화  메소드에서 리턴타입을 받음 이게 핵심
		if(userDong==null) {
			System.out.println("반드시 동을 입력해야합니다.");
		return; //메인을 탈출하고 끝
		}else {
			System.out.println("당신은"+userDong+"을 입력하셨습니다."); 
			//출력부위에 직접 메소드를 직접 넣으면 행동이 중첩되어 출력이 n만큼 입력해야하는 상황발생 고로 호출과 동시에 초기화해야한다.
			ZipCodeVO zcVOS[] = zs.getZipCodeList(userDong);
		}
	}

}
