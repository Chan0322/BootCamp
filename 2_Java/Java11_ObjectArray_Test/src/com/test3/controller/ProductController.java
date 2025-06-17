package com.test3.controller;

import java.util.Scanner;

import com.test3.model.vo.Product;

public class ProductController {
	private Product[] pro = new Product[10];
	public static int count;
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		do {
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				productInput();
				break;
			case 2:
				productPrint();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			}
			
		}while(true);
	}
	
	public void productInput() {
		System.out.print("제품 번호: ");
		int pId = sc.nextInt();
		sc.nextLine();
		System.out.print("제품명: ");
		String pName = sc.nextLine();
		System.out.print("제품가격: ");
		int price = sc.nextInt();
		System.out.print("제품세금: ");
		double tax = sc.nextDouble();
		
		pro[ProductController.count] = new Product(pId, pName, price, tax);
	}
	
	public void productPrint() {
		for(int i=0; i<count; i++) {
//			pro[i].information();
			System.out.println(pro[i].information());
		}
	}
}
