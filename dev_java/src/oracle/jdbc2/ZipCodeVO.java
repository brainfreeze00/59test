package oracle.jdbc2;
/*
 * private[����]<protected<friendly[�ڵ���������]<public
 */
public class ZipCodeVO {
  // int i;
  private int    uid_no  =0;// private �������� - �ν��Ͻ�ȭ�� �ؾ߸� ����Ҽ������ϱ� , �ν��Ͻ�ȭ�� null�� �ʱ�ȭ�Ǹ� �װ��� ������Ƿ� ���� �� �� �����ž�
  private int    zipcode =0;// 
  private String zdo     ="";// 
  private String sigu    ="";// 
  private String dong    ="";// 
  private String ri      ="";// 
  private String bungi   ="";// 
  private String aptname ="";// 
  private String upd_date="";// 
  private String address ="";// 
  //getter �޼ҵ� - �б�
public int getUid_no() {
	return uid_no;
}
//setter �޼ҵ� - ����, ����, ���  ����Ÿ�� void  - �޼ҵ� �̸��� ī��ǥ���  ù�ܾ� �ҹ��� �ι�° �빮��
public void setUid_no(int uid_no) { //this�� ���� �ִ� uid_no�̴�.
	this.uid_no = uid_no;
}
public int getZipcode() {
	return zipcode;
}               
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
public String getzdo() {
	return zdo;
}
public void setzdo(String sigu) {
	this.zdo = zdo;
}
public String getSigu() {
	return sigu;
}
public void setSigu(String sigu) {
	this.sigu = sigu;
}
public String getDong() {
	return dong;
}
public void setDong(String dong) {
	this.dong = dong;
}
public String getRi() {
	return ri;
}
public void setRi(String ri) {
	this.ri = ri;
}
public String getBungi() {
	return bungi;
}
public void setBungi(String bungi) {
	this.bungi = bungi;
}
public String getAptname() {
	return aptname;
}
public void setAptname(String upd_date) {
	this.aptname = aptname;
}
public String getUpd_date() {
	return upd_date;
}
public void setUpd_date() {
	this.upd_date = upd_date;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
