package UI.swing;

public class TestThreeTest {

	public static void main(String[] args) {
		TestThree tt = new TestThree("�ڹٸ�","123-456",10000);
		System.out.println(tt.toString());
		tt.deposit(15000);
		tt.take(30000);
	}

}
