package com.empresa.monitoraLog.recebeLog.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@NamedStoredProcedureQueries({
   @NamedStoredProcedureQuery(name = "PR_INSERIR_STACKTRACE", 
                              procedureName = "PR_INSERIR_STACKTRACE",
                              parameters = {
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_data", 			type = Date.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_tipo_excecao", 	type = String.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_mensagem", 		type = String.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_pacote", 		type = String.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_classe", 		type = String.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_metodo", 		type = String.class),
                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_linha", 			type = String.class)
                              }),
   
   @NamedStoredProcedureQuery(name = "PR_LISTAR_EXCEPTIONS", 
  							  procedureName = "PR_LISTAR_EXCEPTIONS",
  							  parameters={@StoredProcedureParameter(mode = ParameterMode.OUT, type=List.class)
  							    })
})





@Entity
@Table(name="tb_log_aplicacao")
public class StackTrace implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private @Getter @Setter Long id;
	
	@Column(name = "referencia_aplicacao")
	private @Getter @Setter String applicationName = "AP000100";

	@Column(name = "data")
	private @Getter @Setter Date   date;

	@Column(name = "servidor")
	private @Getter @Setter String serverAddress;

	@Column(name = "stack_trace")
	private @Getter @Setter String stackTrace;
	
	@Column(name = "tipo_excecao")
	private @Getter @Setter String exceptionType;
	
	@Column(name = "mensagem")
	private @Getter @Setter String exceptionMessage;
	
	@Column(name = "pacote")
	private @Getter @Setter String exceptionPackage;
	
	@Column(name = "classe")
	private @Getter @Setter String exceptionClass;
	
	@Column(name = "metodo")
	private @Getter @Setter String exceptionMethod;
	
	@Column(name = "linha")
	private @Getter @Setter String exceptionLine;
	


	@Override
	public String toString() {
		return "\n[STACKTRACE][data:" 		+ date 
//					+ "][servidor:" 		+ serverAddress 
//					+ "][NomeApp:" 			+ applicationName
					+ "][Tipo Excecao:" 	+ exceptionType
					+ "][Mensagem Erro:" 	+ exceptionMessage
					+ "][Pacote:" 			+ exceptionPackage
					+ "][Classe:" 			+ exceptionClass
					+ "][Metodo:" 			+ exceptionMethod
					+ "][Linha:" 			+ exceptionLine;
	}

}
