package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class SeoulTempDAO {
/*
 * 서울 기상 통계 정보로부터 최근 10년 년도 가져오기
 */
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con 			= null;
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	
	public String[] getYearList() {
		//String years[] = {"2019","2018","2017"}; 
		String years[] = null; 
		StringBuilder sb = new StringBuilder();
		sb.append("		SELECT                                              ");
		sb.append("	      DISTINCT(TO_CHAR(TO_DATE(sdate),'YYYY')) to_year  ");
		sb.append("	    FROM seoultemp                                      ");
		sb.append("	WHERE TO_CHAR(TO_DATE(sdate),'YYYY')                    ");
		sb.append("	  > TO_CHAR(sysdate,'YYYY')-11                          ");
		sb.append("	ORDER BY TO_CHAR(TO_DATE(sdate),'YYYY')                 ");
		
		try { 
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String year = rs.getString("to_year"); // sb문에 일치하게 맞춰라
				v.add(year);
			}
			years = new String[v.size()];
			v.copyInto(years);
		} catch (Exception e) {
	//stack 영역에 관리되는 에러메세지 정보를 라인번호와 이력까지 출력해줌
			e.printStackTrace();
		}
		return years;
	}
	public String[] getMonthList() {
		String months[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("		SELECT                                            ");
		sb.append("	      DISTINCT(TO_CHAR(TO_DATE(sdate),'MM')) to_month "); 
		sb.append("	    FROM seoultemp                                    ");
		sb.append(" WHERE TO_CHAR(TO_DATE(sdate),'YYYY')=:uyear           ");
		sb.append("	ORDER BY TO_CHAR(TO_DATE(sdate),'MM')                 ");
		
		try { 
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String month = rs.getString("to_month"); // sb문에 일치하게 맞춰라
				v.add(month);
			}
			 months = new String[v.size()];
			v.copyInto(months);
		} catch (Exception e) {
	//stack 영역에 관리되는 에러메세지 정보를 라인번호와 이력까지 출력해줌
			e.printStackTrace();
		}
		return months;
	}
}
