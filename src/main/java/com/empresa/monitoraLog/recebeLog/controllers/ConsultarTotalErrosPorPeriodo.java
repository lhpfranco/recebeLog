package com.empresa.monitoraLog.recebeLog.controllers;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ConsultarTotalErrosPorPeriodo {

	@Autowired
	private StackTraceRepository repository;
	long total;

	// Exemplo de endereço:
	// http://localhost:8080/consultarTotalErrosPorPeriodo?appName=AP000100&startDate=2017-11-29&endDate=2017-11-30

	@RequestMapping(value = "/consultarTotalErrosPorPeriodo", produces = "application/json;charset=UTF-8")
	public long stack(
			@PathParam(value = "appName") String appName,
			@PathParam(value = "startDate") String startDate,
			@PathParam(value = "endDate") String endDate) {

		try {
			total = repository.findTotalErrosPorPeriodo(appName, java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
