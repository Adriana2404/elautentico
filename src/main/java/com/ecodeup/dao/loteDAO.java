package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.model.lote;

import com.ecodeup.app.JPAUtil;


public class loteDAO {

	private List<lote> listalote;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(lote mlote) {
		entity.getTransaction().begin();
		entity.persist(mlote);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(lote mlote) {
		entity.getTransaction().begin();
		entity.merge( mlote);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(lote mlote) {
		
		mlote = entity.find(lote.class,  mlote.getIdlote());
		entity.getTransaction().begin();
		entity.remove(mlote);
		entity.getTransaction().commit();
		
	}
	
	public List< lote> Listar(){
		
				
		return listalote;
	}
}
