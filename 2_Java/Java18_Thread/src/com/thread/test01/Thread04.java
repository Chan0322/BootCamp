package com.thread.test01;

public class Thread04 {

	public static void main(String[] args) {
		for(int i=1; i<=50; i++) {
			try {
				Thread.sleep(1000);	// 1초동안 슬립 -> 실행 -> 1초 슬립 반복
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("🚀");
		}
	}

}
