package com_part00_file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		//File 클래스
		// 경로에 작성된 파일이 없어도 File 객체 생성 가능
		//new File("경로"); ex 경로- "C:\work\test\fileTest.txt"
		File file = new File("fileTest.txt"); // File()은 기본 생성자 없음.
		
		System.out.println("파일명: " + file.getName());
		System.out.println("경로: " + file.getAbsolutePath()); // 전체 경로
		System.out.println("파일크기: " + file.length());
		
		try {
		//파일이 없는 경우 생성
		//createNewFile => 생성을 하면 true 리턴, 기존 파일이 존재하면 false 리턴
		 boolean b = file.createNewFile();
		 
		 System.out.println("파일 생성 결과: " + b);
		 System.out.println("파일 생성 완료!!");
		 
		 file.mkdirs();
		 System.out.println("폴더 생성 완료!!")
		 ;
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("프로그램 종료");
		}
		
		// 필요 디렉터리 생성
		// => 파일 생성
		File dir1 = new File("test");
		dir1.mkdir();
		
		File dir2 = new File("test1/test2/test3");
		dir2.mkdirs();
	}
}
