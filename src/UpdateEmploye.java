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
 * This is the UpdateEmployee Servlet class which will update the 
 * Employee records and save into database.
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class UpdateEmploye extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String deptname=request.getParameter("deptname");
    	
    	String bsalary=request.getParameter("bsalary");
        String ecode=request.getParameter("ecode");
        
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
    	  
    	  
    	  pstmt=con.prepareStatement("update employee_details set basicsalary=?,dno=? where e_code=?");
    	  
    	  
    	  
    	  pstmt.setString(1,bsalary );
    	  pstmt.setString(2,deptname);
    	  pstmt.setString(3,ecode);
    	 
   	  	  pstmt.execute();
   	  	
    	  response.sendRedirect("UpdateEmployee.jsp");
    	  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}