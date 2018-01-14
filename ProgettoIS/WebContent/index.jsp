<!-- 
Jsp che mostra la home del sito e mostra a seconda dell'utente loggato una serie di funzionalità

autori: Mario Procida, Anna Maria Rosanova, Angelo Lucia, Michele Salerno

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
					<h2 class="text-uppercase mb-0"> Funzionalità azienda</h2>
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
					<h2 class="text-uppercase mb-0">Funzionalità Studente</h2>
				</div>
				<div class="text-white text-center">
					<a class="btn btn-info" href="#">Consulta Registro</a>
					<a class="btn btn-info" href="FeedBackAziendaControl?tipo=sendValutazione">FeedBack Azienda</a>	
				</div>
			<%
				}
			%>
		
			<!-- Home didattica -->
			<%	
			
				if(tipoUtente.equals("Didattica")){
		
			%>
				<div class="text-white text-center">
					<h2 class="text-uppercase mb-0"> Funzionalità didattica</h2>
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
