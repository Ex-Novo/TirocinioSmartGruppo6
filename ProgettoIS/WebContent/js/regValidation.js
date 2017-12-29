function regValidation(form){

	var tipo = form.tipo.value;

	var email= form.email.value;
	var psw = form.password.value;

	
	
	if(tipo=="Studente"){
        
		var name = form.nome.value;
		var surname = form.cognome.value;
		var matricola = form.matricola.value;
		var codicefiscale = form.codiceFiscale.value;
		var luogoNascita = form.luogoNascita.value;
		
		var passid_len = psw.value.length;
		if (psw == "" || passid_len == 0 || passid_len >= 12 || passid_len < 7){
			
			$( ".alert" ).append("Il campo password non può essere vuoto / la lunghezza deve essere tra 7 e 12");
			alert("dio");
			form.password.focus();
			return false;
		}

		var letters = /^[A-Za-z]+$/;
		if(name.value==""){
			$( ".alert" ).append("Il campo nome non può essere vuoto");
			form.nome.focus();
			return false;
		}
		if(!name.value.match(letters)){
	
			$( ".alert" ).append("Il nome deve avere solo caratteri alfabetici");
			alert("");
			form.nome.focus();
			return false;
		}

		var letters = /^[A-Za-z]+$/;
		if(surname.value==""){
		
			$( ".alert" ).append("il campo cognome non può essere vuoto");
			form.cognome.focus();
			return false;
		}
		if(!surname.value.match(letters)){
	
			$( ".alert" ).append("Il cognome deve avere solo caratteri alfabetici");
			form.ognome.focus();
			return false;
		}

		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!email.value.match(mailformat)){
		
			$( ".alert" ).append("Hai inserito un'indirizzo email errato! /Il campo mail non può essere vuoto");

			form.email.focus();
			return false;
		}

		var numbers = /^[0-9]+$/;
		if(!tel.value.match(numbers)){
			
			$( ".alert" ).append("Il campo matricola deve avere solo caratteri numerici / Il campo matricola non può essere vuoto");
			form.matricola.focus();
			return false;
		}

	}



}