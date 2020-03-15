package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.model.marca;

import com.ecodeup.app.JPAUtil;

public class marcaDAO {
	
	private List<marca> listamarca;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(marca mmarca) {
		entity.getTransaction().begin();
		entity.persist(mmarca);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(marca mmarca) {
		entity.getTransaction().begin();
		entity.merge( mmarca);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(marca mmarca) {
		
		mmarca = entity.find(marca.class,  mmarca.getIdmarca());
		entity.getTransaction().begin();
		entity.remove(mmarca);
		entity.getTransaction().commit();
		
	}
	
	public List< marca> Listar(){
		
				
		return listamarca;
	}

}
