package oracle.jdbc2;
/*
 * private[나만]<protected<friendly[코딩하지않음]<public
 */
public class ZipCodeVO {
  // int i;
  private int    uid_no  =0;// private 변조방지 - 인스턴스화를 해야만 사용할수있으니까 , 인스턴스화가 null로 초기화되면 그값은 사라지므로 변조 할 수 없을거야
  private int    zipcode =0;// 
  private String zdo     ="";// 
  private String sigu    ="";// 
  private String dong    ="";// 
  private String ri      ="";// 
  private String bungi   ="";// 
  private String aptname ="";// 
  private String upd_date="";// 
  private String address ="";// 
  //getter 메소드 - 읽기
public int getUid_no() {
	return uid_no;
}
//setter 메소드 - 저장, 쓰기, 기억  리턴타입 void  - 메소드 이름은 카멜표기법  첫단어 소문자 두번째 대문자
public void setUid_no(int uid_no) { //this가 오는 애는 uid_no이다.
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
