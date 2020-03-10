package design.book;

import java.util.List;

public class BookController {
	BookApp bookApp = null;
	private static final String _DEL = "delete";//삭제하기
	private static final String _SEL = "detail";//상세조회
	private static final String _INS = "insert";//입력하기
	private static final String _UPD = "update";//수정하기
	private static final String _ALL = "all";//전체조회
	BookDao bDao = new BookDao();
	
	public BookController(BookApp bookApp) {
		this.bookApp = bookApp;
	}
	
	public BookVO send(BookVO pbVO) { //접근제어 public 타입은 BookVO인 메소드 send에 pbVO를 파라미터
		BookVO rbVO = new BookVO();//rbVO를 새로 인스턴스화 한 이유는 파라미터 pbVO의 값과  결과값과 헷갈림을 방지하기 위해
		String command = pbVO.getCommand();
		//insert here
		if(_DEL.equals(command)) {
		//DELETE FROM book2020 WHERE b_no=1
			int result = 0;
			result =bookApp.bDao.bookDelete(pbVO); // create method 키로 Dao에 자동으로 메소드 생성
			rbVO.setReuslt(result);
		}
		else if(_INS.equals(command)) {
			//INSERT FROM book2020(b_no, b_name, b_author, b_publish, b_info
			//VALUES(?,?,?,?,?)
			int result = 0;
			result = bookApp.bDao.bookInsert(pbVO);// create method 키로 Dao에 자동으로 메소드 생성
			rbVO.setReuslt(result);
		}
		else if(_UPD.equals(command)) {
			//UPDATE book2020 SET b_name=?, b_author=?, b_publish=?
			//WHERE b_no =2
			int result = 0;
			result = bookApp.bDao.bookUpdate(pbVO);// create method 키로 Dao에 자동으로 메소드 생성
			rbVO.setReuslt(result);
		}
		else if(_SEL.equals(command)) {
			//SELECT b_no, b_name, b_author, b_publish FROM book2020
			//WHERE b_no=3
			rbVO = bookApp.bDao.bookDetail(pbVO);// create method 키로 Dao에 자동으로 메소드 생성
		}
		return rbVO;
	}////send
	//전체 조회
	public List<BookVO> sendALL(BookVO pbVO){
		System.out.println("sendALL 호출 성공");
		List<BookVO> bList = null;
		String command = pbVO.getCommand();//all이 전달된다.
		if(_ALL.equals(command)) { // 너 전체조회를 누른거니?
			//사용자의 선택은 읽었지만 여기서 DB연동을 하지는 않는다. 연동은 BookDao쪽에서 한다.
			bList = bookApp.bDao.bookList(pbVO);// create method 키로 Dao에 자동으로 메소드 생성
			
		}
		return bList;
	}
}
