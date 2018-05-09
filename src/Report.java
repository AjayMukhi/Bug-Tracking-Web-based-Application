/**  
 * Bug Tracking System which will record and monitor the bugs raised in the project
 * Programmed by Ajay Kumar Mukhi {Student ID: A20392100} 
 * & Karan Shah {Student ID: A20392253}
 * for FINAL PROJECT "Bug Tracking System". 
 * @date 26 APR 2017
 * FINAL PROJECT ITMD-523  
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * This is the Report Servlet class which will insert the report records
 * and show the report into Jasper Report into the database.
 * @author Ajay Kumar Mukhi
 *
 */
public class Report extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
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
		
		
		
		
		try {
			Class.forName(driver);			
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			ResultSet rs;
			
			 String source =session.getServletContext().getRealPath("/Report.jrxml");
			 InputStream input = new FileInputStream(new File(source));
			 
			 JasperReport jreport = JasperCompileManager.compileReport(input);
			 JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
		     JasperViewer.viewReport(jprint, false);
			
		     response.sendRedirect("./Report.jsp?cat=Manager");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
			 
	}
}
