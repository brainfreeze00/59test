package oracle.jdbc2;
class Book {
	String title = null;
	int price = 0;
	public static Book getBook() {
		return new Book();
	}
	
}
public class BookSimulation {

	public static void main(String[] args) {
		Book myBook = new Book(); //�ּҹ���1
		//�޼ҵ带 ȣ���ؼ� ��ü�� ���� �������� �ִ�. - �̷�����
		Book gnomBook = Book.getBook(); //�ּҹ���2 ��� �ּҹ����� �ٸ�
		System.out.println(myBook+" , "+gnomBook);
	}

}
