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
		
public class productovista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idproducto;
			
 @Column
private String NombreProducto;
			
@Column
private int cantidad;
			
@Column
private String  unidaddemedida;

@Column
private int  valor;

@Column
private Date  fechavencimiento;

public Long getIdproducto() {
	return idproducto;
}

public void setIdproducto(Long idproducto) {
	this.idproducto = idproducto;
}

public String getNombreProducto() {
	return NombreProducto;
}

public void setNombreProducto(String nombreProducto) {
	NombreProducto = nombreProducto;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public String getUnidaddemedida() {
	return unidaddemedida;
}

public void setUnidaddemedida(String unidaddemedida) {
	this.unidaddemedida = unidaddemedida;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
}

public Date getFechavencimiento() {
	return fechavencimiento;
}

public void setFechavencimiento(Date fechavencimiento) {
	this.fechavencimiento = fechavencimiento;
}


}
