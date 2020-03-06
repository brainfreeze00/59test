package method.temperature2;
/* VO(Value Object)�����ϱ�-�ڹٿ� ����Ŭ ���̿��� �������̽� ������ �ϰ� ��.
 * ����Ŭ�� �ڹٴ� ������ Ÿ���� ���� �ٸ���.
 * �׷��� �ڷ�� ���� �����ؾ� �Ѵ�.
 * �׷��� VO������ ���ؼ� ���� �ְ� �ް��� �Ѵ�.
 * 
 */
public class SeoulTempVO {
    private String ta_date  =null;// 
    private int    ta_area  =  0;// 
    private double ta_avgt  =0.0;// 
    private double ta_low   =0.0;// 
    private double ta_high  =0.0;// 
    private String nYear    = null;
    private String nMonth   = null;
    public String getTa_date() {
        return ta_date;
    }
    public void setTa_date(String ta_date) {
        this.ta_date = ta_date;
    }
    public int getTa_area() {
        return ta_area;
    }
    public void setTa_area(int ta_area) {
        this.ta_area = ta_area;
    }
    public double getTa_avgt() {
        return ta_avgt;
    }
    public void setTa_avgt(double ta_avgt) {
        this.ta_avgt = ta_avgt;
    }
    public double getTa_low() {
        return ta_low;
    }
    public void setTa_low(double ta_low) {
        this.ta_low = ta_low;
    }
    public double getTa_high() {
        return ta_high;
    }
    public void setTa_high(double ta_high) {
        this.ta_high = ta_high;
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