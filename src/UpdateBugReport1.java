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
 * This is the UpdateBug Servlet class which will update the details in 
 * BugReport table
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class UpdateBugReport1 extends HttpServlet
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	Connection con;
    	PreparedStatement pstmt;
    	ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
    	String url=sc.getInitParameter("url");
    	String dbpassword=sc.getInitParameter("password");
    	String user=sc.getInitParameter("username");
	    response.setContentType("text/html");
	    
	    String status=request.getParameter("status");
	    String bug_rectified=request.getParameter("bug_rectified");
	    int bugid=Integer.parseInt(request.getParameter("bugid"));
	    int i=0;
		try
		{
			
    	  Class.forName(driver);
    	  con=DriverManager.getConnection(url,user,dbpassword);
    	  
     	  if(status.equals("close"))
     	  {
    	   pstmt=con.prepareStatement("update bug_report set status1=? where bugno=?");
    	   
    	   pstmt.setString(1,status);
    	   
    	   pstmt.setInt(2,bugid);
    	   i=pstmt.executeUpdate();
     	 }
     	  else
     	  {
     		 pstmt=con.prepareStatement("update bug_report set status=?,bugdate=?,status1=?,bug_rectifieddate=? where bugno=?");
      	   
      	   pstmt.setString(1,status);
      	   pstmt.setString(2,bug_rectified);
      	   
      	   pstmt.setString(3,"");
      	   pstmt.setString(4,"");
      	   pstmt.setInt(5,bugid);
      	   i=pstmt.executeUpdate();
     		  
     	  }
   	  	
   	  	 if(i>0)
   	  	 {
   	  	
    	  response.sendRedirect("ViewBugs1.jsp?msg=Successfully Updated&bugid="+bugid);
   	  	 }
   	  
    	  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}