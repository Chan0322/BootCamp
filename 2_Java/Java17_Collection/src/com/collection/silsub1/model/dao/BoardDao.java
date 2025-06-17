package com.collection.silsub1.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.collection.silsub1.model.vo.Board;

//dao(Data Access Object) // 제이터에 접근하는 친구
public class BoardDao {
	private  ArrayList<Board> list = new ArrayList<Board>();
	
	public BoardDao() {
		// 객체 생성 시 board.txt로부터 저장된 데이터 입력 받기.
		// 그렇게 input 받은 데이터를 list에 추가.
		try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("board.txt"))) {
			
			while(true) {
				list.add( (Board)(oi.readObject()) );
			}
			//종료되는 조건이 없는 while 이기에
			//End of File 까지 반복.
			
		}catch(EOFException e) {
			System.out.println("[실행 준비 완료]");
			return;
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}
	
	// list에 저장된 게시글 중 마지막 게시글의 번호를 리턴
	public int getLastNo() {
//		if(list.isEmpty()) {
//			return 0;
//		}else {
//			return list.get(list.size()-1).getBoardNo();
//		}
		return list.get(list.size()-1).getBoardNo(); // 리스트에 아무것도 들어있지 않은 경우 -1로 예외 발생.
	}
	
	// 게시글 저장
	public void write(Board board) {
		list.add(board);
	}
	
	//게시글 전체 확인
	public ArrayList<Board> displayAll() {
		return list;
	}
	
	//파일에 list 저장
	public void saveList() {
		//ObjectOutputStream     객체단위로 저장하기 위해서.
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("board.txt"))) {
			//출력, write
			for(int i=0; i<list.size(); i++) {
				//board 객체 하나씩 board.txt에 출력
				os.writeObject(list.get(i));
			}
			System.out.println("[board.txt에 저장 완료]");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//게시글 한 개 보기.
	public Board displayOne(int no) {
		//매개변수로 넘어온 게시글 번호와
		//일치하는 게시글 찾기.
		
//		for(int i=0; i<list.size(); i++) {
//			int boardN = list.get(i).getBoardNo();
//			if(no == boardN) {
//				System.out.println(list.get(i));
//			}
//		}
//		return null;
		
		Board board = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				board = list.get(i);
				break;
			}
		}
		return board;
	}
	
	public void updateTitle(int no, String title) {
		//매개변수로 넘어오는
		//no와 일치하는 게시글의 제목을 title로 변경
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.get(i).setBoardTitle(title);
				break;
			}
		}
	}
	
	public void updateContent(int no, String content) {
		//매개변수로 넘겨 받은 값을 이용해
		// no와 일치하는 Board 객체를 찾아 content를 수행
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.get(i).setBoardContent(content);
				break;
			}
		}
	}
	
	public void delete(int no) {
		//매개변수로 받은 no와 일치하는 board 객체 삭제
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Board> search(String title){
		//검색 결과가 다중일 수도 있으니 리스트에 담아 리턴.
		ArrayList<Board> res = new ArrayList<>();
		
		//탐색
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardTitle().contains(title)) {	// 입력된 내용이 포함되어 있으면
				res.add(list.get(i));
			}
		}
		
		return res;
	}
}
