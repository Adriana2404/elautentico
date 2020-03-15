package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.ProductoDAO;
import com.ecodeup.model.Producto;
import com.ecodeup.model.productovista;

@ManagedBean(name="productoBean", eager=true)
@RequestScoped

public class ProductoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Producto producto = new Producto();
	private ProductoDAO produtodao = new ProductoDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public Producto getProducto() {
		
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
		
	public void registrar() {
		
		producto.setIdproducto(null);
		produtodao.Registrar(this.producto);
	}
	
	public void eliminar(Producto producto) {
		
		produtodao.Eliminar(producto);
	
	}
	
	public void eliminar2() {
		
		String consulta = "SELECT p FROM Producto p WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery<Producto> query = entity.createQuery(consulta, Producto.class);
		List<Producto> listaProductos = query.getResultList();
		
		for (Producto p : listaProductos) {
			produtodao.Eliminar(p);
		}	
	}
	
	public List<productovista> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<productovista> query = entity.createQuery("SELECT p FROM productovista p ORDER BY id", productovista.class);
		List<productovista> listaProductos = new ArrayList<productovista>();
		listaProductos = query.getResultList();
		
		return listaProductos;
	}
	
	public void modificar() {
		
		produtodao.Actualizar(producto);
	}
	
	public void leer(Producto pro) {
		
		this.producto = pro;
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
