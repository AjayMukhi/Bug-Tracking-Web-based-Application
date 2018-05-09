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
 * This is the UpdateDepartment Servlet class which will update the 
 * department records and save into database.
 * @author Ajay Kumar Mukhi
 *
 */
public class UpdateDepartment extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String deptname=request.getParameter("deptname");
    	
    	String loc=request.getParameter("location");
        String deptno=request.getParameter("deptno");
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
    	  
    	  
    	  pstmt=con.prepareStatement("update department_details set dept_name=?,dept_loc=? where dept_no=?");
    	  
    	  
    	  
    	  pstmt.setString(1,deptname);
    	  pstmt.setString(2,loc);
    	  pstmt.setString(3,deptno);
    	 
   	  	  pstmt.execute();
   	  	
    	  response.sendRedirect("UpdateDepartment.jsp");
    	  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}