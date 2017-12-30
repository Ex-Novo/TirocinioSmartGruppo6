<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	Collection<?> aziende = (Collection<?>) request.getAttribute("aziendeConvenzionate");
	
	if (aziende != null && aziende.size() != 0) {
		Iterator<?> it = aziende.iterator();
		
		while (it.hasNext()) {
			Azienda bean = (Azienda) it.next();
			
			out.println(bean.getNomeAzienda());
			out.println(bean.getEmail());%>
			<form action="detailsAz?piva=<%=bean.getP_iva()%>&email=<%=bean.getEmail() %>" method="post"> 
				<input type="submit" value="Visualizza dettaglio" >
			</form><%
		}
    }

	
	%>
	
</body>
</html>