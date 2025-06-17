package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.collection.silsub1.model.comparator.AscBoardNo;
import com.collection.silsub1.model.comparator.DescBoardNo;
import com.collection.silsub1.model.dao.BoardDao;
import com.collection.silsub1.model.vo.Board;

public class BoardController {
	private BoardDao bd = new BoardDao();
	private Scanner sc = new Scanner(System.in);
	
	public void write() {
		//게시글 작성 및 추가
		System.out.println("[새 게시글 쓰기]");
		
		System.out.print("글제목: ");
		String title = sc.nextLine();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		
		//여러 줄 입력 받기
		System.out.print("내용(exit 입력 시 종료): ");
		String content = "";
		String str = "";
		
		while(true) {
			str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			content += str;
		}
		
		//첫 게시글을 작성할 때 예외 발생.
		//그렇지 않으면 예외 발생X
		try {
			Board b = new Board(bd.getLastNo()+1, title, writer, new Date(), content);
			bd.write(b);
		}catch(IndexOutOfBoundsException e) {
			// 해당 예외가 발생하는 경우는
			// list에 객체가 하나도 없을 경우 발생한다.
			Board b = new Board(1, title, writer, new Date(), content);
			bd.write(b);
		}
		
	}
	
	
	public void displayAll() {
		List<Board> list = bd.displayAll(); // 제네릭을 설정하지 않으면, Object 타입으로 인식하여 사용 시 형변환 필요.
		
		for (int i=0; i<list.size(); i++)	{
			System.out.println(list.get(i));
		}
	}
	
	public void saveList() {
		bd.saveList();
	}
	
	public void displayOne() {
		//게시글 번호 입력받아
		//해당 게시글출력
		System.out.print("조회할 글 번호: ");
		int no = sc.nextInt();
		
//		bd.displayOne(no);
		/////////////////////////////////////////////
		Board board = bd.displayOne(no);
		if(board == null) {//아무것도 들어있지 않을 때(if문이 실행되지 않았을 때, 일치하는 번호가 없을 때)
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.println(board);
		}
	}
	
	public void updateTitle() {
		// 수정하려는 게시글 번호를 입력 받는다.
		System.out.print("수정할 게시글 번호: ");
		int no = sc.nextInt();
		sc.nextLine(); // nextInt 다음에 nextLine을 입력 받기 위해 nextInt에서 남아 있던 부분을 밀어버림.
		
		Board board = bd.displayOne(no);  // 이 안에는 displayOne을 통해 가져온 객체가 존재한다. 없으면 null;
		if(board==null) {
			System.out.println("수정하려는 글이 없습니다.");
		}else {
			// 수정하려는 제목을 입력 받는다.
			System.out.print("변경할 제목: ");
			String title = sc.nextLine();
			
			// 수정 작업 진행한다.
			bd.updateTitle(no, title);
		}
	}
	
	public void updateContent() {
		// 수정할 게시글 번호를 입력 받는다.
		System.out.print("수정할 글 번호: ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Board board = bd.displayOne(no);
		if(board==null) {
			System.out.println("수정하려는 글이 없습니다.");
		}else {
			// 수정 하려는 내용 입력 받는다.
			System.out.println("변경할 내용 입력: ");
			String content = sc.nextLine();
			
			// 수정 작업 진행한다.
			bd.updateContent(no, content);
		}	
	}
	
	public void delete() {
		//삭제할 게시글 번호 입력
		System.out.print("삭제할 게시글 번호: ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Board board = bd.displayOne(no);
		if(board==null) {
			System.out.println("삭제할 글이 없습니다.");
		}else {
			System.out.println("정말로 삭제하시겠습니까?(y/n): ");
			/*char ch = sc.nextLine().charAt(0);
			if(ch=='y' || ch=='Y') {
				//삭제
			}*/
			char ch = sc.nextLine().toUpperCase().charAt(0);
			if(ch=='Y') {
				bd.delete(no);
				System.out.println(no+"번 게시글 삭제 완료");
			}
		}
	}
	
	public void search() {
		// 검색할 게시글의 제목 입력
		System.out.print("검색할 제목: ");
		String title = sc.nextLine();
		
		//검색
		ArrayList<Board> res = bd.search(title);
		
		if(res.isEmpty()) {
			//찾는게 없으면
			System.out.println("결과가 없습니다.");
		}else {
			//검색 결과 출력
			for(Board b : res) {
				System.out.println(b);
			}
		}
	}
	
	public void sortList(int field, boolean isAsc) {
		//매개변수
		//정수값 : 어떤 필드를 정렬할지
		//논리값 : true -> 오름차순, false -> 내림차순
	
		
		//field == 1 -> boardno
		//field == 2 -> boardtitle
//		/field == 3 -> boarddate
		ArrayList<Board> list = bd.displayAll();
		
		switch(field) {
		case 1:
			// field == 1 -> boardno를 정렬하겠다.
			if(isAsc) {
				//true일 때
				//오름차순 하겠다
				list.sort(new AscBoardNo());
			}else {
				//내림차순 하겠다.
				list.sort(new DescBoardNo());
			}
			break;	
		}
		for(Board b : list) {
			System.out.println(b);
		}
		
	}
}
