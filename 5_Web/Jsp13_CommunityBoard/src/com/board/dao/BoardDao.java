package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig {
	String namespace="com.my.board.";
	
	// 게시글 전체 조회
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = new ArrayList<>();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectList(namespace+"selectAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	// 글 작성
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insert", dto);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
}
