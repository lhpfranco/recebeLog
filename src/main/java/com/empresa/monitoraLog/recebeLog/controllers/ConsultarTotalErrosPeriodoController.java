package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.TotalErrosPeriodo;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ConsultarTotalErrosPeriodoController {

	@Autowired
	private StackTraceRepository repository;
	public List<TotalErrosPeriodo> lista;

	// Exemplo de endereço:
	// http://localhost:8080/consultarTotalErrosPeriodo?startDate=2017-11-29&endDate=2017-11-30

	@RequestMapping(value = "/consultarTotalErrosPeriodo", produces = "application/json;charset=UTF-8")
	public List<TotalErrosPeriodo> stack(
			@PathParam(value = "startDate") String startDate,
			@PathParam(value = "endDate") String endDate) {

		try {
			this.lista = repository.findTotalErrosPeriodo(java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate));

			if (!lista.isEmpty())
				System.out.println("tamanho lista: " + lista.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
