package unitTesting;

import static org.junit.Assert.assertEquals;

import dao.StudenteDaoImpl;

import org.junit.Test;



/*
 * I metodi ritornano informazioni di uno Studente la sua email o chiave (Matricola)
 * 
 * Le categorie sono:
 * 
 * - email valida
 * - email non esiste o non valida (Ex: errore di codifica)
 * 
 * - matricola valida
 * - matricola non esiste o non valida (Ex: errore di codifica)
 * 
 */

public class TestVisualizzaProfiloStudente {

  /** Test visualizza Profilo Studente // Matricola non esistente.
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testGetStudenteByMatricolaNonEsistente() {
    String matricola = "PROVA";
    StudenteDaoImpl studenteDao = new StudenteDaoImpl();

    assertEquals(null, studenteDao.getStudenteByMatricola(matricola).getMatricola());
  }

  //Test matricola esistente 

  @Test
  public void testGetStudenteByMatricolaEsistente() {
    String matricola = "0512101111";
    StudenteDaoImpl studenteDao = new StudenteDaoImpl();

    assertEquals(matricola, studenteDao.getStudenteByMatricola(matricola).getMatricola());
  }

  //Test email non esistente

  @Test
  public void testGetStudenteByEmailNonEsistente() {
    String email = "PROVA";
    StudenteDaoImpl studenteDao = new StudenteDaoImpl();

    assertEquals(null, studenteDao.getStudenteByEmail(email).getEmail());
  }

  //Test email esistente

  @Test
  public void testGetStudenteByEmailEsistente() {
    String email = "storluccio@gmail.com";
    StudenteDaoImpl studenteDao = new StudenteDaoImpl();

    assertEquals(email, studenteDao.getStudenteByEmail(email).getEmail());
  }

}
