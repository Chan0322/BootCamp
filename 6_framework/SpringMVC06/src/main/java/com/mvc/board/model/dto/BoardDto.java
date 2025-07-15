package com.mvc.board.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
	private int testno;
	private String testname;
	private String testtitle;
	private String testcontent;
	private Date testdate;
}
