package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="factura")
public class factura implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfactura;
	
	@Column
	private Long valortotal;
	
	@Column
	private String numfactura;
	
	@Column
	private String cantidadTotal;

	public Long getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(Long idfactura) {
		this.idfactura = idfactura;
	}

	public Long getValortotal() {
		return valortotal;
	}

	public void setValortotal(Long valortotal) {
		this.valortotal = valortotal;
	}

	public String getNumfactura() {
		return numfactura;
	}

	public void setNumfactura(String numfactura) {
		this.numfactura = numfactura;
	}

	public String getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(String cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	@Override
	public String toString() {
		return "factura [idfacura=" + idfactura + ", valortotal=" + valortotal + ", numfactura=" + numfactura + "cantidadTotal=" + cantidadTotal+ "]";
	}

}
