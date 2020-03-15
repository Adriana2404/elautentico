package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.rolDAO;
import com.ecodeup.model.rol;

@ManagedBean(name="rolBean", eager=true)
@ViewScoped
public class rolBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private rol rol = new rol();
	private rolDAO roldao = new rolDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public rol getrol() {
		
		return rol;
	}

	public void setrol(rol rol) {
		this.rol = rol;
	}
		
	public void registrar() {
		
		rol.setIdrol(null);
		roldao.Registrar(this.rol);
	}
	
	public void eliminar(rol rol) {
		
		roldao.Eliminar(rol);
	
	}
	
	
	public List<rol> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<rol> query = entity.createQuery("SELECT r FROM rol r ORDER BY id", rol.class);
		List<rol> listarol = new ArrayList<rol>();
		listarol = query.getResultList();
		
		return listarol;
	}
	
	public void modificar() {
		roldao.Actualizar(this.rol);
	}
	
	public void leer(rol rl) {
		this.rol = rl;
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


