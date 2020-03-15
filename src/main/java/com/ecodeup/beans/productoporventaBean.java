package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.productoporventaDAO;
import com.ecodeup.model.productoporventa;

@ManagedBean(name="productoporventaBean", eager=true)
@RequestScoped

public class productoporventaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private productoporventa productoporventa = new productoporventa();
	private productoporventaDAO productoporventadao = new productoporventaDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public productoporventa getProductoporventa() {
		
		return productoporventa;
	}

	public void setproductoporventa(productoporventa productoporventa) {
		this.productoporventa = productoporventa;
	}
		
	public void registrar() {
		
		productoporventa.setIdCantidadProductosVenta(null);
		productoporventadao.Registrar(this.productoporventa);
	}
	
	public void eliminar(productoporventa productoporventa) {
		
		productoporventadao.Eliminar(productoporventa);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT p FROM Productoporventa p WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<productoporventa> query = entity.createQuery(consulta, productoporventa.class);
		List<productoporventa> listaproductoporventa = query.getResultList();
		
		for (productoporventa p : listaproductoporventa) {
			

			productoporventadao.Eliminar(p);
		}
		
		
	}
	
	public List<productoporventa> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<productoporventa> query = entity.createQuery("SELECT p FROM Productoporventa p ORDER BY id", productoporventa.class);
		List<productoporventa> listaproductoporventa = new ArrayList<productoporventa>();
		listaproductoporventa = query.getResultList();
		
		return listaproductoporventa;
	}
	
	public void modificar() {
		
		productoporventadao.Actualizar(productoporventa);
	}
	
	public void leer(productoporventa pro) {
		
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


