package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="rol")
public class rol implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;
	
	@Column
	private String nombreRol;

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	@Override
	public String toString() {
		return "productoporventa [idrol=" + idrol + ",nombreRol=" + nombreRol + "]";
	}

}
