package book.chap05;
/*
 * ���� �̸��� �����ڸ� ������ ������ �ִ�.
 * �� �Ķ������ ������ �ݵ�� �޶�� �Ѵ�.
 * �� �Ķ������ Ÿ���� �ݵ�� �޶�� �Ѵ�.
 * ������ �̸��� �ٸ��� ���� ���Ѵ�. JVM�� �����ڸ� �ߺ������ߴ� ��� �����Ѵ�.
 * 
 */
public class Person {
	//���������Դϴ�.
	//�ʱ�ȭ�� �����Ҽ��ִ�. �ֳ��ϸ� �����ڰ� ��� ���ִϱ�
	String name;//����
	float height;//�׻���� Ű
	float weight;//�׻���� ������
	Person(String name) {
		//this.name = name; // Person p = new Person("��ȣ��"); ���� ������ ���� ���Ź������ؼ�?
	}
	//�����ڴ� ������ �����ϱⰡ �ȴ�. -�� Ÿ���� �ݵ�� �޶���Ѵ�.
	Person(float height,float weight){
		this.height = height;
		this.weight = weight;
	}
	Person(double height){
		this.height = (float)height; //float�� double�� ������ ���⿡ ���� �׷��� ĳ���ÿ����ڸ� �޾��ش�
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
	//����Ʈ �����ڴ� �����Ҽ��־��.
	//�ֳ��ϸ� jvm�� ��� ������ټ� �ֱ� ��������.
	//�׷��� �Ķ���͸� ���� �����ڴ� ������ټ� �����
	//�ֳ��ϸ� �׻�� ������ ���� �˼����� ��������
	/*
	Person(){
		System.out.println("Person ����Ʈ������ ȣ�⼺��");
		//name = null;  //�Ķ���Ͱ� ��� �̸��� ����� ��� ���ټ��ִ�.
		//height = 0.0f;
		//weight = 0.0f;
		
	}*/
}
