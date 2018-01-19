package bean;

/**
 * Bean dell'entità Azienda
 * @author Anna Maria Rosanova
 *
 */
public class Azienda {
  private String p_iva;
  private String nomeAzienda;
  private String tutorAziendale;
  private String email;
  private String password;
  private String telefono;
  private String sede;
  private String uniqueID;
  
  
  
  public String getUniqueID() {
    return uniqueID;
  }
  
  public void setUniqueID(String uniqueID) {
    this.uniqueID = uniqueID;
  }
  
  public void setSede(String sede) {
    this.sede = sede;
  }
  
  public String getP_iva() {
    return p_iva;
  }
  
  public void setP_iva(String p_iva) {
    this.p_iva = p_iva;
  }
  
  public String getNomeAzienda() {
    return nomeAzienda;
  }
  
  public void setNomeAzienda(String nomeAzienda) {
    this.nomeAzienda = nomeAzienda;
  }
  
  public String getTutorAziendale() {
    return tutorAziendale;
  }
  
  public void setTutorAziendale(String tutorAziendale) {
    this.tutorAziendale = tutorAziendale;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getTelefono() {
    return telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getSede() {
    return sede;
  }
  
  
}
