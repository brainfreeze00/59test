package UI.swing;

public class TestFour extends TestThree {
/*4. 3������ ������ Ŭ������ ����Ͽ� 
   �Ʒ� �䱸������ �����ϵ��� ���α׷����� �Ͽ� �ҽ��ڵ�� ���ȭ�� ��ũ�� ����
 * �����Ͻÿ�
   [�䱸����]
   ��. ������� Ŭ������ ����Ͽ� ��ü�� �����Ѵ�
   ��. ��ü�� ���(������,���¹�ȣ,�ܾ�)�� �Ʒ�ó�� �ʱ�ȭ �Ͽ���
      ������: �ڹٸ�
      ���¹�ȣ: 123-456
      �ܾ�:10000

   ��. 15000���� �Ա��ϵ��� �޼ҵ带 ȣ���Ͽ���
   ��. 30000���� ����ϵ��� �޼ҵ带 ȣ���Ͽ���
 */
	public TestFour(String name, String account, int cash) {
		super(name, account, cash);
		
	}
	@Override
	public String toString() {
		return String.format("������: %s, ���¹�ȣ : %s, �ܾ� : %d"
				            ,name
				            ,account
				            ,cash);
	}
	public void take(int money) {
		if(cash >= money) {
			cash = cash - money;
			System.out.println("��ݾ� : "+money);
			System.out.println("�ܾ�: "+cash);
		}
		else if(cash<money){
			System.out.println("�ܾ��� �����մϴ�");
			return;
		}
	}
	public void deposit(int money) {
		cash += money;
		System.out.println(" �Աݾ� : "+money);
		System.out.println(" �ܾ� : "+cash);
	}
	public static void main(String[] args) {
		TestFour tf = new TestFour ("�ڹٸ�","123-456",10000);
		tf.deposit(15000);
		tf.take(30000);
	}

}
