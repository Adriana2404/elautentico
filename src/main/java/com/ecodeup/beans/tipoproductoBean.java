package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.tipoproductoDAO;
import com.ecodeup.model.tipoproducto;

@ManagedBean(name="tipoproductoBean", eager=true)
@RequestScoped

public class tipoproductoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private tipoproducto tipoproducto = new tipoproducto();
	private tipoproductoDAO tipoproductodao = new tipoproductoDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public tipoproducto gettipoproducto() {
		
		return tipoproducto;
	}

	public void settipoproducto(tipoproducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}
		
	public void registrar() {
		
		tipoproducto.setIdtipoproducto(null);
		tipoproductodao.Registrar(this.tipoproducto);
	}
	
	public void eliminar(tipoproducto tipoproducto) {
		
		tipoproductodao.Eliminar(tipoproducto);
	
	}
	
	public List<tipoproducto> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<tipoproducto> query = entity.createQuery("SELECT t FROM tipoproducto t ORDER BY id", tipoproducto.class);
		List<tipoproducto> listatipoproducto = new ArrayList<tipoproducto>();
		listatipoproducto = query.getResultList();
		
		return listatipoproducto;
	}
	
	public void modificar() {
		
		tipoproductodao.Actualizar(tipoproducto);
	}
	
	public void leer(tipoproducto pro) {
		
		this.tipoproducto = pro;
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
