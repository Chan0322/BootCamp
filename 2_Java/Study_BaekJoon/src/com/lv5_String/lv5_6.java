package com.lv5_String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv5_6 {

	public static void main(String[] args) throws IOException {
		findCh();
	}

	public static void findCh() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		// 결과 값 담을 배열
		int res[] = new int[26];
		// 초기화
		for(int i=0; i<res.length; i++) {
			res[i] = -1;
		}
		
		
		// a~z의 ASCII 코드 값 대입
		int arr[] = new int[26];
		int ascii = 61;
		for(int i=0; i<arr.length; i++) {
			arr[i] = ascii++;
		}
		
		String str = br.readLine();
		char chArr[] = new char[str.length()];
		
		// str의 각 문자를 배열에 한글자씩 대입
		for(int i=0; i<str.length(); i++) {
			chArr[i] = str.charAt(i);
		}
		
		// a~z와 str 비교
		for(int i=0; i<arr.length; i++) {
			// str 배열
			for(int j=0; j<chArr.length; j++) {
				// ascii 코드 값을 비교
				if(arr[i] == Character.getNumericValue(chArr[j])) {
					res[i] = j;
				}
			}
		}
		
		// 출력
		for(int i=0; i<res.length; i++) {
			bw.write(res[i]+" ");
		}
		bw.close();
	}
}
