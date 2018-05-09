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
 * This is the UpdateProfile Servlet class which will update the 
 * Profiel records and save into database.
 * @author Ajay Kumar Mukhi
 *
 */
public class UpdateProfile extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String userid=request.getParameter("userid");
    	String fname=request.getParameter("fname");
    	
    	String lname=request.getParameter("lname");
        String gender=request.getParameter("gender");
        
        String dob=request.getParameter("dob");
        String qualification=request.getParameter("qualification");
        String address=request.getParameter("address");
        String phoneno=request.getParameter("phoneno");
        String mobileno=request.getParameter("mobileno");
        String mailid=request.getParameter("mailid");
        String doj=request.getParameter("doj");
        String role=request.getParameter("role");
        String maritalstatus=request.getParameter("maritalstatus");
        String HintQuestion=request.getParameter("HintQuestion");
        String hintanswer=request.getParameter("hintanswer");
       
        
        
        
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
    	  
    	
    	  pstmt=con.prepareStatement("update employee_details set fname=?,lname=?,gender=?,dob=?,qualification=?,address=?,phoneno=?,mobileno=?,emailid=?,doj=?,role=?,maritalstatus=?,hintquestion=?,hintanswer=? where loginid=?");
    	  
    	  pstmt.setString(1,fname );
    	  pstmt.setString(2,lname);
    	  pstmt.setString(3,gender);
    	  pstmt.setString(4,dob);
    	  pstmt.setString(5,qualification);
    	  pstmt.setString(6,address);
    	  pstmt.setString(7,phoneno );
    	  pstmt.setString(8,mobileno);
    	  pstmt.setString(9,mailid);
    	  pstmt.setString(10,doj);
    	  pstmt.setString(11,role);
    	  pstmt.setString(12,maritalstatus);
    	  pstmt.setString(13,HintQuestion);
    	  pstmt.setString(14,hintanswer);
    	  pstmt.setString(15,userid);
    	
    	 
    	 
   	  	 int n=0;
   	  	 n=pstmt.executeUpdate();
   	  	
   	  	
    	if(n>0)
    	{
    		
   	  	response.sendRedirect("EditProfile.jsp?msg=Successfully Updated&cat="+request.getParameter("cat"));
    	}
    	  
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
    }
}