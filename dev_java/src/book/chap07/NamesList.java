package book.chap07;

public class NamesList {

	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		//for(�迭�ȿ� ����ִ� Ÿ�� String name:�迭�� �ּҹ��� sj.names) {
		for(String name:sj.names) {
			System.out.println(name);
		}
		//���⼭ ���������� ����غ���
		//�ּҹ���.�����̸��� ���������� �� �� �ִ� | �ƴϴ� ���������� �����ϴ� -> �������
		//int k_tot = sj.korTotal;
		System.out.println();
	}

}
