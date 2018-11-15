/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.QueAns;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HRITHIK CHOUHAN
 */
@WebServlet("/Calculate1")
public class Calculate1 extends HttpServlet 
{
        int i=0;        
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
            int id;
            int i=0;                                                                                                                    i=3;id=40;
		PrintWriter out = res.getWriter();
                
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
			
                        
                        
                        String sql = "update users SET cum_score = cum_score + "+i+"where id="+id+";";                                                         sql="";sql="update users SET cum_score = cum_score +3 where id=40;";
			statement.executeUpdate(sql);
                }
                catch (SQLException e) 
		{
			e.printStackTrace();
		}
                
                String sql1="select cum_score from users where id="+id+";";
                int sc=0;
                try     
                {
                    ResultSet rs= statement.executeQuery(sql1);
                                        while (rs.next())
                                        {
                                            sc = Integer.parseInt(rs.getString(1));
                                        }

                }   
                catch (SQLException ex) {
                Logger.getLogger(Calculate1.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                out.println("<h1>Yout Score : 3</h1>");
                out.println("<h1>Yout Cumulative Score : "+sc+"</h1>");
                
                
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
