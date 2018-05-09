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
 * This class is the AssignProject class which will insert the record for the
 * assign project which manager used to assign.
 * @author Ajay Kumar Mukhi
 *
 */
public class AssignProject extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
		String pname=request.getParameter("pname");
        String e_code=request.getParameter("e_code");
        String role=request.getParameter("role");
		try
		{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			PreparedStatement pstmt=con.prepareStatement("insert into assign_project(project_name,userid,role)values(?,?,?)");
			pstmt.setString(1,pname);
			pstmt.setString(2,e_code);
			pstmt.setString(3,role);
			int n=pstmt.executeUpdate();
			
			if(n==1)
			{
				response.sendRedirect("./AssignProject.jsp?msg=Successfully saved");
				}				
			
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}