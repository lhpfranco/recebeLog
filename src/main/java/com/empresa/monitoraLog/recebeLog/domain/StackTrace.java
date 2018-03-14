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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "referencia_aplicacao")
	private String applicationName = "AP000100";

	@Column(name = "data")
	private Date   date;

	@Column(name = "servidor")
	private String serverAddress;

	@Column(name = "stack_trace")
	private String stackTrace;
	
	@Column(name = "tipo_excecao")
	private String exceptionType;
	
	@Column(name = "mensagem")
	private String exceptionMessage;
	
	@Column(name = "pacote")
	private String exceptionPackage;
	
	@Column(name = "classe")
	private String exceptionClass;
	
	@Column(name = "metodo")
	private String exceptionMethod;
	
	@Column(name = "linha")
	private String exceptionLine;
	
	
	
	
	
//	public String getServerAddress() {
//		return serverAddress;
//	}
//	public void setServerAddress(String serverAddress) {
//		this.serverAddress = serverAddress;
//	}
//	public String getApplicationName() {
//		return applicationName;
//	}
//	public void setApplicationName(String applicationName) {
//		this.applicationName = applicationName;
//	}
//	public String getStackTrace() {
//		return stackTrace;
//	}
//	public void setStackTrace(String stackTrace) {
//		this.stackTrace = stackTrace;
//	}

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}





	public String getExceptionType() {
		return exceptionType;
	}





	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}





	public String getExceptionMessage() {
		return exceptionMessage;
	}





	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}





	public String getExceptionPackage() {
		return exceptionPackage;
	}





	public void setExceptionPackage(String exceptionPackage) {
		this.exceptionPackage = exceptionPackage;
	}





	public String getExceptionClass() {
		return exceptionClass;
	}





	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}





	public String getExceptionMethod() {
		return exceptionMethod;
	}





	public void setExceptionMethod(String exceptionMethod) {
		this.exceptionMethod = exceptionMethod;
	}





	public String getExceptionLine() {
		return exceptionLine;
	}





	public void setExceptionLine(String exceptionLine) {
		this.exceptionLine = exceptionLine;
	}





	public String getServerAddress() {
		return serverAddress;
	}





	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}





	public String getApplicationName() {
		return applicationName;
	}





	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}





	public String getStackTrace() {
		return stackTrace;
	}





	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}





	@Override
	public String toString() {
		return "\n[STACKTRACE][data:" 		+ this.getDate() 
//					+ "][servidor:" 		+ this.getServerAddress() 
//					+ "][NomeApp:" 			+ this.getApplicationName()
					+ "][Tipo Excecao:" 	+ this.getExceptionType()
					+ "][Mensagem Erro:" 	+ this.getExceptionMessage()
					+ "][Pacote:" 			+ this.getExceptionPackage()
					+ "][Classe:" 			+ this.getExceptionClass()
					+ "][Metodo:" 			+ this.getExceptionMethod()
					+ "][Linha:" 			+ this.getExceptionLine();
	}

}
