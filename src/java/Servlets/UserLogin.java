package Servlets;


import Servlets.UserLoginDAO;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public UserLogin() 
	{
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String email = request.getParameter("email");
		String password = request.getParameter("upassword");
		
		UserLoginDAO dao = new UserLoginDAO();
		try {
			if(dao.check(email, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("Profile.jsp");
			}
			else
			{
				response.sendRedirect("Login.jsp");		
			}
		} catch (ReflectiveOperationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
