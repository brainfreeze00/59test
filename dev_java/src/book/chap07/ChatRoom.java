package book.chap07;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ChatRoom extends JFrame{
	//JTable ����� �� �������� �̸��� 1���迭�� �����ϱ�
	String cols[] = {"����", "���ο���", "���������ڸ��"};
	//JTable�� �� ������ ������ �����ϱ�
	//�����ʹ� �������� �����Ƿ� 0�� �־��� �÷��� ���� ����, ���ο���, ���� �����ڸ��
	//�̷��� 3�̹Ƿ� 3�� �־���
	String data[][] = new String[0][3];
	//������ �����͸� ������ �ִ� �ڹٿ��� �����Ǵ� Ŭ������
	//ȭ�鿡 ���϶��� ����������� 2���迭�� ���Խ�Ű������
	DefaultTableModel dtm_room = new DefaultTableModel(data, cols);
	//JTable�� ����� ������ �� �����ʹ� DefaultTableModel�� �ʱ�ȭ�Ǿ�� ��.
	JTable jtb_room = new JTable(dtm_room);
	//JScrollPane�� ������ ������ ��ũ�ѵǴ� ȭ��ǥ�� ��������
	JScrollPane jsp_room = new JScrollPane(jtb_room);
	
	public ChatRoom() {
		ArrayList<Room> al = new ArrayList<Room>();
		Room r = new Room();
		r.t_inwon = 30;
		r.c_inwon = 25;
		al.add(r);
		Vector<Room> v = new Vector<Room>();
		//���� ���������� ȭ�鿡 ���� �� JTable�� �ƴ� JScrollPane�� ����.
		this.add("Center", jsp_room);
		//â�ݱ�� �ڿ��ݳ�ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 500);
	}
	
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ChatRoom();
	}

}
