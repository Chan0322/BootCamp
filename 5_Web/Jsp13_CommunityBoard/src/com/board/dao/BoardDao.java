package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig {
	String namespace="com.my.board";
	
	// 게시글 전체 조회
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = new ArrayList<>();
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
}
