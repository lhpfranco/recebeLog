package com.empresa.monitoraLog.recebeLog.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ErrosRecorrentesPeriodo implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter String tipoException;
	private @Getter @Setter long total;
	
	public ErrosRecorrentesPeriodo(String tipoException, long total) {
	    this.tipoException = tipoException;
	    this.total  = total;
	  }
}
