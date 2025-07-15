package com.mvc.rest.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.rest.model.dto.RestDto;

@Repository
public class RestDaoImpl implements RestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<RestDto> rowMapper = (rs, rowNum)->{
		// ResultSet에서 하나씩 꺼내온다.
		return new RestDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	};
	
	// 위 람다식이 싫으면 아래처럼 익명 클래스를 만들어 사용
	/*
	RowMapper<RestDto> rowMap = new RowMapper<RestDto>() {
		public RestDto mapRow(ResultSet rs, int rowNum) {
			return new RestDto();
		}
	};
	*/
	
	@Override
	public List<RestDto> selectList() {
		List<RestDto> res = new ArrayList<RestDto>();
		String sql = " SELECT * FROM RESTBOARD ";
		res = jdbcTemplate.query(sql, rowMapper);
		return res;
	}

	@Override
	public RestDto selectOne(int restno) {
		String sql = " SELECT * FROM RESTBOARD WHERE RESTNO=? ";
		RestDto res = jdbcTemplate.queryForObject(sql, rowMapper, restno);
		return res;
	}

	@Override
	public int insert(RestDto dto) {
		String sql = " INSERT INTO RESTBOARD VALUES(SEQ_REST.NEXTVAL, ?, ?, ?) ";
		int res = jdbcTemplate.update(sql, dto.getRestid(), dto.getRestpw(), dto.getRestname());
		return res;
	}

	@Override
	public int update(RestDto dto) {
		String sql = " UPDATE RESTBOARD SET RESTPW=? WHERE RESTNO=? ";
		int res = jdbcTemplate.update(sql, dto.getRestpw(), dto.getRestno());
		return res;
	}

	@Override
	public int delete(int restno) {
		String sql = " DELETE FROM RESTBOARD WHERE RESTNO=? ";
		int res = jdbcTemplate.update(sql, restno);
		return res;
	}

}
