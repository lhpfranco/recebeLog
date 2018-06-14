package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.ErrosRecorrentesPeriodo;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ConsultarErrosRecorrentesPeriodoController {

	@Autowired
	private StackTraceRepository repository;
	public List<ErrosRecorrentesPeriodo> lista;

	// Exemplo de endereço:
	// http://localhost:8080/consultarErrosRecorrentesPeriodo?appName=AP000100&startDate=2017-11-28&endDate=2017-11-30&limit=5

	@RequestMapping(value = "/consultarErrosRecorrentesPeriodo", produces = "application/json;charset=UTF-8")
	public List<ErrosRecorrentesPeriodo> stack(
			@PathParam(value = "appName") String appName,
			@PathParam(value = "startDate") String startDate,
			@PathParam(value = "endDate") String endDate,
			@PathParam(value = "quantidade") int limit) {

		try {
			this.lista = repository.findErrosMaisRecorrentesPeriodo(appName, java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate));
			this.lista = limit<=this.lista.size()?this.lista.subList(0, limit):lista;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
