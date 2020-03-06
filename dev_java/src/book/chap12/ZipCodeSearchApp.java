package book.chap12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.ZipCodeVO;
import oracle.jdbc2.JDBCTest;
public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
	String zdos[] = null; // 
	String zdo = null;
	JComboBox jcb_zdo = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection          con = null; // 전역변수선언하기 - 클래스 전역에서 사용가능함.
	PreparedStatement pstmt = null;
	ResultSet      rs       = null;
	JTextField     jtf_dong = new JTextField("동이름을 입력하세요"); // 검색상자
	JButton     jbtn_search = new JButton("조회");
	JButton     jbtn_del 	= new JButton("삭제");
	
	String            cols[] = {"주소","우편번호"}; // 컬럼들
	String          data[][] = new String[0][2]; 
	DefaultTableModel dtm_zip = new DefaultTableModel(data,cols); // 파라미터 2개를 받아서 초기화를 할수있다.
	JTable            jt_zip  = new JTable(dtm_zip);//dtm은 데이터를 갖고있고 테이블은 양식은 있지만 데이터가 없다 그래서 만났다
	JScrollPane       jsp_zip = new JScrollPane(jt_zip);
	JTableHeader     jth_zip   = new JTableHeader();
	JFrame            jf_zip   = new JFrame(); //운영체제위에 창을 띄운다.
	JPanel            jp_north = new JPanel(); //속지를 만들어준다.
	
	public ZipCodeSearchApp() {
		zdos = getZDOList(); //내안에 있는 메소드이니까 인스턴스 안하고 바로 호출
		jcb_zdo = new JComboBox(zdos);
		System.out.println("나는 파라미터가 없는 디폴트 생성자라고 해.");
		System.out.println("나는 인스턴스화하면 자동으로 호출 되는거야");
	}
	public ZipCodeSearchApp(String str, int i) {		
	}
	//Map으로 적용
	public List<Map<String, Object>> refreshData(String zDO,String myDong) { // 메소드 선언부
		con = dbMgr.getConnection(); // con을 받아야 
		System.out.println("refreshData호출성공"+myDong+","+zDO);
		StringBuilder sql = new StringBuilder(); // StringBuilder
		sql.append(" SELECT address, zipcode");
		sql.append(" FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zDO!=null && zDO.length()>0) {
			sql.append(" AND zdo=? ");  // ? 로적어 			
		}
		if(myDong!=null && myDong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");  // ? 로적어 			
		}
		int i = 1;
		 List<Map<String, Object>>  addrList = new ArrayList<>(); // 인스턴스  
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(zDO!=null && zDO.length()>0) {
				pstmt.setString(i++, zDO);  // ? 로적어
				} 
			if(myDong!=null && myDong.length()>0) {
				pstmt.setString(i++, myDong); //?들어갈 동이름이 결정됨.				 			
			}
			rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
			addrList = new Vector<>(); // 인스턴스
			Map<String, Object> rMap = null; 
			while(rs.next()) { //커서이동, 커서이동
				rMap = new HashMap<>();
				rMap.put("address",rs.getString("address")); //직관적으로 하기위해 "address"
				rMap.put("zipcode",rs.getInt("zipcode")); //직관적으로 하기위해 "address"
				addrList.add(rMap); // n건을 밀어넣어주고
			}
			System.out.println("v.size():"+addrList.size());
			if(addrList.size()>0) {
				while(dtm_zip.getRowCount()>0) {
					dtm_zip.removeRow(0);
				}//중복되지않고 새로 출력되는 코드
				for(int x=0; x<addrList.size();x++) {
					Map<String, Object> map = addrList.get(x);
					Vector oneRow = new Vector(); // 한개로우씩 넣어주고 싶어서 
					oneRow.add(0, map.get("address"));//addRow메소드가 받아준다
					oneRow.add(1, map.get("zipcode"));//addRow메소드가 받아준다
					dtm_zip.addRow(oneRow);
				}
			}
		}catch(SQLException se) {
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//그밖에 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
		return addrList;
	} // Map을 적용해 보아라
	public void intiDisplay() {
		jcb_zdo.addItemListener(this); // 화면에 addItemListener을 적용
		jbtn_search.requestFocus(); // 버튼을 포커스로 옮김
		jtf_dong.addFocusListener(this);
		System.out.println("initDisplay 호출 성공");
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(22,22,100));//파라미터를 추가해서 표현
		jth_zip.setForeground(Color.white); // 색지원
		jth_zip.setFont(new Font("맑은고딕",Font.BOLD,20));//파라미터3개 필요 글꼴, 글두께, 글자크기
		jt_zip.setGridColor(Color.BLUE); //그리드 색상
		jt_zip.setRowHeight(20);
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350); //컬럼
		jt_zip.setSelectionBackground(new Color(186,186,241));
		jt_zip.setSelectionForeground(new Color(22,22,241));
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.green);
		jp_north.add(jcb_zdo);
		jp_north.add(jtf_dong);
		jp_north.add(jbtn_search); // 버튼 붙임 라벨은 조회하고 
		jp_north.add(jbtn_del); //버튼 붙음 삭제버튼
		jbtn_search.addActionListener(this); // 나자신을 가리키는 예약어  서치버튼 이벤트 처리활성
		jbtn_del.addActionListener(this); // 삭제 버튼 이벤트 처리활성
		jtf_dong.addActionListener(this);
		jf_zip.setTitle("우편번호 검색");
		jf_zip.add("North", jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	
		
	void actionPerformed(){
		
	}
	public String[] getZDOList() {
		String zdos[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select '전체' zdo from dual  ");
		sb.append("union all                   ");
		sb.append("select zdo                  ");
		sb.append("from (                      ");
		sb.append("select distinct(zdo) zdo    ");
		sb.append("from zipcode_t              ");
		sb.append("order by zdo asc)           ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
	//stack 영역에 관리되는 에러메세지 정보를 라인번호와 이력까지 출력해줌
			e.printStackTrace();
		}
		return zdos;
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearchApp zipAPP = new ZipCodeSearchApp();
		zipAPP.intiDisplay();
	}
	//
	@Override
	public void actionPerformed(ActionEvent ae) { //오버라이드  재정의가 가능함 -기능을 바꿈
		//이벤트가 감지된 버튼의 주소번지를  읽어오는 메소드임.
		Object obj = ae.getSource();
		if((obj == jbtn_search)||(obj == jtf_dong)) {
			String myDong = jtf_dong.getText();
			String zDO = zdos[jcb_zdo.getSelectedIndex()];
			refreshData(zDO, myDong); //타입 개수가 달라서 오류뜸
		}
		else if(obj == jbtn_del) { //삭제 이벤트
			int index[]  = jt_zip.getSelectedRows(); // 
			for(int row:index) {   //row번호 index주소번호
				JOptionPane.showMessageDialog(jf_zip, row);
			}
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==jtf_dong) {//포커스가 이동했을때 감지해야함
			jtf_dong.setText(""); // 문자를 넣어주세요
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == jcb_zdo) { //콤보박스가 일어났다는 뜻
			if(e.getStateChange()==ItemEvent.SELECTED) {// 선택되었는가?
				System.out.println(zdos[jcb_zdo.getSelectedIndex()]); // 리턴타입 int
				zdo = zdos[jcb_zdo.getSelectedIndex()];
				
			} //zdos[]에 넣은이유 저장된 값을 출력
		}
	} // End of ZipCodeSearchApp
}
