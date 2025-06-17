package com.collection.part01_list.listsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
	public void test() {
		List list = new ArrayList();
		
		list.add(new Score("이창진",99));
		list.add(new Score("홍길동",74));
		list.add(new Score("박창진",88));
		
		list.add(new Score("정창진",62));
		list.add(new Score("이창잔",51));
		list.add(new Score("김창진",82));
		
		System.out.println("list: " + list);
		
		
		//1. Comparable - 기본 정렬 기준 구현
		//해당 클래스(객체 생성하는 클래스, Score)에 구현
		// Score객체 정렬해!
		//2. Comparator - 기본 정렬 기준 이외 다른 정렬 기준 구현
		//새로운 클래스에 구현
		// Score객체 나이 오름차순 정렬해!
		
		//list 안의 객체 정렬!
		list.sort(null);
		System.out.println("list: " + list);
		
		list.sort(new PointAsc());
		System.out.println("list: " + list);
		
		//이름 내림차순, 점수 내림차순 정렬을 할 수 있게
		//클래스 생성하고 그 기준에 맞게 완성해보자.
		//NameDesc.java, PointDesc.java
		list.sort(new NameDesc());
		System.out.println("list: " + list);
		
		/////
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new PointAsc());
		
		list.sort(new PointDesc());
		System.out.println("list: " + list);
		
	}
}
