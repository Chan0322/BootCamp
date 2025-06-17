package com_part01_byteStream.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream {
	public void filesave() {
		// byte 단위로 데이터를 출력할 수 있는 스트림
		//FileOutputStream
		
		// 스트림 생성
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("sample.txt");
			// 대상파일(외부자원,sample.txt) 존재하지 않아 자동으로 생성.
			
			// 출력 작업
//			fout.write('a');
			fout.write(97);
			
			byte[] barr = {98,99,100,101,102,10};
			fout.write(barr);
			fout.write(barr, 1, 3); //배열의 인덱스 1부터 3개를 처리.
			
//			fout.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {	// 예외가 배갱
			try {
				fout.close();	
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void fileopen() {
		// 파일로부터 byte 단위로 데이터를 읽어 올 수 있는 스트림
		// FileInputStream
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("sample.txt");
			
//			int fileSize = (int)new File("sample.txt").length();
//			System.out.println(fileSize);
//			
//			//파일의 크기 만큼의 배열 선언
//			byte[] barr = new byte[fileSize];
//			
//			fin.read(barr);
//			
//			for(int i=0; i<barr.length; i++) {
//				System.out.print((char)barr[i]+" ");
//			}
			int val=0;
			while((val=fin.read()) != -1) {
//				System.out.print((char)fin.read() + " "); // read를 두 번 하다보니 중간에 하나씩 값이 빔.
				System.out.print((char)val + " ");
			}
			System.out.println();
			System.out.println("while 종료 후 val: "+val);
			// 한글은 자바에서 2Byte 이므로 제대로 읽지 못하고 깨진다.
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void filesave2() {
		//try with resource문
		//try(객체생성){}catch(예외클래스){}
		//자동으로 close() 처리.
		
		//FileOutputStream 객체 생성
		try (FileOutputStream fout = new FileOutputStream("sample.txt")){
			fout.write(65);
			byte[] b = {66,67};
			fout.write(b);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
		}
	}
	
	public void fileopen2() {
		//fileopen()과 동일하게 sampel.txt에서
		//데이터를 읽어서 출력하자.
		//단, try with resource 이용해서 작성.
		
		//FileInputStream
		try (FileInputStream fin = new FileInputStream("sample.txt")){
			int size = (int)new File("sample.txt").length();
			byte[] b = new byte[size];
			fin.read(b);
			for(int i=0; i<b.length; i++) {
				System.out.println(b[i]);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		// Alt Shift Z
	}
}
