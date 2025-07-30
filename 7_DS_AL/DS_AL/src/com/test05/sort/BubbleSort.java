package com.test05.sort;

//버블정렬 : 인접한 두 값 을 비교한다.
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {6, 4, 3, 7, 1, 9, 8};
		int[] arr2 = {6, 4, 3, 7, 1, 9, 8};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 6 4 3 7 1 9 8
		// i=0 j=6 => 6 4 3 7 1 8 9
		//     j=5 => 6 4 3 7 1 8 9
		//	   j=4 => 6 4 3 1 7 8 9
		//	   j=3 => 6 4 1 3 7 8 9
		//	   j=2 => 6 1 4 3 7 8 9
		// 	   j=1 => 1 6 4 3 7 8 9
		// .......... 반복
		System.out.println("버블 정렬!");
		bubbleSort(arr, arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("앞에서부터 버블 정렬");
		bubbleSort2(arr2, arr2.length);
		for(int i=0; i<arr2.length; i++	) {
			System.out.print(arr2[i] + " ");
		}
	}
	
	// 이번엔 뒤에서부터 정렬해보자
	public static void bubbleSort(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			int cnt = 0;	// 조기 종료 할 조건에서 사용	// 교환 횟수
			for(int j=n-1; j>i; j--) {
				if(a[j-1] > a[j]) {
					//swap
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
					cnt++;
				}
			}
			System.out.println(cnt);
			if(cnt == 0) {
				break;
			}
		}
	}
	
	public static void bubbleSort2(int[] a, int n) {
		// 앞에서부터 인접한 요소 두 개를 비교해 가며
		// 가장 큰 값을 우측으로 밀어 정렬해보자.
		for(int i=0; i<n-1; i++) {
			int cnt = 0;
			for(int j=0; j<n-1-i; j++) {
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					cnt++;
				}
			}
			if(cnt == 0) {
				break;
			}
		}
	}
}
