<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
		HttpSession s = request.getSession();
	
		String email = (String)s.getAttribute("email");
		String password=(String)s.getAttribute("password");
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Test</title>
</head>
<body>
<%if(email != null && password != null){ %>
	<form action="LogoutControl" method="post">

		<input type="submit" placeholder="Logout" />
	</form>
<%} else {%>

Simone Torluccio è un Alpha Man

<%} %>	
	
</body>
</html>