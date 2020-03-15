package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="ventadetalle")
public class ventadetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idventa;
	
	@Column
	private String registro;
	
	@Column
	private String total;
	
	@Column
	private String fecha;

	public Long getIdventa() {
		return idventa;
	}

	public void setIdventa(Long idventa) {
		this.idventa = idventa;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getTotal() {
		return registro;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

	@Override
	public String toString() {
		return "ventadetalle [idventa=" + idventa + ", registro=" + registro + ",total  =" + total +  ",fecha  =" + fecha + "]";
	
}
}	
