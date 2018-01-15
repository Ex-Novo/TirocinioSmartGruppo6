package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Studente;
import dao.StudenteDaoImpl;

public class TestRegistrazioneStudente {

	/* Divisione della registrazione in due categorie:
	 * 
	 * - Avvenuta con successo
	 * - Non avvenuta con successo
	 * 
	 * Da testare su entrambi i tipi di registazione (Studente ed Azienda)
	 */
	
	
	
	/** Test Registrazione Studente // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void RegistrazioneStudenteAvvenuta() {
		
		Studente studente = new Studente();
		studente.setMatricola("PROVA");
		studente.setNome("PROVA");
		studente.setCognome("PROVA");
		studente.setPassword("PROVA");
		studente.setCodiceFiscale("PROVA");
		studente.setEmail("PROVA");
		studente.setDataNascita("2018-12-31");
		studente.setLuogoNascita("PROVA");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		assertEquals(true, studenteDAO.registerUser(studente));
	}

	/** Test Registrazione Studente // Non Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void RegistrazionStudenteFallita() {
		
		/* Inserisco una matricola già esistente nel DB */
		
		Studente studente = new Studente();
		
		/* Inserisco una matricola già esistente nel DB */
		studente.setMatricola("PROVA");
		
		studente.setNome("PROVA");
		studente.setCognome("PROVA");
		studente.setPassword("PROVA");
		studente.setCodiceFiscale("PROVA");
		studente.setEmail("PROVA");
		studente.setDataNascita("2018-12-01");
		studente.setLuogoNascita("PROVA");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		assertEquals(false, studenteDAO.registerUser(studente));
		
		
		
	}

}
