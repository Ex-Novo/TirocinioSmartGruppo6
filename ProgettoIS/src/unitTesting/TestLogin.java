package unitTesting;

import static org.junit.Assert.assertEquals;

import bean.Studente;
import dao.StudenteDaoImpl;

import org.junit.Test;


public class TestLogin {

  /* Esistono tre tipi di casi:
   * 
   * - Email e password di format corretto (correttezza data dalla jsp; email esistente nel db)
   *      - con email e password che matchano (valide)
   *      - con email e password che non matchano (password non matcha)
   * 
   * - Email e password di format corretto (correttezza data dalla jsp; email NON esistente nel db)
   * 
   */

  /** Test_Login // Credenziali corrette (email e password matchano).
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testLoginCredenzialiValide() {

    Studente studente = new Studente();
    StudenteDaoImpl studenteDAO = new StudenteDaoImpl();

    studente.setEmail("mprocida@gmail.com");
    studente.setPassword("111");

    assertEquals(true, studenteDAO.loginUser(studente));
  }

  /** Test_Login // Email esiste ma la password non matcha.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testLoginPasswordErrata() {

    Studente studente = new Studente();
    StudenteDaoImpl studenteDAO = new StudenteDaoImpl();

    studente.setEmail("mprocida@gmail.com");
    studente.setPassword("mari095");

    assertEquals(false, studenteDAO.loginUser(studente));
  }

  /** Test_Login // Email Errata o non presente nel database.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testLoginEmailNonEsiste() {

    Studente studente = new Studente();
    StudenteDaoImpl studenteDAO = new StudenteDaoImpl();

    studente.setEmail("mprocidaX@gmail.com");
    studente.setPassword("111");

    assertEquals(false, studenteDAO.loginUser(studente));
  }


}
