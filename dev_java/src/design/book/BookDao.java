package design.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class BookDao {
	DBConnectionMgr dbMgr 	= DBConnectionMgr.getInstance();
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	
	public int bookDelete(BookVO pbVO) {
		System.out.println("bookDelete");
		int result = 0;
		result = 1;
		return result;
	}

	/*
	 * INSERT into book2020(b_no, b_name, b_author
                    , b_publish, b_info)
               VALUES(seq_book_no.nextval,'1'
               ,'1','1','1')
	�Ķ���ͷ� 1�� 4�� �����ؼ� �߰��غ�. �Ķ���ʹ� 4���� �ʿ��ϴ�
	1�� row�� inserted => 1 �����ϸ� 0
	 */
	public int bookInsert(BookVO pbVO) {
		System.out.println("bookInsert");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append ("INSERT into book2020(b_no, b_name, b_author        ");
            sql.append ("        			, b_publish, b_info)            ");
            sql.append ("   			VALUES(seq_book_no.nextval,?,?,?,?) ");
            con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 1;
			pstmt.setString(i++, pbVO.getB_name());
			pstmt.setString(i++, pbVO.getB_author());
			pstmt.setString(i++, pbVO.getB_publish());
			pstmt.setString(i++, pbVO.getB_info());
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);//1�̸� �Է� ����, 0�̸� �Է� ����
		} catch (Exception e) {
			e.toString();
		}
		return result;
	}
	
	public int bookUpdate(BookVO pbVO) {
		int result = 0;
		System.out.println("bookUpdate");
		result = 1;
		return result;
	}

	public BookVO bookDetail(BookVO pbVO) {
		System.out.println("bookDetail");
		BookVO rbVO = null; 
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT b_no, b_name, b_author, b_publish");
			sql.append(" ,b_info FROM book2020                           ");
			sql.append(" WHERE b_no=?                           ");//2
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			//insert ����ǥ�ڸ��� �ֱ�
			pstmt.setInt(1, pbVO.getB_no());
			rs = pstmt.executeQuery();
			if(rs.next()) { // ������ �Ѱ��̶� while���� if�� �ٲٰ� ����Ʈ ���� 
				rbVO = new BookVO();
				rbVO.setB_no(rs.getInt("b_no"));
				rbVO.setB_name(rs.getString("b_name"));
				rbVO.setB_author(rs.getString("b_author"));
				rbVO.setB_publish(rs.getString("b_publish"));
				rbVO.setB_info(rs.getString("b_info"));
			}
			System.out.println("rbVO : "+rbVO.getB_info());
		} catch(SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]"+ sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rbVO;
	}
	//��ü��ȸ ����
	public List<BookVO> bookList(BookVO pbVO) {//���� all�� ����ִ�. , ���ǰ˻��Ѵٸ� b_no, b_name�� ������ ������ �ִ�.
		System.out.println("bookList() ȣ�⼺��");
		List<BookVO> bookList = new ArrayList<>(); //bookList.size()=0
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT b_no, b_name, b_author, b_publish");
			sql.append(" FROM book2020                           ");
			sql.append(" ORDER BY b_no desc                           ");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			BookVO rbVO = null; 
			while(rs.next()) {
				rbVO = new BookVO();
				rbVO.setB_no(rs.getInt("b_no"));
				rbVO.setB_name(rs.getString("b_name"));
				rbVO.setB_author(rs.getString("b_author"));
				rbVO.setB_publish(rs.getString("b_publish"));
				bookList.add(rbVO);
			}
			System.out.println("bookList.size() : "+bookList.size());
		} catch(SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]"+ sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}//////////////bookList
	public static void main(String[] args) {
		BookDao bd = new BookDao();
		BookVO pbVO = new BookVO();
		pbVO.setB_name("1");
		pbVO.setB_author("2");
		pbVO.setB_publish("3");
		pbVO.setB_info("4");
		bd.bookInsert(pbVO);
		int result = 0;
		result = bd.bookInsert(pbVO);
		System.out.println("result:"+result);
	}
}
