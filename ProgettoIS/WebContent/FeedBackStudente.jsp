<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/styleFormRichiesta.css" rel="stylesheet">
<title>Questionario Valutativo studente</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp" %>
		<div class="wrapper">
			<header class="masthead bg-primary text-white text-center" >
				<div class="container">
				<%
					
					String tipoUtente = (String) s.getAttribute("tipoUtente");
					if(tipoUtente != null && tipoUtente.equals("Azienda")){
						boolean canFeed = (boolean) s.getAttribute("canFeed");
						if(canFeed){
				%>
						<form method="post" action="FeedBackStudenteControl">
							<div id="form"> 
								<h4>Valutazione Studente</h4>
								<p><em>Inserire un numero di valutazione da 1 a 5</em> </p>
								
								<hr id="line">	
								<label>Competenze informatiche possedute in ingresso dallo studente</label> <br>
								<input type="number" name="rating1" min="1" max="5" value="1" required /> <br>
							
								<label>Competenze acquisite al termine del tirocinio nella specifica disciplina</label> <br>
								<input type="number" name="rating2" min="1" max="5" value="1" required /> <br>
									
								<label>Soft skill (capacità di relazionarsi, di comunicare, di lavorare in team)</label> <br>
								<input type="number" name="rating3" min="1" max="5" value="1" required /> <br>
								<br>
								
								<input type="hidden" name="tipo" value="confermaForm"/>
								<input type="submit" name="submit" class="btn btn-info" value="Conferma form" />
							</div>
						</form>
						</div>
				<%  }else{%> <h3> Hai già inviato un feedback</h3><%} %>
				<%}else{ %> <h3> Non sei autorizzato a visualizzare questa pagina</h3> <%} %>
			</header>
		</div>
	<div class="bg-primary" id="push"></div>
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp" %>			
</body>
</html>