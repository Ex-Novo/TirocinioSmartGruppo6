package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Azienda;
import dao.AziendaDaoImpl;

public class TestRegistrazioneAzienda {

	/* La registrazione di un azienda può essere divisa in 4 categorie:
	 * 
	 *  - Azienda = null;
	 *  - Azienda = new Azienda();
	 *  - Azienda = new Azienda (format corretto garantito da javascript, non esistente nel db)
	 *  - Azienda = new Azienda (format corretto garantito da javascript, esistente nel db)
	 */

	/** Test Registrazione Azienda // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneAziendaAvvenuta() {

		Azienda azienda = new Azienda();
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();

		azienda.setNomeAzienda("Nome Azienda");
		azienda.setSede("Sede");
		azienda.setP_iva("Partita Iva");
		azienda.setEmail("email@email.com");
		azienda.setTelefono("3313313313");
		azienda.setPassword("111");

		assertEquals(true, aziendaDAO.registerUser(azienda));

	}


	/** Test Registrazione Azienda // Non Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneAziendaFallita() {

		Azienda azienda = new Azienda();
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();

		/* Inserisco una partita iva già esistente */

		azienda.setNomeAzienda("Nome Azienda");
		azienda.setSede("Sede");
		azienda.setP_iva("0983732387");
		azienda.setEmail("email@email.com");
		azienda.setTelefono("3313313313");
		azienda.setPassword("111");

		assertEquals(false, aziendaDAO.registerUser(azienda));

	}

	/** Test Registrazione Azienda // Azienda = null;
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneAziendaNull() {

		Azienda azienda = null;
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();

		assertEquals(false, aziendaDAO.registerUser(azienda));

	}

	/** Test Registrazione Azienda // Azienda = new Azienda();
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneAziendaDefault() {

		Azienda azienda = new Azienda();
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();

		assertEquals(false, aziendaDAO.registerUser(azienda));

	}
}
