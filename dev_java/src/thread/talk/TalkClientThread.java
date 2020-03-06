package thread.talk;

import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread {
	TalkClient tc = null;
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	public void run() {
		String msg = null; //���� �޼����� ����
		boolean isStop = false; // ������ġ
		while(!isStop) {
			try {
				//100#���� 
				//������ Ŭ���̾�Ʈ�� ���Ѱ��� ������ �޼��� �տ� String�� ObjectŸ���� StringŸ������
				msg = (String)tc.ois.readObject();
				tc.jta_clog.append(msg+"\n");
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case 100:{      //case���� �ٸ� �����̱⿡ �Ź� ����ϴ°� ��ȿ�����̴� �߰�ȣ�� �ƴ�.
					String nickName = st.nextToken();
					tc.jta_clog.append(nickName+"���� �����ϼ̽��ϴ�.\n");
					Vector<String> v = new Vector<String>();
					v.add(nickName);
					tc.dtm_nickName.addRow(v);
					}break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
