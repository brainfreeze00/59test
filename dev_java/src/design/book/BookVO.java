package design.book;

public class BookVO {
	private int		 b_no       = 0;  //
	private String   b_name     = ""; //
	private String   b_publish  = ""; //
	private String   b_author   = ""; //
	private String   b_info     = ""; //
	public String 	command 	= null;//delete or update or insert or select or all 이변수에 담길수 있는 경우의 수는 이 5가지
	public int 		result 		= 0; // INSERT or UPDATE or DELETE 0:실패  1:성공
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_publish() {
		return b_publish;
	}
	public void setB_publish(String b_publish) {
		this.b_publish = b_publish;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_info() {
		return b_info;
	}
	public void setB_info(String b_info) {
		this.b_info = b_info;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getReuslt() {
		return result;
	}
	public void setReuslt(int reuslt) {
		this.result = reuslt;
	}
}
