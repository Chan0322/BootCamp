package com.test01;

public class ArrayTest01 {

	public void testArray1() {
		//배열 사용 하는 이유
//		int num1 = 10;
//		int num2 = 20;
//		int num3 = 30;
//		int num4 = 40;
//		int num5 = 50;
//		
//		int sum = 0;
//		
//		sum += num1;
//		sum += num2;
//		sum += num3;
//		sum += num4;
//		sum += num5; // 배열을 사용하지 않으면 이렇게 하나하나 사용해야 한다.
//		// 사용할 변수의 갯수가 많아질수록 점점 힘듦.
		
		int[] arr = new int[5]; //크기가 5인 배열 arr 생성.

//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;  인덱스 번호를 통해 배열에 접근 가능.
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (i+1)*10;
		}
		int sum = 0;
//		sum += arr[0];
//		sum += arr[1];
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		// 배열같이 만들었는데, 그 안에 다양한 자료형을 넣을 수 있으면 그건 구조체.
	}
	
	public void testArray2() {
		//배열 사용 방법
		//선언
		//자료형[] 변수명;
		//자료형 변수명[];
		//선언은 stack에 배열을 주소를 보관할 수 있는 공간을 만드는 것.
//		int[] iarr;
//		char carr[];
//		
//		//할당
//		//new 타입[크기];
//		//new 연산자는 heap 영역에 공간을 할당하고 발생한 주소값을 반환하는 얀산자.
//		iarr = new int[3]; // 방 3칸짜리 배열이 만들어짐.
//		int size = 5;
//		iarr = new int[size]; // 공간을 할당할 때, 크기를 입력히지 않으면 에러 발생
//		//배열의 괄호 안에는 정수 값을 할당할 수 있다.
		
		//선언과 할당
		int[] iarr = new int[5];
		char carr[] = new char[10];
		
		System.out.println("iarr: " + iarr);
		System.out.println("carr: " + carr);
		
		System.out.println("iarr의 hashcode: " + iarr.hashCode());
		System.out.println("carr의 hashcode: " + carr.hashCode());  // 해시코드
		
		System.out.println("iarr의 길이: " + iarr.length);
		System.out.println("carr의 길이: " + carr.length);
		
		//
		double[] darr = new double[10];
		System.out.println("darr의 길이: " + darr.length);
		System.out.println("darr의 hashcode " + darr.hashCode());
		
		// 배열의 길이 변경, 배열의 길이는 한번 생성 후에는 변경 불가.
		darr = new double[30]; // 배열의 길이를 변경한 코드가 아닌, 새로운 배열을 할당하여 주소값을 덮어 씌운것.
		System.out.println("darr의 길이 : " + darr.length);
		System.out.println("darr의 hashcode " + darr.hashCode());
		
		
		// 배열 삭제.
		//우리가 작접 할당된 배열을 삭제 불가, 참조 관계를 끊어 줌으로써 더이상 참조당하지 않는 공간은 GC(Garbage Collector)가 삭제하게 한다.
		darr = null;
		
		System.out.println("삭제 후 darr의 길이: " + darr.length);
		// NullPointerException 오류 발생.
	}
	
	public void testArray3() {
		// 정수값을 저장하는 크기가 5인 배열
		int[] iarr = new int[5];
		
//		System.out.println(iarr[0]);
		
		for(int i=0; i<iarr.length; i++) {
			System.out.println(iarr[i]);
		}
		// 0 출력
		// heap 영역은 값이 없는 공간이 존재할 수 없다.
		// 배열을 선언하고 할당을 하면 지정된 값으로 초기화 진행
		
//		double[] darr;
//		String str;
//		int no;              // 이 변수들은 다 비어있다.
		// 스택과 힙의 차이?
		
		//힙은 정해져 있지 않은 크기의 데이터들이...
		
//		double[] darr = new double[5];
//		System.out.println(darr[0]);
//		char[] carr = new char[1];
//		System.out.println(carr[0]);
//		String[] sarr = new String[3];
//		System.out.println(sarr[0]);
		
		
		// 퀴즈
		// 기본값 외의 값으로 채워 넣으면서 배열을 생성하고 싶다.
		int[] iarr2 = {11,22,33,44,55};
		
		for(int i=0; i<iarr2.length; i++) {
			System.out.println("iarr2: " + iarr2[i]);
		}
		
		System.out.println(iarr2.length);
	}
}
