package com.ecodeup.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
		
public class empresavista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idemp;
			
 @Column
private String nombre;
			
@Column
private String direccion;
			
@Column
private String contacto;

@Column
private String NombreBarrio;

public Long getIdemp() {
	return idemp;
}

public void setIdemp(Long idemp) {
	this.idemp = idemp;
}

public String getNombreemprsa() {
	return nombre;
}

public void setNombreemprsa(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getContacto() {
	return contacto;
}

public void setContacto(String contacto) {
	this.contacto = contacto;
}

public String getNombreBarrio() {
	return NombreBarrio;
}

public void setNombreBarrio(String nombreBarrio) {
	NombreBarrio = nombreBarrio;
}

}
