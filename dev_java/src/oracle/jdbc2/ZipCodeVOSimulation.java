package oracle.jdbc2;

public class ZipCodeVOSimulation {
//�����Ҷ� set �о�ö� get
	static	void methodA() {
		ZipCodeVO zcVOS[] = new ZipCodeVO[2]; // �÷��ǰ� ���׸�����
		ZipCodeVO zcVO = new ZipCodeVO();
		//�ﰢ�� �ȿ� zipcode ������ �� �ֱ�
		zcVO.setZipcode(21548); // �����ȣ�� [����-7��, �ν��Ͻ�ȭ] ��Ҵ�
		zcVOS[0] = zcVO; //�簢���� �ﰢ�� �ֱ� 0���ڸ���
		zcVO = new ZipCodeVO();
		zcVO.setZipcode(23598); // �����ȣ�� [����-11��, �ν��Ͻ�ȭ]��Ҵ�
		zcVOS[1] = zcVO; //�簢���� �ﰢ�� �ֱ�  1���ڸ���
		//�޼ҵ�ȣ��
		printZcVOS(zcVOS); //�޼ҵ� �Ķ���ͷ� �ּҹ���[]�迭 �Ѱ��ֱ�
	}
	
	static void printZcVOS(ZipCodeVO zcVOS[]) {
		for(ZipCodeVO zcVO : zcVOS) {
			System.out.println(zcVO.getZipcode());
		}
	}
	
	
	public static void main(String[] args) {
		ZipCodeVOSimulation.methodA();
		ZipCodeVO zcVO = new ZipCodeVO();
		//zcVO.uid_no = 10; ��������
		zcVO.setUid_no(10); //void     ����  0 -> 10
		zcVO.setUid_no(30); //void        10 -> 30
		int uid_no = zcVO.getUid_no(); //int
		System.out.println("?"+uid_no);//10-?30 ��������
		zcVO.setAddress("����� ��õ�� ���굿");
		String address = zcVO.getAddress();
		System.out.println(""+address);
		
		
		zcVO.setZipcode(21548);
		int zipcode = zcVO.getZipcode();
		System.out.println(zipcode);
		
	}

}
