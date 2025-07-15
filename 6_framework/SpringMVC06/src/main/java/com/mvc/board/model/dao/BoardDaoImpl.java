package com.mvc.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.board.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectAll() {
		List<BoardDto> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("board.selectAll");
			System.out.println(list.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int testno) {
		BoardDto res = null;
		
		try {
			res = sqlSession.selectOne("board.selectOne", testno);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insert(BoardDto dto) {
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		
		return 0;
	}

	@Override
	public int delete(int testno) {
		return 0;
	}

}
