package com.lv4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class lv4_bj2 {

	public static void main(String[] args) throws IOException {
		lowNum();
	}
	
	public static void lowNum() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < X) {
				bw.write(arr[i] + " ");
			}
		}
		bw.close();
		
	}

}
