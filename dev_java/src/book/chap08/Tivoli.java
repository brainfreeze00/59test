package book.chap08;

public class Tivoli extends Car {
	
	String carColor;
	int volumn;
	//�����ڴ� ������ �ʱ�ȭ���ش�.

	Tivoli(){ //����Ʈ ������
		carColor = "����"; //�������� �ʱ�ȭ
		volumn = 0;
		volumn = 20;
		speed = 30; // �Ƶ鲨 �����ڿ����� �ƹ��� ���� ���� ���� 
	}
	@Override
	public void stop() {
		System.out.println("Override stop ȣ�⼺��");
		if(speed>0) { //���ǵ�� 0���� Ŀ���Ѵ�
		speed = speed -2;
		}
	}
	public void VolumnUp() {
		volumn +=1;
	}
	public void VolumnDown() {
		volumn -=1;
	}
}
