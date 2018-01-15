package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;

public class TestRichiestaTirocinio {

	/** TC_2.2 Test_RichiestConvenzione // Form valido
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testInvioRichiestaTirocinioFormValido() {
		RichiestaTirocinio richiestaTirocinio = new RichiestaTirocinio ();
		
		richiestaTirocinio.setData("2018-01-15");
		richiestaTirocinio.setNomeFile("RichiestaTirocinio");
		richiestaTirocinio.setNomeTutorAccademico("Mario Rossi");
		richiestaTirocinio.setStatus("in attesa");
		richiestaTirocinio.setEmailTutAcc("mrossi@unisa.it");
		richiestaTirocinio.setEmailDir("fverdi@unisa.it");
		richiestaTirocinio.setIdTirocinio(1);
		richiestaTirocinio.setMatricola("0512103599");
		
		
		RichiestaTirocinioDaoImpl richiestaTirocinioDao=new RichiestaTirocinioDaoImpl();
		
		
		assertEquals (true, richiestaTirocinioDao.invioRichiestaTirocinio(richiestaTirocinio));
	}
	
	/* Nella form di invio richiesta tirocinio:
	 * 
	 *  L'Utente non può inviare dei campi non compilati (HTML: < ... required>)
	 *  
	 *  L'Utente non può inserire un nome di tutor accademico non valido (pattern="^[A-Za-z,\.\s']+$" required)
	 *  
	 *  */

}
