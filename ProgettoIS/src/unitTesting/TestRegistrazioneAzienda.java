package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Azienda;
import dao.AziendaDaoImpl;

public class TestRegistrazioneAzienda {

	/** Test Registrazione Azienda // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void RegistrazioneAziendaAvvenuta() {
		
		Azienda azienda = new Azienda();
		
		azienda.setNomeAzienda("Nome Azienda");
		azienda.setSede("Sede");
		azienda.setP_iva("Partita Iva");
		azienda.setEmail("email@email.com");
		azienda.setTelefono("3313313313");
		azienda.setPassword("111");
		
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
		
		assertEquals(true, aziendaDAO.registerUser(azienda));

	}
	
	
	/** Test Registrazione Azienda // Non Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void RegistrazioneAziendaFallita() {
		
		Azienda azienda = new Azienda();
		
		/* Inserisco una partita iva già esistente */
		
		azienda.setNomeAzienda("Nome Azienda");
		azienda.setSede("Sede");
		azienda.setP_iva("Partita Iva");
		azienda.setEmail("email@email.com");
		azienda.setTelefono("3313313313");
		azienda.setPassword("111");
		
		AziendaDaoImpl aziendaDAO = new AziendaDaoImpl();
		
		assertEquals(false, aziendaDAO.registerUser(azienda));

	}
	
}
