package book.chap05;
/*
 * 같은 이름의 생성자를 여러개 가질수 있다.
 * 단 파라미터의 개수가 반드시 달라야 한다.
 * 단 파라미터의 타입이 반드시 달라야 한다.
 * 변수의 이름이 다른건 인정 못한다. JVM은 생성자를 중복정의했다 라고 생각한다.
 * 
 */
public class Person {
	//전역변수입니다.
	//초기화를 생략할수있다. 왜냐하면 생성자가 대신 해주니까
	String name;//성명
	float height;//그사람의 키
	float weight;//그사람의 몸무게
	Person(String name) {
		//this.name = name; // Person p = new Person("강호동"); 에서 보내는 값을 수신받지못해서?
	}
	//생성자는 여러개 선언하기가 된다. -단 타입은 반드시 달라야한다.
	Person(float height,float weight){
		this.height = height;
		this.weight = weight;
	}
	Person(double height){
		this.height = (float)height; //float에 double을 담을수 없기에 오류 그래서 캐스팅연산자를 달아준다
	}
	/*Person(float height2){
		this.height = height2;
	}*/
	Person(String name, float height, float weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	//디폴트 생성자는 생략할수있어요.
	//왜냐하면 jvm이 대신 만들어줄수 있기 때문이죠.
	//그러나 파라미터를 갖는 생성자는 만들어줄수 없어요
	//왜냐하면 그사람 생각을 내가 알수없기 때문이지
	/*
	Person(){
		System.out.println("Person 디폴트생성자 호출성공");
		//name = null;  //파라미터가 없어서 이름만 만들면 대신 해줄수있다.
		//height = 0.0f;
		//weight = 0.0f;
		
	}*/
}
