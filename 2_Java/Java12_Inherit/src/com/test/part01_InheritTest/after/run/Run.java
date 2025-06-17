package com.test.part01_InheritTest.after.run;

import java.util.Date;

import com.test.part01_InheritTest.after.model.Desktop;
import com.test.part01_InheritTest.after.model.SmartPhone;
import com.test.part01_InheritTest.after.model.Television;

public class Run {

	public static void main(String[] args) {
		//String brand, String productNumber, String productCode, String productName, int price, Date date
		
		Television t = new Television("LG","01","T-01234","LGTV",2000000,new Date(),65);
		System.out.println(t.toString());
		
		
		//String brand, String productNumber, String productCode, String productName, int price, Date date,
//		String cpu, int hdd, int ram, String os, boolean allInOne
		Desktop d = new Desktop("apple","02","A-111","Mac",5000000,new Date(),"A-6",500,24,"macOS",true);
		System.out.println(d.toString());
		
		
		//String brand, String productNumber, String productCode, String productName, int price, Date date,
//		String cpu, int hdd, int ram, String os, String mobileAgency
		SmartPhone s = new SmartPhone("samsung","03","G-1234","갤럭시",1000000,new Date(), "퀄컴", 512, 36, "android","KT");
		System.out.println(s.toString());
		
		
		System.out.println(s.getBrand()); // 상속을 통해 부모 것을 내 것처럼 활용 가능하다.
	}

}
