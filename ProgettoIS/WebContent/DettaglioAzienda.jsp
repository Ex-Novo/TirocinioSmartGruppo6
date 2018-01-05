<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio azienda</title>
</head>
<body class="bg-primary">

	<%@ include file="/header.jsp"%>
	
	<div id="wrapper">
		<header class="masthead bg-primary text-white text-center">
			 <div class="container">
				<%
				
				Azienda a = (Azienda) request.getAttribute("azienda");
				Tirocinio t = (Tirocinio) request.getAttribute("tirocinio");	
				
				out.println("Nome azienda" + a.getNomeAzienda());
				out.println("-- Tutor aziendale" + a.getTutorAziendale());
				
				out.println("-- Descrizione tirocinio = " + t.getDescrizione());
				out.println("-- Numero posti disponibili = "+ t.getNumPosti());
				
				
				%>
			</div>
		</header>
	</div>
	
	<div id="push"></div>
	<%@ include file="/footer.jsp"%>
</body>
</html>