package design.book;

import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
//port, ip 서버를 알아야함
public class TimeClient extends Thread {
	JFrame jf =new JFrame();
	JLabel jlb_time = null;
	JLabel jlb_time2 = new JLabel("현재시간",JLabel.CENTER);
	//run메소드보다 TimeClient생성자가 반드시 먼저 실행되어야한다 대기시간때문에
	public TimeClient(){
		jf.add("North",jlb_time2);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	/*
	 * 객체 주입관계는 BookApp.java에서 TimeClient(JLabel)생성자를 호출함.
	 */
	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
	public void run() { // ois를 하게 되니 들을수 있다.
		String time = null;
		Socket socket = null;
		ObjectInputStream ois = null;//읽기 - 듣기
		ObjectOutputStream oos = null;//말하기 - 쓰기
		try {
			socket = new Socket("192.168.0.240",3000);//서버 ip,port
			oos  = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트가 말한 내용을 듣기
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				time = (String)ois.readObject();
				if(time!=null) {
					//System.out.println(time);
					Font f = new Font("sans serif",Font.BOLD,30);
					jlb_time.setFont(f);
					jlb_time.setText(time);//시간을 화면에 띄우기위해 time대입
					try {
						sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println("앗 ~~ ...");
					}
				}
			}
		} catch (Exception ie) {
			System.out.println("타임 서버에 접속할 수 없습니다.");
		}
	}
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}
