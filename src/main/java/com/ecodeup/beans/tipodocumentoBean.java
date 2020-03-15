package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.tipodocumentoDAO;
import com.ecodeup.model.tipodocumento;

@ManagedBean(name="tipodocumentoBean", eager=true)
@RequestScoped

public class tipodocumentoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private tipodocumento tipodocumento = new tipodocumento();
	private tipodocumentoDAO tipodocumentodao = new tipodocumentoDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public tipodocumento gettipodocumento() {
		
		return tipodocumento;
	}

	public void settipodocumento(tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
		
	public void registrar() {
		
		tipodocumento.setIdtipodocumento(null);
		tipodocumentodao.Registrar(this.tipodocumento);
	}
	
	public void eliminar(tipodocumento tipodocumento) {
		
		tipodocumentodao.Eliminar(tipodocumento);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT t FROM tipodocumento t WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<tipodocumento> query = entity.createQuery(consulta, tipodocumento.class);
		List<tipodocumento> listatipodocumento = query.getResultList();
		
		for (tipodocumento t : listatipodocumento) {
			

			tipodocumentodao.Eliminar(t);
		}
		
		
	}
	
	public List<tipodocumento> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<tipodocumento> query = entity.createQuery("SELECT t FROM tipodocumento t ORDER BY id", tipodocumento.class);
		List<tipodocumento> listatipodocumento = new ArrayList<tipodocumento>();
		listatipodocumento = query.getResultList();
		
		return listatipodocumento;
	}
	
	public void modificar() {
		
		tipodocumentodao.Actualizar(tipodocumento);
	}
	
	public void leer(tipodocumento  tip) {
		
		this.tipodocumento = tip;
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


