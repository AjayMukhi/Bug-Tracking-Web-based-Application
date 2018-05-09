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
 * This is the Employee Request Servlet class which will handle 
 * the request raised to Admin and save the record into the database.
 * @author Ajay Kumar Mukhi
 *
 */
public class Employee extends HttpServlet
{
public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	Connection con;
	PreparedStatement pstmt;
	PrintWriter out=response.getWriter();
	ServletContext sc=getServletContext();
	String driver=sc.getInitParameter("drivername");
	String url=sc.getInitParameter("url");
	String uname=sc.getInitParameter("username");
	String pwd=sc.getInitParameter("password");
	response.setContentType("text/html");
	String f1=request.getParameter("f1");
    String to=request.getParameter("to");
    String from=request.getParameter("from");
    String subject=request.getParameter("subject");
    String message=request.getParameter("message");
    String tested=request.getParameter("tested");
        
 try{
	Class.forName(driver);
	 con=DriverManager.getConnection(url,uname,pwd);
	 
	 pstmt=con.prepareStatement("insert into employeerequest values(?,?,?,?,?,?)");
	 
 	pstmt.setString(1,f1);
	pstmt.setString(2,to);
	pstmt.setString(3,from);
	pstmt.setString(4,subject);
	pstmt.setString(5,message);
	pstmt.setString(6,tested);
	
	pstmt.executeUpdate();
	
	pstmt.close();
     con.close();
     {
		 
	    out.print("<html>");
	     out.print("<body bgcolor=\"cyan\">");
	     out.print("<a href=Employeerequest.html>successfully forward one request</a>");		
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