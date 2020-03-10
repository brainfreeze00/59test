package design.book;
//MVC ���� �˻�
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

import javafx.scene.image.Image;
/*Main ���� ������ ������ ���� ��� �Է¹�ư, ������ư, �׸��� ��.....
 * �� ���� ��ȸ�� ����� ��� �ִ�  BookVO��ü Ȥ��  Map��ü������ ������ �ִ�
 * set�޼ҵ带 �߰��Ͻÿ�
 * 
 * BookMain�� �ν��Ͻ�ȭ �� �� ���������� �����  BookDialog�� ���� �ν��Ͻ�ȭ�� �Ѵ�.
 * �̶� �Ķ���ͷ� �Ѿ boolea,String�� ���� �̹� ������ �����̹Ƿ� �ƹ��� ��ư��
 * �ٲپ��� title�� ���� ������ �ʴ� ���̴�.
 * 
 * �����ڰ� ȣ��Ǵ� ������ �̺�Ʈ�� �����Ǵ� ���������� ���̰� �߻��Ͽ���.
 * 
 * public void set(����,��������,Map){}  
 */

public class BookApp extends JFrame implements ActionListener {
	//�����
	//DBĿ�ؼ� �����ϱ�
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//�̹��� ��� �߰�
	String imgPath = "src\\design\\book\\"; //�̹����� �����ϴ� ��� 
	URL bookURL = getClass().getResource("book.jpg"); // ���� �̸�
	ImageIcon bicon = new ImageIcon(bookURL); 
	//�޴��� �߰��ϱ�
		JMenuBar jmb_book 	= new JMenuBar();
		JMenu	 jm_file 	= new JMenu("File");
		JMenuItem jmi_open	= new JMenuItem("Open File");	//file
		JMenuItem jmi_exit	= new JMenuItem("Exit");    	//file
		JMenuItem jmi_db	= new JMenuItem("DB����");   	//file
		JSeparator js_file 	= new JSeparator(); 	// ���м�
		JMenu	 jm_edit 	= new JMenu("Edit"); 	//5���� �޴���
		JMenuItem jmi_all   = new JMenuItem("��ü��ȸ");  	//edit
		JMenuItem jmi_sel   = new JMenuItem("����ȸ",new ImageIcon(imgPath+"detail.gif"));  	//edit
		JMenuItem jmi_ins   = new JMenuItem("�Է�",new ImageIcon(imgPath+"new.gif"));      	//edit
		JMenuItem jmi_upd   = new JMenuItem("����",new ImageIcon(imgPath+"update.gif"));      	//edit
		JMenuItem jmi_del   = new JMenuItem("����",new ImageIcon(imgPath+"delete.gif"));      	//edit
	static BookApp ba 		= null; //���θ޼ҵ� static������ �ܺ� ������ �ȵǾ� ���� �������� ����
	//�Ķ���Ͱ� ���� �����ڴ� ������� ������������ �ִ� ���� �����Ұ��̹Ƿ� �����Ұ���
	BookDialog bd 			= new BookDialog(); //�ٱ��ʿ� ó���ϱ����� ���� �Ķ���Ϳ� �Է�
	//jp_north������ JFrame ���ʿ� ��ġ
	JPanel      jp_north 	= new JPanel();
	//�Ʒ� ��ư�� jp_north������ ���ʴ�� ��ġ �� ��ġ�� ���ʺ���
	JToolBar    jtbar		= new JToolBar();
	JButton     jbtn_db 	= new JButton("DB����"); //
	JButton     jbtn_all 	= new JButton("��ü��ȸ");
	JButton     jbtn_sel 	= new JButton("����ȸ");
	JButton     jbtn_ins 	= new JButton("�Է�");
	JButton     jbtn_upd 	= new JButton("����");
	JButton     jbtn_del 	= new JButton("����");
	JLabel      jlb_time2   = new JLabel("����ð�",JLabel.CENTER);
	TimeClient  tc 			= null; //Ŭ���̾�Ʈ���� ��� �ۿ��� ����ϱ����� ���������� ������ 
	String cols[] = {"������ȣ","������","����","���ǻ�"};              		   //set
	String data[][] = new String[0][4];                                    //set
	DefaultTableModel dtm_book = new DefaultTableModel(data, cols);        //set
	JTable jtb_book = new JTable(dtm_book);                                //set
	JScrollPane jsp_book = new JScrollPane(jtb_book);                      //set
	BookDao bDao = new BookDao();
	BookController bCtrl = new BookController(this);
	
	//�̺�Ʈ �ҽ��� �̺�Ʈ ��鷯 Ŭ���� �����ϱ�
	public void eventMapping() {
		//db���� ��ư �̺�Ʈ ö
		jbtn_db.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
				
			}
		});
		jmi_db.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
				
			}
		});
//		jmi_all.addActionListener(this);
//		jbtn_all.addActionListener(this);
	}
	protected void dbActionPerformed(ActionEvent ae) { //DB���� Ȯ��
		System.out.println("db���� �׽�Ʈ");
		Connection con = null;
		con = dbMgr.getConnection();
		System.out.println(con.toString());
	}
	// initDisplay�� �ν��Ͻ�ȭ�Ͽ� start�޼ҵ� ȣ��
	//ȭ�� �׸���
	public void initDisplay() {
		jm_file.setMnemonic('F'); //����Ű �̿�
		jm_file.setMnemonic('E'); //����Ű �̿�
		jm_file.add(jmi_db);
		jm_file.add(jmi_open);
		jm_file.add(js_file); // ���м� ��ġ
		jm_file.add(jmi_exit);
		jm_edit.add(jmi_all);
		jm_edit.add(jmi_sel);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jmb_book.add(jm_file);
		jmb_book.add(jm_edit);
		this.setJMenuBar(jmb_book); // j�޴��� ����(jmb_book�� ���?)
		//������ Ÿ�Ӽ����� ���� �ð������� ���� TimeClient���� ���� ������ 
		//�������� �Ķ���͸� ���ؼ� BookApp jlb_time ������ �ּҹ�����
		//�Ѱ����Ƿ� TimeClient������ ������ ���� ���ָ� ȭ�鿡 ����.
		tc = new TimeClient(jlb_time2); 
		tc.start();
		//insert here
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif")); //
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));    //
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif")); //
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif")); //
		jbtn_sel.setToolTipText("����ȸ"); // ��ư�� ���콺Ŀ�� �ø��� ������
		jbtn_ins.setToolTipText("�Է�");     //��ư�� ���콺Ŀ�� �ø��� ������
		jbtn_upd.setToolTipText("����");     //��ư�� ���콺Ŀ�� �ø��� ������
		jbtn_del.setToolTipText("����");     //��ư�� ���콺Ŀ�� �ø��� ������
		jtbar.add(jbtn_db);  //jp_north -> jtbar
		jtbar.add(jbtn_all);  //jp_north -> jtbar
		jtbar.add(jbtn_sel);  //jp_north -> jtbar
		jtbar.add(jbtn_ins);  //jp_north -> jtbar
		jtbar.add(jbtn_upd);  //jp_north -> jtbar
		jtbar.add(jbtn_del);  //jp_north -> jtbar
		//�Ʒ��ڵ尡 JFrame�� �ڿ��� ȸ����
		//�θ� �ڿ��� ȸ�� �ɶ� JDialog�� ���� ȸ����
		this.add("Center", jsp_book); //������ȣ ������ ���� ���ǻ� 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //main+sub�Ѵ� �ݱ� ->�ڿ�ȸ��
		this.setTitle("���������ý���");
		this.add("North",jtbar);//JPanel ȭ�� �ֱ� //jp_north -> jtbar�� �����ߴ�. �����ϵ���
		this.add("South",tc.jlb_time2);//Ÿ�̸� �ֱ�
		this.setSize(700, 500);
		this.setIconImage(bicon.getImage());//�̹��� ÷��
		this.setVisible(true);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TimeServer ts = new TimeServer();//�Ķ���� - ���� client
		/*���������� 1�ʿ� �ѹ��� ��ٷȴ� �����Ҷ� �����尡 �ʿ��ϴ�.
		 *������ : ��ٸ��� �޼ҵ�� ����  1000 = 1�� sleep ��ٷ� 
		 */
		ts.initDisplay(); //ȭ���� �׸���  ���� ������ ��⸦ Ÿ���� �ؾ���
		Thread th = new Thread(ts);
		th.start();//java.lang.Thread �������� run�޼ҵ带 ȣ���ϴ� �޼ҵ� - �����带 ���۽�Ŵ
		ba = new BookApp(); // ����ƽ������ Ÿ���̶� ���� �ν��Ͻ�ȭ �ϸ� �ȵ�¡!
		ba.initDisplay(); //ȭ�� ó���κ�
		ba.eventMapping(); //�̺�Ʈ���� - �͸�Ŭ���� ó�� �̺�Ʈ����ȣ��
	}
//JButton�� ���� �̺�Ʈ�� �����ϴ� �������̽��� ActionListener��.
	//Ŭ���� �ڿ� implements�Ұ� 
	//ActionListener�� ���ǵ� �߻�޼ҵ带 �������Ұ�
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� ������ Ŭ������ �ּҹ��� �ޱ�
		Object obj = e.getSource();
		//�Է¹�ư�� �����Ŵ�?
		if(obj==jbtn_ins) {
			System.out.println("�Է�ȣ�⼺��");
			//Map<String,Object> rMap = new HashMap<>();
			//bd.set("�Է�",true, true, rMap, ba);
			BookVO bVO = null;
			bd.set("�Է�",true, true, bVO, ba);
			//initDisplay�� ȣ���� ������ setTitle("�Է�")�� setVisible(true)
			//�����̾���. �׷��� �� ���� set�޼ҵ�� �����Ͽ���.
			//insert here
		}
		else if(obj==jbtn_upd) {//�����ÿ��� ���� �⺻ ������ ��ȸ�ϰ� ȭ���̵�ó��
			System.out.println("����ȣ�⼺��");
			//selectó���� �� �� �� �ο츦 �޾Ƽ� Map�� ����
			Map<String, Object> rMap = null; //��ȸ�� �Ŀ� ��ƾ���
			rMap = new HashMap<>();
			rMap.put("b_title", "�ڹ��� ����");
			rMap.put("b_author", "���ü�");
			rMap.put("b_publish", "��������");
			bd.set("����",true, true, rMap, ba);
		}
		else if(obj==jbtn_sel) {
			System.out.println("����ȸȣ�⼺��");
			Map<String, Object> rMap = null; //��ȸ�� �Ŀ� ��ƾ���
			int indexs[] = jtb_book.getSelectedRows();
			if(indexs.length==0) {
				JOptionPane.showMessageDialog(this, "����ȸ �� �ο츦 �����ϼ���.");
				return; // ������������
			}
			else {
				int b_no = Integer.parseInt(
						dtm_book.getValueAt(indexs[0], 0).toString()); //������ �ε��� 0
				System.out.println("b_no : "+b_no); // ������ȣ���    //2
				BookVO pbVO = new BookVO();
				pbVO.setCommand("detail");
				pbVO.setB_no(b_no);
				BookVO rbVO = bCtrl.send(pbVO);
				bd.set("�󼼺���",true, false, rbVO, ba);
			}
			//bd.set(jbtn_sel.getText(),true, false, rMap, ba);
		}
		else if(obj==jbtn_del) {
			System.out.println("����ȣ�⼺��");
			
		}
		else if(obj==jbtn_all) {
			System.out.println("��ü��ȸ ȣ�⼺��");
			refreshData();
		}
	}
	public void refreshData() {
		System.out.println("refreshData ȣ�� ����");
		List<BookVO> bookList = null;
		BookVO pbVO = new BookVO();
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		//������ ��ȸ��  ����� ����� ȭ���� ����ó���Ѵ�.
		while(dtm_book.getRowCount()>0) {// bookList.size() ���ڿ� ����
			dtm_book.removeRow(0); // ��� �ο����ŭ �ݺ��ϸ鼭 ù��° �ο� �� 0�� ��� �����ش�.
		}
		//������ �� �ٽ� ����ϱ�
		for(int i=0;i<bookList.size();i++) { // ����ڿ��� ������ �ϴ� �κ�
			BookVO bVO = bookList.get(i);
			Vector<Object> v = new Vector<>();
			v.add(bVO.getB_no());
			v.add(bVO.getB_name());
			v.add(bVO.getB_author());
			v.add(bVO.getB_publish());
			//JTable�� �߰��ϴ� ���� �ƴϴ�. -JTable�� ����� ���̰�
			//���� �����͸� ���� Ŭ������ DefaultTableModel �̴� - DataSet ������ DataSet : �����͵��� ����
			//�Ѱ��ο�� Vector�� ��� �� ���͸� for���ȿ��� �ݺ� �߰�����
			dtm_book.addRow(v);
		}
	}///end of refreshData
}//class
