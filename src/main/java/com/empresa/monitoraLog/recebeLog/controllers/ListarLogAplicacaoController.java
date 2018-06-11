package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ListarLogAplicacaoController {

	@Autowired
	private StackTraceRepository repository;
	public List<StackTrace> lista;

	// Exemplo de endereço:
	// http://localhost:8080/listarLogAplicacao?appName=AP000100

	@RequestMapping(value = "/listarLogAplicacao", produces = "application/json;charset=UTF-8")
	public List<StackTrace> stack(@PathParam(value = "appName") String appName) {
		try {
			this.lista = repository.findByApplicationName(appName);

			if (!lista.isEmpty())
				System.out.println("tamanho lista: " + lista.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
