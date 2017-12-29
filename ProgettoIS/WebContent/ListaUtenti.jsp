<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista utenti</title>
</head>
<body>
<%
	
	Collection<?> aziende = (Collection<?>) request.getAttribute("aziende");
    Collection<?> studenti = (Collection<?>) request.getAttribute("studenti");
    
    if (aziende != null && aziende.size() != 0) {
		Iterator<?> it = aziende.iterator();
		
		while (it.hasNext()) {
			Azienda bean = (Azienda) it.next();
			
			
			out.println(bean.getNomeAzienda());
			out.println(bean.getEmail());
		}
    }
    
    if (studenti != null && studenti.size() != 0) {
		Iterator<?> it = studenti.iterator();
		
		while (it.hasNext()) {
			Studente bean = (Studente) it.next();
			
			out.println("Nome Studente = ");
			out.println(bean.getNome());
			out.println("Matricola Studente = ");
			out.println(bean.getMatricola());
		}
    }

 %>
 
 
 
 </body>
</html>
