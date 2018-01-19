package bean;


/**
 * Bean dell'entità FeedBack.
 * @author Anna Maria Rosanova.
 *
 */
public class Feedback {
  private int idFeedback;
  private String data;
  private double valutazioneStudente;
  private double valutazioneAzienda;
  private String piva;
  private String matricola;
  private int idTirocinio;
  
  
  public String getPiva() {
    return piva;
  }
  
  public void setPiva(String piva) {
    this.piva = piva;
  }
  
  public String getMatricola() {
    return matricola;
  }
  
  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }
  
  public int getIdTirocinio() {
    return idTirocinio;
  }
  
  public void setIdTirocinio(int idTirocinio) {
    this.idTirocinio = idTirocinio;
  }
  
  public int getIdFeedback() {
    return idFeedback;
  }
  
  public void setIdFeedback(int idFeedback) {
    this.idFeedback = idFeedback;
  }
  
  public String getData() {
    return data;
  }
  
  public void setData(String data) {
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
