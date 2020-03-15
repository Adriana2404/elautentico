package com.ecodeup.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
		
public class inventariovista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idinventario;
			
 @Column
private int cantdisponible;
			
@Column
private Date  FechaIventario ;
			
@Column
private String NombreProducto;

@Column
private int valor;

public Long getIdinventario() {
	return idinventario;
}

public void setIdinventario(Long idinventario) {
	this.idinventario = idinventario;
}

public int getCantdisponible() {
	return cantdisponible;
}

public void setCantdisponible(int cantdisponible) {
	this.cantdisponible = cantdisponible;
}

public Date getFechaIventario() {
	return FechaIventario;
}

public void setFechaIventario(Date fechaIventario) {
	FechaIventario = fechaIventario;
}

public String getNombreProducto() {
	return NombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	NombreProducto = nombreProducto;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
}  


}