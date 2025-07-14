package com.mvc.upgrade.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	//Transactional : 해당 메소드 내에서 트랜잭션 관리가 가능해짐. 모두 성공해야 문제없이 끝이 나고(커밋), 하나라도 실패하면 불가하게(롤백)
	@Override
	@Transactional
	public String test() {
		dao.insert(new BoardDto(0, "tran2", "test2", "insert2", null));
		String str = dao.test();
		
		// null.length() ==> insert 후 문제 발생
		//str.length();
		
		return null;
	}

}
