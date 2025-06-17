package com.test01;

public class ArrayTest03 {
	
	public  void prn(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void shallowCopy() {
		// 얕은 복사
		// 주소만 복사한다.
		int[] oArr = {1,2,3,4,5};
		int[] cArr = oArr; // index 번호를 입력하지 않으면 주소값을 저장시킨 것임.
		
		System.out.println("oArr");
		prn(oArr);
		System.out.println("cArr");
		prn(cArr);
		
		//원본 배열에 값 변경
		oArr[0] = 99;
		
		System.out.println("oArr 변경 후");
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
		// 둘 다 같은 배열을 참조 하므로 해시코드가 동일.
	}
	
	public void deepCopy1() {
		//깊은 복사 - 동일한 새로운 배열 하나 생성하고 값만 복사해 오는 것.
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[5];
		
		//for문을 이용하여 값을 1:1로 복사
		for(int i=0; i<oArr.length;	i++) {
			cArr[i] = oArr[i];
		}
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);
		
		
		//
		oArr[0] = 99;
		
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);     // cArr은 새로 만든 배열이므로 같은 주소가 아닌 다른 배열을 가리킨다.
		
		System.out.println(oArr.hashCode());
		System.out.println(cArr.hashCode()); // 두 배열은 다른 배열임.
	}

	public void deepCopy2() {
		//arrayCopy()
		//System에 있는 arraycopy() 활용
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[10];
		
		//arraycopy(src, srcPos, de, dePos, length);
		// src: 원본배열 srcPos: 복사 시작 위치
		// de: 카피배열  dePos : 붙여넣기 시작 위치
		//length : 복사될 길이.
		System.arraycopy(oArr, 1, cArr, 3, 3);
		// 마지막 매개 변수가 복사가 될 길이.
		// 네 번째 매개 변수는 붙여녛기가 시작 될 인덱스 번호 위치.
		// 2번째 매개 변수는 원본의 복사를 시작할 위치.
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);     // cArr은 새로 만든 배열이므로 같은 주소가 아닌 다른 배열을 가리킨다.
		
		System.out.println(oArr.hashCode());
		System.out.println(cArr.hashCode()); // 두 배열은 다른 배열임.
	}

	public void deepCopy3() {
		//clone() 이용한 복사
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[10];
		System.out.println(cArr.hashCode());
		
		//원본 배열을 통째로 복사하여 새로운 배열을 할당한다.
		cArr = oArr.clone();
		// clone은 동일하게 생긴 복제품을 복제한다. (배열의 크기 등...) 
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);     // cArr은 새로 만든 배열이므로 같은 주소가 아닌 다른 배열을 가리킨다.
		
		System.out.println(oArr.hashCode());
		System.out.println(cArr.hashCode()); // clone 이후에 해시코드가 바뀜.
	}
}
