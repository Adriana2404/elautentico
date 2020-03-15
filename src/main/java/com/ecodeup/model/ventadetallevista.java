package com.ecodeup.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
		
public class ventadetallevista implements Serializable{
			
private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idventa;
			
 @Column
private String registro;
			
@Column
private String total ;
			
@Column
private String  fecha;

@Column
private String valortotal;

@Column
private int  numfactura;

public Long getIdventa() {
	return idventa;
}

public void setIdventa(Long idventa) {
	this.idventa = idventa;
}

public String getRegistro() {
	return registro;
}

public void setRegistro(String registro) {
	this.registro = registro;
}

public String getTotal() {
	return total;
}

public void setTotal(String total) {
	this.total = total;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public String getValortotal() {
	return valortotal;
}

public void setValortotal(String valortotal) {
	this.valortotal = valortotal;
}

public int getNumfactura() {
	return numfactura;
}

public void setNumfactura(int numfactura) {
	this.numfactura = numfactura;
}


}
