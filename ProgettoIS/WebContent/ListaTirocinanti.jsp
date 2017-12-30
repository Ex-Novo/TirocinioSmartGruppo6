<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista tirocinanti</title>
</head>
<body>
<% 

    
	Collection<?> studenti = (Collection<?>) request.getAttribute("studenti");
   
	if (studenti != null && studenti.size() != 0) {
		Iterator<?> it = studenti.iterator();
		
		while (it.hasNext()) {
	
			Studente bean = (Studente) it.next();
			
			out.println("** -- Nome = " + bean.getNome());
			out.println("-- Cognome = " + bean.getCognome());
		}
	}
			
%>
</body>
</html>