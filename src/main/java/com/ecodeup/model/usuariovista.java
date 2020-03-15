package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
		
public class usuariovista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idusuario;
			
 @Column
private String NumeroDocumento;
			
@Column
private String primernombre;
			
@Column
private String  pimerapellido;

@Column
private String fechanac;

@Column
private String  telefono;

@Column
private String  email;

@Column
private String  nombreTipoDocumento;

@Column
private String  nombreRol;

@Column
private String  NombreBarrio;

public Long getIdusuario() {
	return idusuario;
}

public void setIdusuario(Long idusuario) {
	this.idusuario = idusuario;
}

public String getNumeroDocumento() {
	return NumeroDocumento;
}

public void setNumeroDocumento(String numeroDocumento) {
	NumeroDocumento = numeroDocumento;
}

public String getPrimernombre() {
	return primernombre;
}

public void setPrimernombre(String primernombre) {
	this.primernombre = primernombre;
}

public String getPimerapellido() {
	return pimerapellido;
}

public void setPimerapellido(String pimerapellido) {
	this.pimerapellido = pimerapellido;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNombreTipoDocumento() {
	return nombreTipoDocumento;
}

public void setNombreTipoDocumento(String nombreTipoDocumento) {
	this.nombreTipoDocumento = nombreTipoDocumento;
}

public String getNombreRol() {
	return nombreRol;
}

public void setNombreRol(String nombreRol) {
	this.nombreRol = nombreRol;
}

public String getNombreBarrio() {
	return NombreBarrio;
}

public void setNombreBarrio(String nombreBarrio) {
	NombreBarrio = nombreBarrio;
}

public String getFechanac() {
	return fechanac;
}

public void setFechanac(String fechanac) {
	this.fechanac = fechanac;
}

}
