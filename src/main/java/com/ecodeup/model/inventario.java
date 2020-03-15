package com.ecodeup.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="inventario")
public class inventario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinventario;
	
	@Column
	private Long cantocupada;
	
	@Column
	private Long cantdisponible;
	
	@Column
	private Date FechaInventario;

	public Date getFechaInventario() {
		return FechaInventario;
	}

	public void setFechaInventario(Date fechaInventario) {
		FechaInventario = fechaInventario;
	}

	public Long getIdinventario() {
		return idinventario;
	}

	public void setIdinventario(Long idinventario) {
		this.idinventario = idinventario;
	}

	public Long getCantocupada() {
		return cantocupada;
	}

	public void setCantocupada(Long cantocupada) {
		this.cantocupada = cantocupada;
	}

	public Long getCantdisponible() {
		return cantocupada;
	}

	public void setCantdisponible(Long cantdisponible) {
		this.cantdisponible = cantdisponible;
	}

	

	@Override
	public String toString() {
		return "inventario [idinventario=" + idinventario + ", cantocupada=" + cantocupada + ", cantdisponible=" + cantdisponible + "FechaInventario=" + FechaInventario+ "]";
	}


}
