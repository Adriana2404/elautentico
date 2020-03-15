package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.ecodeup.model.tipodocumento;

import com.ecodeup.app.JPAUtil;

public class tipodocumentoDAO {

	private List<tipodocumento> listatipodocumento;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(tipodocumento mtipodocumento) {
		entity.getTransaction().begin();
		entity.persist(mtipodocumento);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(tipodocumento mtipodocumento) {
		entity.getTransaction().begin();
		entity.merge( mtipodocumento);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(tipodocumento mtipodocumento ) {
		
		mtipodocumento = entity.find(tipodocumento.class, mtipodocumento.getIdtipodocumento());
		entity.getTransaction().begin();
		entity.remove(mtipodocumento);
		entity.getTransaction().commit();
		
	}
	
	public List< tipodocumento> Listar(){
		
				
		return listatipodocumento;
	}
}
