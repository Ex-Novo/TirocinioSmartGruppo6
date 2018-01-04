function regValidation(form){

	var tipo = form.tipo.value;
	var psw = form.password.value;
	var confermaPsw = form.confermaPsw.value;
	
	if(confermaPsw!=psw){ // Controllo match conferma password 
		
		alert('Le password non coincidono');
		return false;
	}	


}