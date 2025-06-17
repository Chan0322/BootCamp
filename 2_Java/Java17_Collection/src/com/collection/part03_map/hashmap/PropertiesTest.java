package com.collection.part03_map.hashmap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public void test() {
		//properties
		//key, value 모두 String 객체
		
		Properties prop = new Properties();
		prop.setProperty("key", "value"); 	// Map에서는 put
		prop.setProperty("id", "admin");
		prop.setProperty("pw", "1234");
//		prop.setProperty("age", 12);	// String만 가능.
//		prop.put("pw", 12);
		
		System.out.println(prop);
		System.out.println();
		
		String id = prop.getProperty("id");
		String pw = prop.getProperty("pw");
//		int getPw = (int)prop.get("pw");
		
		System.out.println(id + ", " + pw);   // pw는 위에서 put으로 밀어넣었기 때문에 프로퍼티로 인식하지 못함.
//		System.out.println("getPw: " + getPw);
		
		//외부 파일로 출력 가능
		try {
			prop.store(new FileOutputStream("driver.properties"), "properties Test"); // 키 값과 밸류 값 인식 가능.
			prop.store(new FileWriter("driver.txt"), "properties Test");	// 그냥 텍스트 파일로 저장.
			prop.storeToXML(new FileOutputStream("dr.xml"), "xml store");   // XML 파일로 저장.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test2() {
		//파일로 부터 읽어오기
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("driver.properties"));
			
			System.out.println(prop);
			System.out.println(prop.getProperty("name"));
			System.out.println(prop.getProperty("age"));
			System.out.println(prop.getProperty("id"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
