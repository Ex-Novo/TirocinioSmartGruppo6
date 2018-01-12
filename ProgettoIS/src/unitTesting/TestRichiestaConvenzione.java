package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Convenzione;
import dao.ConvenzioneDaoImpl;

public class TestRichiestaConvenzione {

	/** TC_2.1 Test_RichiestConvenzione // Form valido
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */


	@Test
	public void testRichiestaConvenzioneFormValido() {

		Convenzione convenzione = new Convenzione();

		convenzione.setData("2018-01-01");
		convenzione.setStato("in attesa");
		convenzione.setDescrizione("Sviluppo App Android e iOS");
		convenzione.setNumPosti(20);
		convenzione.setTutorAziendale("simonelucillo@libero.it");
		convenzione.setNomeFile("Test Nome File");

		String email= "grusso@unisa.it";
		String piva= "000111232334";

		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();

		assertEquals(true, convenzioneDAO.invioRichiestaConvenzione(convenzione, email, piva));

	}

	/* Nella form di invio richiesta convenzione:
	 * 
	 *  L'Utente non può inviare dei campi non compilati (HTML: < ... required>)
	 *  
	 *  L'Utente non può inserire un nome di tutor accademico non valido (HTML: <input type=text>)
	 *  
	 *  L'Utente non può inserire un numero posti NaN (Not A Number) (HTML: <input type=number>)
	 *  */
}
