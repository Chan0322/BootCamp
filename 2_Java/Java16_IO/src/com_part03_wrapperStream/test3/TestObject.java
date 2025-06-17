package com_part03_wrapperStream.test3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObject {
	public static void main(String[] args) {
//		new TestObject().fileSave();
		new TestObject().fileopen();
	}
	
	
	public void fileSave() {
		Member mar[] = {
				new Member("user01", "pass01", "김창진", "kim@multi.com", 20, '남', 1200.4),
				new Member("user02", "pass02", "박창진", "park@multi.com", 40, '여', 1222.1),
				new Member("user03", "pass03", "장창진", "jang@multi.com", 30, '여', 1215.8)
		};
		
		//객체 출력
		//ObjectOutputStream 클래스 사용, 보조스트림
		ObjectOutputStream objOut = null;
		
		try {
			objOut = new ObjectOutputStream(new FileOutputStream("member.txt")); // File은 기반 스트림. 기반 스트림 안에는 외부 자원
			
			for (int i = 0; i < mar.length; i++) {
				objOut.writeObject(mar[i]);
			}
			
			objOut.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileopen() {
		Member[] mar = new Member[3]; // 저장할 배열
		
		//스트림 객체 생성	(try with resource로 생성했기에 자동으로 close처리된다)
		try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("member.txt"))) {
			// 입력
			mar[0] = (Member)objIn.readObject(); //return 타입이 Object 이므로 Member 타입으로 변환
			mar[1] = (Member)objIn.readObject();
			mar[2] = (Member)objIn.readObject();
			
			//입력받은 객체를 콘솔에 출력
			for(Member m : mar) {
				System.out.println("읽어온 객체: " + m);
				System.out.println(m.addr);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
