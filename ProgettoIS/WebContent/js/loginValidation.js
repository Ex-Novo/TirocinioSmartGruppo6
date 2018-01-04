function loginValidation(form){
	var email= form.email.value;
	
	
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(!(email.match(mailformat))){ //controllo formato email
		alert("Formato email non valido");
		form.email.focus();
		return false;
	}
	
	
}