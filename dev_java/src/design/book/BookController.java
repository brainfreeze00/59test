package design.book;

import java.util.List;

public class BookController {
	BookApp bookApp = null;
	private static final String _DEL = "delete";//�����ϱ�
	private static final String _SEL = "detail";//����ȸ
	private static final String _INS = "insert";//�Է��ϱ�
	private static final String _UPD = "update";//�����ϱ�
	private static final String _ALL = "all";//��ü��ȸ
	BookDao bDao = new BookDao();
	
	public BookController(BookApp bookApp) {
		this.bookApp = bookApp;
	}
	
	public BookVO send(BookVO pbVO) { //�������� public Ÿ���� BookVO�� �޼ҵ� send�� pbVO�� �Ķ����
		BookVO rbVO = new BookVO();//rbVO�� ���� �ν��Ͻ�ȭ �� ������ �Ķ���� pbVO�� ����  ������� �򰥸��� �����ϱ� ����
		String command = pbVO.getCommand();
		//insert here
		if(_DEL.equals(command)) {
		//DELETE FROM book2020 WHERE b_no=1
			int result = 0;
			result =bookApp.bDao.bookDelete(pbVO); // create method Ű�� Dao�� �ڵ����� �޼ҵ� ����
			rbVO.setReuslt(result);
		}
		else if(_INS.equals(command)) {
			//INSERT FROM book2020(b_no, b_name, b_author, b_publish, b_info
			//VALUES(?,?,?,?,?)
			int result = 0;
			result = bookApp.bDao.bookInsert(pbVO);// create method Ű�� Dao�� �ڵ����� �޼ҵ� ����
			rbVO.setReuslt(result);
		}
		else if(_UPD.equals(command)) {
			//UPDATE book2020 SET b_name=?, b_author=?, b_publish=?
			//WHERE b_no =2
			int result = 0;
			result = bookApp.bDao.bookUpdate(pbVO);// create method Ű�� Dao�� �ڵ����� �޼ҵ� ����
			rbVO.setReuslt(result);
		}
		else if(_SEL.equals(command)) {
			//SELECT b_no, b_name, b_author, b_publish FROM book2020
			//WHERE b_no=3
			rbVO = bookApp.bDao.bookDetail(pbVO);// create method Ű�� Dao�� �ڵ����� �޼ҵ� ����
		}
		return rbVO;
	}////send
	//��ü ��ȸ
	public List<BookVO> sendALL(BookVO pbVO){
		System.out.println("sendALL ȣ�� ����");
		List<BookVO> bList = null;
		String command = pbVO.getCommand();//all�� ���޵ȴ�.
		if(_ALL.equals(command)) { // �� ��ü��ȸ�� �����Ŵ�?
			//������� ������ �о����� ���⼭ DB������ ������ �ʴ´�. ������ BookDao�ʿ��� �Ѵ�.
			bList = bookApp.bDao.bookList(pbVO);// create method Ű�� Dao�� �ڵ����� �޼ҵ� ����
			
		}
		return bList;
	}
}
