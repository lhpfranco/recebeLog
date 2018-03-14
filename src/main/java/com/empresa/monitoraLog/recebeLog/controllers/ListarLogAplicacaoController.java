package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class ListarLogAplicacaoController{

	@Autowired
	private StackTraceRepository repository;
	
	public List<StackTrace> lista;
	

    @RequestMapping(value="/listarLogAplicacao", produces = "text/plain;charset=UTF-8")
    public List<StackTrace> stack() {
    	
    	try {

    		this.lista = repository.findByApplicationName("AP000100");
			
			if(!lista.isEmpty())
				System.out.println("tamanho lista: " + lista.size());
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        
        
        return lista;
    }
    
 
}
