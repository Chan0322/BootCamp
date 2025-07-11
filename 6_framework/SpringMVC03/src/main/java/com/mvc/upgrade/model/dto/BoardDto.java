package com.mvc.upgrade.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 매개변수 없는 기본생성자, 필드 모두를 포함하는 생성자, @RequiredArgsConstructor: final 필드만 포함된 생성자, @Data: toString / equals / hashcode / getter / setter 모두 통합된 묶음
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
}
