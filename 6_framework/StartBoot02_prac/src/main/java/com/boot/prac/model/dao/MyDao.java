package com.boot.prac.model.dao;

import java.util.List;

import com.boot.prac.model.dto.MyDto;

public interface MyDao {
	public List<MyDto> selectList();
	public MyDto selectOne(int memno);
	public int insert(MyDto dto);
	public int update(MyDto dto);
	public int delete(int memno);
}
