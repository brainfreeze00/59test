package book.chap08;
//�ڵ��� - ���� �߻����̴�
public class Car {
	
	int speed;
	//�����ڴ� ������ �ʱ�ȭ���ش�.
	Car(){ //����Ʈ ������
		speed = 0; //�������� �ʱ�ȭ
		speed = 40;
	}
	public void stop() {
		System.out.println("stop ȣ�⼺��");
		if(speed>0) { //���ǵ�� 0���� Ŀ���Ѵ�
		speed = speed -1;
		}
	}
}
