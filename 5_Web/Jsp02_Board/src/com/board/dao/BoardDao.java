package com.board.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardDto res = new BoardDto();
		
		String sql = " SELECT * FROM BOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비: " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			
			while(rs.next()) {
				// 한 개만 출력하므로 if도 가능!
				res.setSeq(rs.getInt(1));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		return res;
	}
	
	// 글 추가
	public int insert(BoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2,  dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. query 준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료");
		}
		return res;
	}
	
	// 글 수정
	public int update(BoardDto dto) {
		String sql = " UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03.query 준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.quert 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		return res;
	}
	
	// 글 삭제
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM BOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	// 다중 삭제
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int[] cnt = null;
		
		String sql = " DELETE FROM BOARD WHERE SEQ=? ";
		
		// 쿼리문을 작성 하고 모아두고 일괄로 실행한다.
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i=0; i<seq.length; i++) {
				pstm.setString(1, seq[i]);
				pstm.addBatch();   // 완성된 쿼리문을 메모리에 모아둔다. 
				System.out.println("03.query 준비: " + sql + "(삭제할 번호: " + seq[i] + ")");
			}
			
			cnt = pstm.executeBatch();	// 모아둔 쿼리문을 하나씩 실행
			System.out.println("04.query 실행 및 리턴");
			
			// 성공하면 각 방마다 1 저장(seq는 pk이기 때문에)
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i] == 1) {
					res++;
				}
			}
			
			if(seq.length == res) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		
		return res;
	}
}
