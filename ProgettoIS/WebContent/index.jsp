<!-- 
Jsp che mostra la home del sito e mostra a seconda dell'utente loggato una serie di funzionalità

autori: Mario Procida, Anna Maria Rosanova, Angelo Lucia, Michele Salerno

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tirocinio Smart</title>

</head>


<body class="bg-primary">
<%@ include file="/header.jsp" %>
	<div class="wrapper">
		<!-- Header -->
		<header class="masthead bg-primary text-white text-center" >
			<div class="container">
				<a href="aziende" ><img  class="img-fluid mb-5 d-block mx-auto" src="img/profile.png" alt=""></a>
				<h1 class="text-uppercase mb-0">Aziende Convenzionate</h1>
			</div>
			
		</header>
		
		<!--  Check per il login effettuato -->
		<% if(email != null && password != null){ %>
		
			<!-- Home Azienda -->
			<% 
			
				String tipoUtente = (String) s.getAttribute("tipoUtente");
				if(tipoUtente.equals("Azienda")) {
			%>
				<div class="text-white text-center">
					<h3> Funzionalità azienda</h3>
				</div>
				<div class="text-white text-center">
					<a class="btn btn-info" href="checkConv">Richiedi convenzione</a>
					<a class="btn btn-info" href="tirocinanti">Lista Tirocinanti</a>	
				</div>
			<%
				}
			%>
		
			<!-- Home Studente -->
			<%	
			
				if(tipoUtente.equals("Studente")){
		
			%>
				<div class="text-white text-center">
					<h3> Funzionalità Studente</h3>
				</div>
				<div class="text-white text-center">
					<a class="btn btn-info" href="RichiestaTirocinio.jsp">FeedBack Azienda</a>
					<a class="btn btn-info" href="consultaRegistro">Consulta Registro</a>	
				</div>
			<%
				}
			%>
		
			<!-- Home didattica -->
			<%	
			
				if(tipoUtente.equals("Didattica")){
		
			%>
				<div class="text-white text-center">
					<h3> Funzionalità didattica</h3>
				</div>
				<div class="text-white text-center">
					<a class="btn btn-info" href="utenti">Lista Utenti</a>
					<a class="btn btn-info" href="richieste">Visualizza Richieste</a>	
				</div>
			<%
				}
			%>
		
		<%	} %>
	</div>
	<!-- Crea spazio tra il footer e il corpo centrale -->
	<div class="bg-primary" id="push"></div>
<%@include file="/footer.jsp" %>
</body>

</html>
