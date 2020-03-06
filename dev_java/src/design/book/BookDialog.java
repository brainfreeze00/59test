package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BookDialog extends JDialog implements ActionListener {
	/*자녀창에서 저장(입력) 성공했을때 부모창의 refreshData를 호출해야 한다.
	 * 그런데 원본을 재사용해야 하므로 set메소드의 파라미터로 받아서 사용할 것이다.
	 * 다른 메소드에서 ba를 사용해야 하니까 전역변수로 선언한 다음 초기화를 반드시 할것
	 */
	BookApp ba = null; 
	boolean isView = false;
	String title = null;
	//인스턴스화를 하면 생성자 호출이 일어남
	JLabel jlb_title = new JLabel("책제목");
	JLabel jlb_author = new JLabel("저자");
	JLabel jlb_publish = new JLabel("출판사");
	JTextField jtf_title = new JTextField(20);
	JTextField jtf_author = new JTextField(20);
	JTextField jtf_publish = new JTextField(20);
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_close = new JButton("닫기");
	JScrollPane jsp = new JScrollPane(jp_center);
	
	public BookDialog() { // 크리에이트 생성자 한거임 
		jbtn_save.addActionListener(this); //저장  이벤트
		jbtn_close.addActionListener(this); //닫기 이벤트 
	}
	//입력과 수정시에는 컬럼값을 수정 가능하도록 하고
	//조회시에는 불가능하게 하는 메소드를 선언해봐요.
	public void setEditable(boolean isOk) {
		jtf_title.setEditable(isOk); // 꺼주세요 or 키기
		jtf_author.setEditable(isOk); // 꺼주세요 or 키기
		jtf_publish.setEditable(isOk); // 꺼주세요 or 키기
		
	}
	/**********************************
	 * @param title 다이얼로그창 제목
	 * @param isView 다이얼로그창 뷰 여부
	 * @param editable 입력 컴포넌트 수정여부
	 * @param rMap 조회결과를 담은 주소번지
	 ***********************************/
	//생성자로는 시간차가 발생하므로 직접 메소드에 기입한다
	public void set(String title,boolean isView
			,boolean editable, Map<String,Object> rMap, BookApp ba){
		this.ba = ba; // 초기화
		setValue(rMap); // 입력 | 수정, 상세
		setEditable(editable); //실행됐을때 되야하니
		this.setTitle(title);//생성자로는 시간차가 발생하므로 직접 메소드에 기입한다
		this.setVisible(isView);//생성자로는 시간차가 발생하므로 직접 메소드에 기입한다
		initDisplay(); // 사이즈 유지위해서 호출
	}  
	public void initDisplay() { //나중에 쓸일 있어서 내비둠
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		jlb_title.setBounds(20, 20, 100, 20);
		jtf_title.setBounds(120, 20, 150, 20);
		jlb_author.setBounds(20, 80, 100, 20);
		jtf_author.setBounds(120, 80, 150, 20);
		jlb_publish.setBounds(20, 140, 100, 20);
		jtf_publish.setBounds(120, 140, 150, 20);
		jp_center.add(jlb_title);
		jp_center.add(jlb_author);
		jp_center.add(jlb_publish);
		jp_center.add(jtf_title);
		jp_center.add(jtf_author);
		jp_center.add(jtf_publish);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setSize(500, 450);
		//부모창에서 선택한 버튼에 따라 화면을 제어한다. - 변수
	}
	public void setValue(Map<String, Object> rmap) { //rmap이 있을때 호출
		//입력을 위한 화면 설정 - 모든 값을  빈문자열로 셋팅한다.
		if(rmap == null) {
			setB_Title("");
		}
		//상세조회와 수정시는 파라미터로 받은 값으로 셋팅한다.
		else{
			setB_Title(rmap.get("b_title").toString());
			setB_Title(rmap.get("b_author").toString());
			setB_Title(rmap.get("b_publish").toString());
		}
	}
	//각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 입니다.
	public String getB_Title() { return jtf_title.getText();}
	public void setB_Title(String title) {jtf_title.setText(title);}
//	public static void main(String[] args) {
//		BookDialog bd = new BookDialog();
//		bd.set("입력",true,null);
//		bd.initDisplay();
//	}
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 처리
		String command = e.getActionCommand(); //이벤트소스의 라벨을 읽어옴
		JOptionPane.showMessageDialog(ba, "이벤트 소스 라벨:"+command);
		//저장버튼을 누른거니?
		if("저장".equals(command)) {
			this.dispose();
			//insert here - 입력 인지 수정인지 어떻게 구분하지?
			ba.refreshData();
		}
		//닫기버튼을 누른거니?
		else if("닫기".equals(command)) {
			
		}
	}
}
