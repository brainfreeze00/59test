package oracle.jdbc2;



public class ZipCodeList3 {
	
	public static void main(String[] args) {
		java.util.Vector<ZipCodeVO> v 
			= new java.util.Vector<ZipCodeVO>(); //���� �������߰�x
		ZipCodeVO zcVO = null; // 
		ZipCodeVO zcVOS[] = null; //���� ��ũ�� �˼����� �ٸ� ������ ��
		int i = 0;
		while(i<3) { // 3�� �����ϹǷ� ���� 3���� ���´�. - while�� �ȿ��� [0] [1] [2] - 3��
			zcVO = new ZipCodeVO(); // �ν��Ͻ�ȭ new ZipCodeVO()
			System.out.println("zcVO�ּҹ����� �ٲ��"+zcVO);
			v.add(zcVO);
			i++;
		}
		for(int x=0;x<v.size();x++) {
			//Vector�� 0��° ����ִ� �ּҹ����� ZipCodeVOŸ���̴�.
			ZipCodeVO zVO = v.get(x);
			System.out.println(zVO);
		}
		zcVOS = new ZipCodeVO[v.size()]; // ���⼭ 
		System.out.println("�迭�� ũ��� "+zcVOS.length);//3
		//zcVOS�� ����Ű�� ��ü �迭�� ����ִ� ������ ����غ�����.
		//insert here
		//zcVOS.length�� �迭�� ��ũ��(����) - 3�� �ִ�.
		v.copyInto(zcVOS); // (zcVOS) �Ķ���� �迭Ÿ��
		for(int y=0;y<zcVOS.length;y++) {
		  //zcVOS[y] = v.get(y);
		/*	zcVOS[0] = v.get(0);
			zcVOS[1] = v.get(1);
			zcVOS[2] = v.get(2);
		*/	
			System.out.println(zcVOS[y]);//null, null, null
		}
		//����Ÿ���� void������ ���� �����ϰ� �� �� �ִ�
		//�Ķ���ͷ� �ѱ� �ּҹ����� v�� ����Ǿ��ִ� �ּҹ����� �������ִ� �޼ҵ�
		
		//�� �迭�� ���� ��ȿ� ZipCodeVO�� �ʱ�ȭ �� �� �ֵ��� �ڵ带 �ۼ��� ������.
		//zcVOS v.add(0,zcVO);
		//System.out.println(v1.get(0)); // ���ξ���
		//System.out.println(v.get(0).getZipcode());
		
	}

}
