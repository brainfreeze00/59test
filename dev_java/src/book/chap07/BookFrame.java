package book.chap07;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookFrame extends JFrame {
	//�÷�
	String cols[] = {"å����","å����"}; // �÷�
	//�� ������
	String data[][] = new String[0][2]; 
	//������ �����̸� JTable ��ü�� �����Ҷ� �������ش�
	DefaultTableModel	 dtm_book = new DefaultTableModel(data, cols); 
	//getSelectRow()�޼ҵ忡 ���ؼ� �����غ���
	JTable jtb_book = new JTable(dtm_book);
	//���ѵǾ� �ִ� ȭ�鿡 ȭ�麸�� �� ū ������Ʈ�� ǥ���ϱ����� ���ڷ� ����� �߰��� �г� �ַ� JTree, JTable, JList, JTexArea�� �Բ� ���
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	
	//������
	public BookFrame() {
		//��̸���Ʈ���� ���̺귯���� �ν��Ͻ�ȭ�Ѵ� <> �� �����ڴ� ���׸��̶� �θ��� �Էµ� Ŭ������ �ð�ȭ�Ѵ�. �ּҹ����� ��ȯ�Ѵ�.
		ArrayList<Book1> library = new ArrayList<>();
		//��1���� b1�� ��1�� ���� �����Ѵ�.
		Book1 b1 = new Book1();
		//b1�� �ּҹ����� �ִ�  b_title�� string Ÿ���� "�¹���"�� �����Ѵ�.
		b1.b_title = "�¹���";
		//b1�� �ּҹ����� �ִ�  b_author�� string Ÿ���� "������"�� �����Ѵ�.
		b1.b_author = "������";
		//���̺귯���� b1���ڸ� �߰��Ѵ�.
		library.add(b1);
		b1 = new Book1();
		b1.b_title = "���̾�";
		b1.b_author = "�츣�� �켼";
		library.add(b1);
		//���̺귯���� ����� ����Ѵ� INDEX
		System.out.println("size : "+library.size()); // 2
		//�������� v�� �ν��Ͻ�ȭ�Ѵ�  <> �� �����ڴ� ���׸��̶� �θ��� �Էµ� Ŭ������ �ð�ȭ�Ѵ�. �ٸ� String�� ���� ��ȯ�ȴ�
		Vector<String> v = new Vector<>(); // 1 ��  2����
		//���̺귯�� �ε��� 0�� b_title���� get�޼ҵ带 ���� �ҷ����� v�� �߰��Ѵ�. 
		v.add(library.get(0).b_title); 
		//���̺귯�� �ε��� 0�� b_author���� get�޼ҵ带 ���� �ҷ����� v�� �߰��Ѵ�. 
		v.add(library.get(0).b_author);
		//dtm_book�ּҹ����� v���ڸ� addRow�޼ҵ带 ���� �߰��Ѵ�.
		dtm_book.addRow(v); // addRow�޼ҵ忡 �� �Ķ����  1. object 2. vector
		v = new Vector<>(); // �� �� �ν��Ͻ� ������ ? : �ٸ� ���� �־�� �ϴϱ�  2 ���� 2����
		//���̺귯�� �ε���1�� b_title���� get�޼ҵ带 ���� �ҷ����� v�� �߰��Ѵ�
		v.add(library.get(1).b_title);
		//���̺귯�� �ε���1�� b_title���� get�޼ҵ带 ���� �ҷ����� v�� �߰��Ѵ�
		v.add(library.get(1).b_author);
		//dtm_book�ּҹ����� v���ڸ� addRow�޼ҵ带 ���� �߰��Ѵ�.
		dtm_book.addRow(v);
		//jsp_book���� ȭ��  ������ġ�� �߰�
		this.add("Center", jsp_book);
		//ȭ�������
		this.setSize(600, 300);
		//����� ȭ�� ����
		this.setVisible(true);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		//������������ �ٷ� �����ϹǷ� ������� �ٷ� �ν��Ͻ�ȭ
		new BookFrame();
	}

}
