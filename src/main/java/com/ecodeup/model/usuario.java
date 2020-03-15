package com.ecodeup.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="usuario")
public class usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	
	@Column
	private String NumeroDocumento;
	
	@Column
	private String primernombre;
	
	@Column
	private String SegundoNombre;
	
	@Column
	private String pimerApellido;
	
	@Column
	private String SegundoApellido;
	
	@Column
	private String fechanac;
	
	@Column
	private String telefono;
	
	@Column
	private String direccion;
	
	@Column
	private String email;
	
	@Column
	private String barrio;
	
	@Column
	private String clave;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNumeroDocumento() {
		return NumeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		NumeroDocumento = numeroDocumento;
	}

	public String getPrimernombre() {
		return primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public String getSegundoNombre() {
		return SegundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		SegundoNombre = segundoNombre;
	}

	public String getPimerApellido() {
		return pimerApellido;
	}

	public void setPimerApellido(String pimerApellido) {
		this.pimerApellido = pimerApellido;
	}

	public String getSegundoApellido() {
		return SegundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "usuario [idusuario=" + idusuario + ",NumeroDocumento=" + NumeroDocumento + ",primernombre=" + primernombre +",SegundoNombre=" + SegundoNombre +",pimerApellido=" + pimerApellido +",SegundoApellido=" + SegundoApellido +",fechanac=" + fechanac + ",telefono=" + telefono + ",direccion=" + direccion + ",email=" + email + ",barrio=" + barrio +  "]";
	}


}
