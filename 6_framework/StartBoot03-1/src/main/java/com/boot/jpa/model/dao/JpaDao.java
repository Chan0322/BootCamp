package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.model.entity.JpaEntity;

@Repository
public interface JpaDao extends JpaRepository<JpaEntity, Integer>{
	//findAll(), save(), findById(), delete()
	
	public List<JpaEntity> findAll();
	
	// 필드 이름을 기반으로 알아서 조회해옴!
	public JpaEntity findByMyno(int myno);
	
	//public JpaEntity save(JpaEntity dto);
	
	// 트랜잭션을 관리할 수 있도록 아래 어노테이션 필요. 이처럼 내가 추가한 메소드는 트랜잭션 어노테이션 필요.
	@Transactional
	public void deleteByMyno(int myno);
}
