package book.chap08;

public class Tivoli extends Car {
	
	String carColor;
	int volumn;
	//생성자는 전변을 초기화해준다.

	Tivoli(){ //디폴트 생성자
		carColor = "남색"; //전역변수 초기화
		volumn = 0;
		volumn = 20;
		speed = 30; // 아들꺼 생성자에서도 아버지 변수 조정 가능 
	}
	@Override
	public void stop() {
		System.out.println("Override stop 호출성공");
		if(speed>0) { //스피드는 0보다 커야한다
		speed = speed -2;
		}
	}
	public void VolumnUp() {
		volumn +=1;
	}
	public void VolumnDown() {
		volumn -=1;
	}
}
