package thread.talk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.StringTokenizer;

import thread.bank.Protocol;
import thread.bank.ServerBankThread;

public class TalkServerThread extends Thread {
	Login l = null;
	public TalkServer ts = null;
	ObjectOutputStream oos = null; // ��ٰ� ����� �����ϱ� ����ó��
	ObjectInputStream ois = null; // ���ϴٰ� ����� �����ϱ� �����ڿ��� try..catch �ȿ��� �ν��Ͻ�(������ ������ �ٽ�Ʈ��)
	String nickName = null; // �г��� ���� ���� �𸣴ϱ� null
	//�����ڿ� �Ķ���� �ڸ��� �ִ� Ŭ������ �������迡 �ִ�.
	String mem_name = null;
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.socket.getOutputStream());//�����ؼ� ���ϱ���͸���
			ois = new ObjectInputStream(ts.socket.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,"#");
			}
			st.nextToken();// 100
			nickName = st.nextToken();// ����, ����, ���� - ��� nickName�� ����ش�.
			l.login(nickName);
			
			
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		}
	}
	public void run() {
		boolean isStop = false;
		while(!isStop) { //while(true) { �̷� while �ڵ�� �ϼ���
			int protocol = 0;
			switch(protocol) {
			case Protocol.LOGIN:{
				
			}break;
			case Protocol.EXIT:{
				
			}break;
			}//switch
		}//while
	}
	public void broadCasting(String msg) {
		//���� ������ �� ����� �ִ��� ����ϱ�
		ts.jta_log.append("���� �ο��� : "+ts.globalList.size());
		synchronized(this) {//�ٸ� �����尡 ���ͼ�Ʈ �ϴ� ���� ����ϱ� ���� ����ȭó�� : Ŭ���̾�Ʈ�鿡�� �´� ������� �ϱ����� ����ȭ ó��
//			for(TalkServerThread tst:ts.globalList) { // ������ �ִ� ����鵵 ������ �Ǿ�� �ϹǷ�
//				tst.send(msg); // this ���� -���ݵ��³ʿ��Ը� ����  
//			}
		}
	}//////broadCasting
	//�������� Ŭ���̾�Ʈ���� �����ϴ� �޼��� ����
public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace(); //���� �߻��� ���� �޼��� history���
		}
	}///////send
	public String setTimer() {
		Calendar cal = Calendar.getInstance(); //class ī���ٴ� �̷����� �ν��Ͻ��� �ؾ���
		int yyyy = cal.get(Calendar.YEAR);
		int mm 	 = cal.get(Calendar.MONTH)+1;
		int day  = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY); //1~24
		int min  = cal.get(Calendar.MINUTE);
		int sec  = cal.get(Calendar.SECOND);
		return yyyy+"-"+
			(mm < 10 ? "0"+mm:""+mm)+":"+ 
			(day < 10 ? "0"+day:""+day)+" "+ 
			(hour < 10 ? "0"+hour:""+hour)+":"+ 
			(min < 10 ? "0"+min:""+min)+":"+ 
			(sec < 10 ? "0"+sec:""+sec); 
	}
}
