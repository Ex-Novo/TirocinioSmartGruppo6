<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/styleFormRichiesta.css" rel="stylesheet">
<title>Questionario Valutativo azienda</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp" %>
		<div class="wrapper">
			<header class="masthead bg-primary text-white text-center" >
				<div class="container">
				<%
					
					String tipoUtente = (String) s.getAttribute("tipoUtente");
					if(tipoUtente != null && tipoUtente.equals("Studente")){
						boolean canFeed = (boolean) s.getAttribute("canFeed");
						if(canFeed){
				%>
							<form method="post" action="FeedBackAziendaControl">
								<div id="form"> 
									<h4>Valutazione Azienda</h4>
									<p><em>Inserire un numero di valutazione da 1 a 5</em> </p>
									
									<hr id="line">	
									<h5><em>Qualità del progetto di tirocinio</em></h5> <br>	
									<label>La durata del tirocinio è stata adeguata agli obiettivi formativi? </label> <br>
									<input class="input3" type="number" name="rating1" min="1" max="5" value="1" required /> <br>
								
									<label>Gli obiettivi formativi previsti sono stati raggiunti?</label> <br>
									<input class="input3" type="number" name="rating2" min="1" max="5" value="1" required /> <br>
									
									<hr id="line">	
									<h5><em>Qualità ente ospitante</em></h5> <br>	
									<label>Mansioni assegnate</label> <br>
									<input class="input3" type="number" name="rating3" min="1" max="5" value="1" required /> <br>
									
									<label>Assistenza del tutor ospitante</label> <br>
									<input class="input3" type="number" name="rating4" min="1" max="5" value="1" required /> <br>
									
									<hr id="line">	
									<h5><em>Qualità delle strutture universitarie addette alla gestione di tirocini</em></h5> <br>	
									<label>Le strutture hanno fornito informazioni chiare ed esaustive?</label> <br>
									<input class="input3" type="number" name="rating5" min="1" max="5" value="1" required /> <br>
									
									<label>Le strutture hanno fornito assistenza e disponibilità?</label> <br>
									<input class="input3" type="number" name="rating6" min="1" max="5" value="1" required /> <br>
									<br>
									
									<input type="hidden" name="tipo" value="confermaForm"/>
									<input type="submit" id="submit" name="submit" class="btn btn-info" value="Conferma form" />
								</div>
							</form>
				<%  }else{%> <h3> Hai già inviato un feedback</h3><%} %>
				<%}else{ %> <h3> Non sei autorizzato a visualizzare questa pagina</h3> <%} %>
				</div>
			</header>
		</div>
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp" %>			
</body>
</html>