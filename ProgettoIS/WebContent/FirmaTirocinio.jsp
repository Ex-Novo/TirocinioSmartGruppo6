<!-- 
Jsp che permette di poter scaricare e caricare la richiesta e confermarla

autori: Mario Procida

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma Richiesta</title>
</head>
<body class="bg-primary">
	<%@ include file="/header.jsp"%>
	
	<div id="wrapper">
		<header class="masthead bg-primary text-white text-center">
				<div class="container">
				 	<!-- Scarica richiesta da firmare -->
					<a href="DownloadControl?tipo=firmaTirocinio" class="btn btn-info" >Scarica richiesta</a>
					
					<!-- Form per caricare la richiesta firmata -->
					<form method="post" action="UploadControl" name="echo" enctype="multipart/form-data">
						<fieldset>
							<legend>Seleziona il file</legend>
								<input type="file" name="file" size="50" /> <br> 
								<input type="submit" class="btn btn-info" value="Invia"> <input type="reset" value="Reset">
						</fieldset>
					</form>
					
					<!-- Conferma Richiesta di convenzione -->
					<form action="rTiro" method="post">
						<input type="hidden" name="tipo" value="confermaRichiesta"/>
						<input type="submit" class="btn btn-info" value="Conferma Richiesta" />
					</form>
				</div>
		</header>
	</div>
	
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>
</body>
</html>