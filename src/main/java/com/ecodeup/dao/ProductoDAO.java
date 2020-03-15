package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.ecodeup.app.JPAUtil;
import com.ecodeup.model.*;

public class ProductoDAO {
	
	
	private List<Producto> listaProductos;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(Producto producto) {
		
		producto = entity.find(Producto.class, producto.getIdproducto());
		entity.getTransaction().begin();
		entity.remove(producto);
		entity.getTransaction().commit();
		
	}
	
	public List<Producto> Listar(){
		
				
		return listaProductos;
	}
}
