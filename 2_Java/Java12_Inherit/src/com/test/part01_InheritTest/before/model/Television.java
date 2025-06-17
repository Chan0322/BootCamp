package com.test.part01_InheritTest.before.model;

import java.util.Date;

public class Television {
	// 필드
	private String brand;			//제조사
	private String ProductNumber;	//상품번호
	private String productCode;		//상품코드
	private String productName;		//상품명
	private int price;				//가격
	private Date date;				//제조일
	private int inchType;			//화면크기
	
	//생성자(기본, 매개변수)
	public Television() {}
	public Television(String brand, String productNumber, String productCode, String productName, int price, Date date, int inchType) {
		this.brand = brand;
		this.ProductNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		this.inchType = inchType;
	}
	
	//getter&setter
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductNumber() {
		return ProductNumber;
	}
	public void setProductNumber(String productNumber) {
		this.ProductNumber = productNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getInchType() {
		return inchType;
	}
	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	//prn() : 필드값 출력
	public void prn() {
		String str = "brand: " + brand + ", productNumber: " + ProductNumber + ", productCode: " + productCode + ", productName: " + productName + ", price: " + price + ", date: " + date + ", inchType: " + inchType;
		System.out.println(str);
	}
}
