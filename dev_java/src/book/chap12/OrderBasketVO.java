package book.chap12;

public class OrderBasketVO {
	
	private int      seq_nu      =    0;//����
	private String  indate_vc    =  " ";//��¥
	private String  gubun_vc     =  " ";//��ǰ����
	private String  name_vc      =  " ";//��ǰ��
	private int      qty_nu      = 	  0;//�Ǹż���
	private int    price_nu  	 =    0;//�ǸŰ���
	//VO���� ���̺� ���������� ������ ������ �ʿ��� �÷��� �����ؾ� �� �ʿ䰡 ���� �� �ִ�.
	private int    t_qty		 =    0; // ���� �츮�� �����޴� �÷��� �ƴ����� 
	private int    t_price       =    0; // ��������ڰ� ��Ź�Ҽ� �ֱ⿡ �����Ҽ� �ִٴ°��� ������
	
	public int getSeq_nu() {
		return seq_nu;
	}
	public void setSeq_nu(int seq_nu) {
		this.seq_nu = seq_nu;
	}
	public String getIndate_vc() {
		return indate_vc;
	}
	public void setIndate_vc(String indate_vc) {
		this.indate_vc = indate_vc;
	}
	public String getGubun_vc() {
		return gubun_vc;
	}
	public void setGubun_vc(String gubun_vc) {
		this.gubun_vc = gubun_vc;
	}
	public String getName_vc() {
		return name_vc;
	}
	public void setName_vc(String name_vc) {
		this.name_vc = name_vc;
	}
	public int getQty_nu() {
		return qty_nu;
	}
	public void setQty_nu(int qty_nu) {
		this.qty_nu = qty_nu;
	}
	public int getPrice_nu() {
		return price_nu;
	}
	public void setPrice_nu(int price_nu) {
		this.price_nu = price_nu;
	}
	public int getT_qty() {
		return t_qty;
	}
	public void setT_qty(int t_qty) {
		this.t_qty = t_qty;
	}
	public int getT_price() {
		return t_price;
	}
	public void setT_price(int t_price) {
		this.t_price = t_price;
	}
	
}
