package UI.swing;

public class Instance {
//	Instance i = new Instance();                                    A : new������ �����  ������ ����
	                                                                    
//	Instance i2 = null;					                            B :������ �����ϰ� ������ ����
//	i2 = new Instance();                                            B   
	                                                                    
//	new Instance();						                            C  : �ּҹ����� ���� 1������밡���ϰ� 2��°���ķ� ����� ���(����)�� ���Ѵ�. ��,.��
	                                                                    
//	Instance i = new Instance(this);	                            D  : ����������� ���� 
//	Instance i = new Instance(String��);	                            D   
//	Instance i = new Instance(String[]��);                            D   
//	Instance i = new Instance(VO��);		                            D   
	
//	if(dbMgr==null) {												E  : �̱��� ���� �ν��Ͻ��� ������ �Ŵ°� -> ��ü���� ���α׷����� �ν��Ͻ��� ���ϳ��� �����ϴ� ������ ����
//		dbMgr = new DBConnectionMgr();								E  : �ϳ��� �ν��Ͻ����� ������ �����ؼ� ����Ѵ�.
//	}																E
	
//	DBConnectionMgr   dbMgr = DBConnectionMgr.getInstance(); 		F : Eȣ���Ҷ���
	// getInstance();                                               G : private�� �����ڿ� �����ϰ�  �� �ϳ��� �ν��Ͻ��� ������ ����ϴ� ������ �����̴�.

	
	//�ʱ�ȭ :��ü�� �����ϰ� ����  '����'�� �Ҵ��ϴ� ���̴� int a = 2;�̷��� �ۼ��Ѱ��� �����
	//�ʱ�ȭ�Ѱ��̴�. ���Ŀ� a=10;�̷��� �ָ� �ʱ�ȭ�� �ƴ϶� ���� �ٲٴ� �Ҵ��� �Ǵ°��̴�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
