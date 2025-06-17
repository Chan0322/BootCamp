package com.test.chap03_field.test02;

public class Run {

	public static void main(String[] args) {
		InitBlock i = new InitBlock("iphone",200,"apple");
		i.information();
		
		InitBlock i2 = new InitBlock();
		i2.information();
		i.information(); // 브랜드는 static 필드이므로, 객체가 생성되며 삼성으로 덮어씌워짐.
		
		i2.savePName("sam");
		i2.information();
	}

}
