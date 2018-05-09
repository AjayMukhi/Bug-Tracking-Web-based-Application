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
<body onload="return check()"><center>
<table width="100%">
	<tr>
	<td align=""><img src="./Images/defect.jpg" height="120"></img></td>
	<td align=""><font face="arial narrow" size="5px" color="orange"><b> Bug Tracking System</b></font></td>
	</tr>
</table>
<hr>
<br><br>
<table width="100%" border=0 cellpadding=12 >
<tr><td>

      <div class="wrap">
         <h2>Login Form</h2>
         <input type="text" name="username" placeholder="Your username...." >
         <input type="password" name="password" placeholder="Your password...">
         <button class="btn">login</button>
      
      
      
      </div>


</body>
</html>