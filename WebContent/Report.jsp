<jsp:include page="./ManagerHeader.jsp" />
<%@page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>






    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    
</head>
<style type="text/css">

.button{

    background-color: #4CAF50;
    border: none;
    color: white;
    font-size: 15px
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 10px 8px;
    cursor: pointer;
       
}

</style>
 
 
 <body style="background-color:silver">
  <form name="testerForm" action="Report" onsubmit="return check()" method="post">
  	<center>

  		<table> 
  		 		  		
  		<tr><td align="right" colspan="2">
  		<input type="submit" class="button" value="Generate Report"></td></tr>  		  		  		
  	</table>
  	</center>
   </form>
   </body>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
<jsp:include page="./footer.jsp" /> 


</html>