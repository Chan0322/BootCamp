package com.test05.sort;

// 선택정렬 : 6 3 5 1 2 => 1 3 5 6 2 => 1 2 5 6 3 => 1 2 3 6 5 => 1 2 3 5 6
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {6,4,8,3,1,10,7};
		System.out.println("[정렬 전 배열]");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("선택정렬!");
		selectionSort(arr, arr.length);
		
		// 6 4 8 3 1 10 7
		// i=0 j=1... min=4 => 1 4 8 3 6 10 7
		// i=1 j=2... min=3 => 1 3 8 4 6 10 7
		// i=2 j=3... min=3 => 1 3 4 8 6 10 7
		// i=3 j=4... min=4 => 1 3 4 6 8 10 7
		// i=4 j=5... min=6 => 1 3 4 6 7 10 8
		// i=5 j=6... min=6 => 1 3 4 6 7 8 10
		System.out.println("[정렬 후 배열]");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void selectionSort(int[] a, int n) {
		// a : 정렬 진행할 배열, n 그 배열의 크기
		for(int i=0; i<n-1; i++) {
			int min=i;	// 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 저장할 변수
			for(int j=i+1; j<n; j++) {	// 데이터 중 가장 작은 값을 찾아 인덱스를 min에 저장.
				if(a[j] < a[min]) {
					min = j;
				}
			}
			// swap
			swap(a, i, min); //가독성을 높이기 위해 보통 메소드를 따로 만듦
//			int tmp = a[i];
//			a[i] = a[min];
//			a[min] = tmp;
		}
	}
	public static void swap(int[] a, int i, int min) {
		int tmp = a[i];
		a[i] = a[min];
		a[min] = tmp;
	}
}
