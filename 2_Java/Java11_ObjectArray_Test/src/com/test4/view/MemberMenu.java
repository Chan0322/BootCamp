package com.test4.view;

import java.util.Scanner;

import com.test4.controller.MemberController;
import com.test4.model.vo.Member;

public class MemberMenu {
	private MemberController mc;
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("====== 회원 관리 메뉴 ======");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("9. 프로그램 종료");
			
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAllMember();
				break;
			case 6:
				sortMember();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			}
		}
	}
	
	public void insertMember() {
		sc.nextLine();
		mc = new MemberController();
		if(mc.getMemberCount() >= mc.SIZE) {
			return;
		}else {
			System.out.print("아이디: ");
			String userId = sc.nextLine();
			if(mc.checkId(userId) != null) {
				System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
				return;
			}else {
				System.out.print("비밀번호: ");
				String userPwd = sc.nextLine();
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("나이: ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.print("성별: ");
				char gender = sc.nextLine().charAt(0);
				System.out.print("이메일: ");
				String email = sc.nextLine();
				
				Member m = new Member(userId, userPwd, name, age, gender, email);
				mc.insertMember(m);
				System.out.println("성공적으로 회원이 등록되었습니다.");
			}
			
		}
	}
	
	public void searchMember() {
		while(true) {
			System.out.println("====== 회원 정보 검색 ======");
			System.out.print("1. 아이디로 검색하기");
			System.out.print("2. 이름으로 검색하기");
			System.out.print("3. 이메일로 검색하기");
			System.out.print("9. 이전 메뉴로");
			System.out.println();
			System.out.println("메뉴 선택: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			Member res = null;
			
			switch(menu) {
			case 1:
				System.out.print("검색 내용: ");
				String search = sc.nextLine();
				res = mc.searchMember(menu, search);
				break;
			case 2:
				System.out.print("검색 내용: ");
				search = sc.nextLine();
				res = mc.searchMember(menu, search);
				break;
			case 3:
				System.out.print("검색 내용: ");
				search = sc.nextLine();
				res = mc.searchMember(menu, search);
				break;
			case 9:
				return;
			}
			
			if(res == null) {
				System.out.println("검색된 결과가 없습니다.");
			}else {
				System.out.println(res.information());
			}
		}
	}
	
	public void updateMember() {
		while(true) {
			System.out.println("====== 회원 정보 수정 ======");
			System.out.print("1. 비밀번호 수정");
			System.out.print("2. 이름 수정");
			System.out.print("3. 이메일 수정");
			System.out.print("9. 이전 메뉴로");
			System.out.println();
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();
			sc.nextLine();
			System.out.print("변경할 회원 아이디: ");
			String userId = sc.nextLine();
			if(menu == 9 ) {
				return;
			}
			Member m = mc.checkId(userId);
			if(m == null) {
				System.out.println("변경할 회원이 존재하지 않습니다.");
				return;
			}else {
				System.out.println("기존 정보: " + m.information());
				String update;
				
				switch(menu) {
				case 1:
					update = sc.nextLine();
					mc.updateMember(m, menu, update);
					break;
				case 2:
					update = sc.nextLine();
					mc.updateMember(m, menu, update);
					break;
				case 3:
					update = sc.nextLine();
					mc.updateMember(m, menu, update);
					break;
				}
				
				System.out.println("회원 정보가 변경되었습니다.");
			}
			
		}
	}
	
	public void deleteMember() {
		sc.nextLine();
		System.out.print("삭제할 회원 아이디: ");
		String userId = sc.nextLine();
		
		Member m = mc.checkId(userId);
		if(m == null) {
			System.out.println("삭제할 회원이 존재하지 않습니다.");
			return;
		}else {
			System.out.print("정말 삭제? (y/n): ");
			char ch = sc.nextLine().charAt(0);
			if(Character.toUpperCase(ch) == 'Y') {
				mc.deleteMember(userId);
				System.out.println("회원의 정보가 삭제되었습니다.");
			}else {
				return;
			}
		}
	}
	
	public void printAllMember() {
		Member[] mem = mc.getMem();
		for(int i=0; i<mc.getMemberCount(); i++) {
			System.out.println(mem[i].information());
		}
	}
	
	public void sortMember() {
		Member[] sortMem = null;
		
		while(true) {
			System.out.println("====== 회원 정보 정렬 ======");
			System.out.print("1. 아이디 오름차순 정렬");
			System.out.print("2. 아이디 내림차순 정렬");
			System.out.print("3. 나이 오름차순 정렬");
			System.out.print("4. 나이 내림차순 정렬");
			System.out.print("5. 성별 내림차순 정렬");
			System.out.print("9. 이전 메뉴로");
			
			System.out.println();
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 9) {
				return;
			}
			switch(menu) {
			case 1:
				sortMem = mc.sortIdAsc();
				break;
			case 2:
				sortMem = mc.sortIdDesc();
				break;
			case 3:
				sortMem = mc.sortAgeAsc();
				break;
			case 4:
				sortMem = mc.sortAgeDesc();
				break;
			case 5:
				sortMem = mc.sortGenderDesc();
				break;
			default:
				System.out.print("다시 입력: ");
				continue;
			}
			if(sortMem != null) {
				for(int i=0; i<mc.getMemberCount(); i++) {
					System.out.println(sortMem[i].information());
				}
			}
		}
	}
}
