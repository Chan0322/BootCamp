package com.lv4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv4_Bj7 {

	public static void main(String[] args) throws IOException {
		student();
	}

	public static void student() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[30];
		
		for(int i=0; i<28; i++) {
			arr[Integer.parseInt(br.readLine())-1] = 1;   // 28명의 출석 번호만 받고 1로 받음 표시.
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=1) {		// 출석번호가 확인되지 않으면
				bw.write(i+1 + " ");
			}
		}
		bw.close();
	}
}
