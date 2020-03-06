package friday0207;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import com.util.DBConnectionMgr;

public class BaseBallGameLogic {
	Connection          con = null; //���������� �������ִ� ������ ������θ����
	PreparedStatement pstmt = null; //�������� �ۼ��ϱ� - ?
	//��Ŭ�� ������  Ȱ���Ͽ� ��ü ���Թޱ� - �ϳ��� ������ ����.
	DBConnectionMgr   dbMgr = DBConnectionMgr.getInstance(); //�ν��Ͻ�
	//���Ͱ� ä���� ���ڸ� ��� �迭
	int com[] = new int[3]; //���
	//����ڰ� �Է��� ���ڸ� ��� �迭
	int my[] = new int[3]; //my[0]= 0   my[1]= 0   my[2]= 0 
	public int history(BaseballVO bVO) {
		String sql = "";
		sql+="insert into baseball(game_no, game_seq, game_date " ;
        sql+="        ,input, hint, dap                         " ;
        sql+="        ,score, mem_id)                           " ;
        sql+="    values(seq_baseball.nextval                   " ;
        sql+="        ,?,to_char(sysdate,'YYYY-MM-DD')          " ;
        sql+="   ,?,?,?,?,?)		                            " ;
        int result = 0; //1�̸� �Է� ���� 0�̸� �Է½���
        try {
			//insert here
        	con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql);
        	pstmt.setInt(1, bVO.getGame_seq());
        	pstmt.setString(2, bVO.getInput());
        	pstmt.setString(3, bVO.getHint());
        	pstmt.setString(4, bVO.getDap());
        	pstmt.setInt(5, bVO.getScore());
        	pstmt.setString(6, bVO.getMem_id());
        	//1row inserted 
        	result = pstmt.executeUpdate(); //������ �ۼ��� insert���� ó�����ּ���.
        	if(result == 1) System.out.println("�Է¼���");
        	else System.out.println("�Է½���"); //�ǵ��ó��
		} catch (Exception e) {
			System.out.println("Exception"+e.toString());
		}
        return result;
	}
	/*******************************************
	 * ���ڸ� �Է��� ���ڿ� ���� ��Ʈ�� �����ϱ�
	 * @param user ����ڰ� �Է��� ��
	 * @return ��Ʈ�� ��ȯ ��) 1�� 2��
	 *******************************************/
	public String account(String user) { //�̺�Ʈ���� ���� ��������
		int temp = Integer.parseInt(user);
		my[0] = temp/100; // 123/100 = 1
		my[1] = (temp%100)/10; // 2
		my[2] = temp%10; // 3
		for(int me : my) {
			System.out.println("me:"+me); // 0 0 0 
		}
		int strike = 0;
		int ball = 0;
		for(int i =0 ; i<com.length ; i++) {
			for(int j=0; j<my.length ; j++) {
				if(com[i]==my[j]) { //���� �Է��� �����߿� ���Ϳ� �� ���ڰ� �ִ�?
					if(i==j) {// Ȥ�� �׼��ڰ� �ڸ��� ��ġ�ϴ°ž�?
						strike++;
					}//��Ʈ����ũ ����
					else {
						ball++;
					}
				}////��ī��Ʈ Ȯ��
			}///////////end of inner for
		} //////////////end of outer for
		if(strike==3) {
			return "�����Դϴ� �����մϴ�";
		}
		return strike+"��"+ball+"��";  // 0�� 2�� -> ����� ������  
		
	}
	
	public void ranCom() { //ä��
		Random r = new Random(); // 0.0~ // �������ʴ� Random Ŭ���� ���
		com[0]= r.nextInt(10); //0.0~10.0
		do {
			com[1] = r.nextInt(10);
		}while(com[0]==com[1]);
		do {
			com[2] = r.nextInt(10);			
		}while(com[0]==com[2]||com[1]==com[2]); //(ù��° �氪�� ����° ä���� ���ڰ� ����?) || (�ι�°�氪�� ����° ä���� ���ڰ� ����?)
	}
	
	//////////////////////////////////////////////////////// 
	public static void main(String[] args) {
		BaseBallGame bbGame = new BaseBallGame();
		
	}
	
}
