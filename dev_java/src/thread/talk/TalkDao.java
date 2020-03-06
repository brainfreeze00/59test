package thread.talk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import thread.bank.CustomerDao;
import thread.bank.DBConnectionMgr;

public class TalkDao {
	DBConnectionMgr dbMgr 	= DBConnectionMgr.getInstance();
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	public Map<String, Object> login(String mem_id){//id를 파라미터로 받아옮
		Map<String, Object> rMap = null;
		StringBuilder sql = new StringBuilder();
		try {
		sql.append(" SELECT acc_num, balance, mem_id, mem_name    ");
		sql.append(" FROM member                                  ");
		sql.append(" WHERE mem_id = ?                     		  ");
		con = dbMgr.getConnection();
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, mem_id);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			rMap = new HashMap<String, Object>();
			rMap.put("acc_num", rs.getString("acc_num"));
			rMap.put("balance", rs.getString("balance"));
			rMap.put("mem_id", rs.getString("mem_id"));
			rMap.put("mem_name", rs.getString("mem_name"));
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :"+e.toString());
		}
		return rMap;
	}
	public static void main(String[] args) {
		CustomerDao cd = new CustomerDao();
		Map<String, Object> rMap = cd.login("sk");
		System.out.println(rMap.get("mem_name"));
	}
}
