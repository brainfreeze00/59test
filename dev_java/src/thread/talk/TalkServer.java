package thread.talk;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import thread.bank.ServerBankThread;

public class TalkServer extends JFrame implements Runnable {
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
	List<Login> globalList = null;
	TalkServerThread tst = null;
	TalkDao tDao = new TalkDao();

	public static void main(String[] args) {//������ �α��� ���ϴϱ� �翬 �־����
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts);
		th.start();
	}
	//���� ���ϰ� Ŭ���̾�Ʈ�� ������ �����ϱ�
	@Override
	public void run() {
		globalList = new Vector<Login>();
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
				tst = new TalkServerThread(this);//�θ� Ŭ���� �����ޱ�����- �׻���� ������ �����ؾ��ϱ⿡ this-ServerBank�ڽ� -����
				tst.start();//�����忡 ������ run() ȣ��
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
			this.setTitle("TalkServer �α�â");
			this.add("West",jsp_log);
			this.add("Center",jsp_history);
			this.setSize(900, 400);
			this.setVisible(true);
		}

}
