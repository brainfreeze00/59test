package basic_inout;

public class Printf {

	public static void main(String[] args) {
		int value = 123;
		System.out.printf("��ǰ�� ���� :%d��\n",value);
		System.out.printf("��ǰ�� ���� :%6d��\n",value);
		System.out.printf("��ǰ�� ���� :%-6d��\n",value);
		System.out.printf("��ǰ�� ���� :%06d��\n",value); // ĭ �̵�
		String name = "ȫ�浿";
		String job = "����"; // 1 | ȫ�浿  |           ����
		System.out.printf("%6d | %-10s | %10s\n",1,name,job);  //������ŭ �Ķ���� ����
	}

}
