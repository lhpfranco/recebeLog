package com.empresa.monitoraLog.recebeLog.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.monitoraLog.recebeLog.domain.ClassesRecorrentesPeriodo;
import com.empresa.monitoraLog.recebeLog.domain.ErrosRecorrentesPeriodo;
import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.domain.TotalErrosPeriodo;

public interface StackTraceRepository extends JpaRepository<StackTrace, Long>{

	// TODO: COLOCAR ESSAS QUERYS NUM LUGAR DECENTE
	
	List<StackTrace> findByApplicationName(@Param("name")String appReference);
	
	@Query("select s from StackTrace s where s.applicationName = :appName and s.date between :startDate and :endDate")
	List<StackTrace> findByDate(
			@Param("appName") String appName,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	
	@Query("select count(s) from StackTrace s where date between :startDate and :endDate and s.applicationName = :appName")
	Long findTotalErrosPorPeriodo(
			@Param("appName") String appName,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	
	
	
	@Query("select new com.empresa.monitoraLog.recebeLog.domain.TotalErrosPeriodo(s.date, count(s)) " +
		       "from StackTrace s " +
		       "where date between :startDate and :endDate " +
		       "and s.applicationName = :appName "+
		       "group by year(s.date), month(s.date), day(s.date) order by s.date desc")
	List<TotalErrosPeriodo> findTotalErrosPorDia(
			@Param("appName") String appName,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	
	
	
	@Query("select new com.empresa.monitoraLog.recebeLog.domain.ErrosRecorrentesPeriodo(s.exceptionType, count(s)) " +
		       "from StackTrace s " +
		       "where date between :startDate and :endDate " +
		       "and s.applicationName = :appName "+
		       "group by s.exceptionType order by count(s) desc")
	List<ErrosRecorrentesPeriodo> findErrosMaisRecorrentesPeriodo(
			@Param("appName") String appName,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			Pageable pageable);
	
	
	
	@Query("select new com.empresa.monitoraLog.recebeLog.domain.ClassesRecorrentesPeriodo(s.exceptionClass, count(s)) " +
		       "from StackTrace s " +
		       "where date between :startDate and :endDate " +
		       "and s.applicationName = :appName "+
		       "group by s.exceptionClass order by count(s) desc")
	List<ClassesRecorrentesPeriodo> findClassesMaisRecorrentesPeriodo(
			@Param("appName") String appName,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			Pageable pageable);
	

}