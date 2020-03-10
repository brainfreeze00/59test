package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	JLabel jlb_name = new JLabel("������");
	JTextField jtf_name = new JTextField(20);
	JLabel jlb_author = new JLabel("����");
	JTextField jtf_author = new JTextField(20);
	JLabel jlb_publish = new JLabel("���ǻ�");
	JTextField jtf_publish = new JTextField(20);
	JLabel jlb_info = new JLabel("�����Ұ�");
	JTextField jtf_info = new JTextField(20);
	JTextArea jta_info = new JTextArea(8,25);
	JScrollPane jsp_info = new JScrollPane(jta_info);
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("����");
	JButton jbtn_close = new JButton("�ݱ�");
	JScrollPane jsp = new JScrollPane(jp_center);
	BookVO rbVO = null;
	
	public BookDialog() { // ũ������Ʈ ������ �Ѱ��� 
		jbtn_save.addActionListener(this); //����  �̺�Ʈ
		jbtn_close.addActionListener(this); //�ݱ� �̺�Ʈ 
	}
	//�Է°� �����ÿ��� �÷����� ���� �����ϵ��� �ϰ�
	//��ȸ�ÿ��� �Ұ����ϰ� �ϴ� �޼ҵ带 �����غ���.
	public void setEditable(boolean isOk) {
		jtf_name.setEditable(isOk); // ���ּ��� or Ű��
		jtf_author.setEditable(isOk); // ���ּ��� or Ű��
		jtf_publish.setEditable(isOk); // ���ּ��� or Ű��
		jta_info.setEditable(isOk); // ���ּ��� or Ű��
		
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
	public void set(String title, boolean isView, boolean editable, BookVO rbVO, BookApp ba) {
		this.ba = ba; // �ʱ�ȭ
		this.rbVO = rbVO;
		setValue(rbVO); // �Է� | ����, ��
		setEditable(editable); //��������� �Ǿ��ϴ�
		this.setTitle(title);//�����ڷδ� �ð����� �߻��ϹǷ� ���� �޼ҵ忡 �����Ѵ�
		this.setVisible(isView);//�����ڷδ� �ð����� �߻��ϹǷ� ���� �޼ҵ忡 �����Ѵ�
		initDisplay(); // ������ �������ؼ� ȣ��
		
	}
	//��ȸ�� ����� BookDialog�� �ʱ�ȭ�ϱ�
	//���� �Է��ϴ� ��쿡�� �� ���ڿ��� �ʱ�ȭ�ϱ�
	/*******************************************
	 * BookApp���� ��ȸ�� �� ���� BookDialog�� �ʱ�ȭ��.
	 * @param rmap ��ȸ�� �� ���� Map���� ���� ���
	 *****************************************************/
	public void setValue(Map<String, Object> rmap) { //rmap�� ������ ȣ��
		//�Է��� ���� ȭ�� ���� - ��� ����  ���ڿ��� �����Ѵ�.
		if(rmap == null) {
			setB_name("");
			setB_author("");
			setB_publish("");
			setB_info("");
		}
		//����ȸ�� �����ô� �Ķ���ͷ� ���� ������ �����Ѵ�.
		//ó�� ����ÿ��� ������ �ߴ��� ���� bVO�� �߰� ó�� ��.
		else{
			setB_name(rmap.get("b_name").toString());
			setB_author(rmap.get("b_author").toString());
			setB_publish(rmap.get("b_publish").toString());
			setB_info(rmap.get("b_info").toString());
		}
	}
	/*******************************************
	 * BookApp���� ��ȸ�� �� ���� BookDialog�� �ʱ�ȭ��.
	 * @param rbVO ��ȸ�� �� ���� BookVO�� ���� ���
	 *****************************************************/
	private void setValue(BookVO rbVO) {
		//�Է��� ���� ȭ�� ���� - ��� ����  ���ڿ��� �����Ѵ�.
				if(rbVO == null) {
					setB_name("");
					setB_author("");
					setB_publish("");
					setB_info("");
				}
				//����ȸ�� �����ô� �Ķ���ͷ� ���� ������ �����Ѵ�.
				else{
					setB_name(rbVO.getB_name());
					setB_author(rbVO.getB_author());
					setB_publish(rbVO.getB_publish());
					setB_info(rbVO.getB_info());
				}
		
	}
	public void initDisplay() { //���߿� ���� �־ �����
		//TextArea�� �ڵ� �ٹٲ� ó���غ���
		jta_info.setLineWrap(true);//jtextarea.info.�ٹٲ� �޼ҵ� ȣ��
		//������ ���̾ƿ��� FlowLayout�̾������� null�� �ʱ�ȭ��
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		//ȭ�鿡 ��ġ�Ҷ� setBounds (x��ǥ, y��ǥ, ���α���, ���α���)
		//�տ� �� �ڸ��� ������ ��ǥ��
		//����° �׹�°�� ���� ���ΰ���
		jlb_name.setBounds(20, 20, 100, 20);
		jtf_name.setBounds(120, 20, 200, 20);
		jlb_author.setBounds(20, 45, 100, 20); //5�� ����
		jtf_author.setBounds(120, 45, 120, 20);
		jlb_publish.setBounds(20, 70, 100, 20);
		jtf_publish.setBounds(120, 70, 150, 20);
		jlb_info.setBounds(20, 95, 100, 20);
		jsp_info.setBounds(120, 95, 300, 160); // scroll�� ��°��� �׸��� 300�� 125���̹Ƿ� �ø��� 160�� �������� ������ �ø�
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_author);
		jp_center.add(jtf_author);
		jp_center.add(jlb_publish);
		jp_center.add(jtf_publish);
		jp_center.add(jlb_info);
		jp_center.add(jsp_info);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setSize(500, 450);
		//this.setVisible(true); //�׽�Ʈ���� �׽�Ʈ�Ҷ��� �����
		//�θ�â���� ������ ��ư�� ���� ȭ���� �����Ѵ�. - ����
	}
	
	//�� �÷��� ������ �����ϰų� �о���� getter/setter�޼ҵ� �Դϴ�.
	public String getB_name() { return jtf_name.getText();}
	public void setB_name(String name) {jtf_name.setText(name);}
	public String getB_author() {return jtf_author.getText();}
	public void setB_author(String author) {jtf_author.setText(author);}
	public String getB_publish() {return jtf_publish.getText();}
	public void setB_publish(String publish) {jtf_publish.setText(publish);}
	public String getB_info() {return jta_info.getText();}
	public void setB_info(String info) {jta_info.setText(info);}
	
//	public static void main(String[] args) {
//		BookDialog bd = new BookDialog();
//		bd.set("�Է�",true,true,new HashMap<>(),null);
//		bd.initDisplay();
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//�̺�Ʈ ó��
		String command = e.getActionCommand(); //�̺�Ʈ�ҽ��� ���� �о��
		JOptionPane.showMessageDialog(ba, "�̺�Ʈ �ҽ� ��:"+command);
		//�����ư�� �����Ŵ�?
		if("����".equals(command)) {
			//insert here - �Է� ���� �������� ��� ��������?
			if(rbVO!=null) {//����ó��
				
			}else {//�Է�ó��
				int result = 0;
				BookVO pbVO = new BookVO();
				pbVO.setB_name(getB_name());//�Է��� ������ ��������
				pbVO.setB_author(getB_author());//�����̸�
				pbVO.setB_publish(getB_publish());//���ǻ�
				pbVO.setB_info(getB_info());//������
				result = ba.bDao.bookInsert(pbVO);
				JOptionPane.showMessageDialog(ba, "result"+result);
			}
			ba.refreshData();
			this.dispose();
		}
		//�ݱ��ư�� �����Ŵ�?
		else if("�ݱ�".equals(command)) {
			this.dispose();
		}
		
	}//action
}
