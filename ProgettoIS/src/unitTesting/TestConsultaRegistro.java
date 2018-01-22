package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Registro;
import dao.RegistroDaoImpl;

public class TestConsultaRegistro {
	
	/** Test Registro // Consulta registro con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testGetRegistroByMatricolaEsistente() {
		
		String matricola = "051210641";
		
		RegistroDaoImpl registroDao = new RegistroDaoImpl ();
		
		assertNotNull (registroDao.getRegistroByMatricola(matricola).getIdRegistro());
		
	}
	
	/** Test Registro // Consulta registro senza successo (Ex: Matricola non esistente)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testGetRegistroByMatricolaNonEsistente() {
		
		String matricola = "PROVA";
		
		RegistroDaoImpl registroDao = new RegistroDaoImpl ();
	
		assertEquals(0,registroDao.getRegistroByMatricola(matricola).getIdRegistro());
	}
	
	
}
