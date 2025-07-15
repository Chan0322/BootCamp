package com.mvc.board.model.service;

import com.mvc.board.model.dto.MemberDto;

public interface MemberService {
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);
}
