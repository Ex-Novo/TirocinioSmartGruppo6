package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Registro;
import dao.RegistroDaoImpl;

public class TestInserisciRegistro {

	/** Test Registro // Inserimento con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testInserisciRegistroConSuccesso () {
		
		RegistroDaoImpl registroDao = new RegistroDaoImpl ();
		String matricola = "0512101111";
		String piva = "000111232334"; 
		
		assertEquals (true, registroDao.inserisciRegistro(matricola, piva));
	}
	
	/** Test Registro // Inserimento senza Successo (Ex: Partita Iva azienda non esistente)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testInserisciRegistroSenzaSuccesso () {
		
		RegistroDaoImpl registroDao = new RegistroDaoImpl ();
		String matricola = "0512101111";
		String piva = "PROVA"; 
		
		assertEquals (false, registroDao.inserisciRegistro(matricola, piva));
	}

}
