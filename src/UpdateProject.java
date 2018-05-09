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
 * This is the UpdateProject Servlet class which will update the 
 * Project records and save into database.
 * @author Ajay Kumar Mukhi
 *
 */
public class UpdateProject extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String pid=request.getParameter("pid");
    	String pname=request.getParameter("pname");
    	
    	String description=request.getParameter("description");
        String date=request.getParameter("date");
        String duration=request.getParameter("duration");
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String phoneno=request.getParameter("phoneno");
        String emailid=request.getParameter("emailid");
       
        String deptname=request.getParameter("deptname");
        String plead=request.getParameter("plead");
        
        
    	Connection con;
    	PreparedStatement pstmt;
    	ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
    	String url=sc.getInitParameter("url");
    	String dbpassword=sc.getInitParameter("password");
    	String user=sc.getInitParameter("username");
	    response.setContentType("text/html");
	    
		
		try
		{
			
    	  Class.forName(driver);
    	  
    	  con=DriverManager.getConnection(url,user,dbpassword);
    	  
    	  
    	  pstmt=con.prepareStatement("update project_details set project_name=?,project_description=?,sdate=?,duration=?,clientname=?,clientaddress=?,clientphone=?,clientemail=?,projectlead=?,deptname=? where project_no=?");
    	  
    	  pstmt.setString(1,pname );
    	  pstmt.setString(2,description);
    	  pstmt.setString(3,date);
    	  pstmt.setString(4,duration);
    	  pstmt.setString(5,name);
    	  pstmt.setString(6,address);
    	  pstmt.setString(7,phoneno );
    	  pstmt.setString(8,emailid);
    	  pstmt.setString(9,plead);
    	  pstmt.setString(10,deptname);
    	  pstmt.setString(11,pid);
    	
    	 
    	 
   	  	 int n=pstmt.executeUpdate();
   	  	 
   	  	
    	  response.sendRedirect("UpdateProject.jsp");
    	  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}