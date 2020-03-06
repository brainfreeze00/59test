package friday0207;
/*
 * 오버로딩 :같은 이름의 메소드를 여러 개 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
 * 오버라이딩 : 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의 해서 사용한다.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

public class BaseBallGameEvent implements ActionListener {
	DBConnectionMgr 	dbMgr = null;
	Connection        	  con = null;
	BaseBallGameView   bbView = null;
	//BaseBallGameLogic bbLogic = new BaseBallGameLogic(); // 복습
	//게임을 진행하는 동안에는 계속 그 숫자를 기억하고 있다가 1씩 증가되야하니까...
	//전역변수로 해야함.
	int cnt = 0; // 회차를 출력할 변수 선언
	
	public BaseBallGameEvent(BaseBallGameView bbView) { //복습
		this.bbView = bbView; //파라미터를 가리키고 있었던 것을  대입해준것
		//this : 뭘 의미하고 여기서의 역할 정훈: 의미는 이페이지이다.
		//주의사항 파라미터로 건널때 받는것도 작성되있어야 한다. 
		//생성자,메소드의(파라미터)가 없으면 받지 못하기때문에
		//여기 this는  BaseBallGameEvent이다
	}
	public void exitGame() {
		System.exit(0);       
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//insert here
		//BaseBallGameView bbView = new BaseBallGameView();
		if(obj == bbView.jbtn_dap) {
			System.out.println("정답 버튼 호출성공");
			bbView.jta_display.append(bbView.bbLogic.com[0]+""
			+bbView.bbLogic.com[1]+""+bbView.bbLogic.com[2]); //com 전변임
			bbView.jbtn_dap.setEnabled(false);
		}
		else if(obj == bbView.jbtn_clear) {
			System.out.println("지우기버튼 호출성공");
			bbView.jta_display.setText("");
		}
		else if(obj == bbView.jmi_oracle) { // 주소번지 같을려면 
			System.out.println("오라클 테스트 호출 성공");
			dbMgr = DBConnectionMgr.getInstance(); // 겟 인스턴스화
			con = dbMgr.getConnection(); // 커넥션 겟메소드 호출
			if(con !=null) { // 컨이 널이 아니라면 
				System.out.println("오라클 서버연결 성공"+con);
			}else  {  // 컨이 널이라
			 System.out.println("오라클 서버 연결 실패");	
			}
		}
		else if(obj == bbView.jbtn_exit) {
			System.out.println("나가기 버튼 호출 성공");
			exitGame(); // 메소드 호출 
		}
		//다음겜을 누른거니?
		else if(obj == bbView.jbtn_next) {
			System.out.println("다음게임 버튼 호출 성공");
			cnt = 0; //다음게임
			//세자리 숫자 다시 채번해요.
			bbView.bbLogic.ranCom(); // 객체주입해야함
			//정답버튼 다시 활성화하기
			bbView.jbtn_dap.setEnabled(true);
			//BaseBallGameLogic 안에 com배열이 선언되어 있음.
			//인스턴스화를 한 상태이므로 접근이 가능함.
			for(int coms:bbView.bbLogic.com) {
				System.out.print(coms+"");
			}
			System.out.println();
		}
		//세자리 숫자를 입력했어?
		else if(obj == bbView.jtf_input) {
			int no = 0;
			bbView.jta_display.append(++cnt+"회 : "+bbView.jtf_input.getText()+"==>"
		+bbView.bbLogic.account(bbView.jtf_input.getText())+"\n");//256 이숫자의 의미 찾아라
			no = cnt;
			//insert here - 오라클 서버에 insert문 요청 처리하기
			//수집해야하는 정보를 출력해보기 
			System.out.println("mem_id : "+bbView.result[1]); //bbView에 있는 리절트1
			System.out.println("game_seq : "+no);
			System.out.println("input : "+bbView.jtf_input.getText());
			System.out.println("hint : "+bbView.bbLogic.account(bbView.jtf_input.getText()));
			System.out.println("dap : "+bbView.bbLogic.com[0]
									 +""+bbView.bbLogic.com[1]
									 +""+bbView.bbLogic.com[2]);
			BaseballVO bbVO = new BaseballVO(bbView.result[1]
					                       ,no
					                       ,bbView.jtf_input.getText()
					                       ,bbView.bbLogic.account(bbView.jtf_input.getText())
					   					   ,bbView.bbLogic.com[0]
					   					 +""+bbView.bbLogic.com[1]
					   					 +""+bbView.bbLogic.com[2]);

			System.out.println("mem_id : "+bbVO.getMem_id()); //bbView에 있는 리절트1
			System.out.println("game_seq : "+bbVO.getGame_seq());
			System.out.println("input : "+bbVO.getInput());
			System.out.println("hint : "+bbVO.getHint());
			System.out.println("dap : "+bbVO.getDap());
			bbView.jtf_input.setText("");
			int result = bbView.bbLogic.history(bbVO);
			if(result == 1) {
				JOptionPane.showMessageDialog(bbView, "등록성공");
			}else if(result == 0) {
				JOptionPane.showMessageDialog(bbView, "등록실패");
				
			}
			//VO에 값을 초기화 할때 생성자를 활용해 보세요.
			//if(bbView.jtf_input.getText().length()==0) {
			//	System.out.println("입력해주시죠");
			//}
		}
	}

}
