package com.ecodeup.dao;
import java.util.List;

import javax.persistence.EntityManager;


import com.ecodeup.model.tipoproducto;

import com.ecodeup.app.JPAUtil;

public class tipoproductoDAO {
	
	private List<tipoproducto> listatipoproducto;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(tipoproducto mtipoproducto) {
		entity.getTransaction().begin();
		entity.persist(mtipoproducto);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(tipoproducto mtipoproducto) {
		entity.getTransaction().begin();
		entity.merge( mtipoproducto);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(tipoproducto mtipoproducto ) {
		
		mtipoproducto = entity.find(tipoproducto.class, mtipoproducto.getIdtipoproducto());
		entity.getTransaction().begin();
		entity.remove(mtipoproducto);
		entity.getTransaction().commit();
		
	}
	
	public List< tipoproducto> Listar(){
		
				
		return listatipoproducto;
	}
}
