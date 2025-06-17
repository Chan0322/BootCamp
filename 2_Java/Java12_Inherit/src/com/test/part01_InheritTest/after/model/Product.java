package com.test.part01_InheritTest.after.model;

import java.util.Date;

public class Product {
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private int price;
	private Date date;
	
	//생성자
	public Product() {}
	public Product(String brand, String productNumber, String productCode, String productName, int price, Date date) {
		super();
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		System.out.println("Product 객체 생성");
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
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

	//toString  필드값들을 String으로 묶어서 리턴해줌.
	@Override
	public String toString() {
		return "brand=" + brand + ", productNumber=" + productNumber + ", productCode=" + productCode
				+ ", productName=" + productName + ", price=" + price + ", date=" + date;
	}

}
