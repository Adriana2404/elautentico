package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="empresa")
public class empresa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemp;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String conctacto;

	public Long getIdemp() {
		return idemp;
	}

	public void setIdemp(Long idemp) {
		this.idemp = idemp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getConctacto() {
		return conctacto;
	}

	public void setConctacto(String conctacto) {
		this.conctacto = conctacto;
	}
	
	@Override
	public String toString() {
		return "empresa [idemp=" + idemp + ", nombre=" + nombre + ", direccion=" + direccion + "contacto=" + conctacto + "]";
	}

	
}
