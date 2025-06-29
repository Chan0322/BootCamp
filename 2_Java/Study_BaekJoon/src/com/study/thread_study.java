package com.study;

public class thread_study {

	public static void main(String[] args) {
		// 문제1
		// 스레드에 대한 설명 중 틀린 것?
		// 1) 자바 애플리케이션은 메인(main) 스레드가 main() 메소드를 실행시킨다.
		// 2) 작업 스레드 클래스는 Thread 클래스를 상속해서 만들 수 있다.
		// 3) Runnable 객체는 스레드가 실행해야 할 코드를 가지고 있는 객체라고 볼 수 있다.
		// 4) 스레드 실행을 시작하려면 run() 메소드를 호출해야 한다.
		// 답 : 4번
		
		// 문제2
		// 빈칸(/*코드*/)에 적절한 코드
//		public class ThreadExample {
//			public static void main(String[] args) {
//				Thread thread1 = new MovieThread();
//				thread1.start();
//				
//				Thread thread2 = new Thread(/*new MusicRunnable()*/);
//				thread2.start();
//			}
//		}
//		public class MovieThread /*extends Thread*/ {
//			@Override
//			public void run() {
//				for(int i=0; i<3; i++) {
//					System.out.println("동영상을 재생합니다.");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//					}
//				}
//			}
//		}
//		public class MusicRunnable /*implements Runnable*/ {
//			@Override
//			public void run() {
//				for(int i=0; i<3; i++) {
//					System.out.println("음악을 재생합니다.");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//					}
//				}
//			}
//		}
		
		
		// 문제3
		// 동기화 메소드와 동기화 블록에 대한 설명 중 틀린 것?
		// 1) 동기화 메소드와 동기화 블록은 싱글(단일)스레드 환경에서는 필요 없다.
		// 2) 스레드가 동기화 메소드를 실행할 때 다른 스레드는 일반 메소드를 호출할 수 없다.
		// 3) 스레드가 동기화 메소드를 실행할 때 다른 스레ㅔ드는 동기화 메소드를 호출할 수 없다..
		// 4) 스레드가 동기화 블록을 실핼할 때 다른 스레드는 동기화 메소드를 호출할 수 없다.
		// 답 : 2번
		
		
		// 문제4
		// 스레드 일시 정지 상태에 대한 설명 중 틀린 것은?
		// 1) sleep() 메소드는 주어진 시간 동안 스레드가 일시 정지 상태가 된다.
		// 2) 스레드가 동기화 메소드를 실행할 때 다른 스레드가 동기화 메소드를 호출하게 되면 일시 정지 상태가 된다.
		// 3) 동기화 메소드 내에서 wait() 메소드를 호출하면 현재 스레드가 일시 정지 상태가 된다.
		// 4) yield() 메소드를 호출하면 현재 스레드가 일시 정지 상태가 된다.
		// 답 : 4번
		
		// 문제5
		// interrupt() 메소드를 호출한 효과에 대한 설명 중 틀린 것은?
		// 1) 일시 정지 상태에서 InterruptedException을 발생시킨다.
		// 2) 스레드를 즉시 종료한다.
		// 3) 스레드가 일시 정지 상태가 될 때까지 InterruptedException이 발생하지 않는다.
		// 4) InterruptedException이 발생하지 않았다면 isInterrupted() 메소드는 true를 리턴한다.
		// 답 : 2번
		
		// 문제6
		// 메인스레드에서 3초 후 MovieThread의 interrupt() 메소드를 호출해서 MovieThread를 안전하게 종료하고 싶습니다. 비어있는 부분에 적당한 코드를 작성해 보세요.
//		public class ThreadExample {
//			public static void main(String[] args) {
//			Thread thread = new MovieThread();
//			thread.start();
//			try { Thread.sleep(3000); } catch (InterruptedException e) {}
//			thread.interrupt();
//			}
//		}
//		public class MovieThread extends Thread {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("동영상을 재생합니다.");
//			/*
//					if(Thread.interrupted()){
//						break;
//					}
//			*/
//				}
//			}
//		}
		
		
		// 문제7
		// wait()와 notify() 메소드에 대한 설명 중 틀린 것은 무엇입니까?
		// 1) 스 레 드 가 wait()를 호출하면 일시정지 상태가 된다 .
		// 2) notify()를 호출하면 wait ()로 일시 정지 상태에 있던 스레드가 실행 대기 상태가 된다.
		// 3) wait() 와 notify() 는 동기화 메소드 또는 블록에서 호출할 필요가 없다 .
		// 4) wait()와 notify()는 두 스레드가 균등하게 번갈아 가면서 실행할 때 사용할 수 있다.
		// 답 : 3번
		
		
		// 문제8
		// 3초 뒤에 메인 스레드가 종료하면 MovieThread도 같이 종료되게 만들고 싶습니다. 밑줄 친 부분에 적당한 코드를 넣어 보세요.
//		public class ThreadExample {
//			public static void main(String[] args) {
//			Thread thread = new MovieThread();
//			/*thread.setDaemon(true);*/
//			thread.start();
//			try {Thread.sleep(3000); } catch (InterruptedException e) {}
//			}
//		}
//		
//		public class MovieThread extends Thread {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("동영상을 재생합니다.");
//					try { Thread.sleep(1000); } catch (InterruptedException e) {}
//			}
//		}
		
		// 문제9
		// while 문으로 반복적인 작업을 하는 스레드를 종료시키는 방법에 대한 설명 중 최선의 방법이 아닌 것은 무엇입니까?
		// 1) 조건식에 boolean 타입의 stop 플래그를 이용해서 while 문을 빠져나가게 한다.
		// 2) 스레드가 반복적으로 일시 정지 상태가 된다면 InterruptedException을 발생시켜 예외 처리 코드에서 break 문으로 while 문을 빠져나가게 한다.
		// 3) 스레드가 일시 정지 상태로 가지 않는다면 isInterrupted()나 interrupted () 메소드의 리턴값을 조사해서 true일 경우 break 문으로 while 문을 빠져나가게 한다.
		// 4) stop() 메소드를 호출한다.
		// 답 : 4번
		
		// 문제10
		// 스레드풀에 대한 설명 중 틀린 것은 무엇입니까?
		// 1) 갑작스러운 작업의 증가로 스레드의 폭증을 막기 위해 사용된다.
		// 2) ExecutorService 객체가 스레드풀이며 newFixedThreadPool() 메소드로 얻을 수 있다.
		// 3) 작업은 Runnable 또는 Callable 인터페이스를 구현해서 정의한다.
		// 4) execute() 메소드로 작업 처리 요청을 하면 작업이 완료될 때까지 대기(블로킹)된다.
		// 답 : 4번
	}

}
