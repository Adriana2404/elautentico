package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.model.barrio;

public class barrioDAO {

	private List<barrio> listabarrio;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(barrio mbarrio) {
		entity.getTransaction().begin();
		entity.persist(mbarrio);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(barrio mbarrio) {
		entity.getTransaction().begin();
		entity.merge( mbarrio);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(barrio mbarrio) {
		
		 mbarrio = entity.find(barrio.class,  mbarrio.getIdBarrio());
		entity.getTransaction().begin();
		entity.remove(mbarrio);
		entity.getTransaction().commit();
		
	}
	
	public List< barrio> Listar(){
		
				
		return listabarrio;
	}
}
