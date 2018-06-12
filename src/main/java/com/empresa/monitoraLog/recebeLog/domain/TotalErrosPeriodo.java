package com.empresa.monitoraLog.recebeLog.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class TotalErrosPeriodo implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Getter @Setter Date data;
	private @Getter @Setter long total;
	
	public TotalErrosPeriodo(Date data, long total) {
	    this.data = data;
	    this.total  = total;
	  }
}
