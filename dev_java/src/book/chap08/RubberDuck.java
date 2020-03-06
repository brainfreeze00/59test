package book.chap08;

public class RubberDuck extends Duck{
	
	@Override
	public void swimming(String sw) {
		System.out.println(sw+"하면서 뜨더라");
	}
//	public void fly() {
//		System.out.println("나는 날지 못합니다.");
//	}
//	@Override
//	public void swimming() {
	//재정의 
//		System.out.println("나는 물위에 뜰 수있지만 잠수는 불가능합니다.");
//	}
	
	@Override
	public void quack(String qu) {
		System.out.println(qu+"소리내냐?");
	}
}
