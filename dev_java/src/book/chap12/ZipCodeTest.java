package book.chap12;

import java.util.Vector;

import com.google.gson.Gson;

import method.zipcode.ZipCodeSearchApp;
import oracle.jdbc2.ZipCodeVO;

public class ZipCodeTest {
	//ȸ�翡�� ���� �����������������m ���̳� �ȵ���̵忡 json ���α׷��� ���ؼ� �ڿ� ���� �����ϵ�
	public void gsonFormat(Vector<ZipCodeVO> v) {
		Gson g = new Gson();
		String temp = g.toJson(v);
		System.out.println(temp);
	}
	public static void main(String[] args) {
		//
		ZipCodeTest zcTest = new ZipCodeTest();
		ZipCodeSearchApp zcApp = new ZipCodeSearchApp();
		Vector<ZipCodeVO> v = zcApp.refreshData(null, "���굿");
		zcTest.gsonFormat(v);
		System.out.println(v.size()); //43
		for(int i = 0; i<v.size(); i++) {
		ZipCodeVO zcVO	= v.get(i); // ���Ϳ��� ���� i�� ������????? 1������
		System.out.println(zcVO.getAddress()); // getAddress ����Ÿ���� String�̹Ƿ� ��°���
		//System.out.println(zcVO.Address()); ���������� private�� ������ ���� ����
		}
	}

}
