<!-- 
Jsp che mostra la lista di tutti gli utenti registrati

autori: Mario Procida

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista utenti</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp"%>
	<div class="wrapper">
		<header class="masthead bg-primary text-white text-center">

		<div class="container">

			<table>
				<tr>
					<td>
						<table>
							<label>ELENCO AZIENDE REGISTRATE</label>
							<tr>
								<th>NOME AZIENDA</th>
								<th>EMAIL</th>
							</tr>

							<%
								Collection<?> aziende = (Collection<?>) request.getAttribute("aziende");
								Collection<?> studenti = (Collection<?>) request.getAttribute("studenti");

								if (aziende != null && aziende.size() != 0) {
									Iterator<?> it = aziende.iterator();

									while (it.hasNext()) {
										Azienda bean = (Azienda) it.next();
							%>

							<tr>
								<td><%=bean.getNomeAzienda()%></td>
								<td><%=bean.getEmail()%></td>

							</tr>

							<%
								}
								}
							%>
						</table>
					</td>

					<td>
						<table>
							<label>ELENCO STUDENTI REGISTRATI</label>
							<tr>
								<th>NOME STUDENTE</th>
								<th>MATRICOLA</th>
							</tr>



							<%
								if (studenti != null && studenti.size() != 0) {
									Iterator<?> it = studenti.iterator();

									while (it.hasNext()) {
										Studente bean = (Studente) it.next();
							%>
							<tr>
								<td><%=bean.getNome()%> <%=bean.getCognome()%></td>
								<td><%=bean.getMatricola()%></td>

							</tr>

							<%
								}
								}
							%>
						</table>
					</td>
				</tr>
			</table>
		</div>
		</header>
	</div>

	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>
</body>
</html>
