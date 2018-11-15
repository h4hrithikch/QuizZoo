package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddQueAndAns")
public class AddQuesAndAns extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{   
            
                int a_id = Integer.parseInt(req.getParameter("article_id"));
                //System.out.println("Article id is"+a_id);
                String que = req.getParameter("question");
                
                ArrayList<String> al1 = new ArrayList<>();
                ArrayList<Boolean> al2 = new ArrayList<>();
                
                int i=0;
                String ansb="";
                 
                while((ansb=req.getParameter("t"+(++i)))!=null)
                {
                    boolean state = Boolean.parseBoolean(req.getParameter("s"+(i)));
                    al1.add(ansb);
                    al2.add(state);
                }
                
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
			
			String sql="insert into questions(question,a_id) values('" + que +"','" + a_id +"');" ;
                        statement.executeUpdate(sql);
                 //System.out.println("Question Added");       
                        String sql1 = "select* from questions where question='"+que+"';";
                 //System.out.println("In SQl1");       
                        ResultSet rs = statement.executeQuery(sql1);
                 //System.out.println("RS Created"); 
                 int q_id=-1;
                 while(rs.next())
                 {
                        q_id = rs.getInt("id");
                 }
                        
                 //System.out.println("Question id "+q_id);
                        
                        int length = al1.size();
                        for(int j=0;j<length;j++)
                        {
                            int ra=0;
                            if(al2.get(j)==true)
                            {
                                ra=1;
                            }
                            
                            String sql2 = "insert into answers (ans,a_status,q_id) values ( '" + al1.get(j) +"','" + ra +"','" + q_id +"')";
                            statement.executeUpdate(sql2); 
                        }
                       
			res.sendRedirect("AddQue.jsp?article_id="+a_id);
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
