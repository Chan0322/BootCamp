package com.test.part01_InheritTest.after.model;

import java.util.Date;

public class Television extends Product{
	private int inchType;
	
	public Television() {}

	public Television(String brand, String productNumber, String productCode, String productName, int price, Date date,
			int inchType) {
		super(brand, productNumber, productCode, productName, price, date);
		this.inchType = inchType;
	}

	public int getInchType() {
		return inchType;
	}

	public void setInchType(int inchType) {
		this.inchType = inchType;
	}

	@Override
	public String toString() {
		return super.toString() + ", inchType=" + inchType;
	}
	
	
	
}
