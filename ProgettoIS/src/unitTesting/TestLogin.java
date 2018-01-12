package unitTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.Studente;
import dao.StudenteDaoImpl;

public class TestLogin {

	/** TC_1.1 Test_Login // Credenziali corrette
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testLoginCredenzialiValide() {
		
		Studente studente = new Studente();
		studente.setEmail("mprocida@gmail.com");
		studente.setPassword("111");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		assertEquals(true, studenteDAO.loginUser(studente));
	}
	
	/** TC_1.1 Test_Login // Password Errata
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testLoginPasswordErrata() {
		
		Studente studente = new Studente();
		studente.setEmail("mprocida@gmail.com");
		studente.setPassword("mari095");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		assertEquals(false, studenteDAO.loginUser(studente));
	}
	
	/** TC_1.1 Test_Login // Email Errata
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testLoginEmailErrata() {
		
		Studente studente = new Studente();
		studente.setEmail("mprocidaX@gmail.com");
		studente.setPassword("111");
		
		StudenteDaoImpl studenteDAO = new StudenteDaoImpl();
		assertEquals(false, studenteDAO.loginUser(studente));
	}
	

}
