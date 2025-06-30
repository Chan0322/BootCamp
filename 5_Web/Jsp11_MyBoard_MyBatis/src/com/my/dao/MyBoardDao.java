package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig {
	
	// 전체 출력
	public List<MyBoardDto> selectAll(){
		// 준비
		List<MyBoardDto> res = new ArrayList<>();
		SqlSession session = null;
												// (true) => autoCommit
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList("com.my.myboard.selectAll");	// 리스트로 리턴받아 저장.
		
		session.close();
		
		return res;
	}
}
