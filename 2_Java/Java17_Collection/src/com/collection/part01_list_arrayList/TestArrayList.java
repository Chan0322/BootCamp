package com.collection.part01_list_arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
	public void test() {
		
		int arr[] = new int[3];
		
		ArrayList alist = new ArrayList();
		
		//다형성
		List<Integer> list = new ArrayList<Integer>(); // Integer 객체만 저장될 수 있게끔 타입 고정.
		Collection clist = new ArrayList();
		
		
		//arraylist는 저장 순서 유지, 중복 가능.
		// index
		
		//추가
		// arrayList는 객체만 저장 가능.
		alist.add("apple");
		alist.add(123); //autoboxing 처리, int -> autoboxing -> Integer
		alist.add(45.67);
		alist.add(new Date());
		alist.add('A');
		
//		list.add(123);
//		list.add(45.67);
//		list.add("String"); Integer 로 고정했기에 출력 불가.
		
		System.out.println("alist: " + alist);
		
		//인덱스로 접근
		//배열의 크기 : length
		//리스트의 크기 : size()
		for(int i=0; i<alist.size(); i++) {
//			System.out.println(i + " : " + arr[i]);
			// 값을 가져올 때는 get(index)랄 사용한다.
			System.out.println(i + " : " + alist.get(i));
		}
		
		
		//ArrayList는 중복 저장 허용
		alist.add("apple");
		System.out.println("alist: " + alist);
		
		alist.add(new String("apple"));
		System.out.println("alist: " + alist);
		
		// 리스트 중간에 추가된다. 하나씩 뒤로 밀리는 것 확인 가능하다. (입력한 인덱스 위치에 추가)
		alist.add(1, "banana");
		System.out.println("alist: " + alist);
		
		// 삭제
		alist.remove(2);
		System.out.println("alist: " + alist);
		System.out.println(alist.get(2));
		
		//수정
		alist.set(1, true);
		System.out.println("alist: " + alist);
		
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty());
		alist.clear();
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty());
		System.out.println(alist.size() == 0);
	}
	
	public void testSort() {
		//기본적으로 제공되는 sort()메소드, 오름차순 정렬된다.
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("banana");
		list.add("grape");
		
		System.out.println("list: " + list);
		
//		list.sort(null);
		Collections.sort(list);
		System.out.println("list: " + list);
		
		//역순으로 조금 특별하게 구현해봄
		Iterator dIter = new LinkedList(list).descendingIterator();
		
		ArrayList descList = new ArrayList();
		
		while(dIter.hasNext()) {
			descList.add(dIter.next());
		}
		System.out.println("descList: " + descList);
		
	}
}
