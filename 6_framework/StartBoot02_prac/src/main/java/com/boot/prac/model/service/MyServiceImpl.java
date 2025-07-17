package com.boot.prac.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.prac.model.dto.MyDto;
import com.boot.prac.model.mapper.MyMapper;

@Service
public class MyServiceImpl implements MyService {

	// dao 안가고 매퍼를 다오로 사용.
	@Autowired
	private MyMapper mapper;
	
	@Override
	public List<MyDto> selectList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
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
