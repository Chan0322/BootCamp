package com_part03_wrapperStream.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStreamChange {
	//보통 기반이 byte이고 보조가 char일 경우 많이 사용.
	public void input() {
		//InputStreamReader 클래스
		//보조: BufferedReader, char 단위
		//기반: System.in, 콘솔창, byte 단위 		// 얘 또한 inputStream 객체이다.
		
		//new 보조스트림(new 보조스트림(다른스트림));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("문자열 입력: ");
			String val = br.readLine();
			System.out.println("val: " + val);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void output() {
		//OutputStreamWriter클래스
		//보조 스트림: BufferedWriter, char 단위
		//기반 스트림: System.out, byte 단위
		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			bw.write("hello hi bye");
			
			bw.flush(); // finally 안쓰고 하려면 이렇게. 버퍼에 남아있는 내용들을 밀어내며 출력을 완료 시킨다.
		} catch (IOException e) {
			e.printStackTrace();
		}/* finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}*/
	}
}
