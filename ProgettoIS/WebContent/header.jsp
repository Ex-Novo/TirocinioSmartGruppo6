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

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet"
	type="text/css">

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
		<a class="navbar-brand js-scroll-trigger" href="#page-top"><img
			src="img\logo.png" height="80e"></a>
		<button
			class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded"
			type="button" data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#" id="loginform" method="post">Login</a>
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
										<input type="submit" value="Login" /><br> <a href="">Hai dimenticato la password?</a>
									</form>
									

								</fieldset>
							</div>
						</div>
					</div></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#" id="registerform" method="post">Registrati</a>
					<div class="register">
						<div class="arrow-up2"></div>
						<div class="formholder2">
							<div class="randompad">
								<fieldset>

									<form action="RegistrazioneControl" onSubmit="return regValidation(this);" method="post" id="A" style="position: relative">
										<input type="hidden" name="tipo" value="Studente"  />
										<input type="nome" name="nome" placeholder="Nome" required /> 
										<input type="cognome" name="cognome" placeholder="Cognome" required />
										<input type="email" name="email" placeholder="Email" required />
										<input type="password" name="password" placeholder="Password" required />
										<input type="password" name="confermaPsw" placeholder="Conferma Password" required />
										<input type="codicefiscale" name="codiceFiscale" placeholder="Codice Fiscale" required /> 
										<input type="matricola" name="matricola" placeholder="Matricola" pattern="/^[0-9]+$/" title="La matricola può contenere solo numeri" required /> 
										<input type="date" name="dataNascita" required /> 
										<input type="luogoNascita" name="luogoNascita" placeholder="Luogo di Nascita" required />
										<input type="submit" value="Registrati" />
									</form>
									<form action="RegistrazioneControl" onSubmit="return regValidation(this);" method="post" id="B" style="visibility: hidden; position: absolute; top: -1px">
										<input type="hidden" name="tipo" value="Azienda"  />
										<input type="azienda" name="nomeAzienda" placeholder="Nome Azienda" /> 
										<input type="sede" name="sede" placeholder="Sede" /> 
										<input type="email" name="email" placeholder="Email" />
										<input type="piva" name="partitaIva" placeholder="Partita Iva" /> 
										<input type="telefono" name="telefono" placeholder="Numero di telefono" /> 
										<input type="password" name="password" placeholder="Password" />
										<input type="password" name="confermaPsw" placeholder="Conferma Password" />
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
					</div></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#contact"><img src="img/info.png"></a></li>
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