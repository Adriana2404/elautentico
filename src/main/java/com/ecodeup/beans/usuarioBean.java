package com.ecodeup.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.dao.usuarioDAO;
import com.ecodeup.model.usuario;
import com.ecodeup.model.usuariovista;

@ManagedBean(name="usuarioBean", eager=true)
@ViewScoped

public class usuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private usuario usuario = new usuario();
	private usuarioDAO usuariodao = new usuarioDAO();
	private EntityManager entity= JPAUtil.getEntityManagerFactory().createEntityManager();
	
	private String emails;
	private String subject;
	private String message;
	private String resultMessage;
	
	
	
	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public usuario getusuario() {
		
		return usuario;
	}

	public void setusuario(usuario usuario) {
		this.usuario = usuario;
	}
		
	public void registrar() {
		
		usuario.setIdusuario(null);
		usuariodao.Registrar(this.usuario);
	}
	
	public void eliminar(usuario usuario) {
		
		usuariodao.Eliminar(usuario);
	
	}
	
	public List<usuariovista> getListar() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<usuariovista> query = entity.createQuery("SELECT u FROM usuariovista u ORDER BY id", usuariovista.class);
		List<usuariovista> listausuario = new ArrayList<usuariovista>();
		listausuario = query.getResultList();
		
		return listausuario;
	}
	
	public void getListarEmail() {
		
		entity= JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<usuariovista> query = entity.createQuery("SELECT u FROM usuariovista u ORDER BY id", usuariovista.class);
		List<usuariovista> listausuario = new ArrayList<usuariovista>();
		listausuario = query.getResultList();
		
		setEmails("");
		int size = listausuario.size();
		int actualItem = 1;
		for(usuariovista usuario : listausuario){
			System.out.println(actualItem);
			System.out.println(size);
			if(actualItem < size) {
				setEmails(getEmails() + usuario.getEmail() + ", ");
				
			} else {
				setEmails(getEmails() + usuario.getEmail());
			}
			actualItem++;
		}
	}
	
	public void enviarMensaje(String temails, String tsubject, String tmessage) {
		System.out.println("-------------------------------");
		
		System.out.println(tsubject);
		System.out.println(subject);
		System.out.println(temails);
		System.out.println(emails);
		
		System.out.println("-------------------------------");
		EmailBean emailsender = new EmailBean();
		emails = "";
		subject = "";
		message = "";
		System.out.println(temails + "  1");
		resultMessage = emailsender.sendEmail(temails, tsubject, tmessage);

	}
	
	public void modificar() {
		
		usuariodao.Actualizar(usuario);
	}
	
	public void leer(usuario usu) {
		
		this.usuario = usu;
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


