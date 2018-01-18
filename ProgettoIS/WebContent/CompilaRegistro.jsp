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
					if(tipoUtente != null && tipoUtente.equals("Azienda")){
						
				%>
							<form method="post" action="CompilaRegistroControl?tipo=sendAtt">
								<div id="form"> 
									<h4>Compilazione Registro</h4>
									
									
									<hr id="line">	
									<label>Data</label> <br>
									<input type="date" name="data" min="1" max="5" value="1" required /> <br>
								
									<label>Ore Lavoro</label> <br>
									<input type="number" name="oreLavoro" min="1" max="12" value="1" required /> <br>
									
									<hr id="line">		
									<label></label> <br>
									<textarea type="text" name="descrizione" cols="30" rows="10"></textarea>									
									<br>
									
									<input type="hidden" name="tipo" value="confermaForm"/>
									<input type="submit" id="submit" name="submit" class="btn btn-info" value="Conferma form" />
								</div>
							</form>
				<%}else{ %> <h3> Non sei autorizzato a visualizzare questa pagina</h3> <%} %>
				</div>
			</header>
		</div>
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp" %>			
</body>
</html>