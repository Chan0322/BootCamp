package com.boot.jpa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// 엔티티의 이름과 테이블이 이름이 같다면 상관 없지만, 다르다면 테이블 이름을 명시해 매핑 필요.
@Entity
@Table(name="MYBOARD")
public class JpaEntity {
// 테이블과 매핑할 엔티티 클래스.
	
	// MYBOARD의 컬럼과 매핑
	// Id => Primary Key 명시.
	// GeneratedValue(strategy=GenerationType.AUTO) => id 생성 전략. 자동으로 증가되는 키를 이용해 pk로 삽입.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int myno;
	
	//updatable = false => 한 번 저장되면 수정 불가하도록 설정.  nullable=false => not null
	@Column(updatable = false, nullable=false)
	private String myname;
	@Column
	private String mytitle;
	@Column(name="MYCONTENT")
	private String mycontent;
	
	//Temporal(TemporalType.DATE) => 날짜 값을 어떤 식으로 저장할지... DATE => 날짜 정보만. TIME => 시간 정보만.  TIMESTAMP => 날짜 시간 모두 저장하겠다.
	@Column(updatable = false)
	@Temporal(TemporalType.DATE)
	private Date mydate;
	
	public JpaEntity() {
		super();
	}
	public JpaEntity(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
}
