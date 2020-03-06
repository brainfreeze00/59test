package friday0207;
/*
 * �����ε� :���� �̸��� �޼ҵ带 ���� �� �����鼭 �Ű������� ������ ������ �ٸ����� �ϴ� ���
 * �������̵� : ���� Ŭ������ ������ �ִ� �޼ҵ带 ���� Ŭ������ ������ �ؼ� ����Ѵ�.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

public class BaseBallGameEvent implements ActionListener {
	DBConnectionMgr 	dbMgr = null;
	Connection        	  con = null;
	BaseBallGameView   bbView = null;
	//BaseBallGameLogic bbLogic = new BaseBallGameLogic(); // ����
	//������ �����ϴ� ���ȿ��� ��� �� ���ڸ� ����ϰ� �ִٰ� 1�� �����Ǿ��ϴϱ�...
	//���������� �ؾ���.
	int cnt = 0; // ȸ���� ����� ���� ����
	
	public BaseBallGameEvent(BaseBallGameView bbView) { //����
		this.bbView = bbView; //�Ķ���͸� ����Ű�� �־��� ����  �������ذ�
		//this : �� �ǹ��ϰ� ���⼭�� ���� ����: �ǹ̴� ���������̴�.
		//���ǻ��� �Ķ���ͷ� �ǳζ� �޴°͵� �ۼ����־�� �Ѵ�. 
		//������,�޼ҵ���(�Ķ����)�� ������ ���� ���ϱ⶧����
		//���� this��  BaseBallGameEvent�̴�
	}
	public void exitGame() {
		System.exit(0);       
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//insert here
		//BaseBallGameView bbView = new BaseBallGameView();
		if(obj == bbView.jbtn_dap) {
			System.out.println("���� ��ư ȣ�⼺��");
			bbView.jta_display.append(bbView.bbLogic.com[0]+""
			+bbView.bbLogic.com[1]+""+bbView.bbLogic.com[2]); //com ������
			bbView.jbtn_dap.setEnabled(false);
		}
		else if(obj == bbView.jbtn_clear) {
			System.out.println("������ư ȣ�⼺��");
			bbView.jta_display.setText("");
		}
		else if(obj == bbView.jmi_oracle) { // �ּҹ��� �������� 
			System.out.println("����Ŭ �׽�Ʈ ȣ�� ����");
			dbMgr = DBConnectionMgr.getInstance(); // �� �ν��Ͻ�ȭ
			con = dbMgr.getConnection(); // Ŀ�ؼ� �ٸ޼ҵ� ȣ��
			if(con !=null) { // ���� ���� �ƴ϶�� 
				System.out.println("����Ŭ �������� ����"+con);
			}else  {  // ���� ���̶�
			 System.out.println("����Ŭ ���� ���� ����");	
			}
		}
		else if(obj == bbView.jbtn_exit) {
			System.out.println("������ ��ư ȣ�� ����");
			exitGame(); // �޼ҵ� ȣ�� 
		}
		//�������� �����Ŵ�?
		else if(obj == bbView.jbtn_next) {
			System.out.println("�������� ��ư ȣ�� ����");
			cnt = 0; //��������
			//���ڸ� ���� �ٽ� ä���ؿ�.
			bbView.bbLogic.ranCom(); // ��ü�����ؾ���
			//�����ư �ٽ� Ȱ��ȭ�ϱ�
			bbView.jbtn_dap.setEnabled(true);
			//BaseBallGameLogic �ȿ� com�迭�� ����Ǿ� ����.
			//�ν��Ͻ�ȭ�� �� �����̹Ƿ� ������ ������.
			for(int coms:bbView.bbLogic.com) {
				System.out.print(coms+"");
			}
			System.out.println();
		}
		//���ڸ� ���ڸ� �Է��߾�?
		else if(obj == bbView.jtf_input) {
			int no = 0;
			bbView.jta_display.append(++cnt+"ȸ : "+bbView.jtf_input.getText()+"==>"
		+bbView.bbLogic.account(bbView.jtf_input.getText())+"\n");//256 �̼����� �ǹ� ã�ƶ�
			no = cnt;
			//insert here - ����Ŭ ������ insert�� ��û ó���ϱ�
			//�����ؾ��ϴ� ������ ����غ��� 
			System.out.println("mem_id : "+bbView.result[1]); //bbView�� �ִ� ����Ʈ1
			System.out.println("game_seq : "+no);
			System.out.println("input : "+bbView.jtf_input.getText());
			System.out.println("hint : "+bbView.bbLogic.account(bbView.jtf_input.getText()));
			System.out.println("dap : "+bbView.bbLogic.com[0]
									 +""+bbView.bbLogic.com[1]
									 +""+bbView.bbLogic.com[2]);
			BaseballVO bbVO = new BaseballVO(bbView.result[1]
					                       ,no
					                       ,bbView.jtf_input.getText()
					                       ,bbView.bbLogic.account(bbView.jtf_input.getText())
					   					   ,bbView.bbLogic.com[0]
					   					 +""+bbView.bbLogic.com[1]
					   					 +""+bbView.bbLogic.com[2]);

			System.out.println("mem_id : "+bbVO.getMem_id()); //bbView�� �ִ� ����Ʈ1
			System.out.println("game_seq : "+bbVO.getGame_seq());
			System.out.println("input : "+bbVO.getInput());
			System.out.println("hint : "+bbVO.getHint());
			System.out.println("dap : "+bbVO.getDap());
			bbView.jtf_input.setText("");
			int result = bbView.bbLogic.history(bbVO);
			if(result == 1) {
				JOptionPane.showMessageDialog(bbView, "��ϼ���");
			}else if(result == 0) {
				JOptionPane.showMessageDialog(bbView, "��Ͻ���");
				
			}
			//VO�� ���� �ʱ�ȭ �Ҷ� �����ڸ� Ȱ���� ������.
			//if(bbView.jtf_input.getText().length()==0) {
			//	System.out.println("�Է����ֽ���");
			//}
		}
	}

}
