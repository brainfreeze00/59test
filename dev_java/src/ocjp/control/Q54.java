package ocjp.control;

public class Q54 {
	public void testIfA() {
		if(testIfB("True")) { // 19->12 "True" -> True 
		 System.out.println("True");
		 } 
		else {
		 System.out.println("Not true");
		 }
	}
		 public Boolean testIfB(String str) {
		 return Boolean.valueOf(str);
	}
	public static void main(String[] args) {
	//���ȿ� �ִ� �޼ҵ��̴��� static�������� non-static��  ȣ���Ҽ�����.
	//�ν��Ͻ�ȭ�� �ϸ� �Ҽ��ִ�.	
		Q54 q54 = new Q54(); //Ŭ������ ������ �̸� = new Ŭ������();    
		q54.testIfA(); //������ �̸�.�޼ҵ��(); //�ν��Ͻ�ȭ ������ �������� ���� ��
	}
}
