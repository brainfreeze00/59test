package book.chap08;

public class WoodDuck extends Duck {
	
	@Override
	public void swimming(String sw) {
		System.out.println(sw+"하면서둥둥뜬다");
	}
		public void fly() {
		System.out.println("나는 날지 못합니다.");
//	}
//	@Override
//	public void swimming() {
	//재정의 
//		System.out.println("나는 물위에 3초정도 떠 있다가 가라 앉습니다.");
//	}
		}
}
