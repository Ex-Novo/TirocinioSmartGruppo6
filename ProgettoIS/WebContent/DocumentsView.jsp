<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tirocinio Smart - Documenti</title>
</head>


<body>
<%@ include file="/header.jsp" %>

	<header class="masthead bg-primary text-white text-center" >
		<div class="container">
			    <!--  Prende i l'arraylist dei documenti caricati dalla request -->
				<%
					Collection<?> documenti = (Collection<?>) request.getAttribute("documenti");
			
					if (documenti != null && documenti.size() != 0) {
						Iterator<?> it = documenti.iterator();
			
						while (it.hasNext()) {
			
							Documento bean = (Documento) it.next();
			
							out.println("** -- Nome = " + bean.getNome());
							out.println("-- Tipo = " + bean.getTipo());
						}
					}else{
						
					
				%>
				
				<h3>Non hai caricato nessun documento.</h3>
				<%
					}
				%>
				
				<!-- Form per upload di file -->
				<form method="post" action="UploadControl" name="echo" enctype="multipart/form-data">
					<fieldset>
						<legend>Seleziona il file</legend>
						<input type="file" name="file"	size="50"/> <br>
						<input type="submit" value="Invia">
						<input type="reset" value="Reset">	
					</fieldset>
				</form>
		</div>
	</header>
<%@include file="/footer.jsp" %>
</body>
</html>