package bean;

import java.util.Date;

/**
 * Bean dell'entità Convenzione
 * @author Anna Maria Rosanova
 *
 */
public class Convenzione {
	private String idAttivita;
	private String data;
	private String descrizione;
	private String tutorAziendale;
	private int numPosti;
	private String stato;
	
	public String getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(String idAttivita) {
		this.idAttivita = idAttivita;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTutorAziendale(){
		return tutorAziendale;
	}
	public void setTutorAziendale(String tutorAziendale) {
		this.tutorAziendale = tutorAziendale;
	}
	public int getNumPosti(){
		return numPosti;
	}
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	
	
}
