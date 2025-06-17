package com.lv4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv4_Bj8 {

	public static void main(String[] args) throws IOException {
		remainder();
	}
	
	public static void remainder() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[10];
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine())%42; 	// 배열에 나머지 저장.
			for(int k=i+1; k<arr.length; k++) {
				if(arr[i] != arr[k]) {
					cnt++;
				}
			}
		}
		bw.write(cnt + "");
		bw.close();
	}

}
