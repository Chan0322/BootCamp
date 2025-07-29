package com.mlp.dto;

import java.util.Date;

public class CommentDto {
	private int commentno;
	private int feedno;
	private String writer;
	private String content;
	private Date regdate;

	// 대댓글
	private Integer parentcommentno; // null인 경우에는 일반 댓글임

	public CommentDto() {
	}

	public CommentDto(int commentno, int feedno, String writer, String content, Date regdate) {
		super();
		this.commentno = commentno;
		this.feedno = feedno;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public Integer getParentcommentno() {
		return parentcommentno;
	}

	public void setParentcommentno(Integer parentcommentno) {
		this.parentcommentno = parentcommentno;
	}

	public int getCommentno() {
		return commentno;
	}

	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}

	public int getFeedno() {
		return feedno;
	}

	public void setFeedno(int feedno) {
		this.feedno = feedno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
