package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="marca")
public class marca implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmarca;
	
	@Column
	private String nombre;
	
	@Column
	private Long nit;

	public Long getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Long idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}
	
	@Override
	public String toString() {
		return "marca [idmarca=" + idmarca + ", nombre=" + nombre + ", nit=" + nit + "]";
	}
}
