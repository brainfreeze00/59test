package ocjp.basic;
/*
 * TestParam.java�ҽ��ȿ� �ΰ� Ŭ������ ����.
 * TestParam.java�� �������ϸ�(��޾�� -> ���޾��)
 * Param.class�� TestPatam.class �� �������.
 * ParamŬ�������� ���� ival�� �ְ� �ʱⰪ�� ���� 0��.
 * �װ��� TestParamŬ������ main �޼ҵ忡�� 100���� �ʱ�ȭ��.
 * effectParam�ȿ��� 500���� �ʱ�ȭ�Ǿ���.
 * �̶� main ival�� ���� ��µǴ°��� �ƴϸ� sub ival�� ���� ��µǴ� ������?
 * ���߿� ���� ��µ� ���� ���߿� ��µǴ� ���� ������ ���ƴ� �ƴϸ� ������ ���� �ʾҴ�. �Ǵ�
 * 
 * �ι�° ��ȭ �ֱ�
 * 20�� �ּ��� �������� ������ ����� ���̰� �ִ�|����.
 * ���� ���̰� �ִٰ� �����Ѵٸ� � ���̰� ��� �ִ� ������ ��������� �����غ���.
 */
class Param {
	int ival = 0;
}
public class TestParam {
	void effectParam(Param p) {//������ �޾����� 
		//p = new Param();//�� ����� ���⼭ ������ ���� ������ //p = new Param(); ������ �������� 500�ΰ��� ������ 100
		p.ival = 500; // 0->500 // �������� 500���� ����
		System.out.println("sub ival====>"+p.ival);//500
		System.out.println(p);
	}
	/*
	 * 28(entry-point)-31(��ü�� ���� �����ϰԵ� : �ν��Ͻ�ȭ)-32(�������� �ʱ�ȭ-0)
	 * -33(100) - 34(�Ķ���ͷ� �����ּҹ����ű�)-20(32�� ��ü������Ŵ)-22(������ �ٲ�)
	 * [0-100-500]-23-24-35
	 * 
	 */
	public static void main(String[] args) {
		//�ν���ȭ �Ȱ��� �����߱� ������ 500�� ��µ�.
		TestParam tp = new TestParam();
		Param p = new Param();  //���������� ���� ���� p�� ��.�� class Param, class TestParam �ν��Ͻ�ȭ
		p.ival = 100; 
		tp.effectParam(p); // ������ ��.��
		System.out.println("main ival===>"+p.ival);//500, 100
		System.out.println(p);
	}

}
