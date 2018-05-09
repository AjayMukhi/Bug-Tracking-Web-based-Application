/**  
 * Bug Tracking System which will record and monitor the bugs raised in the project
 * Programmed by Ajay Kumar Mukhi {Student ID: A20392100} 
 * & Karan Shah {Student ID: A20392253}
 * for FINAL PROJECT "Bug Tracking System". 
 * @date 26 APR 2017
 * FINAL PROJECT ITMD-523  
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * This is the class AddDepartment Servlet which will insert the department records into database
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class AddDepartment extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    HttpSession session=request.getSession(); 
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
		
		
		String deptname=request.getParameter("dname");
        String loc=request.getParameter("location");
		
		try
		{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			PreparedStatement pstmt=con.prepareStatement("insert into department_details(dept_name,dept_loc)values(?,?)");
			pstmt.setString(1,deptname);
			pstmt.setString(2,loc);
			int n=pstmt.executeUpdate();
			
			if(n==1)
			{
				
				response.sendRedirect("./AddDepartment.jsp?msg=Successfully saved");
				}			
			
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}