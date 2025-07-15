package com.mvc.board.model.dao;

import com.mvc.board.model.dto.MemberDto;

public interface MemberDao {
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
}
