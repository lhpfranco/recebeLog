package com.empresa.monitoraLog.recebeLog.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;

public interface StackTraceRepository extends JpaRepository<StackTrace, Long>{

	List<StackTrace> findByApplicationName(@Param("name")String appReference);
	
	@Query("select u from StackTrace u where date between :startDate and :endDate")
	List<StackTrace> findByDate(@Param("startDate") Date startDate,
								@Param("endDate") Date endDate);

}