package com.silsub1.model;

import java.util.Scanner;

public class Sample {
//	public void munjae1() {
//		int[][] arr = new int[4][4];
//		int sum1 = 0;
//		for(int i=0; i<=2; i++) {
//			for(int j=0; j<=2; j++) {
//				arr[i][j] = (int)(Math.random()*100)+1;
//				System.out.print(arr[i][j]+" ");
//				sum1 += arr[i][j];
//			}
//			System.out.print(sum1);
//			System.out.println();
//		}
//	}
	
	public void munjae1() {
		int[][] iarr = new int[4][4];
		
		//값 저장
		for(int i=0; i<iarr.length-1; i++) {
			for(int j=0; j<iarr[i].length-1; j++) {
				iarr[i][j] = (int)(Math.random() * 100)+1;
			}
		}
		
		//계산 처리
		for(int i=0; i<iarr.length-1; i++) {
			for(int j=0; j<iarr[i].length-1; j++) {
				iarr[i][3] += iarr[i][j];
//				iarr[3][j] += iarr[i][j];
				iarr[3][i] += iarr[j][i];
			}
			iarr[3][3] += iarr[i][3] + iarr[3][i];
		}
		
		// 출력
		for(int i=0; i<iarr.length; i++) {
			for(int j=0; j<iarr[i].length; j++) {
				System.out.print(iarr[i][j] + "\t"); // tab 만큼의 여백.
			}
			System.out.println();
		}
	}
	
	public void munjae2() {
		// 키보드로 숫자를 입력 받아 2차원 배열 생성
		int iarr[][] = new int[3][];
		Scanner sc = new Scanner(System.in);
		
		int[] sum = new int[iarr.length];
		
		for(int i=0; i<iarr.length; i++) {
			System.out.print(i+"번째 1차원 배열 크기: ");
//			int size = sc.nextInt();
//			iarr[i] = new int[size];
			iarr[i] = new int[sc.nextInt()];
			
			for(int j=0; j<iarr[i].length; j++) {
				iarr[i][j] = (int)(Math.random()*100)+1;
				sum[i] += iarr[i][j];
			}
		}
		
		//전체 확인
		for(int i=0; i<iarr.length; i++) {
			for(int j=0; j<iarr[i].length; j++) {
				System.out.print(iarr[i][j] + "\t"); // tab 만큼의 여백.
			}
			System.out.print("sum: " + sum[i] + "\t");
			System.out.println();
		}
		System.out.println("합이 5의 배수인 행 출력");
		//합이 5의 배수인 행만 출력
		for(int i=0; i<iarr.length; i++) {
			if(sum[i]%5 == 0) {
				for(int j=0; j<iarr[i].length; j++) {
					System.out.print(iarr[i][j] + "\t"); // tab 만큼의 여백.
				}
				System.out.print("sum: " + sum[i] + "\t");
				System.out.println();
			}
		}
	}
}
