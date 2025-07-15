package com.mlp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.BoardDto;

public class BoardDao extends SqlMapConfig{
	String namespace="com.mlp.board.";
	
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = new ArrayList<>();
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList(namespace+"selectAll");
		
		session.close();
		
		return res;
	}
	
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(false);
		res = session.insert(namespace+"insert", dto);
		
		if(res>0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		
		return res;
	}
	
	public BoardDto selectOne(int feedno) {
		SqlSession session = null;
		BoardDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(namespace+"selectOne", feedno);
		
		System.out.println(res.getFeedno());
		
		session.close();
		
		return res;
	}
}
