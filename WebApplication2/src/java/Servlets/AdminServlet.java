package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String admin_name = req.getParameter("email");
		String password = req.getParameter("upassword");
		
		Cookie[] cookie = req.getCookies();
		for(Cookie ck : cookie) 
                {
                    
		}
		if(admin_name.equals("Honey123@gmail.com") && password.equals("Honey@123"))
		{
			HttpSession session = req.getSession();
			session.setAttribute("admin_name", "admin_name");
			res.sendRedirect("AdminPage.jsp");
		}
		else
		{
			res.sendRedirect("Admin.jsp");			
		}
	}
}
