package basic_inout;


public class ContinueKeyCode {

	public static void main(String[] args) throws Exception{
		int keyCode;
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode :"+keyCode);
			if(keyCode == 113) { //113 �ƽ�Ű�ڵ� q
				break; // if�� Ż���� �ƴ� while�� Ż��
			}
		} // cage return  ,  line feed �ٹٲ㼭 �Ǿ� 
		System.out.println("����");
	}

}
