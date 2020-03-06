package friday0207;

public class BaseballVO {
	
	private int  	 game_no   = 0;      //
	private int   	 game_seq  = 0;      //
	private String   game_date = "";   //
	private String   input     ="";   //
	private String   hint      = "";   //
	private String   dap       = "";   //
	private int   	 score     = 0;      //
	private String   mem_id    = "";   //
	
public BaseballVO(String mem_id, int no, String input, String hint, String dap) {
	this.mem_id = mem_id;
	this.game_seq = no;
	this.input = input;
	this.hint = hint;
	this.dap = dap;
	
	}
	//	public BaseballVO(String string, int no, String text, String account, String string2, String mem_id, String input, String hint, String dap) {
//		this.mem_id = mem_id;
//		this.game_seq = no;
//		this.input = input;
//		this.hint = hint;
//		this.dap = dap;
//	}
	public int getGame_no() {
		return game_no;
	}
	//setter�޼ҵ��� �Ķ���ͷ� ����ڰ� �Է��� �� Ȥ�� ������ ���� �Ǵ� ������ ������ �Ѿ�´�.
	//�׷��� �̰����� ������ ���� �Ǿ �޼ҵ� �����ۿ����� ����� �Ұ��ϴ�
	//�̶� ���������� ��� ������ ���������� �ٽ� �ʱ�ȭ ���ָ� Ŭ���� �������� ��밡����.
	//�� ������ �ƴϴ��� �ٸ� Ŭ�������� �ν��Ͻ�ȭ�ϸ� ���������� �״�� �������ִ�.
	//�ʱ�ȭ ���δ� å���δ� �Ѱ谡 �ִ�.
	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}
	public int getGame_seq() {
		return game_seq;
	}
	public void setGame_seq(int game_seq) {
		this.game_seq = game_seq;
	}
	public String getGame_date() {
		return game_date;
	}
	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getDap() {
		return dap;
	}
	public void setDap(String dap) {
		this.dap = dap;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
}
