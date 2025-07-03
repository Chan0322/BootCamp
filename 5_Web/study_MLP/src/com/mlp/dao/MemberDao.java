package com.mlp.dao;

import org.apache.ibatis.session.SqlSession;

import com.mlp.dto.MemberDto;

public class MemberDao extends SqlMapConfig {
	String namespace="com.mlp.member.";
	//선택
	public MemberDto selectOne(MemberDto dto) {
		SqlSession session = null;
		MemberDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"selectOne", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
}
