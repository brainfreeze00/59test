package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class SeoulTempDAO {
/*
 * ���� ��� ��� �����κ��� �ֱ� 10�� �⵵ ��������
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
				String year = rs.getString("to_year"); // sb���� ��ġ�ϰ� �����
				v.add(year);
			}
			years = new String[v.size()];
			v.copyInto(years);
		} catch (Exception e) {
	//stack ������ �����Ǵ� �����޼��� ������ ���ι�ȣ�� �̷±��� �������
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
				String month = rs.getString("to_month"); // sb���� ��ġ�ϰ� �����
				v.add(month);
			}
			 months = new String[v.size()];
			v.copyInto(months);
		} catch (Exception e) {
	//stack ������ �����Ǵ� �����޼��� ������ ���ι�ȣ�� �̷±��� �������
			e.printStackTrace();
		}
		return months;
	}
}
