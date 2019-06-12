package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String title = req.getParameter("title");
		String url = req.getParameter("url");
                String discription = req.getParameter("discription");
                System.out.println(title+" "+ url +" "+ discription);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzoo","root", "root");
			statement = connection.createStatement();
			
			String sql="insert into articles(title,url,discription) values('" + title +"','" + url + "','" + discription+ "');" ;
			
			statement.executeUpdate(sql);
                        
			res.sendRedirect("AddArticle.jsp");
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
