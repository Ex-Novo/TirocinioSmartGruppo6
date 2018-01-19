package unitTesting;

import static org.junit.Assert.assertEquals;

import bean.Feedback;
import dao.FeedBackDaoImpl;

import org.junit.Test;



public class TestFeedbackAzienda {

  /** Test FeedBack azienda // Avvenuta con Successo.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */
  
  @Test
  public void testInviaFeedBackAziendaRiuscito() {
    
    Feedback feedback = new Feedback();
    feedback.setData("2018-01-04");
    feedback.setIdTirocinio(9);
    feedback.setMatricola("0512101111");
    feedback.setPiva("2586");
    feedback.setValutazioneAzienda(3);
    
    FeedBackDaoImpl feedbackDao = new FeedBackDaoImpl();
    assertEquals(true, feedbackDao.inviaFeedBackAzienda(feedback));
    
  }
  
  /** Test FeedBack azienda // Non avvenuta con successo (Ex: Partita Iva errata).
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */
  
  @Test
  public void testInviaFeedBackAziendaNonRiuscito() {
    

    
    Feedback feedback = new Feedback();
    
    feedback.setData("2018-01-04");
    feedback.setIdTirocinio(9);
    feedback.setMatricola("051210645");
    feedback.setPiva("258782636");
    feedback.setValutazioneAzienda(3);
    
    FeedBackDaoImpl feedbackDao = new FeedBackDaoImpl();
    assertEquals(false, feedbackDao.inviaFeedBackAzienda(feedback));
    
  }

}
