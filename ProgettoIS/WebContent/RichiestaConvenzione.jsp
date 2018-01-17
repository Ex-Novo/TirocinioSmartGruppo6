
<!-- 
Jsp che permette di compilare una form per richiedere una convenzione

autori: Mario Procida

 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,bean.*,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/styleFormRichiesta.css" rel="stylesheet">
<title>Richiesta convenzione</title>
</head>
<body class="bg-primary">

	<%@ include file="/header.jsp"%>


	<div id="wrapper">

		<!--  Form per la richiesta di convenzione -->
		<header class="masthead bg-primary text-white text-center">
		<div class="container">

			<!--  Se l'utente è loggato mostra la form -->
			<%
			if(email != null && password != null){
				String tipoUtente = (String) s.getAttribute("tipoUtente");
				boolean canRequest = (boolean) s.getAttribute("canRequest");
				if(canRequest && tipoUtente.equals("Azienda")) {
			%>
		
				<form action="rConv" method="post">
					<div id="form">
						<input type="hidden" name="tipo" value="confermaForm"> 
						<h4>Richiesta Convenzione</h4>
						
						<label>Tutor Aziendale</label> <br>
						<input type="text" name="tutorAziendale" pattern="[a-zA-Z\\s']+" required /> <br>
					
						<label>Numero posti offerti</label> <br>
						<input type="number" min="0" name="numPosti" required /> <br>
							
						<label>Descrizione tirocinio</label> <br>
						<textarea type="text" name="descrizione" cols="30" rows="10"></textarea>
						<br>
						
						<input id="submit" type="submit" name="submit" class="btn btn-info" value="Conferma form" />
					</div>
				</form>
			
			
			<%
				} else {
			%>
			<h3>Non sei autorizzato a visualizzare questa pagina</h3>
			<%
				}
			}
			%>
		</div>
		</header>
	</div>


	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>

</body>
</html>