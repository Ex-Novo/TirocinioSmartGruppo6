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
		HttpSession s = request.getSession();

		Collection<?> documenti = (Collection<?>) request.getAttribute("documenti");

		if (documenti != null && documenti.size() != 0) {
			Iterator<?> it = documenti.iterator();

			while (it.hasNext()) {

				Documento bean = (Documento) it.next();

				out.println("** -- Nome = " + bean.getNome());
				out.println("-- Tipo = " + bean.getTipo());
			}
		}
	%>


</body>
</html>