package unitTesting;

import static org.junit.Assert.assertEquals;

import bean.Azienda;
import dao.AziendaDaoImpl;

import org.junit.Test;




public class TestRegistrazioneAzienda {

  /* La registrazione di un azienda può essere divisa in categorie:
   * 
   *  - Azienda = new Azienda
   *  (format corretto e required garantito da javascript/html, chiave non esistente nel db)
   *  
   *  - Azienda = new Azienda
   *  (format corretto e required garantito da javascript/html, chiave esistente nel db)
   * 
   */

  /** Test Registrazione Azienda // Avvenuta con Successo.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void registrazioneAziendaAvvenuta() {

    Azienda azienda = new Azienda();
    

    /* Mi registro con una chiave non presente nel database*/
    azienda.setNomeAzienda("Nome Azienda");
    azienda.setSede("Sede");
    azienda.setP_iva("Partita Iva");
    azienda.setEmail("email@email.com");
    azienda.setTelefono("3313313313");
    azienda.setPassword("111");

    AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
    assertEquals(true, aziendaDAO.registerUser(azienda));

  }


  /** Test Registrazione Azienda // Fallita (Ex: chiave già presente).
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void registrazioneAziendaFallita() {

    Azienda azienda = new Azienda();


    /* Inserisco una chiave già esistente */

    azienda.setNomeAzienda("Nome Azienda");
    azienda.setSede("Sede");
    azienda.setP_iva("0983732387");     /*Chiave = partita iva*/
    azienda.setEmail("email@email.com");
    azienda.setTelefono("3313313313");
    azienda.setPassword("111");

    AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
    assertEquals(false, aziendaDAO.registerUser(azienda));

  }

}
