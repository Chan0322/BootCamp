package com.test01.recu;

public class HanoiTest {

	public static void main(String[] args) {
		hanoi(3, 1, 3);
		// 원판 3개를 1번 기둥에서 3번 기둥으로 이동
	}

	//no : 원판 갯수, x:시작기둥, y:목표기둥
	//no개의 원판을 x에서 y로 이동
	public static void hanoi(int no, int x, int y) {
		if(no>1) {
			hanoi(no-1, x, 6-x-y);
		}
		System.out.println("원판 " + no + "를 " + x + "기둥에서 " + y + "기둥으로 옮김");
		if(no>1) {
			hanoi(no-1, 6-x-y, y);
		}
	}
}
