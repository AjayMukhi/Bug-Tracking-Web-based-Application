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
 * This is the Registration Servlet class which will handle the 
 * registration of the user and save the record into database.
 * @author Ajay Kumar Mukhi
 *
 */
public class Reg extends HttpServlet
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
	String userid=request.getParameter("userid");
    String fname=request.getParameter("fname");
    String lname=request.getParameter("lname");
    String gender=request.getParameter("gender");
    String dob=request.getParameter("dob");
    String qualification=request.getParameter("qualification");
    String phoneno=request.getParameter("phoneno");
    String mobileno=request.getParameter("mobileno");
    String mailid=request.getParameter("mailid");
    String doj=request.getParameter("doj");
    String designation=request.getParameter("designation");
    String maritalstatus=request.getParameter("maritalstatus");
    String password=request.getParameter("password");
    String hintquestion=request.getParameter("HintQuestion");
    String hintanswer=request.getParameter("hintanswer");
    String address=request.getParameter("address");
   
    
    
 try{
	 Class.forName(driver);
	 con=DriverManager.getConnection(url,uname,pwd);
	 
	 pstmt=con.prepareStatement("insert into employee_details(fname,lname,gender,dob,qualification,address,phoneno,mobileno,emailid,doj,loginid,password,maritalstatus,hintquestion,hintanswer,role,permission) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	 
 	pstmt.setString(1,fname);
	pstmt.setString(2,lname);	
	pstmt.setString(3,gender);
	pstmt.setString(4,dob);
	pstmt.setString(5,qualification);
	pstmt.setString(6,address);
	pstmt.setString(7,phoneno);
	pstmt.setString(8,mobileno);
	pstmt.setString(9,mailid);
	pstmt.setString(10,doj);
	pstmt.setString(11,userid);
	pstmt.setString(12,password);
    pstmt.setString(13,maritalstatus);
	pstmt.setString(14,hintquestion);
	pstmt.setString(15,hintanswer);
	pstmt.setString(16,designation);
	pstmt.setString(17, "n");
	
	
	int n=pstmt.executeUpdate();
	
	
	if(n==1)
	{
		
		response.sendRedirect("./Home.jsp");
		
	}
	pstmt.close();
     con.close();
     {
		 
	    out.print("<html>");
	     out.print("<body bgcolor=\"cyan\">");
	     out.print("<a href=./Home.jsp>successfully one employee registered</a>");		
	     out.println("</body>"); 
	     out.println("</html>");	 
		
	}
	
      }
catch(Exception e)
{
	e.printStackTrace();
	
	out.print("<html>");
    out.print("<body bgcolor=\"cyan\">");
    out.print("<a href=Reg.html>Already existing pls try another id</a>");		
    out.println("</body>"); 
    out.println("</html>");	 
    }
 }
}