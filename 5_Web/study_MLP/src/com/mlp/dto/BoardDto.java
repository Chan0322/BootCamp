package com.mlp.dto;

import java.util.Date;

public class BoardDto {
	private int feedno;
	private String feedtitle;
	private String feedcontent;
	private int memno;
	private String memgroup;
	private String memdepart;
	private String memname;
	private Date regdate;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int feedno, String feedtitle, String feedcontent, int memno, String memgroup, String memdepart,
			String memname, Date regdate) {
		super();
		this.feedno = feedno;
		this.feedtitle = feedtitle;
		this.feedcontent = feedcontent;
		this.memno = memno;
		this.memgroup = memgroup;
		this.memdepart = memdepart;
		this.memname = memname;
		this.regdate = regdate;
	}
	public int getFeedno() {
		return feedno;
	}
	public void setFeedno(int feedno) {
		this.feedno = feedno;
	}
	public String getFeedtitle() {
		return feedtitle;
	}
	public void setFeedtitle(String feedtitle) {
		this.feedtitle = feedtitle;
	}
	public String getFeedcontent() {
		return feedcontent;
	}
	public void setFeedcontent(String feedcontent) {
		this.feedcontent = feedcontent;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getMemgroup() {
		return memgroup;
	}
	public void setMemgroup(String memgroup) {
		this.memgroup = memgroup;
	}
	public String getMemdepart() {
		return memdepart;
	}
	public void setMemdepart(String memdepart) {
		this.memdepart = memdepart;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
