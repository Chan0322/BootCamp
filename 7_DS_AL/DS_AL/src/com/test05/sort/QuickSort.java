package com.test05.sort;

public class QuickSort {
	public static void main(String[] args) {
		// 퀵 정렬
		// 정렬 알고리즘 중 빠르기로 유명.
		// 피벗(pivot)이라는 기준 값이 있다. 이 기준값을 기준으로 작은 값을 왼쪽에, 큰 값을 오른쪽에 모으고,
		// 그 왼쪽과 오른쪽에서도 각 피벗을 정해 나눠가며 진행.
		// ex) 5 3 8 4 2 7 1 6	/ 피벗 : 5
		// 1) [3 4 2 1] 5 [8 7 6] 피벗 : 3, 7	=> 2) [2 1] 3 [4] 5 6 7 8
		int[] arr = {5, 8, 4, 2, 6, 1, 3, 9, 7};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		quickSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void quickSort(int[] a, int left, int right) {
		int lc = left;
		int rc = right;
		int x = a[(lc+rc)/2];	// 배열의 가운데 데이터를 피벗으로.....
		
		do {
			while(a[lc]<x) {
				lc++;			// 피벗보다 적으면 lc를 ++시키다 피벗보다 큰 값을 찾으면 스탑.
			}
			while(a[rc]>x) {
				rc--;			// 피벗보다 크면 rc를 -- 시키다 피벗보다 작은 값을 찾으면 스탑.
			}
			
			// 두 와일문 종료되었다! => 피벗 왼쪽에서 피벗보다 큰 값을 찾았다.
			//					 피벗 우측에서 피벗보다 작은 값을 찾았다.
			
			if(lc<=rc) {
				int tmp = a[lc];
				a[lc] = a[rc];
				a[rc] = tmp;
				lc++;
				rc--;
			}
			
		}while(lc<=rc);
		
		if(left < rc) {
			quickSort(a, left, rc);
		}
		if(right > lc) {
			quickSort(a, lc, right);
		}
	}
}
