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
 * This class is the Solution class which will save the solution into the database.
 * @author Ajay Kumar Mukhi
 *
 */
public class solution extends HttpServlet
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
    	ResultSet rs;
    	ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
    	String url=sc.getInitParameter("url");
    	String dbpassword=sc.getInitParameter("password");
    	String user=sc.getInitParameter("username");
	    response.setContentType("text/html");
	    HttpSession hs=request.getSession();
	    
	    
	    
	    
	    
	    
	    int bugid=Integer.parseInt(request.getParameter("bugid"));
	    String userid=(String)hs.getAttribute("userid");
	    String solution=request.getParameter("solution");
	    String bug_rectified=request.getParameter("pdate");

		try
		{
		  
    	  Class.forName(driver);
    	  con=DriverManager.getConnection(url,user,dbpassword);
    	  
     	
    	  pstmt=con.prepareStatement("select * from bug_solution where bugno=?");
    	  pstmt.setInt(1, bugid);
          rs = pstmt.executeQuery();
          if(rs.next()){
        	  
        	  
        	  pstmt=con.prepareStatement("update bug_solution set solution=?,date=? where bugno=?");
        	  
        	  
        	  pstmt.setString(1,solution);
        	  pstmt.setString(2,bug_rectified);        	  
        	  
        	  pstmt.setInt(3,bugid);
        	 
        	  int i=0;
       	  	  i=pstmt.executeUpdate();
       	  	  
       	  	  if(i>0)
       	  	  {
       	  	    
        	    response.sendRedirect("ViewBugs.jsp?msg=Successfully Updated&bugid="+bugid);
       	  	  }
       	       
        	  
    		}
        
          else{
    	  
    	  pstmt=con.prepareStatement("insert into bug_solution values(?,?,?,?)");
    	  
    	  
    	  
    	  pstmt.setInt(1,bugid);
    	  pstmt.setString(2,userid);
    	  pstmt.setString(3,request.getParameter("solution"));
    	  pstmt.setString(4,request.getParameter("pdate"));
    	
    	 
    	 
    	   int i=0;
   	  	  i=pstmt.executeUpdate();
   	  	  
   	  	 if(i>0)
   	  	 {
   	     	
    	    response.sendRedirect("ViewBugs.jsp?msg=Successfully Updated&bugid="+bugid);
   	  	 }
   	     
    	  
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    }
}