package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.ventadetalleDAO;
import com.ecodeup.model.ventadetalle;

@ManagedBean(name="ventadetalleBean", eager=true)
@RequestScoped

public class ventadetalleBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ventadetalle ventadetalle = new ventadetalle();
	private ventadetalleDAO ventadetalledao = new ventadetalleDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public ventadetalle getventadetalle() {
		
		return ventadetalle;
	}

	public void setventadetalle(ventadetalle ventadetalle) {
		this.ventadetalle = ventadetalle;
	}
		
	public void registrar() {
		
		ventadetalle.setIdventa(null);
		ventadetalledao.Registrar(this.ventadetalle);
	}
	
	public void eliminar(ventadetalle ventadetalle) {
		
		ventadetalledao.Eliminar(ventadetalle);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT v FROM ventadetalle v WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<ventadetalle> query = entity.createQuery(consulta, ventadetalle.class);
		List<ventadetalle> listaventadetalle = query.getResultList();
		
		for (ventadetalle v : listaventadetalle) {
			

			ventadetalledao.Eliminar(v);
		}
		
		
	}
	
	public List<ventadetalle> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<ventadetalle> query = entity.createQuery("SELECT v FROM ventadetalle v ORDER BY id", ventadetalle.class);
		List<ventadetalle> listaventadetalle = new ArrayList<ventadetalle>();
		listaventadetalle = query.getResultList();
		
		return listaventadetalle;
	}
	
	public void modificar() {
		
		ventadetalledao.Actualizar(ventadetalle);
	}
	
	public void leer(ventadetalle ven) {
		
		this.ventadetalle = ven;
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


