package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

//import com.mysql.jdbc.Driver;
//import com.mysql.jdbc.PreparedStatement;


@WebServlet("/UserLoginDAO")
public class UserLoginDAO extends HttpServlet 
{
	String sql = "select* from users where email=?and upassword=?";
	private static final long serialVersionUID = 1L;

	public UserLoginDAO() 
	{
            super();
        }
	public boolean check(String email,String upassword) throws ReflectiveOperationException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzoo","root","root");
		PreparedStatement statement =(PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, upassword);
		ResultSet rs = statement.executeQuery();
		if(rs.next())
		{
			return true;
		}
		
		return false;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

	}

}
