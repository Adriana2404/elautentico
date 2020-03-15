package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.model.rol;

import com.ecodeup.app.JPAUtil;

public class rolDAO {
	
	private List<rol> listarol;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(rol mrol) {
		entity.getTransaction().begin();
		entity.persist(mrol);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(rol mrol) {
		entity.getTransaction().begin();
		entity.merge(mrol);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(rol mrol) {
		
		mrol = entity.find(rol.class, mrol.getIdrol());
		entity.getTransaction().begin();
		entity.remove(mrol);
		entity.getTransaction().commit();
		
	}
	
	public List< rol> Listar(){
		
				
		return listarol;
	}

}
