package UI.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
//UI�� /������ ���õ� â�� ������ ���� Ŭ���� 
public class JInternalFrameTest implements ActionListener { 
	JFrame jf = new JFrame();
	//�� ���̸� �߾ӿ� ��ġ�ϰ� JInternalFrame���� ���ο� ����� â�� �����
	//JFrame â �ȿ� �������� ����â�� ������ �� �ִ�.
	JDesktopPane jdp = new JDesktopPane();
	JPanel jp_north = new JPanel(); // ���� ����
	JButton jbtn_zip = new JButton("�����ȣã��"); 
	JButton jbtn_virus = new JButton("���̷���"); 
	JButton jbtn_bacteria = new JButton("����"); 
	JButton jbtn_fungi = new JButton("����"); 
	JButton jbtn_parasite = new JButton("�����"); 
	public JInternalFrameTest() {
		initDisplay();
	}
	
	public void initDisplay() {
		//���ȿ� actionPerformed�޼ҵ带 �����Ͽ���.
		//�� �ڵ尡 �־�� �ڵ�(���� JVM)���� actionPerformed�޼ҵ带 ȣ������  
		jbtn_zip.addActionListener(this);// ������ ���� ����
		jf.setTitle("������â�� ���� ������ �����ϱ�");
		//jp_north������ �����ȣ ã�� ��ư�� �����ʿ������� ���δ�.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_zip); // �г����� ��ư ���̱�
		jp_north.add(jbtn_bacteria); // �г����� ��ư ���̱�
		jp_north.add(jbtn_virus); // �г����� ��ư ���̱�
		jp_north.add(jbtn_fungi); // �г����� ��ư ���̱�
		jp_north.add(jbtn_parasite); // �г����� ��ư ���̱�
		//���ʿ��� jp_north������ �ٿ��ٱ�
		jf.add("North",jp_north); // ���ÿ�
		//jf�� �߾ӿ� JDesktopPane ������ �ٿ��ٷ�
		jf.add("Center",jdp);
		jf.setSize(700, 500);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JInternalFrameTest(); //�ν��Ͻ�
	}/////////////////////end of main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_zip) {
			//System.out.println("�����ȣ ã�� ȣ�� ����");
			InnerFrame inn = new InnerFrame(jbtn_zip.getText()
					,true
					,true
					,true
					,true);
			jdp.add(inn);
			}
		if(e.getSource()==jbtn_bacteria) {
			InnerFrame inn2 = new InnerFrame(jbtn_bacteria.getText()
					,true
					,true
					,true
					,true);
			jdp.add(inn2);
		}
	}//////////////////////////end of actionPerformed
}
class InnerFrame extends JInternalFrame{
	InnerFrame(String title, boolean resizable
			,boolean closable, boolean maximizable
			,boolean iconifiable)
	{
		//�ƺ� ������ ȣ�⹮�� - �ƺ���ü�� ���� ��ɵ��� ������ ���� �� �ִ�.
		super(title, resizable,closable,maximizable, iconifiable);
		this.setSize(300, 200);
		this.setTitle(title);
		this.setVisible(true);
	}
}