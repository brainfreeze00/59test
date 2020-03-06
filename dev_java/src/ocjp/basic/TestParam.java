package ocjp.basic;
/*
 * TestParam.java소스안에 두개 클래스를 가짐.
 * TestParam.java를 컴파일하면(고급언어 -> 저급언어)
 * Param.class와 TestPatam.class 가 만들어짐.
 * Param클래스에는 전변 ival이 있고 초기값은 현재 0임.
 * 그값이 TestParam클래스의 main 메소드에서 100으로 초기화됨.
 * effectParam안에선 500으로 초기화되었다.
 * 이때 main ival이 먼저 출력되는건지 아니면 sub ival이 먼저 출력되는 것인지?
 * 둘중에 먼저 출력된 값이 나중에 출력되는 곳에 영향을 미쳤다 아니면 영향을 주지 않았다. 판단
 * 
 * 두번째 변화 주기
 * 20번 주석이 있을때와 없을때 결과에 차이가 있다|없다.
 * 만약 차이가 있다고 생각한다면 어떤 차이가 어떻게 있는 것인지 옆사람에게 설명해볼것.
 */
class Param {
	int ival = 0;
}
public class TestParam {
	void effectParam(Param p) {//원본을 받았으나 
		//p = new Param();//을 지우면 여기서 복제본 새로 생성됨 //p = new Param(); 있을때 복제본이 500인거지 원본은 100
		p.ival = 500; // 0->500 // 복제본이 500으로 변경
		System.out.println("sub ival====>"+p.ival);//500
		System.out.println(p);
	}
	/*
	 * 28(entry-point)-31(객체가 램에 상주하게됨 : 인스턴스화)-32(전역변수 초기화-0)
	 * -33(100) - 34(파라미터로 원본주소번지옮김)-20(32번 객체를가리킴)-22(원본이 바뀜)
	 * [0-100-500]-23-24-35
	 * 
	 */
	public static void main(String[] args) {
		//인스턴화 된것을 수정했기 때문에 500이 출력됨.
		TestParam tp = new TestParam();
		Param p = new Param();  //지변이지만 원본 변수 p의 주.번 class Param, class TestParam 인스턴스화
		p.ival = 100; 
		tp.effectParam(p); // 동일한 주.번
		System.out.println("main ival===>"+p.ival);//500, 100
		System.out.println(p);
	}

}
