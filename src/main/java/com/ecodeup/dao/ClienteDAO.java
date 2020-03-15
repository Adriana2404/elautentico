package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.model.Cliente;


public class ClienteDAO {
	
	private List<Cliente> listaClientes;
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void Guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
	}
	
	public void Editar(Cliente cliente) {
		
		
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
	}
	
	public Cliente Buscar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		return c;
	}
	
	public void Eliminar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
	public  List<Cliente> ObtenerClientes() {
		listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
}
