package thread.bank;

import java.util.StringTokenizer;

public class MessageTest {

	public static void main(String[] args) {
		String msg = "200#apple#test#���� ���͵� �ұ�?";
		StringTokenizer st = null;
		if(msg != null) { //msg�� null�ƴϸ�
			st = new StringTokenizer(msg,"#"); //������ ���� msg�� �Էµȹ����� #������ �ν�
		}
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement()); // ��½� �νĵ� #������ �ɰ��� �������� ���
			}
		if(msg != null) { //msg�� null�ƴϸ�
			st = new StringTokenizer(msg,"#"); //�̹� while���� �����ż� ���� for���� �ȳѾ��
			//������ �������Ѵ�.
		}
		for(;st.hasMoreTokens();) {
			System.out.println(st.nextToken());
		}
	}
}
