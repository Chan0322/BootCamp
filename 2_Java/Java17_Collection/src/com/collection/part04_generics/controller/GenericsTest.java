package com.collection.part04_generics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericsTest {
	public void test() {
		//다루려는 클래스 타입을 지정.
		//컬렉션이 다룰 클래스 타입을 제한하여 한가지 종류의
		//클래스타입 객체만 저장하게 하는 기능.
		
		//잘못된 타입을 사용하여 형변환 등의 작업을 할 가능성을 제거.
		//컬렉션에 다양 종류의 객체가 저장되있다. 꺼내 사용할 때마다 형변환해야 한다. 그로인해 코드가 복잡.
		
		//<> 해당 기호를 이용하여 클래스 명시.
		
		List list = new ArrayList();
		
		list.add(new String("String Object"));
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		System.out.println("저장된 객체 수: " + list.size());
		System.out.println("list: " + list);
		
		//저장된 객체를 꺼내 사용할 때
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			
			if(obj instanceof String) {
				System.out.println( ((String)obj).equals("test") );
			}else if(obj instanceof Book) {
				((Book)obj).prnBook();
			}else if(obj instanceof Student) {
				((Student)obj).score();
			}else if(obj instanceof Car) {
				((Car)obj).printCar();
			}
		}
	}
	
	public void test2() {
		//제네릭스 : 컬렉션에 저장되는 객체의 자료형 제한
		List<Book> list = new ArrayList<Book>();
		//해당 list에는 Book 클래스 객체만 저장하겠다!!
		
//		list.add("test");
		list.add(new Book());
		list.add(new Book());
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).prnBook();
		}
		///////
		List list2 = new ArrayList();
		list2.add(new Book());
		list2.add(new Book());
		for(int i=0; i<list2.size(); i++) {
			((Book)list2.get(i)).prnBook();; 	// Object 타입으로 객체 가져옴.
		}
	}
	
	public void test3() {
		//Map에 제네릭스 적용
		HashMap<String,Book> map = new HashMap<>();	//앞-key 뒤-value에 대한 제네릭스 설정 뒤<> 비워두면 앞 설정을 따른다. <>를 아예 빼면 제네릭스 설정 안됨.
//		map.put("one", "tesy"); // 에러, value에 String 안된다
		map.put("one", new Book("java"));
		map.put("two", new Book("JS"));
		map.put("three", new Book("HTML"));
		
		System.out.println(map);
		
		System.out.println("-------------------");
		Set<Map.Entry<String,Book>> entry = map.entrySet();
		Iterator<Map.Entry<String,Book>> it = entry.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Book> en = it.next();
			String key = en.getKey();
			Book val = en.getValue();
			System.out.println(key+":"+val);
		}
		
		//KeySet() 을 이용하여 value 확인
		//제네릭스 사용!
		Set<String> keys = map.keySet();
		Iterator<String> keyIt = keys.iterator();
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Book b = map.get(key);
			System.out.println(key+"="+b);
		}
	}
}


//클래스 파일 내부에 또다른 클래스 선언 가능.
//한 클래스파일(.java) 안에 여러 클래스 정의 가능.
//단! public 접근제한자 1개만 가능.
class Book{
	private String title;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public void prnBook() {
		System.out.println("printBook() call...");
	}
	@Override
	public String toString() {
		return "book " + title;
	}
}
class Student{
	public Student() {}
	public void score() {
		System.out.println("score() call...");
	}
	@Override
	public String toString() {
		return "student";
	}
}
class Car{
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "car";
	}
}