package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList2 {

	public static void main(String[] args) {
		java.util.Vector<ZipCodeVO> v = new Vector<ZipCodeVO>();
		Vector<String> v1 = new Vector<>(); //��<>���� ��������		
		System.out.println("v.size() :"+v.size());
		ZipCodeVO zcVO = new ZipCodeVO();
		zcVO.setAddress("����� ������ ������");
		zcVO.setZipcode(21545);
		v.add(0,zcVO);
		v1.add(0, "���ξ���" ); //�� Ʋ�Ⱦ� Ÿ���� �����ʾ� �׷��� v1.add(0, "���ξ���")
		System.out.println(v1.get(0)); // ���ξ���
		System.out.println(v.get(0).getZipcode()); // v.get(0).getZipcode()
		ZipCodeVO zVO=v.get(0);
		int zipcode = zVO.getZipcode();
		System.out.println(zipcode); 
	}

}

