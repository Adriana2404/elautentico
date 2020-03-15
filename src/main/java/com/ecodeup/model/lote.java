package com.ecodeup.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="lote")
public class lote implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlote;
	
	@Column
	private Date fechafabricacion;
	
	@Column
	private Date fechavencimiento;

	public Long getIdlote() {
		return idlote;
	}

	public void setIdlote(Long idlote) {
		this.idlote = idlote;
	}

	public Date getFechafabricacion() {
		return fechafabricacion;
	}

	public void setFechafabricacion(Date fechafabricacion) {
		this.fechafabricacion = fechafabricacion;
	}

	public Date getFechavecimiento() {
		return fechavencimiento;
	}

	public void setFechavecimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	
	@Override
	public String toString() {
		return "lote [idlote=" + idlote + ", fechafabricacion=" + fechafabricacion + ", fechavencimiento=" + fechavencimiento  + "]";
	}
	
}
