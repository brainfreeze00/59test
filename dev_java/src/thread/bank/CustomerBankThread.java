package thread.bank;

import java.util.StringTokenizer;
import java.util.Vector;

public class CustomerBankThread extends Thread {
	
	CustomerBank cb = null;
	
	public CustomerBankThread(CustomerBank cb){
		this.cb=cb;
	}
	
	public void run() {
		String msg = null;
		boolean isStop = false;
		while(!isStop) { 
			try {
				//100#���� 
				//������ Ŭ���̾�Ʈ�� ���Ѱ��� ������ �޼��� �տ� String�� ObjectŸ���� StringŸ������
				msg = (String)cb.ois.readObject();
				cb.jta_clog.append(msg+"\n");
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case 100:{      //case���� �ٸ� �����̱⿡ �Ź� ����ϴ°� ��ȿ�����̴� �߰�ȣ�� �ƴ�.
					String nickName = st.nextToken();
					cb.jta_clog.append(nickName+"���� �����ϼ̽��ϴ�.\n");
					Vector<String> v = new Vector<String>();
					v.add(nickName);
					cb.dtm_nickName.addRow(v);
					}break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}//catch
		}//while
	}//main
}//class
