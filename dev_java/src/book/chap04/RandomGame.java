package book.chap04;

import java.util.Random;
import java.util.Scanner;

/*
 * 0���� 9������ ������ ���ڸ� ä���ϱ�
 * 
 */
public class RandomGame {
//�����ҷ��� �������� ����
	public static void main(String[] args) {
		Random r = new Random(); //�ν��Ͻ�ȭ
		int cnt  = 0;
		while(cnt < 3) { 
			int imsi = r.nextInt(10); //0.0 ~ 10.0 ä���� ����
			System.out.println("imsi:"+imsi);
			cnt++; // �����ؾ� 3�� �ѱ�� ���ѷ��� Ż��
		}
	}

}
