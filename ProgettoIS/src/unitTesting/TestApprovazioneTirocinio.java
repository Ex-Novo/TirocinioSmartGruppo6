package unitTesting;

import static org.junit.Assert.assertEquals;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;

import org.junit.Test;


public class TestApprovazioneTirocinio {

  /* Un'approvazione di tirocinio può avere solo due categorie:
   * 
   * - matricola esiste:
   * - matricola è errata (Ex: errore di codifica)
   */

  /** Test Approvazione Tirocinio // Avvenuta con Successo.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testApprovazioneTirocinioAvvenuta() {

    RichiestaTirocinio richiesta = new RichiestaTirocinio();
    RichiestaTirocinioDaoImpl richiestaTirocinioDAO = new RichiestaTirocinioDaoImpl();

    richiesta.setMatricola("0512101111");
    richiesta.setNomeFile("Nome File");
    richiesta.setStatus("in attesa");
    richiesta.setIdTirocinio(1);


    richiestaTirocinioDAO.invioRichiestaTirocinio(richiesta);

    assertEquals(true,
          richiestaTirocinioDAO.approvazioneRichiestaTirocinio(richiesta.getMatricola()));


  }

  /** Test Approvazione Tirocinio // Fallita.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testApprovazioneTirocinioFallita() {

    /* Provo ad approvare una richiesta di tirocinio che non esiste */


    RichiestaTirocinioDaoImpl richiestaTirocinioDAO = new RichiestaTirocinioDaoImpl();


    assertEquals(false, richiestaTirocinioDAO.approvazioneRichiestaTirocinio("0512101111111111"));



  }

}
