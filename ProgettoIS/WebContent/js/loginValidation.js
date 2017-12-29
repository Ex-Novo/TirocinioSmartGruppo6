function loginValidation(form){
	var email= form.email.value;
	var password= form.password.value;
	
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(!(email.match(mailformat)) || email==""){ //controllo formato email
		alert("Formato email non valido");
		form.email.focus();
		return false;
	}
	if(password ==""){ //se il campo della password è vuoto
		alert("Inserire la password.");		
		form.password.focus();
		return false;
	}
	
}