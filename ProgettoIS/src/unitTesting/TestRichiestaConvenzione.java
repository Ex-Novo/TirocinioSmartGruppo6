package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Convenzione;
import dao.ConvenzioneDaoImpl;

/* Nella form di invio richiesta convenzione:
 * 
 *  L'Utente non può inviare "Tutor Accademico" e "Numero Posti" vuoti (HTML: < ... required>)
 *  L'Utente non può inserire un nome di tutor accademico non valido (pattern="^[A-Za-z,\.\s']+$" required)
 *  L'Utente non può inserire un numero posti NaN (Not A Number) (HTML: <input type=number>)
 *  
 *  Di conseguenza bisogna testare:
 *  -La descrizione può essere "" (Stringa vuota)
 *  -La descrizione può essere vuota (genera errore)
 *  -La descrizione è un qualsiasi testo
 *  
 *  ##################################################################################
 *  Soluz: inserire un campo "required" per la descrizione in RichiestaConvenzione.jsp
 *  ##################################################################################
 *  */


public class TestRichiestaConvenzione {

	/** Test_RichiestConvenzione // Descrizione valida
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testRichiestaConvenzioneDescrizioneValida() {

		Convenzione convenzione = new Convenzione();

		/* I dati nel sistema vengono presi dalla sessione e dal db */
		convenzione.setData("2018-01-01");
		convenzione.setStato("in attesa");
		convenzione.setNomeFile("Test Nome File");

		/* Cosa viene effettivamente richiesto durante la richiesta di conv da parte dell'utente*/
		convenzione.setTutorAziendale("Simone Lucillo");
		convenzione.setDescrizione("Sviluppo App Android e iOS");
		convenzione.setNumPosti(20);
		
		String email= "grusso@unisa.it";
		String piva= "000111232334";

		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();

		assertEquals(true, convenzioneDAO.invioRichiestaConvenzione(convenzione, email, piva));

	}

	/** Test_RichiestConvenzione // Descrizione = null;
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testRichiestaConvenzioneDescrizioneNull() {

		Convenzione convenzione = new Convenzione();

		/* I dati nel sistema vengono presi dalla sessione e dal db */
		convenzione.setData("2018-01-01");
		convenzione.setStato("in attesa");
		convenzione.setNomeFile("Test Nome File");

		/* Cosa viene effettivamente richiesto durante la richiesta di conv da parte dell'utente*/
		convenzione.setTutorAziendale("Simone Lucillo");
		convenzione.setDescrizione(null);
		convenzione.setNumPosti(20);
		
		String email= "grusso@unisa.it";
		String piva= "000111232334";

		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();

		assertEquals(false, convenzioneDAO.invioRichiestaConvenzione(convenzione, email, piva));

	}
	
	/** Test_RichiestConvenzione // Descrizione = "" (Stringa vuota)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testRichiestaConvenzioneDescrizioneStringaVuota() {

		Convenzione convenzione = new Convenzione();

		/* I dati nel sistema vengono presi dalla sessione e dal db */
		convenzione.setData("2018-01-01");
		convenzione.setStato("in attesa");
		convenzione.setNomeFile("Test Nome File");

		/* Cosa viene effettivamente richiesto durante la richiesta di conv da parte dell'utente*/
		convenzione.setTutorAziendale("Simone Lucillo");
		convenzione.setDescrizione("");
		convenzione.setNumPosti(20);
		
		String email= "grusso@unisa.it";
		String piva= "000111232334";

		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();

		assertEquals(false, convenzioneDAO.invioRichiestaConvenzione(convenzione, email, piva));

	}
}
