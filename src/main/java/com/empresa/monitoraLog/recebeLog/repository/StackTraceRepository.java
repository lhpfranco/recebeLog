package com.empresa.monitoraLog.recebeLog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;


public interface StackTraceRepository extends CrudRepository<StackTrace, Long>{

	List<StackTrace> findByApplicationName(@Param("name")String appReference);
	
}