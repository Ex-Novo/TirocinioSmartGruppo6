<!-- 
Jsp che mostra la lista dei documenti caricati

autori: Mario Procida, Anna Maria Rosanova

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*,dao.*,bean.*,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tirocinio Smart - Documenti</title>
</head>


<body class="bg-primary">
	<%@ include file="/header.jsp"%>
	
	<div id="wrapper">
		<header class="masthead bg-primary text-white text-center">
			<div class="container">
	
				<!-- Controlla se l'utente è loggato -->
				<%
						if(email == null && password == null){
					
					%>
				<h3>Non sei loggato. Effettua il login.</h3>
	
				<!-- Mostra i documenti se l'utente è loggato -->
				<%}else{ %>
				<h3> File caricati</h3>
				
						<!--  Prende i l'arraylist dei documenti caricati dalla request e imposta la path per leggere i file nella cartella personale dell'utente-->
						<%
							Collection<?> documenti = (Collection<?>) request.getAttribute("documenti");
					
							if (documenti != null && documenti.size() != 0) {
								Iterator<?> it = documenti.iterator();
					
								while (it.hasNext()) {
					
									Documento bean = (Documento) it.next();
									
									String filename = application.getInitParameter("fsroot") + File.separator + s.getAttribute("uniqueID") + File.separator + bean.getNome();
									
						%>	
									<table>
										<tbody>
											<tr>
												<td><b>NOME:</b></td>
												<td><%=bean.getNome()%></td>
												<td> <a href="DownloadControl?filename=<%=bean.getNome()%>&tipo=myFile">Scarica</a> </td>
											</tr>
										</tbody>
									</table>
						<% 			
								}
							}
							else{
								
							
						%>

						<h3>Non hai caricato nessun documento.</h3>
						<%
							}
						
						%>

						<!-- Form per upload di file -->
						<form method="post" action="UploadControl" name="echo"
							enctype="multipart/form-data">
							<fieldset>
								<legend>Seleziona il file</legend>
								<input type="file" name="file" size="50" /> <br> <input
									type="submit" value="Invia"> <input type="reset"
									value="Reset">
							</fieldset>
						</form>

						<%} %>
					
		</div>

         </header>
	</div>
	
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>
</body>
</html>