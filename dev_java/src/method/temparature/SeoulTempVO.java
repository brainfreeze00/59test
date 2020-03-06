package method.temparature;
/*
 * VO(Value Object)�����ϱ�-�ڹٿ� ����Ŭ ���̿��� �������̽� ������ �ϰԵ�
 * ����Ŭ�� �ڹٴ� ������ Ÿ���� ���� �ٸ���
 * �׷��� �ڷ�� ���� �����ؾ� �Ѵ�.
 * �׷��� VO������ ���ؼ� ���� �ְ� �ް��� �Ѵ�.
 * 
 */
public class SeoulTempVO {
	
	private String sdate  = null;
	private int 	loc   =	  0;
	private double atemp  = 0.0;
	private double mitemp = 0.0;
	private double matemp = 0.0;
	//���� ���̺� �����ϴ� �÷��� �ƴ����� ���α׷��� �ʿ��� ���� ���� ������.
	private String nYear  = null;//�޺��ڽ����� ����ڰ� ������ �⵵ �����ϱ�
	private String nMonth = null;//�޺��ڽ����� ����ڰ� ������ �� ���� �����ϱ�
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public double getAtemp() {
		return atemp;
	}
	public void setAtemp(double atemp) {
		this.atemp = atemp;
	}
	public double getMitemp() {
		return mitemp;
	}
	public void setMitemp(double mitemp) {
		this.mitemp = mitemp;
	}
	public double getMatemp() {
		return matemp;
	}
	public void setMatemp(double matemp) {
		this.matemp = matemp;
	}
	public String getnYear() {
		return nYear;
	}
	public void setnYear(String nYear) {
		this.nYear = nYear;
	}
	public String getnMonth() {
		return nMonth;
	}
	public void setnMonth(String nMonth) {
		this.nMonth = nMonth;
	}
}