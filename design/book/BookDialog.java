package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BookDialog extends JDialog implements ActionListener {
	/*�ڳ�â���� ����(�Է�) ���������� �θ�â�� refreshData�� ȣ���ؾ� �Ѵ�.
	 * �׷��� ������ �����ؾ� �ϹǷ� set�޼ҵ��� �Ķ���ͷ� �޾Ƽ� ����� ���̴�.
	 * �ٸ� �޼ҵ忡�� ba�� ����ؾ� �ϴϱ� ���������� ������ ���� �ʱ�ȭ�� �ݵ�� �Ұ�
	 */
	BookApp ba = null; 
	boolean isView = false;
	String title = null;
	//�ν��Ͻ�ȭ�� �ϸ� ������ ȣ���� �Ͼ
	JLabel jlb_title = new JLabel("å����");
	JLabel jlb_author = new JLabel("����");
	JLabel jlb_publish = new JLabel("���ǻ�");
	JTextField jtf_title = new JTextField(20);
	JTextField jtf_author = new JTextField(20);
	JTextField jtf_publish = new JTextField(20);
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("����");
	JButton jbtn_close = new JButton("�ݱ�");
	JScrollPane jsp = new JScrollPane(jp_center);
	
	public BookDialog() { // ũ������Ʈ ������ �Ѱ��� 
		jbtn_save.addActionListener(this); //����  �̺�Ʈ
		jbtn_close.addActionListener(this); //�ݱ� �̺�Ʈ 
	}
	//�Է°� �����ÿ��� �÷����� ���� �����ϵ��� �ϰ�
	//��ȸ�ÿ��� �Ұ����ϰ� �ϴ� �޼ҵ带 �����غ���.
	public void setEditable(boolean isOk) {
		jtf_title.setEditable(isOk); // ���ּ��� or Ű��
		jtf_author.setEditable(isOk); // ���ּ��� or Ű��
		jtf_publish.setEditable(isOk); // ���ּ��� or Ű��
		
	}
	/**********************************
	 * @param title ���̾�α�â ����
	 * @param isView ���̾�α�â �� ����
	 * @param editable �Է� ������Ʈ ��������
	 * @param rMap ��ȸ����� ���� �ּҹ���
	 ***********************************/
	//�����ڷδ� �ð����� �߻��ϹǷ� ���� �޼ҵ忡 �����Ѵ�
	public void set(String title,boolean isView
			,boolean editable, Map<String,Object> rMap, BookApp ba){
		this.ba = ba; // �ʱ�ȭ
		setValue(rMap); // �Է� | ����, ��
		setEditable(editable); //��������� �Ǿ��ϴ�
		this.setTitle(title);//�����ڷδ� �ð����� �߻��ϹǷ� ���� �޼ҵ忡 �����Ѵ�
		this.setVisible(isView);//�����ڷδ� �ð����� �߻��ϹǷ� ���� �޼ҵ忡 �����Ѵ�
		initDisplay(); // ������ �������ؼ� ȣ��
	}  
	public void initDisplay() { //���߿� ���� �־ �����
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		jlb_title.setBounds(20, 20, 100, 20);
		jtf_title.setBounds(120, 20, 150, 20);
		jlb_author.setBounds(20, 80, 100, 20);
		jtf_author.setBounds(120, 80, 150, 20);
		jlb_publish.setBounds(20, 140, 100, 20);
		jtf_publish.setBounds(120, 140, 150, 20);
		jp_center.add(jlb_title);
		jp_center.add(jlb_author);
		jp_center.add(jlb_publish);
		jp_center.add(jtf_title);
		jp_center.add(jtf_author);
		jp_center.add(jtf_publish);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setSize(500, 450);
		//�θ�â���� ������ ��ư�� ���� ȭ���� �����Ѵ�. - ����
	}
	public void setValue(Map<String, Object> rmap) { //rmap�� ������ ȣ��
		//�Է��� ���� ȭ�� ���� - ��� ����  ���ڿ��� �����Ѵ�.
		if(rmap == null) {
			setB_Title("");
		}
		//����ȸ�� �����ô� �Ķ���ͷ� ���� ������ �����Ѵ�.
		else{
			setB_Title(rmap.get("b_title").toString());
			setB_Title(rmap.get("b_author").toString());
			setB_Title(rmap.get("b_publish").toString());
		}
	}
	//�� �÷��� ������ �����ϰų� �о���� getter/setter�޼ҵ� �Դϴ�.
	public String getB_Title() { return jtf_title.getText();}
	public void setB_Title(String title) {jtf_title.setText(title);}
//	public static void main(String[] args) {
//		BookDialog bd = new BookDialog();
//		bd.set("�Է�",true,null);
//		bd.initDisplay();
//	}
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó��
		String command = e.getActionCommand(); //�̺�Ʈ�ҽ��� ���� �о��
		JOptionPane.showMessageDialog(ba, "�̺�Ʈ �ҽ� ��:"+command);
		//�����ư�� �����Ŵ�?
		if("����".equals(command)) {
			this.dispose();
			//insert here - �Է� ���� �������� ��� ��������?
			ba.refreshData();
		}
		//�ݱ��ư�� �����Ŵ�?
		else if("�ݱ�".equals(command)) {
			
		}
	}
}
