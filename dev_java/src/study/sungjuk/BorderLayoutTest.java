package study.sungjuk;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest {
	
	JFrame jf = new JFrame(); // 디폴트 레이아웃이 BorderLayout[동서남북중앙] 1
	//버튼생성2
	JButton jbtn_north  = new JButton("북쪽");
	JButton jbtn_south  = new JButton("남쪽");
	JButton jbtn_west   = new JButton("서쪽");
	JButton jbtn_east   = new JButton("동쪽");
	JButton jbtn_center = new JButton("중앙");
	
	public BorderLayoutTest() {
		jf.add("North" , jbtn_north);//3
		jf.add("South" , jbtn_south);//3
		jf.add("West" , jbtn_west);//3
		jf.add("East" , jbtn_east);//3
		jf.add("Center" , jbtn_center);//3
		jf.setSize(500, 400); //2
		//화면에 JFrame을 출력해주세요
		jf.setVisible(true); // 1
	}
	public static void main(String[] args) {
		new BorderLayoutTest();
	}

}
