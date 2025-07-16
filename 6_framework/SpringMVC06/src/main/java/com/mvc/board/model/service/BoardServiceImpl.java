package com.mvc.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.board.model.dao.BoardDao;
import com.mvc.board.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public BoardDto selectOne(int testno) {
		return dao.selectOne(testno);
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
	public int delete(int testno) {
		return dao.delete(testno);
	}

}
