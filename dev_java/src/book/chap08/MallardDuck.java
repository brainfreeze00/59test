package book.chap08;

public class MallardDuck extends Duck {
	
	@Override
	public void swimming(String sw) {
		System.out.println(sw+"하면서 잘만 뜬다");
	}
//	@Override
//	public void swimming() {
//		System.out.println("청둥오리는 물위에 뜨기도 하고 잠수도 가능합니다.");
//	}
	public void fly(String f) {
		System.out.println("멋지게"+f+"다");
	}
//	public void fly() {
//		System.out.println("나는 날고 있어요.");
//	}
	@Override
	public void quack(String qu) {
		System.out.println(qu+"소리가 난다?");
	}
}
