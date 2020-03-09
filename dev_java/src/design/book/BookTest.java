package design.book;

import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		BookController bCtrl = new BookController();
		BookVO pbVO = new BookVO();
		pbVO.setCommand("delete");
		BookVO rbVO = bCtrl.send(pbVO);
		System.out.println("삭제처리여부===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("update");
		rbVO = bCtrl.send(pbVO);
		System.out.println("수정처리여부===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("insert");
		rbVO = bCtrl.send(pbVO);
		System.out.println("입력처리여부===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("detail");
		pbVO.setB_no(2);//1번자리에 값을 못넣으니
		rbVO = bCtrl.send(pbVO);
		System.out.println("상세조회처리여부===>"+rbVO);
		pbVO = null;
		pbVO = new BookVO();
		List<BookVO> bookList = null;
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		System.out.println("전체조회처리여부===>"+bookList);
		
	}

}
