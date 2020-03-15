package com.ecodeup.dao;
import java.util.List;

import javax.persistence.EntityManager;


import com.ecodeup.model.ventadetalle;

import com.ecodeup.app.JPAUtil;
public class ventadetalleDAO {
	private List<ventadetalle> listaventadetalle;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(ventadetalle mventadetalle) {
		entity.getTransaction().begin();
		entity.persist(mventadetalle);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(ventadetalle mventadetalle) {
		entity.getTransaction().begin();
		entity.merge( mventadetalle);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(ventadetalle mventadetalle ) {
		
		mventadetalle = entity.find(ventadetalle.class, mventadetalle.getIdventa());
		entity.getTransaction().begin();
		entity.remove(mventadetalle);
		entity.getTransaction().commit();
		
	}
	
	public List< ventadetalle> Listar(){
		
				
		return listaventadetalle;
	}
}


