package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.model.productoporventa;

import com.ecodeup.app.JPAUtil;

public class productoporventaDAO {

	private List<productoporventa> listaproductoporventa;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(productoporventa mproductoporventa) {
		entity.getTransaction().begin();
		entity.persist(mproductoporventa);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(productoporventa mproductoporventa) {
		entity.getTransaction().begin();
		entity.merge( mproductoporventa);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(productoporventa mproductoporventa) {
		
		mproductoporventa = entity.find(productoporventa.class,  mproductoporventa.getIdCantidadProductosVenta());
		entity.getTransaction().begin();
		entity.remove(mproductoporventa);
		entity.getTransaction().commit();
		
	}
	
	public List< productoporventa> Listar(){
		
				
		return listaproductoporventa;
	}
}
