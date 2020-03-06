package basic.method;
//메소드를 설계를 할수있는가? 
//리턴타입은 뭘로 하는가? -나는 실수 영역까지 처리할거야-double 1개 / 정수 int
//파라미터는 몇개로? - 문제에서 두개중이라 했으니 - double 2개 
//파라미터의 타입은 어떻게 설정? -실수영역까지  
//메소드의 이름은 뭘로 할까? - max
public class MaxValure {
	double fn = 8.0;
	double sn = 3.0;
	double max(double fn,double sn){
		//둘(fn과 sn)중에 누가 더 크니?
		double maxNumber = 0.0; // 사용전 선언
		if(fn>sn) { //fn과 sn중에서 누가 더 큰데?
			//실행문
			maxNumber=fn;
		}
		else if(sn>fn){ 
			maxNumber=sn;
		}
		else {
			maxNumber=0; //같을경우
		}
		return maxNumber;
		
	} // end of max
/*
 * 두개의 정수 중에서 큰 숫자를 반환하는  max함수를 구현하세요.
 * 두개의 정수를 입력받고 큰숫자를 출력합니다.
 * 출력) 정수(두개) : 5,8
 *  	최대값 : 8
 *  
 */
	public static void main(String[] args) {
	}

}
