package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;

import com.ecodeup.dao.inventarioDAO;

import com.ecodeup.model.inventario;

@ManagedBean(name="inventarioBean", eager=true)
@RequestScoped
public class inventarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private inventario inventario = new inventario();
	private inventarioDAO inventariodao = new inventarioDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public inventario getInventario() {
		
		return inventario;
	}

	public void setInventario(inventario inventario) {
		this.inventario = inventario;
	}
		
	public void registrar() {
		
		inventario.setIdinventario(null);
		inventariodao.Registrar(this.inventario);
	}
	
	public void eliminar(inventario  minventario) {
		
		inventariodao.Eliminar(inventario);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT c FROM ciudad c WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<inventario> query = entity.createQuery(consulta, inventario.class);
		List<inventario> listainventario = query.getResultList();
		
		for (inventario i : listainventario) {
			

			inventariodao.Eliminar(i);
		}
		
		
	}
	
	public List<inventario> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<inventario> query = entity.createQuery("SELECT p FROM factura p ORDER BY id",  inventario.class);
		List<inventario> listainventario = new ArrayList< inventario>();
		listainventario = query.getResultList();
		
		return listainventario;
	}
	
	public void modificar() {
		
		inventariodao.Actualizar(inventario);
	}
	
	public void leer( inventario  inv) {
		
		this. inventario =  inv;
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
