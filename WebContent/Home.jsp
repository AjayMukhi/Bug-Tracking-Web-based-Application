<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
String msg=null;

msg=request.getParameter("msg");

 %>
<head>
<script type="text/javascript">
function check()
{
<%
if(request.getParameter("msg")!=null)
{
%>
var msg='Please Check your userid and password';
alert(msg);
<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='Permission not granted';
alert(msg1);
<%
}

%>
}

//}
</script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
</head>
<body style="background-color:silver" onload="return check()"><center style="height: 614px; ">
<table  width="100%">
	<tr>
	<td align=""><img src="./Images/defect.jpg" height="120"></img></td>
	<td align=""><font face="arial narrow" size="10px" color="Orange"><b> Bug Tracking System</b></font></td>
	</tr>
</table>
<hr>
<br><br>

<table align="left" width="60%" border=0 cellpadding=12>
<tr><td>
<p align="justify"> <font face="arial narrow" color="F09514"><b>
The Project entitled BUG TRACKING SYSTEM is a web based and intranet application aimed for the tracking 
and resolution of bugs. All businesses have issues that need to be tracked and managed to resolution. Resolution 
of these issues requires the coordination of multiple individuals within and perhaps even outside the company.
This application can be used by all team members to coordinate their work and to make sure that reported bugs can 
use this application and enhancement requests wont be forgotten. In this way Tester delivers up to the minute 
project information and status to the team members everywhere to foster better communication and collaboration.
 The Online handling of reporting ensure that the project working hours will be prompt.
This also ensures well-disciplined authorization of users according to the project specification. 
Usage of this application increases the productivity and quality of the project.
</font></b></p>
</tr>
</table>
<table align="right" width="40%" border=0 cellpadding=12> 
<tr><td>

      <div class="wrap">
       <form action ="Login" method="post">
         <h2>Login Page</h2>
         <input type="text" name="userid" placeholder="Your username...." >
         <input type="password" name="password" placeholder="Your password...">
         <button type="submit" class="btn" >Login</button><br>
         <br><font face="arial narrow" color="red">If New User,click <a href="Register.jsp">here</a></font></br>

      
       </form>
      </div>
</table> 
</body>
</html>