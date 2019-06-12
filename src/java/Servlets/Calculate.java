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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HRITHIK CHOUHAN
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet 
{
                     int i = 0 ;
                        int itrat ;
	
     LinkedHashMap<String,QueAns> quiz;
    Calculate ( LinkedHashMap<String,QueAns> quiz)
    {
        this.quiz = quiz ;
    }
            
            int q=1;
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int article_id = Integer.parseInt(req.getParameter("article_id"));
                
                
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
                PrintWriter out = res.getWriter();
		try 
		{
        		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzoo","root", "root");
			statement = connection.createStatement();
                        quiz.forEach ((k,v) ->
                        {
                               String question = k ;
                               QueAns obj = v ;
                               int l = v.ans_id.size();
                               itrat = 0 ;
                               String ans = "ans_id";
                               for(; itrat < l ;itrat++)
                               {
                                   String id = ans+String.valueOf(i+itrat) ;
                                System.out.println(req.getParameter(id)) ;
                                 out.println(" <script>  var check =  document.getElementById("+id+").checked ;"
                                        + "if (check == true)"
                                        + "{"
                                         
                                         +"document.write("+req.getParameter(id)+"});"
                                        +"}"   
                                        +"</script>");
                                
                                
                               }
                                //System.out.println(req.getParameter(id)) ;
                                i += itrat ;
                               
                        });
                        
		}
                catch(Exception e)
                {
                    
                }
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
