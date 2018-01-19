package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AziendaDaoImpl;

/*
 * I metodi ritornano informazioni di un'Azienda la sua email o chiave (Partita Iva)
 * 
 * Le categorie sono:
 * 
 * - email valida
 * - email non esiste o non valida (Ex: errore di codifica)
 * 
 * - partita iva valida
 * - partita iva non esiste o non valida (Ex: errore di codifica)
 * 
 */

public class TestVisualizzaProfiloAzienda {

	/** Test visualizza Profilo Azienda // Email esistente
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testGetAziendaByEmailEsistente () {
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		String email =  "hsoftware@gmail.com";

		assertEquals (email, aziendaDao.getAziendaByEmail(email).getEmail());
	}

	//Test email non esistente 

	/** Test visualizza Profilo Azienda // Email non esistente (Ex: errore di codifica)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testGetAziendaByEmailNonEsistente () {
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		String email =  "PROVA";

		assertEquals (null, aziendaDao.getAziendaByEmail(email).getEmail());
	}

	/** Test visualizza Profilo Azienda // Partita Iva (chiave) esistente
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */


	@Test
	public void testGetAziendaByPivaEsistente () {
		String piva =  "2586";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();

		assertEquals(piva, aziendaDao.getAziendaBypiva(piva).getP_iva());
	}


	/** Test visualizza Profilo Azienda // Partita Iva (chiave) non esistente (Ex: errore di codifica)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */


	@Test
	public void testGetAziendaByPivaNonEsistente () {
		String piva =  "PROVA";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();

		assertEquals (null, aziendaDao.getAziendaBypiva(piva).getP_iva());
	}
}
