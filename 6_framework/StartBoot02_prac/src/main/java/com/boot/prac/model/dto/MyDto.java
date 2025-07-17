package com.boot.prac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyDto {
	private int memberno;
	private String memberid;
	private String memberpw;
	private String membername;
}
