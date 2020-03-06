package thread.bank;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;


public class ServerBankThread extends Thread {
	ServerBank sb = null;
	ObjectOutputStream oos = null; // ��ٰ� ����� �����ϱ� ����ó��
	ObjectInputStream ois = null; // ���ϴٰ� ����� �����ϱ� �����ڿ��� try..catch �ȿ��� �ν��Ͻ�(������ ������ �ٽ�Ʈ��)
	String nickName = null; // �г��� ���� ���� �𸣴ϱ� null
	//�����ڿ� �Ķ���� �ڸ��� �ִ� Ŭ������ �������迡 �ִ�.
	String mem_name = null;
	public ServerBankThread(ServerBank sb) {
		this.sb = sb;
		try {
			oos = new ObjectOutputStream(sb.socket.getOutputStream());//�����ؼ� ���ϱ���͸���
			ois = new ObjectInputStream(sb.socket.getInputStream());
			//���������� Ŭ���̾�Ʈ�� ���� �޼��� û��Ϸ�
			String msg = (String)ois.readObject();
			sb.jta_log.append(msg+"\n");
			//�޼��� �����ؼ� �������ϴϱ�
			StringTokenizer st = null;
			//msg 100#���� 100#���� 100#���� Ŭ������ ������ �ϳ������� �����帶�� �г��� ���� �����ؾ��Ѵ�.
			//���� �г��� ����������? ����������? - ����: �����带 ���ؼ� �����ؾ��ϹǷ� ���������� �ؾ���

			//			for(ServerBankThread sbt:sb.globalList) {// ���Ͽ��� ������ ���� �Դ� ����, ������ �����带 ����
			//				sbt.nickName?
			//			}
			if(msg!=null) {
				st = new StringTokenizer(msg,"#");
			}
			st.nextToken();// 100
			//�α��ΰ� ���õ� ����
			nickName = st.nextToken();// ����, ����, ���� - ��� nickName�� ����ش�.
			login(nickName);
			
			
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		}
	}
	//�α��� ó�� ����
	public void login(String mem_id) {
		Map<String, Object> rMap = null; 
		rMap = sb.cDao.login(mem_id); // SeverBank���� �ν��Ͻ�ȭ �����ϱ� sb.����
		if(rMap !=null) {//�α��� ���������� 100
			String currentName = null;
			String msg2 = null;
			//�ƹ��� ���������ʾ�����  ũ�Ⱑ ���������ʾұ⿡ for���� ���� ���ϰ� null�� ����ϰ� �ȴ�.
			//�׷��Ƿ� 3������ for������ �����
			currentName = rMap.get("mem_name").toString();
			msg2 = 100+"#"+currentName;
			mem_name =msg2;
			for(ServerBankThread sbt:sb.globalList) {// ���Ͽ��� ������ ���� �Դ� ����, ������ �����带 ����
				//currentName = sbt.nickName;
				//msg2 = 100+"#"+currentName;
				// this.send(msg2);
				this.send(sbt.mem_name); 
			}
			Vector<String> v = new Vector<>();
			v.add(setTimer());
			v.add(nickName);
			v.add(100+"#"+rMap.get("mem_name").toString()); // v.add(100+"#"+mem_id);
			v.add("�α���");
			sb.dtm_history.addRow(v);
			sb.globalList.add(this); //ServerBankThread this=���Ͻ�����
			this.broadCasting(100+"#"+rMap.get("mem_name").toString());//msg = 100#���� �� �ѱ��.
		}
		else {//���� ������ 110
			for(ServerBankThread sbt:sb.globalList) {// ���Ͽ��� ������ ���� �Դ� ����, ������ �����带 ����
				this.send(110+"#"+mem_id+"���� �α��� �����Դϴ�.");
			}
			this.broadCasting(110+"#"+mem_id+"���� �α��� �����Դϴ�.");//msg = 100#���� �� �ѱ��.
		}
	}
	//���� ������ ������ ��� ����ڿ��� �ð������� ����ϱ� ���� �������� ����
	
	public void broadCasting(String msg) {
			//���� ������ �� ����� �ִ��� ����ϱ�
			sb.jta_log.append("���� �ο��� : "+sb.globalList.size());
			synchronized(this) {//�ٸ� �����尡 ���ͼ�Ʈ �ϴ� ���� ����ϱ� ���� ����ȭó��
				for(ServerBankThread sbt:sb.globalList) { // ������ �ִ� ����鵵 ������ �Ǿ�� �ϹǷ�
					sbt.send(msg); // this ���� -���ݵ��³ʿ��Ը� ����  
				}
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
	//������ Ŭ���̾�Ʈ�ʹ� �޸� ���� ������ ���(������ �ִ� �����) �����ؾ� �ϹǷ�
	//run�޼ҵ忡�� ���ois�� ���ϱ�oos�� ���ÿ� ������
	public void run() {
		sb.jta_log.append(sb.socket+"���� ������ �����ؾ���.-�����ڿ��� �߰�");//sb�� ����
	}
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
