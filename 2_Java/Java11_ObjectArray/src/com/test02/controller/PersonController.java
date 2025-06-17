package com.test02.controller;

import java.util.Scanner;

import com.test02.model.vo.Person;

public class PersonController {
	private Person[] p = new Person[3];
	Scanner sc = new Scanner(System.in);
	
	public void insertPerson() {
		//회원 추가
		for(int i=0; i<3; i++) {
			System.out.println("== 회원 정보 입력 ==");
			System.out.print("이름: ");
			String name = sc.next();
			System.out.print("나이: ");
			int age = sc.nextInt();
			System.out.print("재산: ");
			int wealth = sc.nextInt();
			
			p[i] = new Person(name, age, wealth);
		}
	}
	
	public void printPerson() {
		//회원 전체 조회
//		for(int i=0; i<p.length; i++) {
//			System.out.println(p[i].info());
//		}
		
		//향상된 for문
		for(Person people : p) { // p배열의 처음부터 끝까지 한번씩 그 안의 객체를 꺼내서 people 변수에 담는다.
			System.out.println(people.info());
		}
	}
	
	public void avgWealth() {
		//회원 평균 재산.
		int sum = 0;
		for(Person people : p) {
			sum += people.getWealth();
		}
		System.out.println("평균 재산: " + (sum/p.length));
	}
	
	public void searchName() {
		//키보드로 입력받은 이름과 같은 회원을 찾아
		//화면에 출력
		System.out.print("검색할 이름: ");
		String searchName = sc.next();
		
		for(int i=0; i<p.length; i++) {
			if(p[i].getName().equals(searchName)) {
				System.out.println(p[i].info());
			}
		}
	}
}
