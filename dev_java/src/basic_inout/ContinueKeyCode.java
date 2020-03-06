package basic_inout;


public class ContinueKeyCode {

	public static void main(String[] args) throws Exception{
		int keyCode;
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode :"+keyCode);
			if(keyCode == 113) { //113 아스키코드 q
				break; // if문 탈출이 아닌 while문 탈출
			}
		} // cage return  ,  line feed 줄바꿔서 맨앞 
		System.out.println("종료");
	}

}
