package bean;

import java.util.Date;

/**
 * Bean dell'entità Convenzione
 * @author Anna Maria Rosanova
 *
 */
public class Convenzione {
	private String idAttivita;
	private Date data;
	private int ore;
	private String descrizione;
	
	public String getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(String idAttivita) {
		this.idAttivita = idAttivita;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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
