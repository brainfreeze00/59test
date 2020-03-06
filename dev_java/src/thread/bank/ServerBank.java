package thread.bank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//�������̽��� �߰��ϸ� �ݵ�� ����ü Ŭ������ �Ǳ� ���ؼ� �߻�޼ҵ带 �������ؾ��Ѵ�. - ��Ģ
//run �޼ҵ带 �������̵��ؾ� �Ѵٴ� �Ŵ�.
//�� �޼ҵ� �ȿ����� ������ ����? - ��ٸ��°�[Thread.sleep(1000) 1��] 
//, ���[ois.readObject()]�� ���ϱ�[oos.writeObject("�޼���")] 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class ServerBank extends JFrame implements Runnable {
	//�������� �����ϱ� ����
	Socket socket = null; //���纻�� �ƴ϶� ������ ����ҰŴϱ� �ݵ�� null�� �ʱ�ȭ ������ ���� �������� �ȴ�.
	//���������� ����ڰ� ������ ���⸦ ��ٸ��ϴ�. �������� ��ٷ��� ���� �� �� ����
	int port = 3000; //������Ʈ�� 3000
	ServerSocket server = null;
	JTextArea jta_log = new JTextArea(12,30); // 12ũ�⿡ 30��
	JScrollPane jsp_log = new JScrollPane(jta_log // ��ũ�ѹ� 
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // �̰� ã�ƺ���
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//NEVER�� ȭ�鿡 ���� ���� ���Ѵٴ� ����
	String cols[] = {"���ӽð�","������","�޼���","����"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm_history = new DefaultTableModel(data,cols);
	JTable jtb_history = new JTable(dtm_history); 
	JScrollPane jsp_history = new JScrollPane(jtb_history
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//Ŭ���̾�Ʈ���� �����ؿ� ����ڿ� ���� �����带 ������� List����
	//�ϴ� ���� �صξ��ٰ� ���� ������ �����Ǳ� ������ �ν��Ͻ�ȭ�Ѵ�.
	//List�� �������̽��̹Ƿ� �ܵ����� �ν��Ͻ�ȭ �Ұ��ϴϱ� ����ü Ŭ�����߿���
	//���� ����� �սǾ��� ���� �� �� �ִ� Vector��ü�� ���� �� ��
	//Ŭ���̾�Ʈ�� ������ ������ �����带 ���� ��Ų��.
	//ServerBankThread�� ���������� ������ Ŭ���������� �� �ȿ� ��� ������ Ŭ���̾�Ʈ��
	//���� ������ ��� �ִ�.
	//Ŭ���̾�Ʈ�� ���� �����ϸ� �Ϲݼ��Ͽ��� ���������� ������ ������ �ѱ�
	//�� ������ �Ѱܹ����� �� �ȿ� Ŭ���̾�Ʈ ������ ���
	//�����尡 �����Ǿ����� �׶� Vector�ȿ� addó�� �Ұ� �׷��� �׻�� ������ ��������
	//��� �۾��� �����尡 �����Ǿ����� ���� ���ÿ� �Ͼ�� ����̹Ƿ� ������ �ȿ��� ó��
	List<ServerBankThread> globalList = null;
	ServerBankThread sbt = null; // accept ������ �ν��Ͻ�ȭ run() �ȿ�
	CustomerDao cDao = new CustomerDao(); // �̾ȿ� this�� ���� ���� �θ𿡰� �������� ����
	//���θ޼ҵ�� entry point�̴�.
	//���� �������� �Ѵ�. - ������ ��������.
	//ȭ��ó���� ���������ϱ� ���̿� ���� �̰��� �����ϱ����� �������̽� Runnable �߰�
	//������ Ŭ������ run�޼ҵ�� ��� ȣ������?
	
	public static void main(String[] args) {
		ServerBank sb = new ServerBank(); // �ν��Ͻ�ȭ
		sb.initDisplay(); // ȭ���� run���� ���� ȣ��
		//��� �ذ�����? - �ϴ� Thread�� �ν��Ͻ�ȭ �ϰ� �����ڿ� ����üŬ������ �־���
		Thread th = new Thread(sb); // ������ �ν��Ͻ�ȭ
		//sb.start();  ȣ��Ұ��� �ֳ��ϸ� �����带 ��ӹ��� �ʾ����ϱ� - �ᱹ �� �����尡 �ƴ�
		th.start(); // �̷������� Thread�� start�޼ҵ� = run�޼ҵ带 ȣ���Ѵ�
	}

	@Override
	public void run() {//���������� �����ϰ� ��ٸ��� ���
		globalList = new Vector<ServerBankThread>();
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
				//�׻���� ������ �����ؾ��ϱ⿡ this-ServerBank�ڽ� -����-������ȣ��
				sbt = new ServerBankThread(this);//�θ� Ŭ���� �����ޱ�����- �׻���� ������ �����ؾ��ϱ⿡ this-ServerBank�ڽ� -����
				sbt.start();//�����忡 ������ run() ȣ��
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	//ȭ���̿�
	public void initDisplay() { //TimeServer�� init���� �Ծ�
		//������ â���� X��ư Ŭ������ �� �̺�Ʈó��
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {//��� �ڿ� �ݳ��ϱ�
					server.close();
					socket.close();
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		this.setTitle("ServerBank �α�â");
		this.add("West",jsp_log);
		this.add("Center",jsp_history);
		this.setSize(900, 400);
		this.setVisible(true);
	}
}
