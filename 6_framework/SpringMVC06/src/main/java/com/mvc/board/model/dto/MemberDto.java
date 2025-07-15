package com.mvc.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
	private int memno;
	private String memid;
	private String mempw;
	private String memname;
}
