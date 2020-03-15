package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="barrio")
public class barrio implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBarrio;
	
	@Column
	private String NombreBarrio;
	
	
	@Column
	private String cuidad;


	public Long getIdBarrio() {
		return idBarrio;
	}


	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}


	public String getNombreBarrio() {
		return NombreBarrio;
	}


	public void setNombreBarrio(String nombreBarrio) {
		this.NombreBarrio = nombreBarrio;
	}


	public String getCuidad() {
		return cuidad;
	}


	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}
	
	@Override
	public String toString() {
		return "barrio [idBarrio=" + idBarrio + ", NombreBarrio=" + NombreBarrio + ", cuidad=" + cuidad + "]";
	}
																					
	
}

