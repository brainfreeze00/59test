package design.book;

import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		BookController bCtrl = new BookController();
		BookVO pbVO = new BookVO();
		pbVO.setCommand("delete");
		BookVO rbVO = bCtrl.send(pbVO);
		System.out.println("����ó������===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("update");
		rbVO = bCtrl.send(pbVO);
		System.out.println("����ó������===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("insert");
		rbVO = bCtrl.send(pbVO);
		System.out.println("�Է�ó������===>"+rbVO.getReuslt());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("detail");
		pbVO.setB_no(2);//1���ڸ��� ���� ��������
		rbVO = bCtrl.send(pbVO);
		System.out.println("����ȸó������===>"+rbVO);
		pbVO = null;
		pbVO = new BookVO();
		List<BookVO> bookList = null;
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		System.out.println("��ü��ȸó������===>"+bookList);
		
	}

}
