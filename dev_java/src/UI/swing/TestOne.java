package UI.swing;
import java.util.Calendar;

public class TestOne {
	/*1. ������ �䱸������ �����ϴ� ���α׷��� �ҽ��ڵ�� ���ȭ�� ��ũ�� ���� �����Ͻÿ�
  	��. �ڽ��� �¾ �⵵�� ���ڸ� ���� �� �� �ִ� ���� year�� �����ϰ�
      	�ڽ��� �¾ �⵵�� �����Ѵ�.     
  	��. �ڽ��� ���̸� ������ �� �ִ� ���� age�� �����ϰ�, 
     year ������ ����Ͽ� �ڽ��� ���̸� 
     	����Ͽ� �����Ѵ�(����:����⵵-�¾ �⵵)
     	��,���� �⵵�� CalendarŬ������ ����Ͽ� ���ؾ� �Ѵ�
     	�׸��� age �� year�� ����Ͽ���
	 * 
	 * 
	 * 
	 * A a = new A();
	 * 
	 * A a = null;
	 * a = new A();
	 * 
	 * A a = A.getInstance();
	 * 
	 * static : 1���� ����  -ȣ��� �ν��Ͻ����ص� Ŭ�������ᵵ��
	 * 
	 * JAVA �ؿ� lang
	 * 
	 * JAVA �ؿ� util�̸� �ݵ�� import
	 * 
	 * API :�ڿ� ������ ���� ����Ÿ��
	 * 
	 */
	int Year = 0;
	int age = 0;
	public int getAge(int birthYear, int birthMonth, int birthDay)
	{
	        Calendar current = Calendar.getInstance();
	        int Year  = current.get(Calendar.YEAR);
	        int Month = current.get(Calendar.MONTH) + 1;
	        int Day   = current.get(Calendar.DAY_OF_MONTH);
	       
	        int age = Year - birthYear;
	        // ���� �� ���� ��� -1
	        if (birthMonth * 100 + birthDay > Month * 100 + Day)  
	            age--;
	       
	        return age;
	}

	public static void main(String[] args) {
		TestOne to = new TestOne();
		int Year = 1992;
		to.getAge(Year, 02, 11);
		System.out.println("   �¾ �⵵: "+Year+"    ������: "+to.getAge(Year, 02, 11));
		/* �� ����
		 *���θ޼ҵ��
		 * int year = 0;
		 * year = 1992;
		 * int age = 0;
		 * int cyear = 0;
		 * Calendar cal = Calendar.getInstance;
		 * cyear = cal.get(Calendar.YEAR);  // API���� �빮�ڶ� �빮�� �����
		 * age =cyear-year;
		 * Sysout.out.println("age==>"+age);
		 * Sysout.out.println("year==>"+year);
		 */
	}

}
