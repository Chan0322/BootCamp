package com.arrayPractice1.sample;

import java.util.Scanner;

public class ArraySample {

	//문제1
	public void test1() {
		int arr[] = new int[10];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int rand = (int)(Math.random()*100)+1;
			arr[i] = rand;
			System.out.print(arr[i] + ", ");
			sum += arr[i];
		}
		System.out.println("합: " + sum);
	}
	
	//문제2
	public void test2() {
		int arr[] = new int[10];
		int max = 0, min = 100;
		
		for(int i=0; i<arr.length; i++) {
			int rand = (int)(Math.random()*100)+1;
			arr[i] = rand;
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("max: " + max + ", min: " + min);
	}
	
	// 문제3
	public void test3() {
		byte arr[] = new byte[10];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (byte)(Math.random()*256);
			System.out.print(arr[i]+", ");
			
			if(arr[i]%2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println(sum);
	}
	
	//문제4
	public void test4(){
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		String str = sc.nextLine();
		
		int arr[] = new int[str.length()];
		int sum=0;
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
			sum += arr[i];
		}
		
		System.out.println("합계: "+sum);
	}
	
	//문제5
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		String str = sc.nextLine();
		int arr[] = new int[str.length()];
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
			sum += arr[i];
		}
		System.out.println("합계: "+sum);

	}
}
