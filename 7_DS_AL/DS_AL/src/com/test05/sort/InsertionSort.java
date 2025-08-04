package com.test05.sort;

public class InsertionSort {
	public static void main(String[] args) {
		// 삽일 정렬
		//ex) 5 2 3 1
		// 1) 2 5 3 1 / 2) 2 3 5 1	/ 3) 2 3 1 5 / 4) 2 1 3 5 / 5) 1 2 3 5
		int[] arr = {6, 4, 1, 7, 3, 9, 8};
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		System.out.println("[삽입정렬]");
		insertionSort(arr, arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] a, int n) {
		for(int i=1; i<n; i++) {
			int j;
			int tmp = a[i];
			for(j=i; j>0 && a[j-1]>tmp; j--) {
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
	}
}
