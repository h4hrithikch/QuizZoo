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


@WebServlet("/ArticleList.jsp")
public class AllArticle extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");  
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quizzoo","root", "root");
			statement = connection.createStatement();
			
			String sql="select * from articles" ;
			
			out.println("<html>");

			out.println("<head>");
			out.println("<style>");
			out.println("body{");
			
			out.println("background: #A49D9C;}");
			
			out.println("</style>");
			out.println("</head>");
			
			out.println("<body>");
			
			
			out.println("<h2 align="  +  "\""  +   "center"+ "\""+">Articles_Detail</h2><br>");
			ResultSet rs = statement.executeQuery(sql);
			
			out.print("<table border ='3' style="+"\"width:100%; height:100%;\">");
			out.println("<tr>");
			out.println("<th>Article_ID</th>");
			out.println("<th>Article_Title</th>");
			out.println("<th>Article_Url</th><br>");
                        out.println("<th>Article_Discription</th><br>");
			out.println("</tr>");
			while(rs.next())
			{
				int id = rs.getInt("id");
				String  title = rs.getString("title");
				String url = rs.getString("url");
                                String discription = rs.getString("discription");
				
                                out.println("<tr>");
				out.println("<td>"+id +"</td>");
				out.println("<td><a href='"+"AddQue.jsp?article_id="+id+"'>"+ title +"</a></td>");
				out.println("<td>" +  "<a href ="  + "\""  + url + "\""  + "target =" + "\"" + "_blank" + "\"" + ">" + "Link" + "</a>" +"</td>");
				out.println("<td>"+discription +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
