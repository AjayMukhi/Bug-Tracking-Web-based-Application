<jsp:include page="./TesterHeader.jsp" />
<%@page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript" language="javascrpt">
    	function check()
    	{
    		
    	
       	}
    </script>
  </head>
  <body style="background-color:silver">
<form name="testerForm" action="ViewBugs" onsubmit="return check()" method="post">
<br>
<center>
<h4 align="center"><font color="red">
<%if(request.getParameter("msg")!=null)
{ %>
<%=request.getParameter("msg")%>
<%} %>
	</font></h4>
	
	<h3 align=center><font color="Green" face="arial narrow">&nbsp;&nbsp;&nbsp;&nbsp;View Solution</font></h3>
  		
    
<%
		ServletContext sc=getServletContext();
		String driver=sc.getInitParameter("drivername");
		String url=sc.getInitParameter("url");
		String uname=sc.getInitParameter("username");
		String pwd=sc.getInitParameter("password");
		HttpSession hs=request.getSession();
		String s=request.getParameter("bugid");
try{
			Class.forName(driver);
			Connection  con=DriverManager.getConnection(url,uname,pwd);
			
			ResultSet rs;
			PreparedStatement pstmt=con.prepareStatement("select * from bug_solution where bugno=?");
			pstmt.setString(1,s);
			rs=pstmt.executeQuery();
			int i=0;
	while(rs.next())
	{			
%>      <table align=center border="1" cellpadding="2" cellspacing="0" bordercolor="green">
  		<tr bgcolor="#999900">
  			<th>BugId</th>
  			<th>Employee Code</th>
  			<th>Solution</th>
  			<th>Date</th>
  			  		</tr>

  		<tr>
  		    <td><%=rs.getString(1)%></td>
  			<td><%=rs.getString(2)%></td>
  			<td><%=rs.getString(3)%></td>
  			<td><%=rs.getString(4)%></td>
  			
		</tr>
  
<%
i=i+1;
}//while
if(i==0)
{
%>
<table></table><td colspan="3" align="center">No Records Found</td> 
</table> 			
	
 		
<%


}
}
catch(Exception e)
{
	e.printStackTrace();
}
 %>  
   </table>			
  	</center>
   </form>
   </body>
   <br>
   <br>
<jsp:include page="./footer.jsp" />   
</html>
