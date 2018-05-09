/**  
 * Bug Tracking System which will record and monitor the bugs raised in the project
 * Programmed by Ajay Kumar Mukhi {Student ID: A20392100} 
 * & Karan Shah {Student ID: A20392253}
 * for FINAL PROJECT "Bug Tracking System". 
 * @date 26 APR 2017
 * FINAL PROJECT ITMD-523  
*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

/**
 * This is the EmployeePermission servlet class which will check the 
 * employee which are required the permission to login.
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class employeepermission extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		//String username =	req.getParameter("login");
		//String salutation =	req.getParameter("salutation");
		try
		{
		Connection con;
		Statement st;
		Class.forName("com.mysql.jdbc.Driver");
		String s="jdbc:mysql://localhost:3306/test_lab04";
		con=DriverManager.getConnection(s,"root","pass");
		st=con.createStatement();		
	
		
		String query=null;	
        String userid=null;
        String a[]=new String [Integer.parseInt(req.getParameter("size"))];
        int size=Integer.parseInt(req.getParameter("size"));
        int i=0,j=0;
        for(i=0;i<size;i++)
        {
        	
        	a[i]=req.getParameter("list-"+i);
        	
        	userid=a[i];
        	if(a[i]!=null)
        	{
        		j++;
        		query="update employee_details set permission='y'where e_code='"+userid+"'";
        		
        		st.executeUpdate(query);
	      	}
        }
        if(j>0)
        {
        	res.sendRedirect("./EmployeePermission.jsp");
        	//out.println("<center> "+j+" Records Updated !  Click <a href='./html/RecruiterFilter.jsp'>here</a> to go Back</center>");
        }
		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
