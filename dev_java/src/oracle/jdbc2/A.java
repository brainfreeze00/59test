package oracle.jdbc2;

public class A { 
	void methodA(ZipCodeVO zcVOS[]) {
		ZipCodeVO zVO = new ZipCodeVO();
		zcVOS[0]= zVO;
		zVO = null;//���⼭ �ٽ� null���·� �ʱ�ȭ �ȴ�.
		zVO = new ZipCodeVO(); // �ٸ� Ŭ������ ���� �ǹǷ� ������ �����صд�.
		zcVOS[1]= zVO;
		//�ڹٿ����� ���� Ÿ���� ������ �ߺ����Ǹ� �Ұ���.
		//Ÿ���� ������ �� �̾�� ���� ������ ���� Ÿ���� �ٸ� ��ü�� ���� �� �� �ִ�.
		zVO = null;
		zVO = new ZipCodeVO();
		zcVOS[2] = zVO;
	}
	public static void main(String[] args) {
		A a = new A();
		ZipCodeVO zcVOS[] = new ZipCodeVO[3];
		//�޼ҵ� ȣ��� �ĸ����ͷ� �ּҹ����� �Ѱܼ� �ٸ� �޼ҵ忡�� ������ �� �� �ִ�.
		//�� �۾��� methodA���� ó���غ���.
		a.methodA(zcVOS);
		for(int i=0; i<zcVOS.length; i++) {	
			System.out.println("zcVOS["+i+"]="+zcVOS[i]);
		}
	
	}
}
