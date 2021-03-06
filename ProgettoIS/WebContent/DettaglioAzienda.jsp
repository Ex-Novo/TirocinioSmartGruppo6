<!-- 
Jsp che mostra in dettaglio il tirocinio offerto dall'azienda

autori: Mario Procida, Anna Maria Rosanova

 -->

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
					double valutazione = (double) request.getAttribute("valutazione");
					Azienda a = (Azienda) request.getAttribute("azienda");
					Tirocinio t = (Tirocinio) request.getAttribute("tirocinio");	
					System.out.println(valutazione);
					if(email != null && password != null){
				
				
				%>
				<table>
					<tbody>
						<tr>
							<td>Descrizione Attivit� Tirocinio</td>
							<td><%=t.getDescrizione() %></td>
						</tr>
						<tr>
							<td>Numero Posti Disponibili</td>
							<td><%=t.getNumPosti() %></td>
						</tr>
						<tr>
							<td>Sede</td>
							<td><%=a.getSede() %></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><%=a.getTelefono() %></td>
						</tr>
						<tr>
							<td>Partita Iva</td>
							<td><%=a.getP_iva() %></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><%=a.getEmail() %></td>
						</tr>
						<tr>
							<td>Tutor Aziendale</td>
							<td><%=a.getTutorAziendale() %></td>
						</tr>
								<td>FeedBack Complessivo Tirocinanti</td>
								<td>
									<span class="fa fa-star <%if(valutazione >= 1){%>checked<%}%>"></span>
									<span class="fa fa-star <%if(valutazione >= 2){%>checked<%}%>"></span>
									<span class="fa fa-star <%if(valutazione >= 3){%>checked<%}%>"></span>
									<span class="fa fa-star <%if(valutazione >= 4){%>checked<%}%>"></span>
									<span class="fa fa-star <%if(valutazione == 5){%>checked<%}%>"></span>
								</td>
						<tr>
							<td>Richiesta Tirocinio</td>
							<td>
								<a class="btn btn-info" href="checkTiro?t=<%=t.getIdTirocinio()%>&nomeAz=<%=a.getNomeAzienda()%>">Richiedi tirocinio</a>
							</td>								
						</tr>	
							
					</tbody>
				</table>
				<%}else{ %>
				<h3>Non sei loggato. Effettua il login</h3>
				<%} %>
			</div>
		</header>
	</div>
	
	<div id="push"></div>
	<%@ include file="/footer.jsp"%>
</body>
</html>