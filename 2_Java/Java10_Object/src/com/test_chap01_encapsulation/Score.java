package com.test_chap01_encapsulation;

public class Score {
	//필드
	private String name="이창진";
	private int kor=90;
	private int eng=84;
	private int math=97;
	
	//메소드
	//생성자
	public Score() {
		System.out.println("객체 생성");
		// 객체 생성시 출력 됨.
	}
	
	//1. 점수의 총합을 구해 출력하는 메소드
	public void sum() {
		int sum = kor + eng + math;
		System.out.println("점수의 총합: " + sum);
	}
	//2. 점수의 평균을 구해 출력하는 메소드
	public void avg() {
		int avg = (kor+eng+math)/3;
		System.out.println("점수의 평균: "+ avg);
	}
	//3. 평균을 확인하고 등급을 매기는 메소드
	// (평균 점수가 90이상 A, 70~89 B, 나머지 C)
	public void grade() {
		int avg = (kor+eng+math)/3;
		char grade = ' ';
		
		if(avg>=90) {
			grade = 'A';
		}else if(avg>=70) { // 90 이상은 이미 위에서 걸러짐.
			grade = 'B';
		}else {
			grade = 'C';
		}
		
		System.out.println("등급: " + grade);
	}
	//4. 필드 값을 확인할 수 있게 출력해 주는 메소드
	public void prn() {
		System.out.println(name+"님의 점수[국어-"+kor+", 영어-"+eng+", 수학-"+math+"]");
	}
}
