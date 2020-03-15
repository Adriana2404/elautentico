package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;

@ManagedBean(name="clienteBean", eager=true)
@RequestScoped

public class ClienteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private ClienteDAO clientedao = new ClienteDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		
	public Cliente getCliente() {
		
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
		
	public void guardar() {
		cliente.setId(null);
		Date fechaActual = new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		clientedao.Guardar(cliente);
	}
	
	public void eliminar(Cliente cliente) {
		
		clientedao.Eliminar(cliente.getId());
	
	}
	
	
	
	public List<Cliente> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<Cliente> query = entity.createQuery("SELECT p FROM Cliente p ORDER BY id", Cliente.class);
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes = query.getResultList();
		
		return listaClientes;
	}
	
	public void editar() {
		
//		Date fechaActual = new Date();
//		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		
		clientedao.Editar(cliente);
	}
	
	public void leer(Cliente pro) {
		
		this.cliente = pro;
	}
	
	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}


	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	private String campo;
	private String elemento;
}
