package bean;

import java.util.Date;

/**
 * Bean dell'entità FeedBack
 * @author Anna Maria Rosanova
 *
 */
public class Feedback {
	private int idFeedback;
	private Date data;
	private double valutazioneStudente;
	private double valutazioneAzienda;
	
	
	public int getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValutazioneStudente() {
		return valutazioneStudente;
	}
	public void setValutazioneStudente(double valutazioneStudente) {
		this.valutazioneStudente = valutazioneStudente;
	}
	public double getValutazioneAzienda() {
		return valutazioneAzienda;
	}
	public void setValutazioneAzienda(double valutazioneAzienda) {
		this.valutazioneAzienda = valutazioneAzienda;
	}

}
