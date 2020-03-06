package book.chap08;
//자동차 - 완전 추상적이다
public class Car {
	
	int speed;
	//생성자는 전변을 초기화해준다.
	Car(){ //디폴트 생성자
		speed = 0; //전역변수 초기화
		speed = 40;
	}
	public void stop() {
		System.out.println("stop 호출성공");
		if(speed>0) { //스피드는 0보다 커야한다
		speed = speed -1;
		}
	}
}
