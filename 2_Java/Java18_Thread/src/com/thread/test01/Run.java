package com.thread.test01;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Thread01 th1 = new Thread01("야옹이");
		Thread01 th2 = new Thread01("강아지");
		
//		th1.run();
//		th2.run(); // run은 메인에서 실행된다. th1 run 실행이 끝나고, th2 run이 실행된다.
		
//		th1.start(); // 각각의 thread 2개를 추가로 만들고 실행된다.
//		th2.start(); // start는 각자의 thread로 실행. => 서로 번갈아가며 실행됨.
		
		Thread01_1 th3 = new Thread01_1();
//		th3.run();
//		th1.run();
//		th3.start();
//		th1.start();	// 입력 받기를 기다리는 동안 th1이 먼저 처리된다.
		
		//우선순위 : 작업 진행이 우선순위가 높은 스레드가 먼저 진행된다.
		//우선순위가 높더라도 작업의 양이 많으면, 우선순위가 낮은 것보다 작업이 늦게 끝날 수 있다.
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(8);
		
		th1.start();
		th2.start();
		
	}

}

class Thread01_1 extends Thread {
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		String str = sc.nextLine();
		
		System.out.println("str: " + str);
	}
}
