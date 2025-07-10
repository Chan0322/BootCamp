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
	
	public MemberDto selectOneByMemno(int memno) {
	    SqlSession session = null;
	    MemberDto res = null;
	    try {
	        session = getSqlSessionFactory().openSession(true);
	        res = session.selectOne(namespace + "selectOneByMemno", memno);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return res;
	}

	
	//수정
	public int update(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"update", dto);
			
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
	
	//아이디 중복 체크
	public String idChk(String memid) {
		SqlSession session = null;
		String res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(namespace+"idchk", memid);
		//System.out.println(res);
		session.close();
		return res;
	}
	
	// 회원가입
	public int insert(MemberDto dto) {
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
}
