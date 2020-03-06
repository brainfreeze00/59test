package study.sungjuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SungJuk_JJW implements ActionListener {
	//선언부
	
	//생성자
	SungJuk_JJW(){
		
	}
	//총점을 구하는 메소드 구현
	public double total() {
		return 0.0; //미정이지만 더블타입이라 실수형태로 적기
	}
	//평균을 구하는 메소드 구현
	public double average() {
		return 0.0;
	}
	//석차를 구하는 메소드 구현
	//public int[] ranking() {
	//	return
	//}
	//이벤트 소스와 이벤트처리 클래스를 맵핑
	public void start() {
		
	}
	//화면처리부
	public void initDisplay() {
		
	}
	//메인메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//@Overrid는 (@은 어노테이션이고)   읽음- ActionListener가 가진 추상메소드를
	//그대로 가져다가 재정의해서 사용하시오.
	//
	//추상메소드 : void methodA(); 이런 형태 , 특징 : 이름은 정해졌지만 기능은 정해진게 없음 고로 기능을 담을수없다.
	@Override
	public void actionPerformed(ActionEvent e) {//반드시 부모가 갖고있는 기능을 선언해서 써라 바꾸면 에러
		//insert here  actionPerformed method는 여기만 건들어라 
	}

}
