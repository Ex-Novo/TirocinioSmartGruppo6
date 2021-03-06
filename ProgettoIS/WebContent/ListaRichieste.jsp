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
	<%@ include file="/header.jsp"%>
	<div class="wrapper">
		<header class="masthead bg-primary text-white text-center">
		<div class="container">

			<!--  Se l'utente � loggato ed � la Didattica -->
			<%
				String tipoUtente = (String) s.getAttribute("tipoUtente");
				if (email != null && password != null && tipoUtente.equals("Didattica")) {
			%>
			<!--  Lista convenzioni -->
			<table>
				<tr>
					<th>Richieste di Convenzione</th>
				</tr>
				<tr>
					<th>Data</th>
					<th>Stato</th>
					<th>Partita Iva Azienda</th>
					<th>Documento Richiesta</th>
				</tr>

				<%
					Collection<?> convenzioni = (Collection<?>) request.getAttribute("listRichConvenzione");

						if (convenzioni != null && convenzioni.size() != 0) {
							Iterator<?> it = convenzioni.iterator();

							while (it.hasNext()) {
								Convenzione bean = (Convenzione) it.next();
				%>

				<tr>
					<td><%=bean.getData()%></td>
					<td><%=bean.getStato()%></td>
					<td><%=bean.getP_iva()%></td>
					<td><a class="btn btn-info"
						href="DownloadControl?filename=<%=bean.getNomeFile()%>&piva=<%=bean.getP_iva()%>&tipo=convenzione">Scarica</a>
					</td>
					<td><a class="btn btn-success"
						href="ApprovaConvenzioneControl?piva=<%=bean.getP_iva()%>&tipo=accetta">Accetta</a>
					</td>
					<td><a class="btn btn-danger"
						href="ApprovaConvenzioneControl?piva=<%=bean.getP_iva()%>&tipo=rifiuta">Rifiuta</a>
					</td>
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
			<h3>Non sono presenti richieste di convenzione</h3>
			<%
				}
			%>

			<!--  Lista tirocini -->

			<table>
				<tr>
					<th>Richieste di Tirocinio</th>
				</tr>
				<tr>
					<th>Data</th>
					<th>Stato</th>
					<th>Matricola Studente</th>
					<th>Documento Richiesta</th>
				</tr>
				<%
					Collection<?> rTirocini = (Collection<?>) request.getAttribute("listRichTirocinio");

						if (rTirocini != null && rTirocini.size() != 0) {
							Iterator<?> it = rTirocini.iterator();

							while (it.hasNext()) {
								RichiestaTirocinio bean = (RichiestaTirocinio) it.next();
				%>

				<tr>
					<td><%=bean.getData()%></td>
					<td><%=bean.getStatus()%></td>
					<td><%=bean.getMatricola()%></td>
					<td><a class="btn btn-info"
						href="DownloadControl?filename=<%=bean.getNomeFile()%>&matricola=<%=bean.getMatricola()%>&tipo=tirocinio">Scarica</a>
					</td>
					<td><a class="btn btn-success"
						href="ApprovaTirocinioControl?matricola=<%=bean.getMatricola()%>&tipo=accetta">Accetta</a>
					</td>
					<td><a class="btn btn-danger"
						href="ApprovaTirocinioControl?matricola=<%=bean.getMatricola()%>&tipo=rifiuta">Rifiuta</a>
					</td>
				</tr>
				<%
						}
					%>
			</table>
			<%
				} else {
			%>
			<!-- Se non sono presenti richieste nel DB -->
			<br> <br>
			<h3>Non sono presenti richieste di tirocinio</h3>
			<%
				}
			%>

			<!-- Se l'utente non � loggato o non � autorizzato a visualizzare questa pagina -->
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