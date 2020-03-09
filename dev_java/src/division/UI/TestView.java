package division.UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestView extends JFrame {
	TestSouth ts = new TestSouth();
	//TestEvent에게 ts를 넘기면 TestSouth만 누릴수 있지만 this를 넘기면 TestView와 TestSouth 모두 누릴수 있다.
	TestEvent te = new TestEvent(this);
	//TestSouth ts2 = new TestSouth(this); this를 넣게되면 
	JPanel jp_north = new JPanel();
	JButton jbtn_change = new JButton("변경");
	
	public TestView() {
		initDisplay();
	}
	
	public void initDisplay() {
		//코드의 가독성이 좋아짐
		ts.jtf_msg.addActionListener(te); // 사우스에서 해야할 일 즉 이벤트 처리를 이벤트에서 하게 된다.
		jbtn_change.addActionListener(te); // te에 있는 ActionListener에 이벤트 처리-버튼 실행
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));//패널의 정열
		jp_north.add(jbtn_change); //버튼 붙임
		this.add("North",jp_north); // 변경버튼을 붙을 패널
		this.add("South",ts); // JPanel을 상속받은 TestSouth 클래스의 JTextField를 불러옴 ts주소번지
	//	this.add("South",ts.jtf_); // JPanel을 상속받은 TestSouth 클래스의 JTextField를 불러옴 ts주소번지
		this.setVisible(true);
		this.setTitle("View");
		this.setSize(500, 500);
	}
	
	public static void main(String[] args) {
		new TestView();
		
	}
}
