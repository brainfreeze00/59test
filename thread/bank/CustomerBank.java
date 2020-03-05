package thread.bank;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerBank extends JFrame {
	Socket socket = null;
	ObjectInputStream ois = null;//�б� - ���
	ObjectOutputStream oos = null;//���ϱ� - ����
	String mem_id = null; //����
	JPanel jp_south = new JPanel(); // ȭ�鿡 timer ���ϰ��� �� �Ʒ���
	JLabel jlb_time = new JLabel("����ð�",JLabel.CENTER); // Ÿ��Ŭ���̾�Ʈ���� �Ծ� init���� ����ϴϱ�
	JTextArea jta_clog = new JTextArea(8,30);
	JScrollPane jsp_clog = new JScrollPane(jta_clog
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED 
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public CustomerBank() {
		mem_id = JOptionPane.showInputDialog("���̵� �Է��ϼ���.");
		if(mem_id == null) { //�̰� �־�� ȭ���� �����ش�.
			return; //������ Ż�� - �Ʒ� �޼ҵ�2���� ȣ���� �ȵſ�.
		}
		initDisplay();
		connect_process();
	}
	
	//ȭ��
	private void initDisplay() {
		jp_south.setLayout(new BorderLayout()); //��ġ������ ���� - �߾�, ����
		jp_south.add("Center",jsp_clog); 
		jp_south.add("South",jlb_time);
		this.setTitle(mem_id +"�� �����Դϴ�."); // �������� mem_id
		//this.add("Center",jsp_clog);
		this.add("South",jp_south); // �ð� �Ʒ� ������
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	//������ �����ϱ� ����
	public void connect_process() {                                    //    TimeClient �Ծ�
		try {                                                          //    TimeClient
			socket = new Socket("192.168.0.240",3000);//���� ip,port     //    TimeClient
			oos  = new ObjectOutputStream(socket.getOutputStream());   //    TimeClient
			//Ŭ���̾�Ʈ�� ���� ������ ���                            //    							 TimeClient
			ois = new ObjectInputStream(socket.getInputStream());      //    TimeClient
			oos.writeObject(100+"#"+mem_id); // ī������� �ִ� �� ����     			 TimeClient
		} catch (Exception ie) {                                       //    TimeClient
			System.out.println("���� ������ ������ �� �����ϴ�.");     //  			 TimeClient
		}	                                                           //    TimeClient
	}
	
	//Ÿ�ӿ� �����ϱ� ����
	public void time_process() {
		
	}
	
	//����
	public static void main(String[] args) {
		CustomerBank cb = new CustomerBank();
		
	}

}
