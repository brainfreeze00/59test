package thread.talk;

import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;

import thread.bank.ServerBankThread;

public class Login extends JFrame {
	TalkServer ts = null;
	String mem_id = null;
	String nickName = null;
	TalkServerThread tst = null;
	public Login(String mem_id) {
		this.mem_id=mem_id;
		}
	public void login(String mem_id) {
		Map<String, Object> rMap = null; 
		rMap = ts.tDao.login(mem_id); // SeverBank���� �ν��Ͻ�ȭ �����ϱ� sb.����
		if(rMap !=null) {//�α��� ���������� 100
			String currentName = null;
			String msg2 = null;
			//�ƹ��� ���������ʾ�����  ũ�Ⱑ ���������ʾұ⿡ for���� ���� ���ϰ� null�� ����ϰ� �ȴ�.
			//�׷��Ƿ� 3������ for������ �����
			currentName = rMap.get("mem_name").toString();
			msg2 = 100+"#"+currentName;
			mem_id =msg2;
//			for(TalkServerThread tst:ts.globalList) {// ���Ͽ��� ������ ���� �Դ� ����, ������ �����带 ����
//				//currentName = sbt.nickName;
//				//msg2 = 100+"#"+currentName;
//				// this.send(msg2);
//				this.tst.send(tst.mem_name); 
//			}
			Vector<String> v = new Vector<>();
			v.add(tst.setTimer());
			v.add(nickName);
			v.add(100+"#"+rMap.get("mem_name").toString()); // v.add(100+"#"+mem_id);
			v.add("�α���");
			ts.dtm_history.addRow(v);
			ts.globalList.add(this); //ServerBankThread this=���Ͻ�����
			this.tst.broadCasting(100+"#"+rMap.get("mem_name").toString());//msg = 100#���� �� �ѱ��.
		}
		else {//���� ������ 110
//			for(TalkServerThread sbt:ts.globalList) {// ���Ͽ��� ������ ���� �Դ� ����, ������ �����带 ����
//				this.tst.send(110+"#"+mem_id+"���� �α��� �����Դϴ�.");
//			}
			this.tst.broadCasting(110+"#"+mem_id+"���� �α��� �����Դϴ�.");//msg = 100#���� �� �ѱ��.
		}
	}
	public static void main(String[] args) { // ���п� TalkClient, Thread�� ���θ޼ҵ� �ʿ������
		TalkClient tc = new TalkClient();
		
	}

}
