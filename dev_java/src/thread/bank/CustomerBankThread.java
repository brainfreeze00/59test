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
				//100#진아 
				//서버가 클라이언트가 말한것을 들을때 메세지 앞에 String은 Object타입을 String타입으로
				msg = (String)cb.ois.readObject();
				cb.jta_clog.append(msg+"\n");
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
					case 100:{      //case마다 다른 업무이기에 매번 출력하는건 비효율적이니 중괄호를 쳤다.
					String nickName = st.nextToken();
					cb.jta_clog.append(nickName+"님이 입장하셨습니다.\n");
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
