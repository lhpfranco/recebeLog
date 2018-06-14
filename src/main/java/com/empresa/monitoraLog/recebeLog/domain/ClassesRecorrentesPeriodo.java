package com.empresa.monitoraLog.recebeLog.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ClassesRecorrentesPeriodo implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter String exceptionClass;
	private @Getter @Setter long total;
	
	public ClassesRecorrentesPeriodo(String exceptionClass, long total) {
	    this.exceptionClass = exceptionClass;
	    this.total  = total;
	  }
}
