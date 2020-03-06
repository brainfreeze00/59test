package ocjp.basic;
/*
 * 달의 중력이 지구의 중력의 17%라 가정 당신의 몸무게는 ? 
 */
public class WrapperTest {

	public static void main(String[] args) {
		int i = 5;
		//8번의 변수 i에 대한 Wrapper클래스라고한다.
		Integer oi = new Integer(5);
		//원시형 타입 i는 메소드를 호출 할수 없다.
//System.out.println(i.intValue()); 불법
		System.out.println(oi.intValue()); // 합법
		int j = 6;
		j = i;
		Double pi = new Double(3.14); // 클래스타입
		double d = pi.doubleValue(); // pi 메소드와 변수 호출
		double d1 = pi; // 오토박싱 - 자동으로 원시형과 참조형 사이에 타입을 맞춰줌
		System.out.println(d1);
		Boolean b = new Boolean(false);
	}

}
