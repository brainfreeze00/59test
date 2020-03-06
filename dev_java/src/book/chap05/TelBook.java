package book.chap05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame; // javax.swing. 반복방지
import javax.swing.JPanel;

public class TelBook {
//선언부
	int width = 600; // 전역변수로 선언할줄알아야한다.
	int height = 500;
	String title = "전화번호부";
	JPanel jp_nroth = new JPanel();
	JButton jbtn = new JButton("전화목록출력할 영역");
	//미션 위 4개 객체배열로 바꿔보아라
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	GridLayout glay = new GridLayout(1,4); // 1/n 
	
	//생성자
public String toString() {
		return "나는 TelBook테스트 클래스임.";
	} // 다르게 정의한 부분이 있을것이다. 즉 재정의 아버지 Object가 아닌 딸이 적용
	
//화면처리부
public void display() {
	System.out.println("display 호출성공"); // 다잉테스트
	//윈도우 화면에 창을 만들어주는 클래스입니다. 가로세로 변경가능 , 제목 바꿀수있다.
	JFrame jf_tel = new JFrame();
	//속지의 레이아웃을 GridLayout 1,4 로우 한개 컬럼 4개로 n분할
	jp_nroth.setLayout(glay);
	jp_nroth.add(jbtn_sel);
	jp_nroth.add(jbtn_ins);
	jp_nroth.add(jbtn_upd);
	jp_nroth.add(jbtn_del);
	//화면의 크기를 정해주세요. 600, 500
	//setSize메소드를 호출해보세요.   return타입과 파라미터가 중요
	jf_tel.setSize(width, height); // 파라미터의 개수를 맞춰야한다.
	//jf_tel.setSize(400, 600); //갱신
	jf_tel.setTitle(title);
	jf_tel.add("North",jp_nroth);
	jf_tel.add("Center", jbtn);
	jf_tel.setVisible(true); // 적절히 true false를 쓸수있는가?  false이면 비활성화라서 안보임.
}
//메인메소드
	public static void main(String[] args) {
		TelBook tb = new TelBook(); // 인스턴스
		tb.display(); //부르기
	}

}
