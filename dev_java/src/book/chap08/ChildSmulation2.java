package book.chap08;

public class ChildSmulation2 {
//��Ӱ��踦 �̿��ϸ� ���뼺�� �������Ƿ� �ڵ����� �پ���.
//�ڵ����� �پ�� ��Ÿ�߻��� �پ����̴�.
//������ ������ ����ȴ� �ϴ��� ������ �ڵ带 ���� �����ϵ��� Ŭ���� ���踦 �Ͽ����Ѵ�.
	public static void main(String[] args) {
		int i = 5;
		double d = i;
		Parent p = new Parent();
		Child c = new Child();
		//������ Ÿ���� ���� Ÿ�Ժ��� ����Ŭ������ �ü� ����.
		//�׻� ����Ŭ������ �����ϴ�.
		p = c; // p = new Child(); // O  �ڽ��� �θ��� ����� ����� �����ϹǷ� �н�?
		//insert here ���� p�� bookRead�޼ҵ帣 ȣ�� �Ͽ��ٸ� � Ŭ������ �޼ҵ尡 ȣ��Ǿ�����?
		//12�� ���ο��� ���� Parent ��ü�� ���������� Child ��ü�� ���� �Ǿ���.
		p.bookRead();
		//c = p; // c = new Parent(); X  �θ�� �ڽĸ��� ����� ��� ���ϹǷ� ����? 
	}

}
