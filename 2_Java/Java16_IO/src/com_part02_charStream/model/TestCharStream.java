package com_part02_charStream.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
	public void filesave() {
		//문자 단위의 기반스트림
		//FileWriter
		FileWriter fw = null;
		
		
		try {
			fw = new FileWriter("sample2.txt",true); // boolean 값을 넣어주면, 내용을 덮어쓰지 않고, 이어서 작성해준다.
			//파일이 존재하지 않으면 자동 생성한다.
			
			fw.write("안녕하세요 반가워요");
			fw.write('A');
			char[] carr = {'a','p','p','l','e'};
			fw.write(carr);
			fw.write("!\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileopen() {
		//문자 기반
		//FileReader
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample2.txt");
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
			
			int val;
			while((val=fr.read()) != -1) {
				System.out.print((char)val);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없다!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//new 기반스트림("외부자원");
	//new 보조스트림(new 다른스트림()); //다른스트림:또 다른 보조 스트림 or 기반 스트림
	//new 보조스트림(new 보조스트림(new 다른스트림()));
	//new 보조스트림(new 기반스트림("외부자원"));
}
