package com.board.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;

public class BoardDao {
	// 전체 조회
	public List<BoardDto> selectAll(){
		Connection con = getConnection();
		Statement stmt = null;	// 쿼리문을 실행하는 객체
		ResultSet rs = null;	// 결과값을 담을 객체  (ROW 하나)
		List<BoardDto> res = new ArrayList<>(); 	// 위에서 나온 ROW 하나하나의 결과값들을 모으기 위한 리스트
		
		String sql = " SELECT * FROM BOARD "
					+" ORDER BY SEQ DESC ";
		
		try {
			stmt = con.createStatement();
			System.out.println("03.query 준비" + sql); 		// 단순 진행과정 확인용
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				// 결과 값을 rs에 담고, 그 한줄 한줄을 리스트에 추가
				BoardDto tmp = new BoardDto();		// 결과 값을 Dto 객체에 담고,
				tmp.setSeq(rs.getInt(1));
				tmp.setWriter(rs.getString(2));
				tmp.setTitle(rs.getString("TITLE"));
				tmp.setContent(rs.getString(4));
				tmp.setRegdate(rs.getDate(5));
				
				res.add(tmp);			// 리스트에 저장.
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05.db 종료");
		}
		return res;
	}
	
	// 선택 조회
	public BoardDto selectOne(int seq) {
		return null;
	}
	
	// 글 추가
	public int insert(BoardDto dto) {
		return 0;
	}
	
	// 글 수정
	public int update(BoardDto dto) {
		return 0;
	}
	
	// 글 삭제
	public int delete(int seq) {
		return 0;
	}
}
