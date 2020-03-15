package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.model.inventario;

public class inventarioDAO {

	private List<inventario> listainventario;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(inventario minventario) {
		entity.getTransaction().begin();
		entity.persist(minventario);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(inventario minventario) {
		entity.getTransaction().begin();
		entity.merge( minventario);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(inventario minventario) {
		
		minventario = entity.find(inventario.class,  minventario.getIdinventario());
		entity.getTransaction().begin();
		entity.remove(minventario);
		entity.getTransaction().commit();
		
	}
	
	public List< inventario> Listar(){
		
				
		return listainventario;
	}
}
