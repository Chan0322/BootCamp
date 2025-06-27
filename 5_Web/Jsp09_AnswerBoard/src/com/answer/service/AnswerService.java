package com.answer.service;

import java.sql.Connection;
import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

import static common.JDBCTemplate.*;

public class AnswerService {
	private AnswerDao dao = new AnswerDao();
	
	public List<AnswerDto> selectAll(){
		Connection con = getConnection();
		
		List<AnswerDto> res = dao.selectAll(con);
		
		close(con);
		System.out.println("05. db 종료");
		
		return res;
	}
	
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		
		int res = dao.insert(con, dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료\n");
		return res;
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		
		AnswerDto res = dao.selectOne(con, boardno);
		
		close(con);
		System.out.println("05. db 종료\n");
		return res;
	}
	
	public int update(AnswerDto dto) {
		Connection con = getConnection();
		
		int res = dao.update(con, dto);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료\n");
		
		return res;
	}
	
	public boolean answerInsert(int parentboardno, AnswerDto dto) {
		Connection con = getConnection();
		
		AnswerDto parent = dao.selectOne(con, parentboardno);
		int parentgroupno = parent.getGroupno();
		int parentgroupsq = parent.getGroupsq();
		int parenttitletab = parent.getTitletab();
		
		// update
		
		// 업데이트 전 업데이트 될 글이 몇개인지 확인
		int cnt = dao.countUpdate(con, parentgroupno, parentgroupsq);
		
		int uRes = dao.updateAnswer(con, parentgroupno, parentgroupsq);
		
		// insert
		dto.setGroupno(parentgroupno);
		dto.setGroupsq(parentgroupsq);
		dto.setTitletab(parenttitletab);
		
		int iRes = dao.insertAnswer(con, dto);
		
		if(uRes==cnt && iRes==1) {
			System.out.println("결과1: "+uRes);
			System.out.println("결과2: "+iRes);
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		System.out.println("05. db 종료 \n");
		
		return (uRes==cnt && iRes==1);
	}
}
