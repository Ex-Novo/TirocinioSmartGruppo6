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
<%@ include file="/header.jsp"%>
<body>
	<header class="masthead bg-primary text-white text-center">
	<div id="wrapper">

		<div class="container">
			<%
							String tipoUtente= (String) s.getAttribute("tipoUtente");
							if(tipoUtente != null){
								if(tipoUtente.equals("Studente")){
									Studente bean = (Studente) request.getAttribute("bean");			
						%>
			<a class="btn btn-info" href="documents" method="post">Visualizza
				documenti</a>
			<form action="" method="post" id="A" style="position: relative">
				<input type="hidden" name="tipo" value="Studente" /> <br> <label>NOME:
				</label><input readonly="readonly" type="nome" name="nome"
					value="<%=bean.getNome()%>" /> <br> <label>COGNOME: </label><input
					readonly="readonly" type="cognome" name="cognome"
					value="<%=bean.getCognome() %>" /><br> <label>EMAIL:
				</label><input readonly="readonly" type="email" name="email"
					value="<%=bean.getEmail() %> " /><br> <label>CODICE
					FISCALE: </label><input readonly="readonly" type="codicefiscale"
					name="codiceFiscale" value=<%=bean.getCodiceFiscale() %> /> <br>
				<label>MATRICOLA: </label><input readonly="readonly"
					type="matricola" name="matricola" value="<%=bean.getMatricola() %>" />
				<br> <label>DATA NASCITA: </label><input readonly="readonly"
					type="date" name="dataNascita" value="<%=bean.getDataNascita() %>" /><br>
				<label>LUOGO NASCITA: </label><input readonly="readonly"
					type="luogoNascita" name="luogoNascita"
					value="<%=bean.getLuogoNascita() %>" /><br>
			</form>
			<%
								} else{
								Azienda bean = (Azienda) request.getAttribute("bean");			
						%>

			<form action="" method="post" id="B"position:absolute">
				<label>NOME AZIENDA: </label><input readonly="readonly"
					type="azienda" name="nomeAzienda"
					value="<%=bean.getNomeAzienda() %>" /> <br> <label>SEDE:
				</label><input readonly="readonly" type="sede" name="sede"
					value="<%=bean.getSede() %>" /> <br> <label>EMAIL: </label> <input
					readonly="readonly" type="email" name="email"
					value="<%=bean.getEmail() %>" /><br> <label>PARTITA
					IVA: </label><input readonly="readonly" type="piva" name="partitaIva"
					value="<%=bean.getP_iva()%>" /> <br> <label>TELEFONO:
				</label><input readonly="readonly" type="telefono" name="telefono"
					value="<%=bean.getTelefono() %>" /> <br>
			</form>
			<%
								}
							}else{
								
							
						%>
			<h3>Non sei loggato. Effettua il login.</h3>
			<%
							}
						%>
		</div>

	</div>
	</header>
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>

</body>

</html>
