package book.chap04;

public class FizzBuzzGame {
	//if��ó��
	public void ifTest() {
		System.out.println("ifTest ȣ�⼺��");
		int i = 1; // i=0;
//for(�ʱ�ȭ;���ǽ�;���������) {while�� 
		for(i=1; i<101; i++) { //1���� 100���� ���� - while��
			if(i%35==0) {//35�� ���������� 0�̾�?
				System.out.println("FizzBuzz");
			}
			else if(i%5==0) {//5�� ������ 0�̾�?
				System.out.println("Fizz");
			}
			else if(i%7==0) {//7�� ������ 0�̾�?
				System.out.println("Buzz");
			}
			else {
			System.out.println(i);	
			}
		}
	}
	//switch��ó��

	public void swichTest() {
		System.out.println("swichTest ȣ�⼺��");
		int i = 1; // i=0;
		for(i=1; i<101; i++) { //1���� 100���� ���� - while��
			switch(i%35) {//switch(?) ?: ���ǽ� �ٸ� ��ȣ�� ���� �ȵ� �� i%3
				case 0 : // 1����
					System.out.println("FizzBuzz");	//insert here fizzbuzz���
					break; 
				case 5: case 10: case 15: case 20: case 25: case 30: //2����
				    System.out.println("Fizz");
					break;
					//insert
				case 7: case 14: case 21: case 28:  //3����
				    System.out.println("Buzz");
					break;
				default: 
					System.out.println(i);// 4����
		    }//end of swich
	    }///////////end of for
	}///////////////end of switch
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
