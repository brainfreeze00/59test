package special;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.util.DBConnectionMgr;

import friday0207.BaseBallGameView;

public class Programming implements ActionListener {
	//선언부
		Connection          con = null; //물리적으로 떨어져있는 서버와 연결통로만들기
		PreparedStatement pstmt = null; //동적쿼리 작성하기 - ?
		ResultSet            rs = null;
		//싱클톤 패턴을  활용하여 객체 주입받기 - 하나로 나누어 쓴다.
		DBConnectionMgr   dbMgr = DBConnectionMgr.getInstance();//friendly 상태는 서로 다른 패키지는 접근 불가 
		JFrame jf_login  		= new JFrame();
		JPanel jp_first  		= new JPanel();
		//jp_first 속지안에 서쪽에 jlb_id, 중앙에 jtf_id
		JLabel jlb_id 			= new JLabel("아 이 디");
		JTextField jtf_id 		= new JTextField();
		JPanel jp_second 		= new JPanel();
		JTextField jtf_pw 		= new JTextField();
		JLabel jlb_pw			= new JLabel("비밀번호");
		JPanel jp_third  		= new JPanel();
		JButton jbtn_login      = new JButton("로그인");
		//생성자
		Programming() {
			initDisplay();
		}
		//메소드
		public String[] login(String id, String pw) {
			String result[] = new String[2];
			String db_id = null; // 이 아이디는 디비에서 가져온것 db_
			String mem_name = null;
			String status = null;
			StringBuilder sb = new StringBuilder("");
			StringBuilder sb2 = new StringBuilder("");
			try { //계정변경및 다른 변수에 따라서 변경되어야 마땅하다.
				sb.append("	SELECT                       ");
		        sb.append("	NVL((SELECT 1 FROM member    ");
		        sb.append("	   WHERE mem_id = ?) 		 ");
		        sb.append("	   ,-1) status 				 ");	        
		        sb.append("	   FROM dual                 ");
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {//조회결과가 있는거야? 정훈 : next - 커서이동능력, 커서꺼
					status = rs.getString("status");
				}
				System.out.println("status:"+status);
				if("1".equals(status)) {//아이디가 존재하니?
				sb2.append("	SELECT                               ");
			    sb2.append("    NVL((SELECT mem_name                 "); //신뢰도를 위해서 디비에서 꺼내오기
			    sb2.append("         FROM   member                   ");
			    sb2.append("         WHERE  mem_id = ?               ");
			    sb2.append("         AND    mem_pw = ?),0) mem_name  ");
			    sb2.append(" FROM dual                               ");
			    pstmt = null;
			    pstmt = con.prepareStatement(sb2.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = null;
				rs = pstmt.executeQuery();
				if(rs.next()) {
					mem_name = rs.getString("mem_name");
					db_id = id;
					result[0] = mem_name; //첫번째 방에 이름을 담았다.
					result[1] = db_id; //두번째방에 사용자가 입력한 아이디를 담았다.
				}
				if(mem_name.equals("0")) {
					result[0] = "비밀번호가 맞지 않습니다."; //mem_name을 내비두면 출력이 안됨 초기화
				}
				}
				else if("-1".equals(status)) {//아이디가 없는건가?
					result[0] = "아이디가 존재하지 않습니다."; // mem_name 내비두면 출력이 안됨 초기화
				}
			} catch (Exception e) {
				e.printStackTrace();//e.printStackTrace(); 이넘은 외워서라도 알고있어야함 
				System.out.println("sql:"+sb.toString());
				System.out.println(e.toString());//예외가 발생하면 힌트를 얻을수 있어용
			}
			return result;
		}
		public void initDisplay() {
			jbtn_login.addActionListener(this);
			jf_login.setLayout(new GridLayout(3,1));
			
			jp_first.setBackground(Color.green);
			jp_first.setLayout(new BorderLayout());
			jp_first.add("West",jlb_id);
			jp_first.add("Center",jtf_id);
			
			jp_second.setBackground(Color.gray); // 비밀번호 배경색
			jp_second.setLayout(new BorderLayout());
			jp_second.add("West",jlb_pw);
			jp_second.add("Center",jtf_pw);
			
			jp_third.setBackground(Color.red);	
			jp_third.add(jbtn_login);
			
			jf_login.add(jp_first);
			jf_login.add(jp_second);
			jf_login.add(jp_third);
			jf_login.setSize(500, 500); 
			jf_login.setVisible(true);
		}
	public static void main(String[] args) {
		Programming p = new Programming();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//Object obj = new Object();
		//로그인 버튼을 누른거야?
		if(obj == jbtn_login) {
			String u_id = jtf_id.getText();//텍스트 필드에 입력한 아이디
			String u_pw = jtf_pw.getText();//텍스트 필드에 입력한 비번
			String result[] = login(u_id,u_pw);
			System.out.println("mem_name :"+result[0]);
			if(result[0].equals("비밀번호가 맞지 않습니다.") // 83
					||result[0].equals("아이디가 존재하지 않습니다.")) { // 86
					JOptionPane.showMessageDialog(jf_login, result[0]);//단순한 알림창을 띄울 수 있는 함수다.
			//if문에서 return을 만나면 그 메소드를 탈출 할 수 있다.
					return;
			}
			else {
				new BaseBallGameView(result); //str에서 배열로 바껴서 에러 고로 업데이트
				jf_login.dispose(); //로그인성공시 로그인창자동으로 닫히고 야구게임온
			}
		}
	}

}
