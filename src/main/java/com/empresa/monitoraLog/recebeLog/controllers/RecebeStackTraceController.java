package com.empresa.monitoraLog.recebeLog.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class RecebeStackTraceController{

	@Autowired
	private StackTraceRepository repository;

	String response;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/trace", produces = "text/plain;charset=UTF-8")
    public String stack(@RequestBody StackTrace trace) {
    	
    	try {
    		
    		if(!validaNullPointerException(trace)) {
    			response = "[erro - message with null values]";
    			return response;
    		}
    		
    		trace.setApplicationName("AP000100"); 
    		repository.save(trace);
    		
    		System.out.println("==== Mensagem: " + counter.incrementAndGet() + " " + trace.toString());
    		

    		response = "[ok - message received]";
    		
    	}catch(Exception e) {
    		System.out.println("==== Mensagem: " + counter.incrementAndGet() + " " + trace.toString());
    		e.printStackTrace();
    		response = "[error: " + e.getMessage() + "]";
    	}
        
        
        return response;
    }
    
    
    /*
     * METODO PALEATIVO PARA TRATAR VALORES NULL VINDOS DO COLETOR
     * MOTIVO: PADROES DE LOG AINDA NAO DETECTADOS
     */
    public boolean validaNullPointerException(StackTrace trace){
    	
    	if(trace.getDate() == null ||
    			trace.getExceptionType() == null ||
    					trace.getExceptionMessage()== null ||
    							trace.getExceptionPackage() == null ||
    									trace.getExceptionClass() == null ||
    											trace.getExceptionLine() == null) {
    		return false;
    	}else {
    		return true;
    	}
    	
    }

}
