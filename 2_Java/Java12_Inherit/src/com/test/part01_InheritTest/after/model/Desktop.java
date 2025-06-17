package com.test.part01_InheritTest.after.model;

import java.util.Date;

public class Desktop extends Computer{
	private boolean AllInOne;
	
	//생성자
	public Desktop() {}
	public Desktop(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, boolean allInOne) {
		super(brand, productNumber, productCode, productName, price, date, cpu, hdd, ram, os);
		AllInOne = allInOne;
		System.out.println("Desktop 객체 생성");
	}

	//getter&setter
	public boolean isAllInOne() {
		return AllInOne;
	}
	public void setAllInOne(boolean allInOne) {
		AllInOne = allInOne;
	}

	//toString
	@Override
	public String toString() {
		return super.toString()+", AllInOne=" + AllInOne;
	}
}
