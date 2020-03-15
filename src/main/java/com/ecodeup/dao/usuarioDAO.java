package com.ecodeup.dao;
import java.util.List;

import javax.persistence.EntityManager;


import com.ecodeup.model.usuario;

import com.ecodeup.app.JPAUtil;
public class usuarioDAO {
	private List<usuario> listausuario;
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Registrar(usuario musuario) {
		entity.getTransaction().begin();
		entity.persist(musuario);
		entity.getTransaction().commit();
	}
	
	public void Actualizar(usuario musuario) {
		entity.getTransaction().begin();
		entity.merge( musuario);
		entity.getTransaction().commit();
	}
	
	public void Eliminar(usuario musuario ) {
		
		musuario = entity.find(usuario.class, musuario.getIdusuario());
		entity.getTransaction().begin();
		entity.remove(musuario);
		entity.getTransaction().commit();
		
	}
	
	public List< usuario> Listar(){
		
				
		return listausuario;
	}
}

