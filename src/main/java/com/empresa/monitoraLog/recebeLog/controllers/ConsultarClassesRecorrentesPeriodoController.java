package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ConsultarClassesRecorrentesPeriodoController {

	@Autowired
	private StackTraceRepository repository;
	public List<StackTrace> lista;
	public Map<String, Long> map;

	// Exemplo de endereço:
	// http://localhost:8080/consultarClassesRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5

	@RequestMapping(value = "/consultarClassesRecorrentesPeriodo", produces = "application/json;charset=UTF-8")
	public List<StackTrace> stack(
			@PathParam(value = "appName") String appName,
			@PathParam(value = "startDate") String startDate,
			@PathParam(value = "endDate") String endDate,
			@PathParam(value = "limit") int limit) {

		try {
			Pageable pageLimit = new PageRequest(0, limit);
			this.lista = repository.findClassesMaisRecorrentesPeriodo(appName, java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate), pageLimit);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
