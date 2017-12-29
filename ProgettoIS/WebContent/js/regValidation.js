function regValidation(form){

	var tipo = form.tipo.value;

	var email= form.email.value;
	var psw = form.password.value;

	var passid_len = psw.length;
	if (passid_len == 0 || passid_len >= 15 || passid_len < 5){ //controllo lunghezza password 

		alert("Il campo password non può essere vuoto / la lunghezza deve essere tra 5 e 15 caratteri");
		form.password.focus();
		return false;
	}
	
	var confermaPsw = form.confermaPsw.value;
	
	if(confermaPsw!=psw){ // Controllo match conferma password 
		
		alert('Le password non coincidono');
		return false;
	}
		
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(!email.match(mailformat)){ //controllo formato email
	
		alert("Hai inserito un'indirizzo email errato! /Il campo mail non può essere vuoto");

		form.email.focus();
		return false;
	}
	
	
	if(tipo=="Studente"){ 
        
		var name = form.nome.value;
		var surname = form.cognome.value;
		var matricola = form.matricola.value;
		var codicefiscale = form.codiceFiscale.value;
		var luogoNascita = form.luogoNascita.value;
		

		var letters = /^[A-Za-z]+$/;
		if(name==""){ //se il campo nome è vuoto
			alert("Il campo nome non può essere vuoto");
			form.nome.focus();
			return false;
		}
		if(!name.match(letters)){ //se il campo non contiene soltanto lettere
	
			alert("Il nome deve avere solo caratteri alfabetici");
			alert("");
			form.nome.focus();
			return false;
		}

		var letters = /^[A-Za-z]+$/;
		if(surname==""){ //se il campo cognome è vuoto
		
			alert("il campo cognome non può essere vuoto");
			form.cognome.focus();
			return false;
		}
		if(!surname.match(letters)){ //se il campo non contiene soltanto lettere
	
			alert("Il cognome deve avere solo caratteri alfabetici");
			form.cognome.focus();
			return false;
		}

		
		var numbers = /^[0-9]+$/;
		if(!matricola.match(numbers)){//se il campo matricola non contiene solo numeri
			
			alert("Il campo matricola deve avere solo caratteri numerici / Il campo matricola non può essere vuoto");
			form.matricola.focus();
			return false;
		}
		
		var cfFormat=/[A-Za-z0-9]+/;
		if(!codiceFiscale.match(cfFormat)){
			
			alert("Formato codice fiscale non consentito");
			form.codiceFiscale.focus();
			return false;
		}
		
		if(codiceFiscale==""){
			
			alert("Inserire il codice fiscale");
			form.codiceFiscale.focus();
			return false;
		}

	}
	
	if(tipo=="Azienda"){
		
		var telefono = form.telefono.value;
		var partitaIva = form.partitaIva.value;
		var sede = form.sede.value;
		var nomeAzienda = form.nomeAzienda.value;
		
		var numbers = /^[0-9]+$/;
		if(!telefono.match(numbers)){//se il campo telefono non contiene solo numeri
			
			alert("Il campo telefono deve avere solo caratteri numerici / Il campo telefono non può essere vuoto");
			form.telefono.focus();
			return false;
		}
		
		if(!partitaIva.match(numbers)){//se il campo partitaiva non contiene solo numeri
			
			alert("Il campo partita iva deve avere solo caratteri numerici / Il campo partita iva non può essere vuoto");
			form.telefono.focus();
			return false;
		}
		
		if(!sede.match(letters)){//se la sede non contiene soltanto lettere
			
			alert("La sede deve avere solo caratteri alfabetici");
			form.sede.focus();
			return false;
		}
		if(sede==""){//se il campo sede è vuoto
			
			alert("Inserisci la sede");
			form.sede.focus();
			return false;
		}
		
		if(!nomeAzienda.match(letters)){ //se il nome dell'azienda non contiene soltanto lettere
			
			alert("Il nome dell'azienda deve avere solo caratteri alfabetici");
			form.nomeAzienda.focus();
			return false;
		}
		if(nomeAzienda==""){ // se il campo è vuoto
			
			alert("Inserisci il nome dell'azienda");
			form.nomeAzienda.focus();
			return false;
		}
		
		
	}



}