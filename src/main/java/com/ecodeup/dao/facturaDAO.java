package com.ecodeup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.model.factura;

public class facturaDAO {

	private List<factura> listafactura;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(factura mfactura) {
		entity.getTransaction().begin();
		entity.persist(mfactura);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(factura mfactura) {
		entity.getTransaction().begin();
		entity.merge( mfactura);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(factura mfactura) {
		
		mfactura = entity.find(factura.class,  mfactura.getIdfactura());
		entity.getTransaction().begin();
		entity.remove(mfactura);
		entity.getTransaction().commit();
		
	}
	
	public List< factura> Listar(){
		
				
		return listafactura;
	}
}
