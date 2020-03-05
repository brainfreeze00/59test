package design.book;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/* �������Ͽ� �����ҷ��� ip , port num �ʿ�
 * �������� : ������ �Ÿ��� �ذ����� 
 * �빮 : ��Ʈ��ȣ
 * 
 * �ڹٿ����� ���� ��Ӹ� ������.
 * ���� ����� �ʿ��� �� �������̽��� ����Ѵ�.
 * ���⼭ ó�� JFrame�� �̹� ��� ���� ��� Thread�� �� ��ӹ����� ����.
 * �̷���츦 �����ϱ� ���ؼ� Runnable�̶�� �������̽��� ������.
 * 
 */
public class TimeServer extends JFrame implements Runnable {
	Socket socket = null; //���纻�� �ƴ϶� ������ ����ҰŴϱ� �ݵ�� null�� �ʱ�ȭ ������ ���� �������� �ȴ�.
	//���������� ����ڰ� ������ ���⸦ ��ٸ��ϴ�. �������� ��ٷ��� ���� �� �� ����
	int port = 3000; //������Ʈ�� 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // �̰� ã�ƺ���
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER�� ȭ�鿡 ���� ���� ���Ѵٴ� ����
	List<TimeServerThread> globalList = null;
	TimeServerThread tst = null;
	//������
	public TimeServer() {
	}
	//�ð� ����ִ� �޼ҵ�
	public String setTimer() {
		Calendar cal = Calendar.getInstance(); //class ī���ٴ� �̷����� �ν��Ͻ��� �ؾ���
		int hour = cal.get(Calendar.HOUR_OF_DAY); //1~24
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour:""+hour)+":"+ 
			   (min < 10 ? "0"+min:""+min)+":"+ 
			   (sec < 10 ? "0"+sec:""+sec); 
	}
	public void run() {//����ó�� ����, ���� ������ �������� �ִ�, 1�ʿ� �ѹ��� �ð������� ��������.
		globalList = new Vector<>();
		try {
			server = new ServerSocket(port); //���Ӱ����ϰ��ϰ� ��ٸ�����..Ŭ���̾�Ʈ�� �����ñ�?(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true) { //while(true){}���ѷ��� - Ż��Ұ� 
			try { // ��Ʈ��ũ�� ���� ó�� ���ؾ���
		//Ŭ���̾�Ʈ ������ �����ؿ� ������ client ���Ͽ��� �ѱ�
				socket = server.accept();//��� Ŭ���̾�Ʈ ���� - accept() �׻���� ���Ͽ� ��Ʈ���� ���� 
				jta_log.append("TimeServer started successfully.....\n");//�����׽�Ʈ
				jta_log.append("New Client connected...."+socket.toString()+"\n");//Ŭ���̾�Ʈ�� ������ ���
				tst = new TimeServerThread(this);//�θ� Ŭ���� �����ޱ�����
				tst.start();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	/*
	 * main �޼ҵ� �ȿ��� ������� ������ run �޼ҵ忡�� ����Ϸ��� �����ڸ� ���ؼ�
	 * �ʱ�ȭ�� ���־���Ѵ�.
	 * ���纻�� ����ϴ� ���� �ƴ϶� ���ο��� ������ Ŭ���̾�Ʈ�� ������ ����ؾ��ϴϱ�
	 */
	public static void main(String[] args) {
	 TimeServer ts =	new TimeServer();
	 ts.initDisplay();
	 Thread th = new Thread(ts);
	 th.start();
	}//main
	public void initDisplay() {
		this.setTitle("TimeServer �α�");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
}
