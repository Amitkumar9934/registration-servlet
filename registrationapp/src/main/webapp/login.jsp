<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login here...</h2>
 <form action="verifyLogin" method="post">
 Username <input type="text" name="email" />
 Password <input type="password" name="password" />
 <input type="submit" value="Login" />
 </form>
 <%
    if(request.getAttribute("msg")!=null){
    	out.print(request.getAttribute("msg"));
    }
 %>
</body>
</html>