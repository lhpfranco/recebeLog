package com.empresa.monitoraLog.recebeLog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;


@RepositoryRestResource(collectionResourceRel = "logAplicacao", path = "logAplicacao")
public interface StackTraceRepository extends CrudRepository<StackTrace, Long>, JpaSpecificationExecutor<StackTrace>, PagingAndSortingRepository<StackTrace, Long>{
	
//	@Procedure(name = "PR_INSERIR_STACKTRACE")
//    void inserirStackTrace(	@Param("pi_data") Date inData, 
//    						@Param("pi_tipo_excecao") String inTipoExcecao,
//    						@Param("pi_mensagem") String inMensagemExcecao,
//    						@Param("pi_pacote") String inPacoteExcecao,
//    						@Param("pi_classe") String inClasseExcecao,
//    						@Param("pi_metodo") String inMetodoExcecao,
//    						@Param("pi_linha") String inLinhaExcecao);
//					
//	@Procedure(name = "PR_LISTAR_EXCEPTIONS")
//	List<StackTrace> listarLog();

	List<StackTrace> findByApplicationName(@Param("name")String appReference);
	
}



//IN `pi_data` DATETIME, 
//IN `pi_tipo_excecao` VARCHAR(30) CHARSET utf8, 
//IN `pi_mensagem` VARCHAR(100), 
//IN `pi_pacote` VARCHAR(30), 
//IN `pi_classe` VARCHAR(20), 
//IN `pi_metodo` VARCHAR(20),
//IN `pi_linha` VARCHAR(10))

