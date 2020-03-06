package design.book;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TimeServerThread extends Thread {
	TimeServer ts = null;
	ObjectInputStream ois = null;//�б� - ���
	ObjectOutputStream oos = null;//���ϱ� - ����
	String time = "10:20:35";
	public TimeServerThread(TimeServer ts) { // �����ڿ��� ȣ���ϸ� �ѹ��� 
		this.ts = ts; // �������� ts�� �Ķ���� ts�� �����Ѵ�.
		try {
			oos  = new ObjectOutputStream(ts.socket.getOutputStream()); //������ ����
			//Ŭ���̾�Ʈ�� ���� ������ ���
			ois = new ObjectInputStream(ts.socket.getInputStream());
			//TimeServer���� ������ setTimer�޼ҵ忡�� ���� ��ġ�� �ð����� ��������
			time = ts.setTimer();
			oos.writeObject(time);
			//���� �����ϱ� ���� �ִ� ģ���鿡�� �����ϱ�
			for(TimeServerThread tst : ts.globalList) { //����for��  Ŭ����Ÿ�� ���� : �����̳� �ּҹ���
				this.send(time);//�ϰ� �������� �ִ� ���� ���̵��� ������ �Ͽ��� �����ִ°�
			}
			ts.globalList.add(this); // ������ �׻��Ŭ������ ����Ʈ�� add�Ѵ�. 
			this.broadCasting(time); // ���� �����ִ� ���������  = this  - ����ڰ� �̿��Ҷ����� �ν��Ͻ�
		} catch (Exception e) {
			System.out.println("TimeServerThread:"+e.toString());
		}
	}
	//���� ������ ������ ��� ����ڿ��� �ð������� ����ϱ� ���� �������� ����
	
	public void broadCasting(String msg) {
		//���� ������ �� ����� �ִ��� ����ϱ�
		ts.jta_log.append("���� �ο��� : "+ts.globalList.size());
		synchronized(this) {//�ٸ� �����尡 ���ͼ�Ʈ �ϴ� ���� ����ϱ� ���� ����ȭó��
			for(TimeServerThread tst:ts.globalList) { // ������ �ִ� ����鵵 ������ �Ǿ�� �ϹǷ�
				tst.send(msg); // this ���� -���ݵ��³ʿ��Ը� ����  
				//, tst ���� �ٸ����� - ������ �ִ� �����+���� �ʿ��� �������
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
	public void run() {
		while(true) {
			try {
				//TimeServer���� ������ setTimer�޼ҵ忡�� ���� ��ġ�� �ð����� ��������
				time = ts.setTimer();
				oos.writeObject(time);
				sleep(1000); //1�ʵ��� ������Ű��
			}catch (IOException ie) {	
				System.out.println(ie.toString());
			} catch (InterruptedException ie) {
				System.out.println("�ٸ� �����尡 ��ġ�⸦ ���� ��");
			}
		}//while
	}//run
}//class
