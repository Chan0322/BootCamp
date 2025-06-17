package com.thread.test01;

//2. Runable 상속
public class Thread02 {
	public static void main(String[] args) {
		System.out.println("----main start----");
		MyThread mt = new MyThread();
//		mt.start();	// Runnable 상속 받았을 때는 객체를 만들고 바로 start 불가.
		Thread t1 = new Thread(mt); 	// Thread 클래스로 객체를 추가로 만들어야 한다.
		Thread t2 = new Thread(new MyThread());
		
		//start() -> 자동으로 run() 실행
		t1.start();
		t2.start();
		
		System.out.println("----main end====");
	}


}

class MyThread implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("i="+i);
		}
	}
}