package com.ecodeup.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
		
public class marcavista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idmarca;
			
 @Column
private String nombremarca;
			
@Column
private int nit ;
			
@Column
private String nombreempresa;

@Column
private String direccion;

public Long getIdmarca() {
	return idmarca;
}

public void setIdmarca(Long idmarca) {
	this.idmarca = idmarca;
}

public String getNombremarca() {
	return nombremarca;
}

public void setNombremarca(String nombremarca) {
	this.nombremarca = nombremarca;
}

public int getNit() {
	return nit;
}

public void setNit(int nit) {
	this.nit = nit;
}

public String getNombreemprsa() {
	return nombreempresa;
}

public void setNombreemprsa(String nombreempresa) {
	this.nombreempresa = nombreempresa;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}
}
