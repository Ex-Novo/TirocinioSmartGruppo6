<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro studente-</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp"%>
	<div class="wrapper">
		<header class="masthead bg-primary text-white text-center">
		<div class="container">

			<!--  Se l'utente è loggato ed è la Studente -->
			<%
				String tipoUtente = (String) s.getAttribute("tipoUtente");
				if (email != null && password != null && tipoUtente.equals("Studente")) {
			%>
			<!--  Lista attività -->
			<table>
				<tr>
					<th>Registro Studente</th>
				</tr>
				<tr>
					<th>Data</th>
					<th>Ore</th>
					<th>Descrizione</th>
				</tr>

				<%
					Collection<?> activities = (Collection<?>) request.getAttribute("activities");
						if (activities != null && activities.size() != 0) {
							Iterator<?> it = activities.iterator();

							while (it.hasNext()) {
								Attivita bean = (Attivita) it.next();
				%>

								<tr>
									<td><%=bean.getData()%></td>
									<td><%=bean.getOre()%></td>
									<td><%=bean.getDescrizione()%></td>
								</tr>
								<%
										}
									%>
				
							</table>
							<br>
						<%
							} else {
						%>
			<!-- Se non sono presenti richieste nel DB -->
			<h3>Non sono presenti attivita</h3>
			<%
				}
			%>

			<!-- Se l'utente non è loggato o non è autorizzato a visualizzare questa pagina -->
			<%
				} else {
			%>
			<h3>Non sei autenticato o non sei autorizzato a visualizzare
				questa pagina.</h3>
			<%
				}
			%>
		</div>
		</header>
	</div>
	<div class="bg-primary" id="push"></div>
</body>
</html>