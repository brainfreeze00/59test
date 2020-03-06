package book.chap04;

import java.util.Random;
import java.util.Scanner;

/*
 * 0부터 9사이의 임의의 숫자를 채번하기
 * 
 */
public class RandomGame {
//유지할려면 전역변수 선언
	public static void main(String[] args) {
		Random r = new Random(); //인스턴스화
		int cnt  = 0;
		while(cnt < 3) { 
			int imsi = r.nextInt(10); //0.0 ~ 10.0 채번한 숫자
			System.out.println("imsi:"+imsi);
			cnt++; // 증가해야 3을 넘기면 무한루프 탈출
		}
	}

}
