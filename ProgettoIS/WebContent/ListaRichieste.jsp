<!-- 
Jsp che mostra sia le richieste di convenzione che le richieste di tirocinio

autori: Mario Procida

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Richieste di Convenzione e Tirocinio</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp" %>
		<div class="wrapper">
			<header class="masthead bg-primary text-white text-center" >
				<div class="container">
				<!--  Se l'utente è loggato ed è la Didattica -->
				<%
					String tipoUtente = (String) s.getAttribute("tipoUtente");
					if(email != null && password != null && tipoUtente.equals("Didattica")){ 
				%>
					<table>
						<tbody>
							<tr>
								<td>Data</td>
								<td>Stato</td>
								<td>Partita Iva Azienda</td>
								<td>Email</td>								
							</tr>
							
					<%
					
					Collection<?> convenzioni = (Collection<?>) request.getAttribute("listRichConvenzione");
		
					if (convenzioni != null && convenzioni.size() != 0) {
					Iterator<?> it = convenzioni.iterator();
			
						while (it.hasNext()) {
							Convenzione bean = (Convenzione) it.next();
				
					%>
						
						<tr>
							<td><%=bean.getData() %></td>
							<td><%=bean.getStato() %></td>
							<td><%=bean.getP_iva() %></td>
							<td><%=bean.getEmail() %></td>
						</tr>
							
						</tbody>
					</table>
					<%	} 
					}else{
					%>
					<!-- Se non sono presenti richieste nel DB -->
						<h3> Non sono presenti richieste</h3>
					<%} %>
					
				<!-- Se l'utente non è loggato o non è autorizzato a visualizzare questa pagina -->
				<%}else{
					
				%>
					<h3> Non sei autenticato o non sei autorizzato a visualizzare questa pagina.</h3>
				<%} %>
				</div>
			</header>
		</div>
		
		
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp" %>
</body>
</html>