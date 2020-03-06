package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

public class OrderBasketDAO {
	
	//識情
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	
	//持失
	public OrderBasketDAO() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
