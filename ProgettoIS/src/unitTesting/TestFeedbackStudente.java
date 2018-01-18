package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Feedback;
import dao.FeedBackDaoImpl;

public class TestFeedbackStudente {

	/** Test FeedBack studente // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testInviaFeedBackStudenteRiuscito () {
		
		FeedBackDaoImpl feedbackDao = new FeedBackDaoImpl ();
		
		Feedback feedback = new Feedback ();
		
		feedback.setData("2018-01-04");
		feedback.setIdTirocinio(9);
		feedback.setMatricola("0512101111");
		feedback.setPiva("2586");
		feedback.setValutazioneStudente(3);
		
		assertEquals (true, feedbackDao.inviaFeedBackStudente(feedback));
		
	}
	
	/** Test FeedBack azienda // Non avvenuta con successo (Ex: Matricola errata)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testInviaFeedBackStudenteNonRiuscito () {
		
		FeedBackDaoImpl feedbackDao = new FeedBackDaoImpl ();
		
		Feedback feedback = new Feedback ();
		
		feedback.setData("2018-01-04");
		feedback.setIdTirocinio(9);
		feedback.setMatricola("0511111");
		feedback.setPiva("09837327");
		feedback.setValutazioneStudente(3);
		
		assertEquals (false, feedbackDao.inviaFeedBackStudente(feedback));
		
	}

}
