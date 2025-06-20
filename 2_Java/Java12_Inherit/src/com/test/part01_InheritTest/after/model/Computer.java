package com.test.part01_InheritTest.after.model;

import java.util.Date;

public class Computer extends Product{ // 다중 상속은 지원하지 않지만, 그를 해결하기 위해 상속에 상속에 상속이 가능.
	private String cpu;
	private int hdd;
	private int ram;
	private String os;
	
	//생성자
	public Computer() {}
	public Computer(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os) {
		super(brand, productNumber, productCode, productName, price, date);
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		System.out.println("Computer 객체 생성");
	}

	//getter & setter
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	//toString
	@Override
	public String toString() {
		return super.toString()+", cpu=" + cpu + ", hdd=" + hdd + ", ram=" + ram + ", os=" + os;
	}
	
}
