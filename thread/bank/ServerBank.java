package thread.bank;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//�������̽��� �߰��ϸ� �ݵ�� ����ü Ŭ������ �Ǳ� ���ؼ� �߻�޼ҵ带 �������ؾ��Ѵ�. - ��Ģ
//run �޼ҵ带 �������̵��ؾ� �Ѵٴ� �Ŵ�.
//�� �޼ҵ� �ȿ����� ������ ����? - ��ٸ��°�[Thread.sleep(1000) 1��] 
//, ���[ois.readObject()]�� ���ϱ�[oos.writeObject("�޼���")] 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import design.book.TimeServerThread;

public class ServerBank extends JFrame implements Runnable {
	//�������� �����ϱ� ����
	Socket socket = null; //���纻�� �ƴ϶� ������ ����ҰŴϱ� �ݵ�� null�� �ʱ�ȭ ������ ���� �������� �ȴ�.
	//���������� ����ڰ� ������ ���⸦ ��ٸ��ϴ�. �������� ��ٷ��� ���� �� �� ����
	int port = 3000; //������Ʈ�� 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea(); // ȭ��
	JScrollPane jsp_log = new JScrollPane(jta_log // ��ũ�ѹ� 
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // �̰� ã�ƺ���
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER�� ȭ�鿡 ���� ���� ���Ѵٴ� ����
	//���θ޼ҵ�� entry point�̴�.
	//���� �������� �Ѵ�. - ������ ��������.
	//ȭ��ó���� ���������ϱ� ���̿� ���� �̰��� �����ϱ����� �������̽� Runnable �߰�
	//������ Ŭ������ run�޼ҵ�� ��� ȣ������?
	public static void main(String[] args) {
		ServerBank sb = new ServerBank();
		sb.initDisplay(); // ȭ���� run���� ���� ȣ��
		//��� �ذ�����? - �ϴ� Thread�� �ν��Ͻ�ȭ �ϰ� �����ڿ� ����üŬ������ �־���
		Thread th = new Thread(sb);
		//sb.start();  ȣ��Ұ��� �ֳ��ϸ� �����带 ��ӹ��� �ʾ����ϱ� - �ᱹ �� �����尡 �ƴ�
		th.start(); // �̷������� Thread�� start�޼ҵ� = run�޼ҵ带 ȣ���Ѵ�
	}

	@Override
	public void run() {//���������� �����ϰ� ��ٸ��� ���
		JOptionPane.showMessageDialog(this, "runȣ�� ����  - ������ ���� ��"); //���̾�α� â��
		try {
			server = new ServerSocket(port); //���Ӱ����ϰ��ϰ� ��ٸ�����..Ŭ���̾�Ʈ�� �����ñ�?(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}
		jta_log.append("ServerBank started successfully.....\n");//�����׽�Ʈ
		while(true) { //while(true){}���ѷ��� - Ż��Ұ� 
			try { // ��Ʈ��ũ�� ���� ó�� ���ؾ���
		//Ŭ���̾�Ʈ ������ �����ؿ� ������ client ���Ͽ��� �ѱ�
				socket = server.accept();//��� Ŭ���̾�Ʈ ���� - accept()
				jta_log.append("New Client connected...."+socket.toString()+"\n");//Ŭ���̾�Ʈ�� ������ ���
//				tst = new TimeServerThread(this);//�θ� Ŭ���� �����ޱ�����
//				tst.start();
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	//ȭ���̿�
	public void initDisplay() { //TimeServer�� init���� �Ծ�
		this.setTitle("ServerBank �α�â");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
}
