package design.book;

import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
//port, ip ������ �˾ƾ���
public class TimeClient extends Thread {
	JFrame jf =new JFrame();
	JLabel jlb_time = null;
	JLabel jlb_time2 = new JLabel("����ð�",JLabel.CENTER);
	//run�޼ҵ庸�� TimeClient�����ڰ� �ݵ�� ���� ����Ǿ���Ѵ� ���ð�������
	public TimeClient(){
		jf.add("North",jlb_time2);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	/*
	 * ��ü ���԰���� BookApp.java���� TimeClient(JLabel)�����ڸ� ȣ����.
	 */
	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
	public void run() { // ois�� �ϰ� �Ǵ� ������ �ִ�.
		String time = null;
		Socket socket = null;
		ObjectInputStream ois = null;//�б� - ���
		ObjectOutputStream oos = null;//���ϱ� - ����
		try {
			socket = new Socket("192.168.0.240",3000);//���� ip,port
			oos  = new ObjectOutputStream(socket.getOutputStream());
			//Ŭ���̾�Ʈ�� ���� ������ ���
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				time = (String)ois.readObject();
				if(time!=null) {
					//System.out.println(time);
					Font f = new Font("sans serif",Font.BOLD,30);
					jlb_time.setFont(f);
					jlb_time.setText(time);//�ð��� ȭ�鿡 �������� time����
					try {
						sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println("�� ~~ ...");
					}
				}
			}
		} catch (Exception ie) {
			System.out.println("Ÿ�� ������ ������ �� �����ϴ�.");
		}
	}
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}
