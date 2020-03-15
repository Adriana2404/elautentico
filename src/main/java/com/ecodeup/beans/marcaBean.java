package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.marcaDAO;
import com.ecodeup.model.marca;

@ManagedBean(name="marcaBean", eager=true)
@RequestScoped

public class marcaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private marca marca = new marca();
	private marcaDAO marcadao = new marcaDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public marca getmarca() {
		
		return marca;
	}

	public void setmarca(marca marca) {
		this.marca = marca;
	}
		
	public void registrar() {
		marca.setIdmarca(null);
		marcadao.Registrar(this.marca);
	}
	
	public void eliminar(marca marca) {
		
		marcadao.Eliminar(marca);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT m FROM marca m WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<marca> query = entity.createQuery(consulta, marca.class);
		List<marca> listamarca = query.getResultList();
		
		for (marca m : listamarca) {
			

			marcadao.Eliminar(m);
		}
		
		
	}
	
	public List<marca> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<marca> query = entity.createQuery("SELECT m FROM marca m ORDER BY id", marca.class);
		List<marca> listamarca = new ArrayList<marca>();
		listamarca = query.getResultList();
		
		return listamarca;
	}
	
	public void modificar() {
		
		marcadao.Actualizar(marca);
	}
	
	public void leer(marca mar) {
		
		this.marca = mar;
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