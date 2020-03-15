package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.barrioDAO;
import com.ecodeup.model.barrio;

@ManagedBean(name="barrioBean", eager=true)
@RequestScoped

public class barrioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String NombreBarrio;
	private String cuidad;
	private barrio barrio = new  barrio();
	private barrioDAO barriodao = new barrioDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String getNombreBarrio() {
		return NombreBarrio;
	}

	public void setNombreBarrio(String nombreBarrio) {
		NombreBarrio = nombreBarrio;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public  barrio getProducto() {
		
		return  barrio;
	}

	public void setProducto( barrio mbarrio) {
		this. barrio = mbarrio;
	}
		
	public void registrar() {
		barrio.setCuidad(this.cuidad);
		barrio.setNombreBarrio(this.NombreBarrio);
		barrio.setIdBarrio(null);
		barriodao.Registrar(this.barrio);
	}
	
	public void eliminar(barrio mbarrio) {
		
		barriodao.Eliminar(barrio);
	
	}
	
	public barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(barrio barrio) {
		this.barrio = barrio;
	}

	public void eliminar2() {
		
		String consulta = "SELECT p FROM Producto p WHERE " + getCampo() + " ='" + getElemento() + "'";
		TypedQuery< barrio> query = entity.createQuery(consulta,  barrio.class);
		List< barrio> listabarrio = query.getResultList();
		
		for (barrio b: listabarrio) {
			

			barriodao.Eliminar(b);
		}
		

	}

public List<barrio> getListar() {
	
	entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	TypedQuery<barrio> query = entity.createQuery("SELECT b FROM barrio p ORDER BY id", barrio.class);
	List<barrio> listabarrio = new ArrayList< barrio>();
	listabarrio = query.getResultList();
	
	return listabarrio;
}
	
public void modificar() {
	
	barriodao.Actualizar( barrio);
}

public void leer(barrio bar) {
	
	this. barrio =  bar;
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


