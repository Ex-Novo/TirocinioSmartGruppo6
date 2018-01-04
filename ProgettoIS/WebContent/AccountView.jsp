<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tirocinio Smart</title>

</head>
<%@ include file="/header.jsp" %>
<body>
	
		<header class="masthead bg-primary text-white text-center">
			<div class="container">
						<%
							String tipoUtente= (String) s.getAttribute("tipoUtente");
							if(tipoUtente != null){
								if(tipoUtente.equals("Studente")){
									Studente bean = (Studente) request.getAttribute("bean");			
						%>
			
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
								type="matricola" name="matricola"
								value="<%=bean.getMatricola() %>" /> <br> <label>DATA
								NASCITA: </label><input readonly="readonly" type="date" name="dataNascita"
								value="<%=bean.getDataNascita() %>" /><br> <label>LUOGO
								NASCITA: </label><input readonly="readonly" type="luogoNascita"
								name="luogoNascita" value="<%=bean.getLuogoNascita() %>" /><br>
						</form>
						<%
								} else{
								Azienda bean = (Azienda) request.getAttribute("bean");			
						%>
			
						<form action="" method="post" id="B"
							position: absolute">
							<label>NOME AZIENDA: </label><input readonly="readonly"
								type="azienda" name="nomeAzienda"
								value="<%=bean.getNomeAzienda() %>" /> <br> <label>SEDE:
							</label><input readonly="readonly" type="sede" name="sede"
								value="<%=bean.getSede() %>" /> <br> <label>EMAIL: </label> <input
								readonly="readonly" type="email" name="email"
								value="<%=bean.getEmail() %>" /><br> <label>PARTITA
								IVA: </label><input readonly="readonly" type="piva" name="partitaIva"
								value="<%=bean.getP_iva()%>" /> <br> <label>TELEFONO:
							</label><input readonly="readonly" type="telefono" name="telefono" value="<%=bean.getTelefono() %>" /> <br>
						</form>
						<%
								} 
							}
						%>
			</div>
		</header>


	<!-- Footer -->
	<footer class="footer text-center">
	<div class="container">
		<div class="row">
			<div class="col-md-4 mb-5 mb-lg-0">
				<h4 class="text-uppercase mb-4">Location</h4>
				<p class="lead mb-0">
					2215 John Daniel Drive <br>Clark, MO 65243
				</p>
			</div>
			<div class="col-md-4 mb-5 mb-lg-0">
				<h4 class="text-uppercase mb-4">Around the Web</h4>
				<ul class="list-inline mb-0">
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-facebook"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-google-plus"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-twitter"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-linkedin"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-dribbble"></i>
					</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h4 class="text-uppercase mb-4">About Freelancer</h4>
				<p class="lead mb-0">
					Freelance is a free to use, open source Bootstrap theme created by
					<a href="http://startbootstrap.com">Start Bootstrap</a>.
				</p>
			</div>
		</div>
	</div>
	</footer>

	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; TirocinioSmart Gruppo 6</small>
		</div>
	</div>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>

	

</body>

</html>
