package com.boot.prac.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRACMEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int memno;
	@Column(updatable = false)
	private String memid;
	@Column
	private String mempw;
	@Column
	private String memname;
	@Column
	private String mememail;
	@Column
	private String memphone;
}
