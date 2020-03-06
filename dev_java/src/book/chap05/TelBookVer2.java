package book.chap05;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame; // javax.swing. 반복방지
import javax.swing.JPanel;

public class TelBookVer2 { //객체배열모드
//선언부
	int width = 600; // 전역변수로 선언할줄알아야한다.
	int height = 500;
	String title = "전화번호부-객체배열적용";
	JPanel jp_nroth = new JPanel();
	JButton jbtn = new JButton("전화목록출력할 영역");
	//insert here - 선언부 영역에는 제어문이나 실행문을 적을수 없다.
	JButton jbtns[] = new JButton[4];
	String jbtn_label[] = {"조회","입력","수정","삭제"};
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
	for(int i=0; i<jbtns.length;i++) {
		jbtns[i] = new JButton(jbtn_label[i]);
		jp_nroth.add(jbtns[i]); // 2번 접근임 그래서 [i] 붙이는거임
	}
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
		TelBookVer2 tb = new TelBookVer2(); // 인스턴스
		tb.display(); //부르기
	}

}
