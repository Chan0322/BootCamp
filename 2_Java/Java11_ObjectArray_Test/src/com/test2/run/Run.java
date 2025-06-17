package com.test2.run;

import java.util.Scanner;

import com.test2.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = 'y';
		
		Student[] arr = new Student[10];
		int cnt=0;
		
		while(ch=='y') {
			arr[cnt] = new Student();
			
			System.out.print("학년: ");
			arr[cnt].setGrade(sc.nextInt());
			System.out.print("반: ");
			arr[cnt].setClassroom(sc.nextInt());
			sc.nextLine();
			System.out.print("이름: ");
			arr[cnt].setName(sc.nextLine());
			System.out.print("국어: ");
			arr[cnt].setKor(sc.nextInt());
			System.out.print("영어: ");
			arr[cnt].setEng(sc.nextInt());
			System.out.print("수학: ");
			arr[cnt].setMath(sc.nextInt());
			cnt++;
			sc.nextLine();
			System.out.print("계속 추가하시겠습니까?");
			ch = sc.nextLine().charAt(0);
		}
		
		
		
		
		for(int i=0; i<cnt; i++) {
			int sum = 0;
			int avg = 0;
			
			sum += arr[i].getKor();
			sum += arr[i].getEng();
			sum += arr[i].getMath();
			
			avg = sum/3;
			
			System.out.println(arr[i].information()+avg);
		}
	}

}
