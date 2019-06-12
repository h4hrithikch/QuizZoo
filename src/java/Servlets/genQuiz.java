
package Servlets;


import Classes.Ans;
import Classes.Que;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Quiz.jsp")
public class genQuiz extends HttpServlet 
{
    int q=0;
    int qi=0;
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
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizzoo","root", "root");
			statement = connection.createStatement();
			
                        
                        
                        String sql = "select * from questions inner join answers on questions.id=answers.q_id where questions.a_id="+article_id+";";
			ResultSet rs = statement.executeQuery(sql);
                        
                        LinkedHashMap<String,QueAns> quiz  = new LinkedHashMap<>();
                        res.setContentType("text/html");
                        PrintWriter out = res.getWriter();
                        
                        
                        while (rs.next())
                        {
                            //System.out.println("Temp1");
                            int que_id  = Integer.parseInt(rs.getString(1));
                            String question = rs.getString(2);
                            int a_id = Integer.parseInt(rs.getString(3));
                            int ans_id = Integer.parseInt(rs.getString(4));
                            String ans = rs.getString(5);
                            Boolean stat = rs.getBoolean(6);
                            int q_id = Integer.parseInt(rs.getString(7));
                            QueAns obj ;
                            if(quiz.containsKey(question))
                            {
                               obj = quiz.get(question);
                            }
                            else
                            {
                                obj = new QueAns();
                                obj.question=question;
                                obj.answer=new ArrayList<>();
                                obj.ans_id = new ArrayList<>();
                                obj.status =new ArrayList<>();
                                
                            }
                                obj.answer.add(ans);
                                obj.ans_id.add(ans_id);
                                obj.status.add(stat);
                                obj.q_id = q_id;
                                quiz.put(question, obj);
                        
                            //out.println(que_id+" "+question+" "+a_id+" "+ans_id+" "+ans+" "+stat+" "+q_id);
                        }
                        out.println("<html>");
                        out.println("<head>");
			out.println("<title>Quiz</title>");
                        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />");
			out.println("</head>");
                        
                        
                        
                        out.println("<body>");
                        out.println("<div id=\"page-wrap\">");
                        out.println("<h1>Quiz</h1>");
                        out.println("<form action=\"Calculate1\" method=\"post\" id=\"quiz\">");
                       
                        out.println("<input type=\"hidden\" class=\"form-control\" name=\"article_id\" value=\""+article_id+"\">");
                        out.println("<ol>");
                        
                        
                        quiz.forEach((k,v)->
                        {
                          out.println("<li>");
                          System.out.print(v.getQuestion() );
                          out.println("<h3>"+v.getQuestion()+"</h3>");
                          out.println("<input type=\"hidden\" class=\"form-control\" name=\"q_id"+(qi++)+"\" value=\""+v.q_id+"\">");
                          int size = v.ans_id.size();
                           int key = 0 ;
                       
                          for(String s: v.answer)
                          {
                              System.out.print(s);
                              out.println("<div>");
                              out.println("<input type="+"\"radio\""+"name=q"+ String.valueOf(q) +"/>");
                              out.println("<input type=\"hidden\" class=\"form-control\" name=\"ans_id"+String.valueOf(q)+"\" value=\""+v.ans_id.get(key)+"\">");
                              out.println("<label>"+s+"</label>");
                              q++;
                              key++;
                              out.println("</div>");
                          }
                          out.println("</br></br>");
                          
                        }
                        );
                        out.println("</li>");
                        out.println("</ol>");
                        out.println("<input type=\"submit\" value=\"SubmitQuiz\" />");
                        out.println("</form>");
                        out.println("</div>");
                        
                        
                        
                        out.println("<script type=\"text/javascript\">");
                        out.println("var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");");
                        out.println("document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));");
                        out.println("</script>");
                        out.println("<script type=\"text/javascript\">");
                        out.println("var pageTracker = _gat._getTracker(\"UA-68528-29\");");
                        out.println("pageTracker._initData();");
                        out.println("pageTracker._trackPageview();");
                        out.println("</script>");
                        
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
