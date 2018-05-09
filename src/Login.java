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
 * This is the LoginServlet class which will handle the login to the user and 
 * check the user credentials and permissions
 * @author Ajay Kumar Mukhi
 *
 */
public class Login extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
		
		//login credentials...
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		try
		{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			PreparedStatement pstmt=con.prepareStatement("select role,permission from employee_details where loginid=? and password=?");
			pstmt.setString(1,userid);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			
			HttpSession hs=request.getSession();
			int i=0;
			if(userid.equals("admin") && password.equals("12345"))
			{
				
				hs.setAttribute("role","admin");
				response.sendRedirect("./AdminHome.jsp");
			}
		
			while(rs.next())
			{
				i++;
				
				if(rs.getString("role").equals("Tester"))
				{
					 
						if(rs.getString("permission").equals("n"))
						{
						response.sendRedirect("./Home.jsp?msg1=Permission not Granted");
							
					     }
						else
						{	
					         
					         hs.setAttribute("userid",userid);
					         hs.setAttribute("role", rs.getString("role"));
					         response.sendRedirect("./TesterHome.jsp");
						}
				}
				
				if(rs.getString("role").equals("Manager"))
				{
					 
						if(rs.getString("permission").equals("n"))
						{
						response.sendRedirect("./Home.jsp?msg1=Permission not Granted");
							
					     }
						else
						{
							hs.setAttribute("userid",userid);
							hs.setAttribute("role", rs.getString("role"));
							response.sendRedirect("./ManagerHome.jsp");
						}
				}
				if(rs.getString("role").equals("Developer"))
				{
					 
						if(rs.getString("permission").equals("n"))
						{
						response.sendRedirect("./Home.jsp?msg1=Permission not Granted");
							
					     }
						else
						{
					
					     
					     hs.setAttribute("userid",userid);
					     hs.setAttribute("role", rs.getString("role"));
					     response.sendRedirect("./DeveloperHome.jsp");
						}
				}
					
			
			
			}//while
		
		
			
			if(i==0)
			{
				
				response.sendRedirect("./Home.jsp?msg=Check your userid and password.");
			}
			
			
			}catch(Exception e)
			{
				e.printStackTrace();
				}
			
		
	}
}