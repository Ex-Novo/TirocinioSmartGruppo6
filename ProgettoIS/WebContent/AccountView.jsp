<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Tirocinio Smart</title>

</head>

<body class="bg-primary">
<%@ include file="/header.jsp"%>
	<div id="wrapper">
		<header class="masthead bg-primary text-white text-center">
		<div class="container">
			<%
				String tipoUtente = (String) s.getAttribute("tipoUtente");
				if (tipoUtente != null) {
					if (tipoUtente.equals("Studente")) {
						Studente bean = (Studente) request.getAttribute("bean");
			%>

			<form action="" method="post" id="A">
				<table>
					<tbody>
						<tr>
							<td><b>NOME:</b></td>
							<td><%=bean.getNome()%></td>
						</tr>
						<tr>
							<td><b>COGNOME:</b></td>
							<td><%=bean.getCognome()%></td>
						</tr>
						<tr>
							<td><b>EMAIL:</b></td>
							<td><%=bean.getEmail()%></td>
						</tr>
						<tr>
							<td><b>CODICE FISCALE:</b></td>
							<td><%=bean.getCodiceFiscale()%></td>
						</tr>
						<tr>
							<td><b>MATRICOLA:</b></td>
							<td><%=bean.getMatricola()%></td>
						</tr>
						<tr>
							<td><b>DATA NASCITA:</b></td>
							<td><%=bean.getDataNascita()%></td>
						</tr>
						<tr>
							<td><b>LUOGO NASCITA:</b></td>
							<td><%=bean.getLuogoNascita()%></td>
						</tr>
						<tr>
							<td><b>DOCUMENTI CARICATI:</b></td>
							<td><a class="btn btn-info" href="documents" method="post">Visualizza
									documenti </a></td>
						</tr>
					</tbody>
				</table>
			</form>
			<%
				} else {
						Azienda bean = (Azienda) request.getAttribute("bean");
			%>

			<form action="" method="post" id="B">
				<table>
					<tbody>
						<tr>
							<td><b>NOME AZIENDA:</b></td>
							<td><%=bean.getNomeAzienda()%></td>
						</tr>
						<tr>
							<td><b>SEDE:</b></td>
							<td><%=bean.getSede()%></td>
						</tr>
						<tr>
							<td><b>EMAIL:</b></td>
							<td><%=bean.getEmail()%></td>
						</tr>
						<tr>
							<td><b>PARTITA IVA:</b></td>
							<td><%=bean.getP_iva()%></td>
						</tr>
						<tr>
							<td><b>TELEFONO:</b></td>
							<td><%=bean.getTelefono()%></td>
						</tr>
						<tr>
							<td><b>DOCUMENTI CARICATI:</b></td>
							<td><a class="btn btn-info" href="documents" method="post">Visualizza
									documenti </a></td>
						</tr>
					</tbody>
				</table>
			</form>
			<%
				}
				} else {
			%>
			<h3>Non sei loggato. Effettua il login.</h3>
			<%
				}
			%>
		</div>
		</header>
	</div>

	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>

</body>

</html>
