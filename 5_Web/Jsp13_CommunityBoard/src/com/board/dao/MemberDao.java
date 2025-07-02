package com.board.dao;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.MemberDto;

public class MemberDao extends SqlMapConfig{
	String namespace = "com.my.member.";
	
	//아이디 중복 체크
	public String idChk(String id) {
		SqlSession session = null;
		String res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(namespace+"idchk", id);
		//System.out.println(res);
		session.close();

		return res;
	}
	
	//회원가입
	public int insertMem(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace+"insertmem", dto);
			
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	// 로그인
	public MemberDto login(MemberDto dto) {
		SqlSession session = null;
		MemberDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"loginmem", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//회원 정보
	public MemberDto selectMember(int no) {
		SqlSession session = null;
		MemberDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace+"selectmem", no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	
	//회원 탈퇴
	// enable 값만 변경하여 임시 탈퇴 처리
	public int deleteMember(int no) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace+"deletemem", no);
			
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
