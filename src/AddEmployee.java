/**  
 * Bug Tracking System which will record and monitor the bugs raised in the project
 * Programmed by Ajay Kumar Mukhi {Student ID: A20392100} 
 * & Karan Shah {Student ID: A20392253}
 * for FINAL PROJECT "Bug Tracking System". 
 * @date 26 APR 2017
 * FINAL PROJECT ITMD-523  
*/

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is the AddEmployee Servlet class which will add the employee 
 * into the system by inserting the records into database.
 * @author Ajay Kumar Mukhi & Karan Shah
 *
 */
public class AddEmployee extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
        
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
		
		
		String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String gender=request.getParameter("gender");
        String dob = request.getParameter("DOB");
        String qualification = request.getParameter("qualification");
        String address=request.getParameter("qualification");
        String phoneno = request.getParameter("phoneno");
        String mobileno=request.getParameter("phoneno");
        String emailid =request.getParameter("emailid");
        String doj =request.getParameter("emailid");
        String basicsalary=request.getParameter("basicsalary");
        String departmentNo=request.getParameter("departmentNo");
        String loginid = request.getParameter("loginId");
        String password = request.getParameter("password");
        String maritalstatus =request.getParameter("maritialStatus");
        String hintquestion=request.getParameter("HintQuestion");
        String hintanswer=request.getParameter("hintanswer");
        String designation=request.getParameter("designation");
        
        
        
        
		
		try
		{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			PreparedStatement pstmt=con.prepareStatement("insert into employee_details(fname,lname,gender,dob,qualification,address,phoneno,mobileno,emailid,doj,loginid,password,maritalstatus,hintquestion,hintanswer,role,permission) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1,fname);
			pstmt.setString(2,lname);	
			pstmt.setString(3,gender);
			pstmt.setString(4,dob);
			pstmt.setString(5,qualification);
			pstmt.setString(6,address);
			pstmt.setString(7,phoneno);
			pstmt.setString(8,mobileno);
			pstmt.setString(9,emailid);
			pstmt.setString(10,doj);
			pstmt.setString(11,loginid);
			pstmt.setString(12,password);
		    pstmt.setString(13,maritalstatus);
			pstmt.setString(14,hintquestion);
			pstmt.setString(15,hintanswer);
			pstmt.setString(16,designation);
			pstmt.setString(17, "n");
			
			
			
			
			
			
			int n=pstmt.executeUpdate();
			
			if(n==1)
			{
				response.sendRedirect("./AddEmployee.jsp?msg=Successfully saved");
				}				
			
			}catch(Exception e)
			{
				e.printStackTrace();
		}
			
			 
	}
}
