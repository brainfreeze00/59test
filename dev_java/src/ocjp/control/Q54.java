package ocjp.control;

public class Q54 {
	public void testIfA() {
		if(testIfB("True")) { // 19->12 "True" -> True 
		 System.out.println("True");
		 } 
		else {
		 System.out.println("Not true");
		 }
	}
		 public Boolean testIfB(String str) {
		 return Boolean.valueOf(str);
	}
	public static void main(String[] args) {
	//내안에 있는 메소드이더라도 static영역에서 non-static을  호출할수없다.
	//인스턴스화를 하면 할수있다.	
		Q54 q54 = new Q54(); //클래스명 임의의 이름 = new 클래스명();    
		q54.testIfA(); //임의의 이름.메소드명(); //인스턴스화 구조를 이해한후 실험 ㄱ
	}
}
