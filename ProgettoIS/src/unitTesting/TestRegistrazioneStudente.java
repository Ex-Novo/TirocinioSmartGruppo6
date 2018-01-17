package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Studente;
import dao.StudenteDaoImpl;

public class TestRegistrazioneStudente {

	/* La registrazione di uno studente può essere divisa in categorie:
	 * 
	 *	 *  - Studente = new Studente
	 *  (format corretto e required garantito da javascript/html, chiave non esistente nel db)
	 *  
	 *  - Studente = new Studente
	 *  (format corretto e required garantito da javascript/html, chiave esistente nel db)  
	 *  
	 */



	/** Test Registrazione Studente // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneStudenteAvvenuta() {

		Studente studente = new Studente();
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();

		studente.setMatricola("Matricola");
		studente.setNome("Nome");
		studente.setCognome("Cognome");
		studente.setPassword("Password");
		studente.setCodiceFiscale("Codice Fiscale");
		studente.setEmail("email@email.com");
		studente.setDataNascita("2018-12-31");
		studente.setLuogoNascita("Luogo Nascita");


		assertEquals(true, studenteDAO.registerUser(studente));
	}

	/** Test Registrazione Studente // Fallita (Ex: chiave già presente)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void registrazioneStudenteFallita() {

		/* Inserisco una matricola già esistente nel DB */

		Studente studente = new Studente();
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();

		studente.setMatricola("0512101111"); /*Chiave=matricola*/
		studente.setNome("Nome");
		studente.setCognome("Cognome");
		studente.setPassword("Password");
		studente.setCodiceFiscale("Codice Fiscale");
		studente.setEmail("email@email.com");
		studente.setDataNascita("2018-12-31");
		studente.setLuogoNascita("Luogo Nascita");

		assertEquals(false, studenteDAO.registerUser(studente));

	}
}
