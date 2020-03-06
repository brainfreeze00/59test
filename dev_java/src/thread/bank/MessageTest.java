package thread.bank;

import java.util.StringTokenizer;

public class MessageTest {

	public static void main(String[] args) {
		String msg = "200#apple#test#오늘 스터디 할까?";
		StringTokenizer st = null;
		if(msg != null) { //msg가 null아니면
			st = new StringTokenizer(msg,"#"); //다음과 같이 msg에 입력된문장을 #단위로 인식
		}
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement()); // 출력시 인식된 #단위로 쪼개서 각문장을 출력
			}
		if(msg != null) { //msg가 null아니면
			st = new StringTokenizer(msg,"#"); //이미 while문이 성립돼서 다음 for문이 안넘어가서
			//기준을 재정의한다.
		}
		for(;st.hasMoreTokens();) {
			System.out.println(st.nextToken());
		}
	}
}
