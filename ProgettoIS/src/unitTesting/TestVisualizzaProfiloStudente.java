package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.StudenteDaoImpl;

public class TestVisualizzaProfiloStudente {
	
	/** Test visualizza Profilo Studente // Matricola non esistente
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testGetStudenteByMatricolaNonEsistente () {
		String matricola = "PROVA";
		StudenteDaoImpl studenteDao = new StudenteDaoImpl ();
		assertEquals (null, studenteDao.getStudenteByMatricola(matricola).getMatricola());
	}
	
	//Test matricola esistente 
	
	@Test
	public void testGetStudenteByMatricolaEsistente () {
		String matricola = "0512101111";
		StudenteDaoImpl studenteDao = new StudenteDaoImpl ();
		assertNotNull (studenteDao.getStudenteByMatricola(matricola));
	}
	
	//Test email non esistente
	
	@Test
	public void testGetStudenteByEmailNonEsistente () {
		String email = "PROVA";
		StudenteDaoImpl studenteDao = new StudenteDaoImpl ();
		assertEquals (null, studenteDao.getStudenteByEmail(email).getEmail());
	}
	
	//Test email esistente
	
	@Test
	public void testGetStudenteByEmailEsistente () {
		String email = "storluccio@gmail.com";
		StudenteDaoImpl studenteDao = new StudenteDaoImpl ();
		assertNotNull (studenteDao.getStudenteByEmail(email));
	}

}
