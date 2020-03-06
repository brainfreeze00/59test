package com.test;

import com.util.DBConnectionMgr;

public class DBConnectionTest {
	void methodA(DBConnectionMgr dbMgr1) {
		System.out.println(this+", "+dbMgr1); // 주소번지가 다름을 확인
	}
	
	void methodB() {
		
	}
	void methodB(int a) {
		
	}
	void methodB(int b, int c) {
		
	}
	void methodB(String aa) {
		
	}
	void methodB(int d, String bb) {
		
	}
	public static void main(String[] args) {
		DBConnectionTest dbTest = new DBConnectionTest();
		DBConnectionMgr dbMgr1 = DBConnectionMgr.getInstance();
		DBConnectionMgr dbMgr2 = DBConnectionMgr.getInstance();
		dbTest.methodA(dbMgr1);
		if(dbMgr1 == dbMgr2) { // 주소번지가 같다
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println(dbMgr1);
		System.out.println(dbMgr2);
		System.out.println(dbTest);
	}

}
