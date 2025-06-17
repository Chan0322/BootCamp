package com.lv5_String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv5_2 {

	public static void main(String[] args) throws IOException {
		strLength();
	}

	public static void strLength() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
	
		bw.write(str.length()+"");
		bw.close();
	}
}
