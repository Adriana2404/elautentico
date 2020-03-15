package com.ecodeup.dao;

import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import com.ecodeup.app.JPAUtil;
import com.ecodeup.beans.LoginBean;
import com.ecodeup.model.usuario;

public class AuthDAO {
	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String authenticateUser(LoginBean loginBean)
	{
		String userName = loginBean.getUsuario();
		String password = loginBean.getClave();

		List<usuario> usersList = null;

		String userNameDB = "";
		String passwordDB = "";

		try
		{
		      Query query = entity.createQuery( "Select u " + "from usuario u ");
		      usersList = (List<usuario>)query.getResultList();
			for (usuario usuario : usersList) {
				System.out.println("------------------------");
				System.out.println(usuario.getEmail());
				System.out.println(usuario.getClave());
				System.out.println("------------------------");
				userNameDB = usuario.getEmail();
				passwordDB = usuario.getClave();

				if(userName.equals(userNameDB) && password.equals(passwordDB))
					return "Usuario";
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}
