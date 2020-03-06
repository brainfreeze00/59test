package book.chap04;

public class FizzBuzzGame {
	//if문처리
	public void ifTest() {
		System.out.println("ifTest 호출성공");
		int i = 1; // i=0;
//for(초기화;조건식;증감연산사) {while문 
		for(i=1; i<101; i++) { //1부터 100까지 센다 - while문
			if(i%35==0) {//35로 나누었을때 0이야?
				System.out.println("FizzBuzz");
			}
			else if(i%5==0) {//5로 나누면 0이야?
				System.out.println("Fizz");
			}
			else if(i%7==0) {//7로 나누면 0이야?
				System.out.println("Buzz");
			}
			else {
			System.out.println(i);	
			}
		}
	}
	//switch문처리

	public void swichTest() {
		System.out.println("swichTest 호출성공");
		int i = 1; // i=0;
		for(i=1; i<101; i++) { //1부터 100까지 센다 - while문
			switch(i%35) {//switch(?) ?: 조건식 다만 등호나 값은 안됨 예 i%3
				case 0 : // 1가지
					System.out.println("FizzBuzz");	//insert here fizzbuzz출력
					break; 
				case 5: case 10: case 15: case 20: case 25: case 30: //2가지
				    System.out.println("Fizz");
					break;
					//insert
				case 7: case 14: case 21: case 28:  //3가지
				    System.out.println("Buzz");
					break;
				default: 
					System.out.println(i);// 4가지
		    }//end of swich
	    }///////////end of for
	}///////////////end of switch
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
