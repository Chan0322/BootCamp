package com.lv5_String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lv5_4 {
	public static void main(String[] args) throws IOException {
		ascii();
	}
	
	public static void ascii() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ch = br.read();
		
		bw.write(ch+"");
		bw.close();
	}
}
