package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String  age = req.getParameter("age");
		String upassword = req.getParameter("upassword");
		String contact = req.getParameter("contact");
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzoo","root","root");
			statement = connection.createStatement();
			
			String sql="insert into users(uname,email,age,upassword,contact) values('" + uname +"','"+ email 
					                                                                                +"','"+age+"','"+upassword +"','"+contact+"');" ;
			boolean b= true;
			if(statement.executeUpdate(sql)==1)
                        {
                            System.out.println("Record Inserted");
                            req.setAttribute("message", "Record Successfully Inserted");
                            res.sendRedirect("Registration.jsp");
                            connection.close();
                        }
		}
		catch (SQLException e) 
		{
                    
                     HttpSession session=req.getSession();  
                     //System.out.println((String)session.getAttribute("value")+"value");
		
                     session.setAttribute("value","hr");
                     //System.out.println((String)session.getAttribute("value")+"value");
                     res.sendRedirect("Registration.jsp");
                 
                 	e.printStackTrace();
		}
	}

}
