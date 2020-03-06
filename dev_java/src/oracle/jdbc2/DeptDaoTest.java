package oracle.jdbc2;

public class DeptDaoTest {
	DeptDao dDao = new DeptDao();
	int result = 0;//입력결과|수정결과|삭제결과 
	//조회하기 테스트
	public void selectTest(DeptVO dVO) { //컬럼수가 많으니까 VO처리 한번에 배열
		System.out.println("selectTest 호출성공");	
		DeptVO dVOS[] = dDao.deptList(dVO.getDeptno());
	
		for(DeptVO rdVO:dVOS) {
			System.out.println(rdVO.getDeptno()+", "
								+rdVO.getDname()+", "
								+rdVO.getLoc());
		}
	}
	//등록하기 테스트
	public void insertTest(DeptVO dVO) { //컬럼수가 많으니까 VO처리 한번에 배열
		System.out.println("insertTest 호출성공");
		result = dDao.deptInsert(dVO.getDeptno(), dVO.getDname(), dVO.getLoc());
		System.out.println("입력 성공유무:"+result);
	}
	//수정하기 테스트
	public void updateTest(DeptVO dVO) { //컬럼수가 많으니까 VO처리 한번에 배열
		System.out.println("updateTest 호출성공");
		result = dDao.deptUpdate(dVO.getDname(), dVO.getLoc(), dVO.getDeptno());
		System.out.println("수정 성공유무:"+result);
	}
	//삭제하기 테스트
	public void deleteTest(DeptVO dVO) { //컬럼수가 많으니까 VO처리 한번에 배열
		System.out.println("deleteTest 호출성공");
		result = dDao.deptDelete(dVO.getDeptno());
		System.out.println("삭제 성공유무:"+result);
	}
	public static void main(String[] args) {
		DeptDaoTest ddt = new DeptDaoTest();
		//화면이 아직 완성되지않았으므로 통합테스트는 불가하다.
		//하지만 단위테스트는 언제나 가능 
		DeptVO dVO = new DeptVO();
		//dVO의 setDeptno메소드를 이용하여 int 61를 인자로 넘긴다
		dVO.setDeptno(61);
		//dVO의 setDname메소드를 이용하여 String  "품질관리팀"를 인자로 넘긴다.
		dVO.setDname("품질관리팀");
		//dVO의 setLoc메소드를 이용하여 String "인천"을 인자로 넘긴다.
		dVO.setLoc("인천");
		//dVO 파라미터를 대입한 ddt의 insertTest메소드에  dVO를 인자로 넘긴다 
		ddt.insertTest(dVO);
		//dVO를 null로 초기화하여 기존의 연결고리를 끊는다 
		dVO = null;//기존의 연결고리를 끊는다
		//dVO에 새로운 DeptVO객체 생성한다
		dVO = new DeptVO(); //다시 인스턴스해야함 왜냐면 새로운 객체를 조립시작해야하니까
		//dVO의 setDeptno메소드를 이용하여 int 61를 인자로 넘긴다
		dVO.setDeptno(61);
		//dVO의 selectTest메소드를 이용하여 ㅇ
		ddt.selectTest(dVO);
		dVO = null;//기존의 연결고리를 끊는다
		dVO = new DeptVO(); //다시 인스턴스해야함 왜냐면 새로운 객체를 조립시작해야하니까
		dVO.setDeptno(61);
		dVO.setDname("품질관리팀2");
		dVO.setLoc("인천2");
		ddt.updateTest(dVO);
		dVO = null;//기존의 연결고리를 끊는다
		dVO = new DeptVO(); //다시 인스턴스해야함 왜냐면 새로운 객체를 조립시작해야하니까
		dVO.setDeptno(61);
		ddt.deleteTest(dVO);
	}

}
