package book.chap07;

import java.util.ArrayList;

class Book1{
	
	public String b_title = null;
	public String b_author = null;
}

public class BookTest {

	public static void main(String[] args) {
		//ArrayList�� �б� ����(����)�� ���� �����Ѵ�
		//���̾Ƹ�� �����ڸ� ����Ͽ� ���׸��� ǥ���Ѵ�.
		//���׸� �ȿ��� Ŭ���� ���谡����.
		ArrayList<Book1> library	= new ArrayList<Book1>(); // ��̸���Ʈ<Book1>�� ���� library�� �ν��Ͻ�ȭ 
		Book1 b1 = new Book1(); // Book1�� ����� �ʱ�ȭ 
		b1.b_title = "�¹���"; // b1��  b_title�� "�¹���" StringŸ�� ���� ����
		b1.b_author = "������"; // b1��  b_author�� "������" StringŸ�� ���� ����
		library.add(b1);
		String title = library.get(0).b_title;
		String author = library.get(0).b_author;
		System.out.println("å���� : "+title);
		System.out.println("å���� : "+author);
	}

}
