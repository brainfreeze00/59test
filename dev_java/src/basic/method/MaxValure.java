package basic.method;
//�޼ҵ带 ���踦 �Ҽ��ִ°�? 
//����Ÿ���� ���� �ϴ°�? -���� �Ǽ� �������� ó���Ұž�-double 1�� / ���� int
//�Ķ���ʹ� ���? - �������� �ΰ����̶� ������ - double 2�� 
//�Ķ������ Ÿ���� ��� ����? -�Ǽ���������  
//�޼ҵ��� �̸��� ���� �ұ�? - max
public class MaxValure {
	double fn = 8.0;
	double sn = 3.0;
	double max(double fn,double sn){
		//��(fn�� sn)�߿� ���� �� ũ��?
		double maxNumber = 0.0; // ����� ����
		if(fn>sn) { //fn�� sn�߿��� ���� �� ū��?
			//���๮
			maxNumber=fn;
		}
		else if(sn>fn){ 
			maxNumber=sn;
		}
		else {
			maxNumber=0; //�������
		}
		return maxNumber;
		
	} // end of max
/*
 * �ΰ��� ���� �߿��� ū ���ڸ� ��ȯ�ϴ�  max�Լ��� �����ϼ���.
 * �ΰ��� ������ �Է¹ް� ū���ڸ� ����մϴ�.
 * ���) ����(�ΰ�) : 5,8
 *  	�ִ밪 : 8
 *  
 */
	public static void main(String[] args) {
	}

}
