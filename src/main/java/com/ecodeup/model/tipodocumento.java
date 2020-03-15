package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="tipodocumento")
public class tipodocumento implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipodocumento;
	
	@Column
	private String nombreTipoDocumento;
 
	
	public Long getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}


  public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}


	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

	@Override
	public String toString() {
		return "tipodocumento [idtipodocumento=" + idtipodocumento + ",nombreTipoDocumento=" + nombreTipoDocumento + "]";
	}

}
