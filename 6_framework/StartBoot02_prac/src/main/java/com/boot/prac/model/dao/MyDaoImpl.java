package com.boot.prac.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.prac.model.dto.MyDto;

@Repository
public class MyDaoImpl implements MyDao {

	@Override
	public List<MyDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyDto selectOne(int memno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int memno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
