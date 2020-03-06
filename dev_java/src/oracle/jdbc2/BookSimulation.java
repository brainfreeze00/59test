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
		Book myBook = new Book(); //주소번지1
		//메소드를 호출해서 객체를 주입 받을수도 있다. - 이런느낌
		Book gnomBook = Book.getBook(); //주소번지2 고로 주소번지가 다름
		System.out.println(myBook+" , "+gnomBook);
	}

}
