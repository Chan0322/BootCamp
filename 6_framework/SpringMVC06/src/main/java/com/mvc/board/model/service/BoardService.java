package com.mvc.board.model.service;

import java.util.List;

import com.mvc.board.model.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int testno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int testno);
}
