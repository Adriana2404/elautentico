package com.ecodeup.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="producto")


public class Producto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproducto;
	
	@Column
	private Long cantidad;
	
	@Column
	private String NombreProducto;
	
	@Column
	private String unidaddemedida;

	@Column
	private Long valor;
	
	@Column
	private Long marca_idmarca;
	
	@Column
	private Long TipoProducto_idTipoProducto;
	
	@Column
	private Long Lote_idLote;

	public Long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public String getUnidaddemedida() {
		return unidaddemedida;
	}

	public void setUnidaddemedida(String unidaddemedida) {
		this.unidaddemedida = unidaddemedida;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}
	
	public Long getMarca_idmarca() {
		return marca_idmarca;
	}

	public void setMarca_idmarca(Long marca_idmarca) {
		this.marca_idmarca = marca_idmarca;
	}

	public Long getTipoProducto_idTipoProducto() {
		return TipoProducto_idTipoProducto;
	}

	public void setTipoProducto_idTipoProducto(Long tipoProducto_idTipoProducto) {
		TipoProducto_idTipoProducto = tipoProducto_idTipoProducto;
	}

	public Long getLote_idLote() {
		return Lote_idLote;
	}

	public void setLote_idLote(Long lote_idLote) {
		Lote_idLote = lote_idLote;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", cantidad=" + cantidad + ", NombreProducto=" + NombreProducto + ", unidaddemedida=" + unidaddemedida+ ", valor=" + valor + "]";
	}


	
	
}
