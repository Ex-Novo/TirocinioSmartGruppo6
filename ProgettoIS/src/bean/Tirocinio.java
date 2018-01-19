package bean;

/**
 * Bean dell'entità Tirocinio.
 * @author Anna Maria Rosanova.
 *
 */

public class Tirocinio {
  private int idTirocinio;
  private String descrizione;
  private int numPosti;
  private String p_iva;
  
  
  public int getIdTirocinio() {
    return idTirocinio;
  }
  
  public void setIdTirocinio(int idTirocinio) {
    this.idTirocinio = idTirocinio;
  }
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public int getNumPosti() {
    return numPosti;
  }
  
  public void setNumPosti(int numPosti) {
    this.numPosti = numPosti;
  }
  
  public String getP_iva() {
    return p_iva;
  }
  
  public void setP_iva(String p_iva) {
    this.p_iva = p_iva;
  }
  
  
}
