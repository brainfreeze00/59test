package book.chap05;

public class MemberSimulation2 {
	public static void main(String[] args) {
		//MemberŬ������ �ΰ� ���� �� �ִ� ���� �����غ���
		Member mems[] = null;                   // ���� ���� �Ҵ���� ����
		//������ ��ü�迭�� �����ϱ� �Դϴ�. ũ��� 2�� �߾��
		//�ֳ��ϸ� �̼��Ű� ������ �λ���� ����ϸ� �Ǵϱ�....
	 	mems = new Member[2];                   // �����ϱ�
	 	//���⸦ ������ �����Ҽ��־��.
	 	Member mem = new Member(); // �ν��Ͻ�ȭ
	 	//Member�ȿ� �ִ� mem_name�� �������� �����߾��
	 	mem.mem_name="������";                    // ���������� �ʱ�ȭ
	 	mem.mem_id="ghost";
	 	mem.mem_pw="123";
	 	//�� mem �ּҹ����� �߶󳻷��� �ؿ�....
	 	//�߸��� ���� ��Ƶξ�� �մϴ�. �ϴ�null�� �ǰ� ���� ������ �÷��Ͱ�
	 	//�� �����Ⱚ�̾� ��� ������ ���Դϴ�. �׷��� ������ ���ؿ�Ф�
	 	//�׷��� �ݵ�� ������ ��Ƶξ���ϴ±���
	 	mems[0] = mem;
	 	mem = null;
	 	mem = new Member();
	 	mem.mem_name="�̼���";
	 	mem.mem_id="nono";
	 	mem.mem_pw="333";
	 			mems[1]=mem;
	 	for(int i=0;i<mems.length;i++) {
	 		String id = mems[i].mem_id; // Ȱ��� ���� ���ϵ� ����
	 		String pw = mems[i].mem_pw;
	 		String name = mems[i].mem_name;
	 		System.out.println("id====> "+id);
	 		System.out.println("pw====> "+pw);
	 		System.out.println("name====> "+name);
		//Member mem1 = new Member("������", 14);
		}

	}

}
