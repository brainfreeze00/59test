package friday0207;
//Ŭ���� A,B,C���� ���� �޼ҵ尡 ����.
class A{
	//B b = new B();//11��ȣ���, �����ڴ� ������ �Ķ���� Ÿ�� ������ �޶�� �Ѵ�.
	String name = null;
	A(){
		System.out.println("����Ʈ A������");
	}

	A(String name){
		System.out.println("�Ķ���Ͱ� name�� A������");
		this.name = name;
	}
	A(ABCTest abc){ //ABCTestŸ���� ������ A�� �ʿ��ؼ� ������ ���� 
		System.out.println("�Ķ���Ͱ� ABCTestŸ���� A������");
		this.name = name;
	
	}
}
class B{
	A a = new A();
	B(){
		System.out.println("����Ʈ B������");
	}
}
class C{
	A a = new A();
	B b = new B();
}
public class ABCTest {
//22-23-3-6
//Ŭ�����ȿ� ����Ʈ�����ڸ� ���� �� ���� �ְ� ��������� ���� �� ���� �ִ�.
	ABCTest() {
		A a1 = new A(this);//this - ABCTest 
	}
	public static void main(String[] args) {
		new ABCTest();
		//A a1 = new A("�̼���");//����Ʈ A������ ȣ�� �׸��� heap�޸𸮿� �ε��� , �Ķ���� �̼����� ���Ա⶧���� A(String name) ȣ��
	}

}
