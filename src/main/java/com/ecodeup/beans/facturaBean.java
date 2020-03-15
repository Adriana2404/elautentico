package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;

import com.ecodeup.dao.facturaDAO;

import com.ecodeup.model.factura;

@ManagedBean(name="facturaBean", eager=true)
@RequestScoped
public class facturaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private factura factura = new factura();
	private facturaDAO facturadao = new facturaDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public factura getfactura() {
		
		return factura;
	}

	public void setfactura(factura factura) {
		this.factura = factura;
	}
		
	public void registrar() {
		
		factura.setIdfactura(null);
		facturadao.Registrar(this.factura);
	}
	
	public void eliminar(factura  mfactura) {
		
		facturadao.Eliminar(factura);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT c FROM ciudad c WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<factura> query = entity.createQuery(consulta, factura.class);
		List<factura> listafactura = query.getResultList();
		
		for (factura c : listafactura) {
			

			facturadao.Eliminar(c);
		}
		
		
	}
	
	public List<factura> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<factura> query = entity.createQuery("SELECT p FROM factura p ORDER BY id",  factura.class);
		List<factura> listafactura = new ArrayList< factura>();
		listafactura = query.getResultList();
		
		return listafactura;
	}
	
	public void modificar() {
		
		facturadao.Actualizar(factura);
	}
	
	public void leer( factura  fac) {
		
		this. factura =  fac;
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
