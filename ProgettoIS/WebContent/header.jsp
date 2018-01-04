<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,dao.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<!-- Prende la sessione e salva i dati dell'utente se loggato  -->
<%
		HttpSession s = request.getSession();
	
		String email = (String)s.getAttribute("email");
		String password = (String)s.getAttribute("password");
			
%>

<head>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Tirocinio Smart</title>
	
	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom fonts for this template -->
	<link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- Plugin CSS -->
	<link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
	
	<!-- Custom styles for this template -->
	<link href="css/freelancer.min.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/loginValidation.js"></script>
	<script type="text/javascript" src="js/regValidation.js"></script>
</head>

<body id="page-top">
	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase"
		id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="index.jsp"><img src="img\logo.png" height="80e"></a>
		<button
			class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded"
			type="button" data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		
		
		
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
			<!-- Controlla se l'utente è loggato e in caso positivo mostra i tasti per login e registrazione nella navigation bar-->
			<%
		
				if(email == null && password == null){
		
		
			%>
				<!-- Login e registrazione -->
				<li class="nav-item mx-0 mx-lg-1">
				<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#" id="loginform" method="post">Login</a>
					<div class="login">
						<div class="arrow-up"></div>
						<div class="formholder">
							<div class="randompad">
								<fieldset>
									<form action="LoginControl" onSubmit="return loginValidation(this);" method="post">
										<input type="radio" name="tipo" checked="checked" value="Studente">Studente 
										<input type="radio" name="tipo" value="Azienda">Azienda 
										<input type="radio" name="tipo" value="Didattica">Didattica
										
										<br> <label name="email">Email</label> <input type="email" name="email" required />
										<label name="password">Password</label> <input type="password" name="password" required />
										<input type="submit" value="Login" />
									</form>
									

								</fieldset>
							</div>
						</div>
					</div>
				</li>
				<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#" id="registerform" method="post">Registrati</a>
					<div class="register">
						<div class="arrow-up2"></div>
						<div class="formholder2">
							<div class="randompad">
								<fieldset>

									<form action="RegistrazioneControl" onSubmit="return regValidation(this);" method="post" id="A" style="position: relative">
										<input type="hidden" name="tipo" value="Studente"  />
										<input type="nome" name="nome" placeholder="Nome" pattern="^[A-Za-z]+$" title="Il nome può contenere solo lettere" required /> 
										<input type="cognome" name="cognome" placeholder="Cognome" pattern="^[A-Za-z]+$" title="Il cognome può contenere solo lettere" required />
										<input type="email" name="email" placeholder="Email" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Formato email rossi@mail.com" required />
										<input type="password" name="password" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" placeholder="Password" maxlength="15" minlength="4" required />
										<input type="password" name="confermaPsw" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');" placeholder="Conferma Password" required />
										<input type="nome" name="codiceFiscale" placeholder="Codice Fiscale" pattern="[A-Za-z0-9]+" required /> 
										<input type="matricola" name="matricola" placeholder="Matricola" pattern="^[0-9]+$" title="La matricola può contenere solo numeri" required /> 
										<input type="date" name="dataNascita" required /> 
										<input type="nome" name="luogoNascita" placeholder="Luogo di Nascita" pattern="^[A-Za-z]+$" title="Il luogo può contenere solo lettere" required />
										<input type="submit" value="Registrati" />
									</form>
									<form action="RegistrazioneControl" onSubmit="return regValidation(this);" method="post" id="B" style="visibility: hidden; position: absolute; top: -1px">
										<input type="hidden" name="tipo" value="Azienda"  />
										<input type="nome" name="nomeAzienda" placeholder="Nome Azienda" pattern="^[A-Za-z]+$" title="Il nome può contenere solo lettere" required /> 
										<input type="sede" name="sede" placeholder="Sede" pattern="^[A-Za-z]+$" title="La sede può contenere solo lettere" required /> 
										<input type="email" name="email" placeholder="Email" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Formato email rossi@mail.com" required />
										<input type="piva" name="partitaIva" placeholder="Partita Iva" pattern="^[0-9]+$" title="Solo numeri consentiti" required/> 
										<input type="telefono" name="telefono" placeholder="Numero di telefono" pattern="^[0-9]+$" title="Solo numeri consentiti" required/> 
										<input type="password" name="password" placeholder="Password" maxlength="15" minlength="4" required />
										<input type="password" name="confermaPsw" placeholder="Conferma Password" required/>
										<input type="submit" value="Registrati" />
									</form>
									<br>
									<br>
									<form action="">
										<center>
											<input type="radio" name="RadioB" onclick="hideB()" value="Studente" checked="checked"> 
											Studente 
											<input type="radio" name="RadioB" onclick="hideA()" value="Azienda">
											Azienda
										</center>
										<br> 
									</form>
								</fieldset>
							</div>
						</div>
					</div>
				</li>
				
				<%
				 } else {
				%>
				<!-- Logout -->
				<li class="nav-item mx-0 mx-lg-1">
					<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="logout" method="post">Logout</a>
				</li>
				
				<li class="nav-item mx-0 mx-lg-1">
					<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="profile" method="post"><%=email %></a>
				</li>

				<%
				}
				%>
			</ul>
		</div>
	</div>
	</nav>
	
	<!-- LoginRegisterForm -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="js/general.js"></script>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/freelancer.min.js"></script>

	<!-- JS form action -->
	<script type="text/javascript">
          function get_action() { // inside script tags
        return form_action;
    }
    </script>

	<form action=get_action()>...</form>
</body>
</html>