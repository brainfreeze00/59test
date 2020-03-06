package book.chap12;

import java.util.Vector;

import com.google.gson.Gson;

import method.zipcode.ZipCodeSearchApp;
import oracle.jdbc2.ZipCodeVO;

public class ZipCodeTest {
	//회사에서 쓴데 헤헤헤헤헤헤헤헤헿 웹이나 안드로이드에 json 프로그램을 통해서 자원 관리 가능하데
	public void gsonFormat(Vector<ZipCodeVO> v) {
		Gson g = new Gson();
		String temp = g.toJson(v);
		System.out.println(temp);
	}
	public static void main(String[] args) {
		//
		ZipCodeTest zcTest = new ZipCodeTest();
		ZipCodeSearchApp zcApp = new ZipCodeSearchApp();
		Vector<ZipCodeVO> v = zcApp.refreshData(null, "가산동");
		zcTest.gsonFormat(v);
		System.out.println(v.size()); //43
		for(int i = 0; i<v.size(); i++) {
		ZipCodeVO zcVO	= v.get(i); // 벡터에서 꺼낸 i가 누구니????? 1차접근
		System.out.println(zcVO.getAddress()); // getAddress 리턴타입이 String이므로 출력가능
		//System.out.println(zcVO.Address()); 접근제한자 private라서 변수로 직접 못함
		}
	}

}
