package com.lv4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class lv4_Bj9 {

	public static void main(String[] args) throws IOException {
		revBall();
	}

	public static void revBall() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//바구니 갯수
		int M = Integer.parseInt(st.nextToken());	//입력 줄 수
		
		int arr[] = new int[N];	// 정수 배열
		// 배열에 초기값 대입
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;		// 1,2,3.......
		}
		
		// 입력
		for(int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st2.nextToken());
			int J = Integer.parseInt(st2.nextToken());
			
			// for 문을 2개로 나눠서 j, k 따로 진행시 역순으로 안바뀐다...
			for(int j=I-1, k=J-1; j<k; j++, k--) {
					int ex = arr[j];
					arr[j] = arr[k];
					arr[k] = ex;
			}
		}
		
		//출력
		for(int i=0; i<arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		bw.close();
	}
}
