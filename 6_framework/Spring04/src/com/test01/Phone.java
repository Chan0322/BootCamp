package com.test01;

public class Phone extends Product {
	private String mobileAgency;

	public Phone() {
		super();
	}

	public Phone(String pname, int price) {
		super(pname, price);
	}
	
	public Phone(String pname, int price, String mobileAgency) {
		super(pname, price);
		this.mobileAgency = mobileAgency;
	}

	public String getMoblieAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String toString() {
		return super.toString() + ", mobileAgency=" + mobileAgency;
	}
	
	
}
