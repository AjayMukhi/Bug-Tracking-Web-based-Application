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
 * This is the Delete Department Servlet class which will delete the department 
 * records from the table.
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class DeleteDepartment extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
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
    	  
    	  pstmt=con.prepareStatement("delete from department_details where dept_no=?");
    	  pstmt.setString(1,deptno);
    	 
    	  
    	  
    	  pstmt.execute();
    	  
    	response.sendRedirect("ViewDepartment.jsp");
    	  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}