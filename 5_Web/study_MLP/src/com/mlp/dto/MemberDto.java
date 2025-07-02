package com.mlp.dto;

public class MemberDto {
	private int memno;
	private String memgroup;
	private String memdepart;
	private String memname;
	private String memid;
	private String mempw;
	private String mememail;
	private String memphone;
	private String memenabled;
	
	public MemberDto() {}
	public MemberDto(int memno, String memgroup, String memdepart, String memname, String memid, String mempw,
			String mememail, String memphone, String memenabled) {
		super();
		this.memno = memno;
		this.memgroup = memgroup;
		this.memdepart = memdepart;
		this.memname = memname;
		this.memid = memid;
		this.mempw = mempw;
		this.mememail = mememail;
		this.memphone = memphone;
		this.memenabled = memenabled;
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
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	public String getMememail() {
		return mememail;
	}
	public void setMememail(String mememail) {
		this.mememail = mememail;
	}
	public String getMemphone() {
		return memphone;
	}
	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}
	public String getMemenabled() {
		return memenabled;
	}
	public void setMemenabled(String memenabled) {
		this.memenabled = memenabled;
	}
	
}
