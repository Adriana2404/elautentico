package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="ciudad")
public class ciudad implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idciudad;
	
	@Column
	private String NombreCiudad;
	
	
	@Column
	private String Departamento;


	public Long getIdciudad() {
		return idciudad;
	}


	public void setIdciudad(Long idciudad) {
		this.idciudad = idciudad;
	}


	public String getNombreCiudad() {
		return NombreCiudad;
	}


	public void setNombreCiudad(String nombreCiudad) {
		NombreCiudad = nombreCiudad;
	}


	public String getDepartamento() {
		return Departamento;
	}


	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}


	@Override
	public String toString() {
		return "cuidad [idciudad=" + idciudad + ", NombreCiudad=" + NombreCiudad + ", Departamento=" + Departamento + "]";
	}
		
	
	
}
