package com.lv2;

import java.util.Scanner;

public class Lv2_Bj4 {

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Lv2_Bj4 bj = new Lv2_Bj4();
		bj.quadrantTest();
	}
	
	public void quadrantTest() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int quad = 0;
		
		if(x>=0&&y>=0) {
			quad = 1;
		}else if(x<=0&&y>=0) {
			quad = 2;
		}else if(x<=0&&y<=0) {
			quad = 3;
		}else if(x>=0&&y<=0){
			quad = 4;
		}
		
		switch(quad) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
		}
	}
}
