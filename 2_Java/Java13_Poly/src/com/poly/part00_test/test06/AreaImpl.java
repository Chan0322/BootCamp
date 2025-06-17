package com.poly.part00_test.test06;

public abstract class AreaImpl implements Area {
	
	private String result;
	
	@Override
	public void print() {
		System.out.println(Area.print + result);
	}
	// 원하는 메소드만 작성하고 싶으면 클래스를 abstract로 작성.
	
	public void setResult(String result) {
		this.result = result;
	}
}
