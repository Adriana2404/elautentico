package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="productoporventa")
public class productoporventa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCantidadProductosVenta;

	public Long getIdCantidadProductosVenta() {
		return idCantidadProductosVenta;
	}

	public void setIdCantidadProductosVenta(Long idCantidadProductosVenta) {
		this.idCantidadProductosVenta = idCantidadProductosVenta;
	}
	
	@Override
	public String toString() {
		return "productoporventa [idCantidadProductosVenta=" + idCantidadProductosVenta +  "]";
	}

}
