package com.test4.controller;

import java.util.Arrays;
import java.util.Comparator;

import com.test4.model.vo.Member;

public class MemberController {
	public static int SIZE = 10;
	private int memberCount;
	private Member[] mem = new Member[SIZE];
	
	// 초기화 블럭으로 기본 회원 5명 정보 초기화
    {
        mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
        mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
        mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
        mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
        mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
        memberCount = 5;
    }

	
	public int getMemberCount() {
		return memberCount;
	}
	
	public Member[] getMem() {
		return mem;
	}
	
	public Member checkId(String userId) {
		Member m = null;
		for(int i=0; i<memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				return mem[i];
			}
		}
		return null;
	}
	
	public void insertMember(Member m) {
		mem[memberCount] = m;
		memberCount++;
	}
	
	public Member searchMember(int menu, String search) {
		Member searchMember = null;
		for(int i=0; i<memberCount; i++) {
			if(menu == 1 && mem[i].getUserId().equals(search)) {
				return mem[i];
			}else if(menu==2 && mem[i].getName().equals(search)) {
				return mem[i];
			}else if(menu==3 && mem[i].getEmail().equals(search)) {
				return mem[i];
			}
		}
		return null;
	}
	
	public void updateMember(Member m, int menu, String update) {
		for(int i=0; i<memberCount; i++) {
			if(menu == 1) {
				m.setUserPwd(update);
			}else if(menu == 2) {
				m.setName(update);
			}else if(menu == 3) {
				m.setEmail(update);
			}
		}
	}
	
	public void deleteMember(String userId) {
		for(int i=0; i<memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				mem[i] = null;
				for(int j=i; j<memberCount-1; j++) {
					mem[j] = mem[j+1];
				}
				mem[memberCount-1] = null;
				memberCount--;
			}
		}
	}
	
	public Member[] sortIdAsc() {
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		// 한 배열에서 다른 배열로 요소를 복사.
		// arraycopy(원본 배열, 원본에서 복사 시작 인덱스, 대상 배열, 대상 배열의 저장 시작 인덱스, 복사할 요소 갯수)
		Arrays.sort(copy, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				return m1.getUserId().compareTo(m2.getUserId());
			}
			
		});
		return copy;
	}
	
	public Member[] sortIdDesc() {
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		// 한 배열에서 다른 배열로 요소를 복사.
		// arraycopy(원본 배열, 원본에서 복사 시작 인덱스, 대상 배열, 대상 배열의 저장 시작 인덱스, 복사할 요소 갯수)
		Arrays.sort(copy, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				return m2.getUserId().compareTo(m1.getUserId());
			}
			
		});
		return copy;
	}
	
	public Member[] sortAgeAsc() {
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		// 한 배열에서 다른 배열로 요소를 복사.
		// arraycopy(원본 배열, 원본에서 복사 시작 인덱스, 대상 배열, 대상 배열의 저장 시작 인덱스, 복사할 요소 갯수)
		Arrays.sort(copy, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				return Integer.compare(m1.getAge(), m2.getAge());
			}
			
		});
		return copy;
	}
	
	public Member[] sortAgeDesc() {
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		// 한 배열에서 다른 배열로 요소를 복사.
		// arraycopy(원본 배열, 원본에서 복사 시작 인덱스, 대상 배열, 대상 배열의 저장 시작 인덱스, 복사할 요소 갯수)
		Arrays.sort(copy, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				return Integer.compare(m2.getAge(), m1.getAge());
			}
			
		});
		return copy;
	}
	
	public Member[] sortGenderDesc() {
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		// 한 배열에서 다른 배열로 요소를 복사.
		// arraycopy(원본 배열, 원본에서 복사 시작 인덱스, 대상 배열, 대상 배열의 저장 시작 인덱스, 복사할 요소 갯수)
		Arrays.sort(copy, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				return Character.compare(m2.getGender(), m1.getGender());
				// M = 77 , F = 70
			}
			
		});
		return copy;
	}
	
	/////////////////////////////// 선택 정렬, 버블 정렬 공부하고 해보자.
//	public static Member[] sortIdAAsc() {
//		Member[] oA = new Member[10];
//		
//		Member[] tmp = new Member[10];    // 복사 배열이라 생각.
//		
//		for(int i=0; i<memberCount-1; i++) {
//			for(int j=i+1; j<memberCount; j++) {
//				int res = oA[i].getId().compareTo(oA[j]);
//				if(res==1) {
//					tmp[0] = oA[i];
//					oA[i] = oA[j];
//					oA[j] = tmp[0];
//				}
//			}
//		}
//		i==0
//		j== 1 ~ memCnt-1
//		
//		return null;
//	}
}
