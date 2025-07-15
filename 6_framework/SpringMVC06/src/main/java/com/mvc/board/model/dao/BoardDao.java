package com.mvc.board.model.dao;

import java.util.List;

import com.mvc.board.model.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int testno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int testno);
	
}
