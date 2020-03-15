package com.ecodeup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecodeup.beans.LoginBean;
import com.ecodeup.dao.AuthDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();

		loginBean.setUsuario(userName);
		loginBean.setClave(password);

		AuthDAO authdao = new AuthDAO();

		try
		{
			String userValidate = authdao.authenticateUser(loginBean);
			System.out.println(userValidate);
			if(userValidate.equals("Usuario"))
			{
				HttpSession session = request.getSession(); //Creating a session
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("user", userName);
				session.setAttribute("Admin", userName); //setting session attribute
				request.setAttribute("userName", userName);
				
				if(request.getAttribute("errMessage") != null) {
					session.removeAttribute("errMessage");
				}
				response.sendRedirect(request.getContextPath() + "/Dashboard.xhtml");
			}
			else
			{
				System.out.println("Error message = "+userValidate);
				request.setAttribute("errMessage", userValidate);
				response.sendRedirect(request.getContextPath() + "/landingpage/login.xhtml");
			}
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	} //End of doPost()
}