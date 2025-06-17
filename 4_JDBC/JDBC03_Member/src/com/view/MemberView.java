package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MemberController;
import com.model.dto.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	public void menu() {
		int no = 0;
		
		while(no != 6) {
			System.out.println("----------------------");
			System.out.println("1. 전체출력");
			System.out.println("2. 선택출력");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("----------------------");
			System.out.print("번호 입력: ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				// 전체 출력
				System.out.println("***전체 출력***");
				List<Member> resSelAll = mc.selectAll();
				for(Member m : resSelAll) {
					System.out.println(m);
				}
				break;
			case 2:
				// 선택 출력
				System.out.println("***선택 출력***");
				System.out.print("번호 선택: ");
				int no1 = sc.nextInt();
				Member resSelOne = mc.selectOne(no1);
				
				if(resSelOne.getM_name() != null) {
					System.out.println(resSelOne);
				}else {
					System.out.println("일치하는 데이터가 없습니다.");
				}
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			}
		}
	}
}
