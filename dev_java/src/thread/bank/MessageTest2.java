package thread.bank;

import java.util.StringTokenizer;

public class MessageTest2 {

	public static void main(String[] args) {
		String msg = "200#apple#test#���� ���͵� �ұ�?";
		msg = "210#apple#���� ���� ������ ���ұ�?";
		msg = "100#apple";//�����ϱ�
		StringTokenizer st = null;
		if(msg != null) { //msg�� null�ƴϸ�
			st = new StringTokenizer(msg,"#"); //������ ���� msg�� �Էµȹ����� #������ �ν�
		}
		int protocol = 0;
		protocol = Integer.parseInt(st.nextToken()); // nextToken String  nextElement Object
		switch(protocol) {//if�� ���� �ξ� �������� ��� �̰��� ä���Ѵ�.
		case 100:
			System.out.println("100�� �� �ؾ� ����");
			break;
		case 200:
			System.out.println("200�� �� �ؾ� ����");
			break;
		case 210:
			System.out.println("210�� �� �ؾ� ����");
			break;
		
		}
	}
}
