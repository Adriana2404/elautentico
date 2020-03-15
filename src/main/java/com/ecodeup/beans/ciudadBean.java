package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.ciudadDAO;
import com.ecodeup.model.ciudad;

@ManagedBean(name="ciudadBean", eager=true)
@RequestScoped
public class ciudadBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ciudad ciudad = new ciudad();
	private ciudadDAO ciudaddao = new ciudadDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public ciudad getCiudad() {
		
		return ciudad;
	}

	public void setCiudad(ciudad mciudad) {
		this.ciudad = mciudad;
	}
		
	public void registrar() {
		
		ciudad.setIdciudad(null);
		ciudaddao.Registrar(this.ciudad);
	}
	
	public void eliminar(ciudad mciudad) {
		
		ciudaddao.Eliminar(mciudad);
	
	}
	
	public List<ciudad> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<ciudad> query = entity.createQuery("SELECT c FROM ciudad c ORDER BY id",  ciudad.class);
		List<ciudad> listaCiudad = new ArrayList< ciudad>();
		listaCiudad = query.getResultList();
		
		return listaCiudad;
	}
	
	public void modificar() {
		
		ciudaddao.Actualizar(ciudad);
	}
	
	public void leer( ciudad  ciu) {
		
		this. ciudad =  ciu;
	}
	
	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}


	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	private String campo;
	private String elemento;

}


	
