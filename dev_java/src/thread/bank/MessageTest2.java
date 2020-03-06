package thread.bank;

import java.util.StringTokenizer;

public class MessageTest2 {

	public static void main(String[] args) {
		String msg = "200#apple#test#오늘 스터디 할까?";
		msg = "210#apple#오늘 수업 끝나고 농구할까?";
		msg = "100#apple";//입장하기
		StringTokenizer st = null;
		if(msg != null) { //msg가 null아니면
			st = new StringTokenizer(msg,"#"); //다음과 같이 msg에 입력된문장을 #단위로 인식
		}
		int protocol = 0;
		protocol = Integer.parseInt(st.nextToken()); // nextToken String  nextElement Object
		switch(protocol) {//if문 보다 훨씬 직관적임 고로 이것을 채택한다.
		case 100:
			System.out.println("100일 때 해야 할일");
			break;
		case 200:
			System.out.println("200일 때 해야 할일");
			break;
		case 210:
			System.out.println("210일 때 해야 할일");
			break;
		
		}
	}
}
