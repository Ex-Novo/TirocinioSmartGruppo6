package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;

// Ho provato con un nuovo utente "dauriafrancescomaria@gmail.com" e "111"

/* Durante la richiesta di tirocinio vi � solo il nome del "Tutor Accademico" da inserire:
 * 
 * Il nome del "Tutor Accademico" � <required> dal tag, quindi non pu� essere nullo o "" (stringa vuota)
 * Si pu� solo testare se effettivamente funziona la funzionalit� di creazione di richiesta tirocinio
 */


public class TestRichiestaTirocinio {

  /** TC_2.2 Test_RichiestConvenzione // Form valido
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testInvioRichiestaTirocinioFormValido() {

    RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio ();
    RichiestaTirocinioDaoImpl richiestaTirocinioDao=new RichiestaTirocinioDaoImpl();

    richiestaTirocinio.setData("2018-01-15");
    richiestaTirocinio.setNomeFile("RichiestaTirocinio");
    richiestaTirocinio.setNomeTutorAccademico("Mario Rossi");
    richiestaTirocinio.setStatus("in attesa");
    richiestaTirocinio.setEmailTutAcc("mrossi@unisa.it");
    richiestaTirocinio.setEmailDir("fverdi@unisa.it");
    richiestaTirocinio.setIdTirocinio(1);
    richiestaTirocinio.setMatricola("0512103599");


    assertEquals (true, richiestaTirocinioDao.invioRichiestaTirocinio(richiestaTirocinio));
  }

  /* Nella form di invio richiesta tirocinio:
   * 
   *  L'Utente non pu� inviare dei campi non compilati (HTML: < ... required>)
   *  
   *  L'Utente non pu� inserire un nome di tutor accademico non valido (pattern="^[A-Za-z,\.\s']+$" required)
   *  
   *  */

}
