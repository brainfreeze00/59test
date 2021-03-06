package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	JLabel jlb_name = new JLabel("도서명");
	JTextField jtf_name = new JTextField(20);
	JLabel jlb_author = new JLabel("저자");
	JTextField jtf_author = new JTextField(20);
	JLabel jlb_publish = new JLabel("출판사");
	JTextField jtf_publish = new JTextField(20);
	JLabel jlb_info = new JLabel("도서소개");
	JTextField jtf_info = new JTextField(20);
	JTextArea jta_info = new JTextArea(8,25);
	JScrollPane jsp_info = new JScrollPane(jta_info);
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_close = new JButton("닫기");
	JScrollPane jsp = new JScrollPane(jp_center);
	BookVO rbVO = null;
	
	public BookDialog() { // 크리에이트 생성자 한거임 
		jbtn_save.addActionListener(this); //저장  이벤트
		jbtn_close.addActionListener(this); //닫기 이벤트 
	}
	//입력과 수정시에는 컬럼값을 수정 가능하도록 하고
	//조회시에는 불가능하게 하는 메소드를 선언해봐요.
	public void setEditable(boolean isOk) {
		jtf_name.setEditable(isOk); // 꺼주세요 or 키기
		jtf_author.setEditable(isOk); // 꺼주세요 or 키기
		jtf_publish.setEditable(isOk); // 꺼주세요 or 키기
		jta_info.setEditable(isOk); // 꺼주세요 or 키기
		
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
	public void set(String title, boolean isView, boolean editable, BookVO rbVO, BookApp ba) {
		this.ba = ba; // 초기화
		this.rbVO = rbVO;
		setValue(rbVO); // 입력 | 수정, 상세
		setEditable(editable); //실행됐을때 되야하니
		this.setTitle(title);//생성자로는 시간차가 발생하므로 직접 메소드에 기입한다
		this.setVisible(isView);//생성자로는 시간차가 발생하므로 직접 메소드에 기입한다
		initDisplay(); // 사이즈 유지위해서 호출
		
	}
	//조회된 결과를 BookDialog에 초기화하기
	//새로 입력하는 경우에는 빈 문자열로 초기화하기
	/*******************************************
	 * BookApp에서 조회된 한 건을 BookDialog에 초기화함.
	 * @param rmap 조회된 한 건을 Map으로 받은 경우
	 *****************************************************/
	public void setValue(Map<String, Object> rmap) { //rmap이 있을때 호출
		//입력을 위한 화면 설정 - 모든 값을  빈문자열로 셋팅한다.
		if(rmap == null) {
			setB_name("");
			setB_author("");
			setB_publish("");
			setB_info("");
		}
		//상세조회와 수정시는 파라미터로 받은 값으로 셋팅한다.
		//처음 설계시에는 맵으로 했던걸 어제 bVO로 추가 처리 함.
		else{
			setB_name(rmap.get("b_name").toString());
			setB_author(rmap.get("b_author").toString());
			setB_publish(rmap.get("b_publish").toString());
			setB_info(rmap.get("b_info").toString());
		}
	}
	/*******************************************
	 * BookApp에서 조회된 한 건을 BookDialog에 초기화함.
	 * @param rbVO 조회된 한 건을 BookVO로 받은 경우
	 *****************************************************/
	private void setValue(BookVO rbVO) {
		//입력을 위한 화면 설정 - 모든 값을  빈문자열로 셋팅한다.
				if(rbVO == null) {
					setB_name("");
					setB_author("");
					setB_publish("");
					setB_info("");
				}
				//상세조회와 수정시는 파라미터로 받은 값으로 셋팅한다.
				else{
					setB_name(rbVO.getB_name());
					setB_author(rbVO.getB_author());
					setB_publish(rbVO.getB_publish());
					setB_info(rbVO.getB_info());
				}
		
	}
	public void initDisplay() { //나중에 쓸일 있어서 내비둠
		//TextArea에 자동 줄바꿈 처리해보기
		jta_info.setLineWrap(true);//jtextarea.info.줄바꿈 메소드 호출
		//속지에 레이아웃이 FlowLayout이었던것을 null로 초기화함
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		//화면에 배치할때 setBounds (x좌표, y좌표, 가로길이, 세로길이)
		//앞에 두 자리가 시작점 좌표값
		//세번째 네번째가 가로 세로결정
		jlb_name.setBounds(20, 20, 100, 20);
		jtf_name.setBounds(120, 20, 200, 20);
		jlb_author.setBounds(20, 45, 100, 20); //5는 여백
		jtf_author.setBounds(120, 45, 120, 20);
		jlb_publish.setBounds(20, 70, 100, 20);
		jtf_publish.setBounds(120, 70, 150, 20);
		jlb_info.setBounds(20, 95, 100, 20);
		jsp_info.setBounds(120, 95, 300, 160); // scroll에 담는거임 그리고 300은 125자이므로 늘리고 160은 정보글이 많으니 늘림
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_author);
		jp_center.add(jtf_author);
		jp_center.add(jlb_publish);
		jp_center.add(jtf_publish);
		jp_center.add(jlb_info);
		jp_center.add(jsp_info);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setSize(500, 450);
		//this.setVisible(true); //테스트용임 테스트할때만 열어라
		//부모창에서 선택한 버튼에 따라 화면을 제어한다. - 변수
	}
	
	//각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 입니다.
	public String getB_name() { return jtf_name.getText();}
	public void setB_name(String name) {jtf_name.setText(name);}
	public String getB_author() {return jtf_author.getText();}
	public void setB_author(String author) {jtf_author.setText(author);}
	public String getB_publish() {return jtf_publish.getText();}
	public void setB_publish(String publish) {jtf_publish.setText(publish);}
	public String getB_info() {return jta_info.getText();}
	public void setB_info(String info) {jta_info.setText(info);}
	
//	public static void main(String[] args) {
//		BookDialog bd = new BookDialog();
//		bd.set("입력",true,true,new HashMap<>(),null);
//		bd.initDisplay();
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//이벤트 처리
		String command = e.getActionCommand(); //이벤트소스의 라벨을 읽어옴
		JOptionPane.showMessageDialog(ba, "이벤트 소스 라벨:"+command);
		//저장버튼을 누른거니?
		if("저장".equals(command)) {
			//insert here - 입력 인지 수정인지 어떻게 구분하지?
			if(rbVO!=null) {//수정처리
				
			}else {//입력처리
				int result = 0;
				BookVO pbVO = new BookVO();
				pbVO.setB_name(getB_name());//입력한 도서명 가져오기
				pbVO.setB_author(getB_author());//저자이름
				pbVO.setB_publish(getB_publish());//출판사
				pbVO.setB_info(getB_info());//상세정보
				result = ba.bDao.bookInsert(pbVO);
				JOptionPane.showMessageDialog(ba, "result"+result);
			}
			ba.refreshData();
			this.dispose();
		}
		//닫기버튼을 누른거니?
		else if("닫기".equals(command)) {
			this.dispose();
		}
		
	}//action
}
