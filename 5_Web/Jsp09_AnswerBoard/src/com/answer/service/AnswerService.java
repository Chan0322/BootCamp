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
}
