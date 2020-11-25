package com.gestion.banque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.banque.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	// consulter page par page (pagination) 
	// trié par la date
	@Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param("x")String codeCompte,Pageable pageable);
}
