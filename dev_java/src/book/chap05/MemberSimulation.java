package book.chap05;
//Member[] - ��ü�迭     Ŭ������[] ����
public class MemberSimulation {

	public static void main(String[] args) {
	//String mem_name=null;
	Member mem = new Member();  // �ν��Ͻ�ȭ
	//before
	System.out.println("before "+mem.mem_name);
	mem.mem_name="������";//�ʱ�ȭ null ==> ������
	mem = null;
	//after	
	//System.out.println("after "+mem.mem_name); // ������ ��� -> ��¾ȵ� 11������
 	mem = new Member(); // ����ǰ �� �ּҹ��� �ٸ� 
	mem.mem_name = "�̼���";
	System.out.println("after "+mem.mem_name); // �̼��� ���
	
	//Member mem1 = new Member("������", 14);
	}

}
