package study.sungjuk;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutTest2 {
	
	JFrame jf_sungjuk = new JFrame(); // 디폴트 레이아웃이 BorderLayout[동서남북중앙] 1
	//버튼생성2 -> 패널로 변경
	JPanel jp_north  = new JPanel();
	JLabel jlb_su    = new JLabel("인원수"); // 인원수 파라미터가 있는 클래스 타입과 개수 제공된 클래스 west
	JLabel jlb_su2    = new JLabel("인원수"); // 인원수 파라미터가 있는 클래스 타입과 개수 제공된 클래스 west
	JLabel jlb_inwon = new JLabel("명"); // 인원수 파라미터가 있는 클래스 타입과 개수 제공된 클래스 west
	JTextField jtf_inwon = new JTextField(); //인원 center
	JTextField jtf_inwon2 = new JTextField(15); //인원 center  재사용이 안돼서 2붙임 칸크기
	JPanel jp_south  = new JPanel();//디폴트 레이아웃이 FlowLayout
	JPanel jp_west   = new JPanel();
	JPanel jp_east   = new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_data = new JButton("데이터요청"); //인스턴스화 동시에 버튼 글
	JButton jbtn_account = new JButton("처리");
	JButton jbtn_exit = new JButton("종료");
	
	public BorderLayoutTest2() { 
		//원래 FlowLayout이었는데 이것을 BorderLayout으로 변경하기
		jp_north.setLayout(new BorderLayout());
		jp_north.setBackground(Color.ORANGE); //orange static
		jp_south.setBackground(Color.cyan);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south.add(jlb_su2);  // 메뉴바추가
		jp_south.add(jtf_inwon2); //
		jp_south.add(jlb_inwon);//
		jp_south.add(jbtn_data); //버튼화면에 넣기
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		
		jp_west.setBackground(Color.GREEN);
		jp_east.setBackground(Color.BLUE);
		jp_center.setBackground(Color.darkGray);
		
		jp_north.add("West", jlb_su); // 서쪽에 인원수
		jp_north.add("Center", jtf_inwon); // 센터에 인원
		
		jbtn_account.setBackground(Color.lightGray);
		jbtn_data.setBackground(Color.red);
		jbtn_exit.setBackground(Color.white);
		
		jf_sungjuk.add("North" , jp_north);//3
		jf_sungjuk.add("South" , jp_south);//3
		jf_sungjuk.add("West" , jp_west);//3
		jf_sungjuk.add("East" , jp_east);//3
		jf_sungjuk.add("Center" , jp_center);//3
		jf_sungjuk.setSize(500, 400); //2
		//화면에 JFrame을 출력해주세요
		jf_sungjuk.setVisible(true); // 1
	}
	public static void main(String[] args) {
		new BorderLayoutTest2();
	}

}
