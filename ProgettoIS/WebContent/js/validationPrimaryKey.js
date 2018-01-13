/**
 * script che controlla le chiavi primarie di azienda e studente
 * tramite funzioni ajax
 * 
 * @author : Luca Lamberti , Simone Torluccio
 */

function checkMatricolaStudente(matricola){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.responseText == 'no'){
			
			alert('Matricola non valida. Gia presente nel database');
		}
	};
	xmht.open("GET","checkMatricola?matricola="+matricola,true);
	xmht.send();
	return true;
}

function checkEmailStudente(email){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.responseText == 'no'){
			
			alert('Email non valida. Gia presente nel database');
		}
	};
	xmht.open("GET","checkEmailStudente?email="+email,true);
	xmht.send();
	return true;
}
	
function checkEmailAzienda(email){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.responseText == 'no'){
			
			alert('Email non valida. Gia presente nel database');
		}
	};
	xmht.open("GET","checkEmailAzienda?email="+email,true);
	xmht.send();
	return true;
}

function checkP_IvaAzienda(piva){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.responseText == 'no'){
			
			alert('Partita iva non valida. Gia presente nel database');
		}
	};
	xmht.open("GET","checkpiva?piva="+piva,true);
	xmht.send();
	return true;
}
	
	
