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
		if(this.readyState==4&&this.status==200){
			
			alert(this.responseText);
		}
	};
	xmht.open("GET","ControlloMatricolaStudente.java?matricola="+matricola,true);
	xmht.send();
	return true;
}

function checkEmailStudente(email){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.readyState==4&&this.status==200){
			
			alert(this.responseText);
		}
	};
	xmht.open("GET","ControlloEmailStudente.java?email="+email,true);
	xmht.send();
	return true;
}
	
function checkEmailAzienda(email){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.readyState==4&&this.status==200){
			
			alert(this.responseText);
		}
	};
	xmht.open("GET","ControlloEmailAzienda.java?email="+email,true);
	xmht.send();
	return true;
}

function checkP_IvaAzienda(piva){
	
	
	var xmht= new XMLHttpRequest();
	xmht.onreadystatechange =function(){
		console.log("readyState: " + this.readyState);
		if(this.readyState==4&&this.status==200){
			
			alert(this.responseText);
		}
	};
	xmht.open("GET","ControlloP_IvaAzienda.java?piva="+piva,true);
	xmht.send();
	return true;
}
	
	
