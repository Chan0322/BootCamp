package com.boot.jpa.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	
	// 개발자가 jpql을 작성해 실행한다.
	@Modifying			//  수정하겠다는 선언
	@Query(" DELETE FROM JpaEntity j WHERE j.myno= :myno ")
	@Transactional
	public void delBoard(@Param("myno")int myno);	// 매개변수 값을 myno에다 넘겨주겠다는 param
	
	// queryDSL 이라는 것도 있음. 함수 기반. 쿼리문을 다 작성할 필요 없이 .selectFrom().where() 이런 식으로 ....
}
