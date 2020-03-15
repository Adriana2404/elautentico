package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="tipoproducto")
public class tipoproducto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipoproducto;
	
	@Column
	private String Nombre;

	public Long getIdtipoproducto() {
		return idtipoproducto;
	}

	public void setIdtipoproducto(Long idtipoproducto) {
		this.idtipoproducto = idtipoproducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "tipoproducto [idtipoproducto=" + idtipoproducto + ",Nombre=" + Nombre + "]";
	}


}
