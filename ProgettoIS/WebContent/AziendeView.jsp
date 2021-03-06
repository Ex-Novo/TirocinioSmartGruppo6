<!-- 
Jsp che mostra le aziende convenzionate

autori: Mario Procida, Anna Maria Rosanova

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,dao.*,bean.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="bg-primary">

	<%@ include file="/header.jsp"%>
	
	<div id="wrapper">
		 <header class="masthead bg-primary text-white text-center">
		 	<div class="container">
			 	<table>
					<tbody>
						<tr>
							<th>Nome Azienda</th>
							<th>Sede</th>
							<th>Telefono</th>
							<th>Dettagli Azienda</th>							
						</tr>
					<%
					
					
					Collection<?> aziende = (Collection<?>) request.getAttribute("aziendeConvenzionate");
				
					if (aziende != null && aziende.size() != 0) {
						Iterator<?> it = aziende.iterator();
						
						while (it.hasNext()) {
							Azienda bean = (Azienda) it.next();
							
					%>
							<tr>
								<td><%=bean.getNomeAzienda() %></td>
								<td><%=bean.getSede() %></td>
								<td><%=bean.getTelefono() %></td>	
								<td>
									<form action="detailsAz?piva=<%=bean.getP_iva()%>&email=<%=bean.getEmail() %>" method="post"> 
										<input type="submit" class="btn btn-info" value="Visualizza dettaglio" >
									</form>
								</td>								
							</tr>
								
					<%
						}
				    }
				
					%>
					</tbody>
				</table>
			</div>
		</header>
	</div>
	
	
	<div id="push"></div>
	<%@ include file="/footer.jsp"%>
</body>
</html>