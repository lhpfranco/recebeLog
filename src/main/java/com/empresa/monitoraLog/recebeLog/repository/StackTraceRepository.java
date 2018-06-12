package com.empresa.monitoraLog.recebeLog.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.domain.TotalErrosPeriodo;

public interface StackTraceRepository extends JpaRepository<StackTrace, Long>{

	// TODO: COLOCAR ESSAS QUERYS NUM LUGAR DECENTE
	
	List<StackTrace> findByApplicationName(@Param("name")String appReference);
	
	@Query("select u from StackTrace u where date between :startDate and :endDate")
	List<StackTrace> findByDate(@Param("startDate") Date startDate,
								@Param("endDate") Date endDate);
	
	
	
	@Query("select new com.empresa.monitoraLog.recebeLog.domain.TotalErrosPeriodo(s.date, count(s)) " +
		       "from StackTrace s " +
		       "where date between :startDate and :endDate " +
		       "group by year(s.date), month(s.date), day(s.date) order by s.date")
	List<TotalErrosPeriodo> findTotalErrosPeriodo(@Param("startDate") Date startDate,
												  @Param("endDate") Date endDate);

}