package com.ecodeup.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.empresaDAO;

import com.ecodeup.model.empresa;

@ManagedBean(name="empresaBean", eager=true)
@RequestScoped
public class empresaBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	private empresa empresa = new empresa();
	private empresaDAO empresadao = new empresaDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public empresa getProducto() {
		
		return empresa;
	}

	public void setProducto(empresa empresa) {
		this.empresa = empresa;
	}
		
	public void registrar() {
		
		empresa.setIdemp(null);
		empresadao.Registrar(this.empresa);
	}
	
	public void eliminar(empresa mempresa) {
		
		empresadao.Eliminar(empresa);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT c FROM ciudad c WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<empresa> query = entity.createQuery(consulta, empresa.class);
		List<empresa> listaempresa = query.getResultList();
		
		for (empresa e : listaempresa) {
			

			empresadao.Eliminar(e);
		}
		
		
	}
	
	public List<empresa> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<empresa> query = entity.createQuery("SELECT p FROM Producto p ORDER BY id",  empresa.class);
		List<empresa> listaempresa = new ArrayList< empresa>();
		listaempresa = query.getResultList();
		
		return listaempresa;
	}
	
	public void modificar() {
		
		empresadao.Actualizar(empresa);
	}
	
	public void leer( empresa  emp) {
		
		this. empresa = emp;
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


	


