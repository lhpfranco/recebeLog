package com.empresa.monitoraLog.recebeLog.controllers;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RestController
public class RecebeStackTraceController{

	@Autowired
	private StackTraceRepository repository;
	
//	@PersistenceContext
//	private EntityManager entityManager;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/trace", produces = "text/plain;charset=UTF-8")
    public String stack(@RequestBody StackTrace trace) {
    	
    	String response;
    	
    	try {
    		
    		if(!validaNullPointerException(trace)) {
    			response = "[erro - message with null values]";
    			return response;
    		}

//    		trace.setApplicationName("AP000100");
//    		repository.save(trace);
    		
//    		repository.inserirStackTrace(trace.getDate(), 
//    										trace.getExceptionType(),
//    										trace.getExceptionMessage(),
//    										trace.getExceptionPackage(),
//    										trace.getExceptionClass(), 
//    										trace.getExceptionMethod(), 
//    										trace.getExceptionLine());
//    		
//    		System.out.println("==== Mensagem: " + counter.incrementAndGet() + " " + trace.toString());
    		

    		@SuppressWarnings("unused")
			List<StackTrace> lista = repository.findByApplicationName("AP000100");			
			if(!lista.isEmpty())
				System.out.println("tamanho lista: " + lista.size());
			
    		  		
    		response = "[ok - message received]";
    		
    	}catch(Exception e) {
    		System.out.println("==== Mensagem: " + counter.incrementAndGet() + " " + trace.toString());
    		e.printStackTrace();
    		response = "[error: " + e.getMessage() + "]";
    	}
        
        
        return response;
    }
    
    
//	@Override
//	public List<StackTrace> listarlog() {
//		// TODO Auto-generated method stub
//		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("PR_LISTAR_EXCEPTIONS");
//		List<StackTrace> lista = storedProcedure.getResultList();		
//		return lista;
//	}

    
    
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
