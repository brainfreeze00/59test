package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

public class TdeptManager extends JFrame {
	
	String cols[] 		  = {"���̵�", "�����", "�μ���"}; // ȭ�� �÷���
	String data[][] 	  = new String[0][3]; // ��ũ�������� ���� ���� ����
	//�����͸� ���� ���� �̰� �־�� ȭ�鿡 �����͸� �Ѹ����ְ� data�� cols�� ���� ��ü ����
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	//ǥ��������� dtm�� ���� ��ü ���� 
	JTable jtb 			  = new JTable(dtm);
	JScrollPane jsp 	  = new JScrollPane(jtb);
	//����̹��ε� �� Connection ��ü ����
	Connection con 			= null;
	//������ ��ü ����
	PreparedStatement pstmt = null;
	//��� ���� ��ü ����
	ResultSet rs 			= null;
	//Pool�� ����ؼ� DB �����ϱ�
	DBConnectionMgr  dbMgr  = DBConnectionMgr.getInstance(); 
	//����Ʈ ������
	public TdeptManager() {
		
	}
	
	public void initDisplay() {
		this.setTitle("������� ��ȸ");
		this.add("Center",jsp);//jtb��� JScrollPane jsp �� ���Ϳ� �߰��Ͽ� �÷� ��Ÿ���� ����
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public ArrayList<TempVO> getDeptList(){ // ���ο��� �Ծ��Ѱ��� DB����ó��
		 //ArrayList<OrderBasketVO> al = null; �̰� ������ ���� �ϰ� �ʺ��� �ּ�ó���� 
			ArrayList<TempVO> al = new ArrayList<TempVO>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT emp_id, emp_name, dept_name      ");
			sql.append(" FROM temp,tdept                         ");
			sql.append(" WHERE temp.dept_code = tdept.dept_code  ");
		    try {
		    	con = dbMgr.getConnection(); //db����
		    	pstmt = con.prepareStatement(sql.toString());// ������ ��ĵ
		    	rs = pstmt.executeQuery();//select�϶� executeQuery
		    	//VO�� �ѹ��� �Ѱ� �ο츸 ���� �� �־��. �ΰ� �ο�� �ȵ���.
		    	//VO�� ���� �ϳ��� �Ѱ� ���� ��� ������ �����߱� ��������.
		    	TempVO tVO = null;
		    	while(rs.next()) {
		    		tVO = new TempVO();
		    		//����Ŭ���� ���� ���� rs�� ������ 
		    		//������ ���� ���� obVO�� ����� ���� �� indate_vc������ ����
		    		//����ּ���
		    		//�� setter �޼ҵ�� ���� �ڲٸ� ��°ž�? 
		    		tVO.setEmp_id(rs.getInt("emp_id")); //rs���� �����ö� �� ��Ʈ��
		    		tVO.setEmp_name(rs.getString("emp_name")); // rs���� �����ö� �� ��Ʈ
		    		//tVO.setDept_name(rs.getString("dept_name")); // rs���� �����ö� �� ��Ʈ
		    	    al.add(tVO); //��� ����Ʈ�� �־���ϴ� add �սô�  al = new ArrayLis();
		    	}
			} catch (SQLException se) { //����Ŭ���� �߻��Ǵ� �����޼���
				//�ڹ� ������ ��Ŭ�������� ��� ����Ŭ������ ��忡�� ��°� ���ڴ�.
				System.out.println(se.toString()); //java.sql.SQLException: �������� �� �̸� ��Ʈ��
			} catch(Exception e) {//�ڹ���õ���� �߻��Ǵ� �����޼��� ���
				System.out.println(e.toString()); //�ڹٵ� ��������
			}
			return al; // al=null; al�� null���� ���ݾ�? �׷��� al�� ���� Ȯ�� �ؾ��� ���� ��ٸ� 
		}
		
	
	public static void main(String[] args) {
		 TdeptManager tm = new TdeptManager();
		 tm.initDisplay();
	}

}
