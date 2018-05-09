/**  
 * Bug Tracking System which will record and monitor the bugs raised in the project
 * Programmed by Ajay Kumar Mukhi {Student ID: A20392100} 
 * & Karan Shah {Student ID: A20392253}
 * for FINAL PROJECT "Bug Tracking System". 
 * @date 26 APR 2017
 * FINAL PROJECT ITMD-523  
*/
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * This is the Admin Servlet class which will take care of the admin response 
 * to the employee request
 * @author Ajay Kumar Mukhi
 *
 */
public class Admin extends HttpServlet
{
public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	Connection con;
	PreparedStatement pstmt;
	ServletContext sc=getServletContext();
	String driver=sc.getInitParameter("drivername");
	String url=sc.getInitParameter("url");
	String uname=sc.getInitParameter("username");
	String pwd=sc.getInitParameter("password");
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String f1=request.getParameter("f1");
    String message=request.getParameter("message");
    String reassignto=request.getParameter("reassignto");
    String newstatus=request.getParameter("newstatus");
    String tested=request.getParameter("tested");
    
 try{
	Class.forName(driver);
	 con=DriverManager.getConnection(url,uname,pwd);
	 
	 pstmt=con.prepareStatement("insert into adminresponse values(?,?,?,?,?)");
	 
 	pstmt.setString(1,f1);
	pstmt.setString(2,message);
	pstmt.setString(3,reassignto);
	pstmt.setString(4,newstatus);
	pstmt.setString(5,tested);
	
	pstmt.executeUpdate();
	
	pstmt.close();
     con.close();
     {
		 
	    out.print("<html>");
	     out.print("<body bgcolor=\"cyan\">");
	     out.print("<a href=Status.html>successfully forward one response</a>");		
	     out.println("</body>"); 
	     out.println("</html>");	 
		
	}
	
      }
catch(Exception e)
{
	e.printStackTrace();

    }
 }
}