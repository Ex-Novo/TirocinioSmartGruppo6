function loginValidation(form){
	var email= form.email.value;
	var password= form.password.value;
	
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(!(email.match(mailformat)) || email==""){
		alert("Formato non valido");
		form.email.focus();
		return false;
	}else if(password ==""){
		alert("Inserire la password.");		
		form.password.focus();
		return false;
	}
	
}