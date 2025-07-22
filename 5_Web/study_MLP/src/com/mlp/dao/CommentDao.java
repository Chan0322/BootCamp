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
		
		return res;
	}
	
	
}
