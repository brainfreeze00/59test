package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

public class OrderBasketDAO {
	
	//����
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	
	//����
	public OrderBasketDAO() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
