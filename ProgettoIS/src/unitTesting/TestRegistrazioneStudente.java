package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Studente;
import dao.StudenteDaoImpl;

public class TestRegistrazioneStudente {

	/* La registrazione di uno studente può essere divisa in 4 categorie:
	 * 
	 *  - Studente = null;
	 *  - Studente = new Studente();
	 *  - Studente = new Studente (format corretto garantito da javascript, non esistente nel db)
	 *  - Studente = new Studente (format corretto garantito da javascript, esistente nel db)
	 */
	
	
	
	/** Test Registrazione Studente // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void RegistrazioneStudenteAvvenuta() {
		
		Studente studente = new Studente();
		studente.setMatricola("Matricola");
		studente.setNome("Nome");
		studente.setCognome("Cognome");
		studente.setPassword("Password");
		studente.setCodiceFiscale("Codice Fiscale");
		studente.setEmail("email@email.com");
		studente.setDataNascita("2018-12-31");
		studente.setLuogoNascita("Luogo Nascita");
		
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
		studente.setMatricola("0512101111");
		
		studente.setNome("Nome");
		studente.setCognome("Cognome");
		studente.setPassword("Password");
		studente.setCodiceFiscale("Codice Fiscale");
		studente.setEmail("email@email.com");
		studente.setDataNascita("2018-12-31");
		studente.setLuogoNascita("Luogo Nascita");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		assertEquals(false, studenteDAO.registerUser(studente));

	}
	
	/** Test Registrazione Studente // Studente = null;
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void RegistrazionStudenteNull() {
		
		Studente studente = null;
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		assertEquals(false, studenteDAO.registerUser(studente));

	}
	
	/** Test Registrazione Studente // Studente = null;
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void RegistrazionStudenteDefault() {
		
		Studente studente = new Studente();
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		
		assertEquals(false, studenteDAO.registerUser(studente));

	}


}
