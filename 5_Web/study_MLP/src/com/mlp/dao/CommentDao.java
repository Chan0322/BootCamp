package com.mlp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.CommentDto;

public class CommentDao extends SqlMapConfig {
	String namespace = "com.mlp.comment.";
	
	public List<CommentDto> selectFeedCommentAll(int feedno){
		SqlSession session = null;
		List<CommentDto> list = null;
		
		session = getSqlSessionFactory().openSession(true);
		list = session.selectList(namespace+"selectFeedCommentAll", feedno);
		
		session.close();
		
		return list;
	}
	
	public int insert(CommentDto dto) {
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
	
	public int delete(int commentno) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(false);
		res = session.delete(namespace+"delete", commentno);
		
		if(res>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return res;
	}
	
	public CommentDto selectOne(int commentno) {
		SqlSession session = null;
		CommentDto res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(namespace+"select", commentno);
		
		session.close();
		
		return res;
	}
	
	public int update(CommentDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSqlSessionFactory().openSession(false);
		res = session.update(namespace+"update", dto);
		
		if(res>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return res;
	}
}
