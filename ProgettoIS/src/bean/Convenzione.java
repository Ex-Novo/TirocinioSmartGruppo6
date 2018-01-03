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
	private String email;
	private String p_iva;
	
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
	public String getP_iva() {
		return p_iva;
	}
	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
