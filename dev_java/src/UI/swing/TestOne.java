package UI.swing;
import java.util.Calendar;

public class TestOne {
	/*1. 다음의 요구사항을 충족하는 프로그램의 소스코드와 결과화면 스크린 샷을 제출하시오
  	가. 자신이 태어난 년도인 숫자를 저장 할 수 있는 변수 year를 선언하고
      	자신이 태어난 년도를 대입한다.     
  	나. 자신의 나이를 저장할 수 있는 변수 age를 선언하고, 
     year 변수를 사용하여 자신의 나이를 
     	계산하여 대입한다(공식:현재년도-태어난 년도)
     	단,현재 년도는 Calendar클래스를 사용하여 구해야 한다
     	그리고 age 와 year를 출력하여라
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
	 * static : 1개를 공유  -호출시 인스턴스안해도 클래스명만써도됨
	 * 
	 * JAVA 밑에 lang
	 * 
	 * JAVA 밑에 util이면 반드시 import
	 * 
	 * API :뒤에 나오는 용어는 리턴타입
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
	        // 생일 안 지난 경우 -1
	        if (birthMonth * 100 + birthDay > Month * 100 + Day)  
	            age--;
	       
	        return age;
	}

	public static void main(String[] args) {
		TestOne to = new TestOne();
		int Year = 1992;
		to.getAge(Year, 02, 11);
		System.out.println("   태어난 년도: "+Year+"    내나이: "+to.getAge(Year, 02, 11));
		/* 쌤 정답
		 *메인메소드안
		 * int year = 0;
		 * year = 1992;
		 * int age = 0;
		 * int cyear = 0;
		 * Calendar cal = Calendar.getInstance;
		 * cyear = cal.get(Calendar.YEAR);  // API에서 대문자라서 대문자 써야함
		 * age =cyear-year;
		 * Sysout.out.println("age==>"+age);
		 * Sysout.out.println("year==>"+year);
		 */
	}

}
