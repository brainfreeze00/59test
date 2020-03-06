package thread.talk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import thread.bank.CustomerBankThread;

public class TalkClient extends JFrame {
	Socket socket = null; // ���� - ��������
	ObjectInputStream ois = null;//�б� - ���
	ObjectOutputStream oos = null;//���ϱ� - ����
	String mem_id = null; //����
	JPanel jp_center = new JPanel();
	String cols[] = {"��ȭ��"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_nickName = new DefaultTableModel(data,cols);
	JTable jtb_nickName = new JTable(dtm_nickName); 
	JScrollPane jsp_nickName = new JScrollPane(jtb_nickName
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_south = new JPanel(); // ȭ�鿡 timer ���ϰ��� �� �Ʒ���
	JLabel jlb_time = new JLabel("����ð�",JLabel.CENTER); // Ÿ��Ŭ���̾�Ʈ���� �Ծ� init���� ����ϴϱ�
	JTextArea jta_clog = new JTextArea(8,30);
	JScrollPane jsp_clog = new JScrollPane(jta_clog
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public TalkClient(){
		mem_id = JOptionPane.showInputDialog("���̵� �Է��ϼ���.");
		if(mem_id == null) { //�̰� �־�� ȭ���� �����ش�.
			return; //������ Ż�� -�� ���̵� null�϶� �Ʒ� �޼ҵ�2���� ȣ���� �ȵſ�.
		}
		initDisplay(); // �����ڿ��� ȭ�� ȣ��
		connect_process(); // �����ڿ��� Ÿ������ȣ��
	}
	public void initDisplay() {
		jp_south.setLayout(new BorderLayout()); //��ġ������ ���� - �߾�, ����
		jp_center.setLayout(new GridLayout(1,2)); //��ġ������ ���� - �߾�, ����
		jp_center.add(jsp_nickName);
		jp_south.add("Center",jsp_clog); //���͹��⿡ JSCrollpane ����
		jp_south.add("South",jlb_time); // South���⿡ ����ð� ����
		this.setTitle(mem_id +"���� ä��â�Դϴ�."); // �������� mem_id
		this.add("Center",jp_center);
		this.add("South",jp_south); // �ð� �Ʒ� ������
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public void connect_process() {
		try {                                                          //    TimeClient
			socket = new Socket("192.168.0.240",3000);//���� ip,port     //    TimeClient
			oos  = new ObjectOutputStream(socket.getOutputStream());   //    TimeClient
			//Ŭ���̾�Ʈ�� ���� ������ ���                            //    							 TimeClient
			ois = new ObjectInputStream(socket.getInputStream());      //    TimeClient
			oos.writeObject(100+"#"+mem_id); // ī������� �ִ� �� ����     			 TimeClient
			//Ŀ���ҹ�ũ������ �ν��Ͻ�ȭ �� start()ȣ��
			TalkClientThread tct = new TalkClientThread(this); 
			tct.start();
		} catch (Exception ie) {                                       //    TimeClient
			System.out.println("���� ������ ������ �� �����ϴ�.");     //  			 TimeClient
		}	                                                      	
	}
}
