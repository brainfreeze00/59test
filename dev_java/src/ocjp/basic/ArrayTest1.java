package ocjp.basic;

public class ArrayTest1 {
	static void methodA(int is[]) {
		System.out.println("is:"+is); //main is
		//�Ķ���ͷ� �Ѿ�� is�迭�� ������ ����° �濡�ִ� ���� 0���� 10���� ��������Ʈ(��������)
		is[2] = 10;
	}
	public static void main(String[] args) {
		//�迭 ����� �����ϱ� - ���� ���� �������.
		//���� is�� �迭Ÿ���̰� �迭�� �������̴�.
		int is[] = new int[3];//is[0]=0, is[1]=0, is[2]=0
		//�迭�� �ּҹ��� ����غ���
		System.out.println("main is : "+is); //����is�� is�� �ּҹ����� �ְ�����?
		//methodA(is)ȣ���Ҷ� is�迭�� �ּҹ����� �޼ҵ��� �Ķ���ͷ� �Ѱ���.
		//is�� �ּҹ�����  ������ �����°� 
		methodA(is); // �� �޼ҵ忡�� is[2]�濡 0�� ��� 10���� ��������.
		//for(�ʱ�ȭ; ���ǽ�; ����������)
		//for(int x=0 ; x<3 ; ++x) {���� �����ϰ� ���� ��� ������ ����
		for(int x=0 ; x<3 ; x++) {
			System.out.println("is["+x+"]"+is[x]);
		}
		System.out.println("==============");
		//������ for�� -�迭�� �ִ� ��� ������ �� ����Ҷ�
		for(int a:is) {
			System.out.println(a);
		}
	}

}
