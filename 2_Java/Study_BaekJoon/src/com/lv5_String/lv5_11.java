package com.lv5_String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv5_11 {
	public static void main(String[] args) throws IOException {
		str();
	}
	
	public static void str() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = "";
		
		while((str=br.readLine()) != null) {
			bw.write(str+"\n");
		}
		
		
		bw.close();
	}
}
