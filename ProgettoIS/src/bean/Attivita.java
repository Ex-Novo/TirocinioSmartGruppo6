package bean;

import java.util.Date;

/**
 * Bean dell'entità Attività
 * @author Anna Maria Rosanova
 *
 */
public class Attivita {
	private int idAttivita;
	private String data;
	private int ore;
	private String descrizione;
	private int idRegistro;
	private int idTirocinio;
	
	
	public int getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	public int getIdTirocinio() {
		return idTirocinio;
	}
	public void setIdTirocinio(int idTirocinio) {
		this.idTirocinio = idTirocinio;
	}
	public int getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(int idAttivita) {
		this.idAttivita = idAttivita;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
