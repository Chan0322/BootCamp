package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig {
	
	//list
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.board.selectAll");
		
		session.close();
		
		return res;
	}
	
	//
	public BoardDto selectOne(int seq) {
		SqlSession session = null;
		BoardDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne("com.my.board.selectOne", seq);
		
		session.close();
		
		return res;
	}
	
	//update
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(false);
		res = session.update("com.my.board.update", dto);
		
		if(res>0) {
			session.commit();
		}
		
		session.close();

		return res;
	}
}
