package com.boot.prac.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.prac.model.dto.MyDto;

@Mapper
public interface MyMapper {

	@Select(" SELECT * FROM MYMEMBER ORDER BY MEMBERNO ")
	List<MyDto> selectList();
}
