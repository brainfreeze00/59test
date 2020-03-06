package UI.swing;

public class Instance {
//	Instance i = new Instance();                                    A : new예약어로 선언과  생성을 동시
	                                                                    
//	Instance i2 = null;					                            B :선언을 먼저하고 생성은 나중
//	i2 = new Instance();                                            B   
	                                                                    
//	new Instance();						                            C  : 주소번지가 없다 1번만사용가능하고 2번째이후로 기능의 사용(생성)을 못한다. ㅡ,.ㅡ
	                                                                    
//	Instance i = new Instance(this);	                            D  : 만들어진것을 담음 
//	Instance i = new Instance(String형);	                            D   
//	Instance i = new Instance(String[]형);                            D   
//	Instance i = new Instance(VO형);		                            D   
	
//	if(dbMgr==null) {												E  : 싱글톤 패턴 인스턴스의 조건을 거는것 -> 객체지향 프로그램에서 인스턴스를 단하나만 생성하는 디자인 패턴
//		dbMgr = new DBConnectionMgr();								E  : 하나의 인스턴스만을 가지고 공유해서 사용한다.
//	}																E
	
//	DBConnectionMgr   dbMgr = DBConnectionMgr.getInstance(); 		F : E호출할때씀
	// getInstance();                                               G : private을 생성자에 선언하고  단 하나의 인스턴스를 생성해 사용하는 디자인 패턴이다.

	
	//초기화 :객체를 선언하고 값을  '최초'로 할당하는 것이다 int a = 2;이렇게 작성한것은 선언과
	//초기화한것이다. 이후에 a=10;이렇게 주면 초기화가 아니라 값을 바꾸는 할당이 되는것이다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
