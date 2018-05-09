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
 * This is the AssignBug Servlet class which will  insert the records for the 
 * assign Bug table for the Developer
 * @author Ajay Kumar Mukhi & Karan shah
 *
 */
public class AssignBug extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
        String bug_name=request.getParameter("bug_name");
		String bug_type=request.getParameter("bug_type");
		String bug_level=request.getParameter("bug_level");
        int priority=Integer.parseInt(request.getParameter("priority"));
        String pname=request.getParameter("pname");
        String tester_code=request.getParameter("tester_code");
        String bug_date=request.getParameter("bug_date");
        String e_code=request.getParameter("e_code");
        String status=request.getParameter("status");
        
		
		try
		{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			PreparedStatement pstmt=con.prepareStatement("insert into bug_report(bug_name,bug_type,bug_level,priority,pname,testercode,bugdate,e_code,status) values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,bug_name);
			pstmt.setString(2,bug_type);
			pstmt.setString(3,bug_level);
			pstmt.setInt(4,priority);
			pstmt.setString(5,pname);
			pstmt.setString(6,tester_code);
			pstmt.setString(7,bug_date);
			pstmt.setString(8,e_code);
			pstmt.setString(9,status);
			
			int n=pstmt.executeUpdate();
			
			if(n==1)
			{
				response.sendRedirect("./AssignBug.jsp?msg=Successfully saved");
				}				
			
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}