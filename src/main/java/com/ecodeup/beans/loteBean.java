package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;

import com.ecodeup.dao.loteDAO;

import com.ecodeup.model.lote;

@ManagedBean(name="loteBean", eager=true)
@ViewScoped

public class loteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private lote lote = new lote();
	private loteDAO lotedao = new loteDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public lote getlote() {
		
		return lote;
	}

	public void setlote(lote lote) {
		this.lote = lote;
	}
		
	public void registrar() {
		
		lote.setIdlote(null);
		lotedao.Registrar(this.lote);
	}
	
	public void eliminar(lote mlote) {
		
		lotedao.Eliminar(mlote);
	
	}
	
	public List<lote> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<lote> query = entity.createQuery("SELECT l FROM lote l ORDER BY id", lote.class);
		List<lote> listaLotes = new ArrayList<lote>();
		listaLotes = query.getResultList();
		
		return listaLotes;
	}
	
	public void modificar() {
		
		lotedao.Actualizar(lote);
	}
	
	public void leer(lote lot) {
		
		this.lote = lot;
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


