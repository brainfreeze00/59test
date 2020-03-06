package book.chap08;

public class Duck {
	
	String sw = "수영";
	String qu = "꽥꽥";
	String  f = "날아간";
	int leg = 2;
	int eye = 2;
	int wing = 2;

	public void swimming(String sw) {
		System.out.println("모든 오리는 물에"+sw+"하면서 뜬다");
	}
	public void fly(String f) {
		System.out.println("하늘을"+ f +"다");
	}
	public void quack(String qu) {
		System.out.println(qu+"소리를 낸다");
	}
}
