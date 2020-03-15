package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	
public class barriovista implements Serializable{
		
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idBarrio;
		
 @Column
 private String NombreBarrio;
		
 @Column
 private String NombreCiudad;
		
 @Column
 private String Departamento;

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
	NombreBarrio = nombreBarrio;
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
		
		
}
