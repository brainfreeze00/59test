package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView extends JFrame { //상속 JFrame 메소드 이용가능 고로 주소번지.를 지워도 된다
		BaseBallGameLogic bbLogic = new BaseBallGameLogic(); //전변
	//화면과 관련된 코드추가 시작
		//JMenuBar는 JFrame안에 메뉴바를 추가하기
		JMenuBar jmb_bbgame = new JMenuBar();
		//JMenu는 JMenuBar안에 들어갈 메뉴 추가하기
		JMenu       jm_game = new JMenu("게임");
		//JMenuItem은 JMenu아래에 들어갈 메뉴내용들..
		JMenuItem   jmi_next = new JMenuItem("다음겜");
		JMenuItem   jmi_clear = new JMenuItem("지우기");
		JMenuItem   jmi_dap= new JMenuItem("정답");
		JMenuItem   jmi_oracle = new JMenuItem("오라클테스트");
		JMenuItem   jmi_exit = new JMenuItem("나가기");
		JMenu       jm_info = new JMenu("도움말");
		JTextArea jta_display = new JTextArea("");
		JScrollPane jsp_display = new JScrollPane(jta_display);
		JTextField jtf_input = new JTextField(); //jta_area 없음 
		JButton    jbtn_next = new JButton("다음겜");
		JButton    jbtn_clear = new JButton("지우기");
		JButton    jbtn_hint = new JButton("힌트");
		JButton    jbtn_dap = new JButton("정답");
		JButton    jbtn_exit = new JButton("나가기");
		//JTextArea와 JTextField를 붙일 속지 추가하기
		JPanel     jp_center = new JPanel();
		//버튼 4개를 붙일 속지 추가하기
		JPanel     jp_east   = new JPanel();
		String mem_name = null;
		String result[] = null; // 전역변수 선언
		//전역변수를 선언하여 문제를 해결할 수있어요.
		//생성자의 파라미터로 배열의 주소번지를 받게 되는데 이 값을 사용하는 곳이
		//생성자 안에서가 아니라 initDisplay메소드 안에 setTitle 메소드에서
		//사용해야하기 때문에 파라미터로 넘어온 값을 반드시 전변과 초기화해야 합니다
		//파라미터자리는 변수를 선언하는 자리 입니다.
		//초기화는 일어나지 않아요  - 생성하는 자리가 아닙니다.
		public BaseBallGameView(String result[]) {
			this.result = result;  //result는 같은가? 다른건가?
			if(this.result==null) { //this.result 전변
				this.result = new String[2]; //null 전변에 대해 인스턴스
				this.result[0] = ""; // 전변에 대해 초기화
				this.result[1] = ""; // 전변에 대해 초기화
			}
 			System.out.println("로그인 정보 "+this.result[0]+","+this.result[1]);
			//생성자 안에서 메소드를 호출하면 인스턴스화 없이도 호출이 가능하다.
			if(this.result[0]!=null) { // 결국 result[0]도 전변에 있는게 됨
				//initDisplay에 result[]를 매개변수 넘긴다. 
				initDisplay(); // 
				bbLogic.ranCom(); // 호출
			}
		}
		/////////////////화면처리시작///////////////////////
		public void initDisplay() {
			//이벤트소스와 이벤트처리 클래스 매핑
			/*이전 버전에서는 friday0131소스 이벤트처리를 직접 하였다. -ActionListener  
			 */
			//디폴트 생성자는 JVM이 만들어줄수 있어요. 왜냐하면 파라미터가 없기 때문이죠
			//파라미터가 있는 생성자는 내가 대신해 줄수 없다. 왜냐면 네 생각을 난 알수없으니까
			BaseBallGameEvent bbEvent = new BaseBallGameEvent(this); //인스턴스화  복습 지변
			jtf_input.addActionListener(bbEvent);
			jbtn_clear.addActionListener(bbEvent); //이벤트와 연결해주는 곳 
			jbtn_dap.addActionListener(bbEvent); //이벤트와 연결해주는 곳 
			jbtn_next.addActionListener(bbEvent);
			jbtn_exit.addActionListener(bbEvent);
			jmi_oracle.addActionListener(bbEvent);
			jmi_exit.addActionListener(bbEvent);
			//System.out.println("화면처리 시작");
			jp_center.setLayout(new BorderLayout());
			jp_center.add("Center",jsp_display);		
			jp_center.add("South",jtf_input);
			jp_east.setLayout(new GridLayout(5,1));
			jbtn_next.setBackground(new Color(158,9,9)); //Color 3번째꺼로 import
			jbtn_next.setForeground(new Color(212,212,212)); //Color 3번째꺼로 import
			jbtn_clear.setBackground(new Color(7,84,170)); 
			jbtn_clear.setForeground(new Color(212,212,212)); 
			jbtn_dap.setBackground(new Color(27,48,50)); 
			jbtn_dap.setForeground(new Color(212,212,212));
			jbtn_exit.setBackground(new Color(57,94,70)); 
			jbtn_exit.setForeground(new Color(250,180,200)); 
			jp_east.add(jbtn_next);
			jp_east.add(jbtn_clear);
			jp_east.add(jbtn_hint);
			jp_east.add(jbtn_dap);
			jp_east.add(jbtn_exit);
			add("Center", jp_center);
			add("East",jp_east);
			/////////////////////메뉴바 추가시작/////////////////////
			jm_game.add(jmi_next);
			jm_game.add(jmi_clear);
			jm_game.add(jmi_dap);
			jm_game.add(jmi_oracle);
			jm_game.add(jmi_exit);
			//메뉴를 메뉴바에 붙여요
			jmb_bbgame.add(jm_game);
			jmb_bbgame.add(jm_info);
			//jf_bbgame의 setJMenuBar 
			setJMenuBar(jmb_bbgame);
			/////////////////////메뉴바 추가끝/////////////////////
			//jf_bbgame의 setTitle에서 result[0],result[1]를 매개변수로 넘긴다.
			setTitle("야구숫자게임-"+result[0]+"["+result[1]+"]");
			//jf_bbgame의 setSize 조정 매개변수 600,600 
			setSize(600, 600);
			//jf_bbgame의 setVisible 매개변수 true  - true(창보임) false(창안보임) 의미  
			setVisible(true);
		}
		///화면처리끝
	public static void main(String[] args) { //화면이 있어야 게임이 가능
		 new BaseBallGameView(null);
	}
		/* object oriented programming   ?
		 * procedural programming    ?
		 * 서로 연관되어 있는 함수와 변수들을 객체화 하는 것으로 그룹핑하고 사용한다.
		 * 모듈에 함수들을 담음으로써 정리정돈해서 복잡한 코드를 단순화
		 * 객체 Object - 클래스 + 인스턴스(예제) 
		 * class 를 복제해서 인스턴스(클래스와 똑같은 변수와 함수를 갖게됨)를 만들고 
		 * 인스턴스 
		 */
}
