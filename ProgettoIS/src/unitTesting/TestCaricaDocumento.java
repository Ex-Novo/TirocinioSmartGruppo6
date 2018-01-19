package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Azienda;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.DocumentoDaoImpl;
import dao.StudenteDaoImpl;

public class TestCaricaDocumento {


  /* Il metodo per salvare il documento prende in input 3 parametri:
   * saveFile(String nome, String chiave, String tipoUtente)
   * 
   * nome: nome del file, che può essere
   *    - String nome = null;
   *    - String nome = ""; (Stringa vuota)
   *    - String nome = formato valido;
   * 
   * chiave: chiave autogenerata dell'utente loggato
   * 
   * tipoUtente: tipo di utente, il quale può essere:
   *      - String tipoUtente = "Studente";
   *      - String tipoUtente = "Azienda";
   * 
   * Le categorie sono:
   * 
   * Studente, file name valido
   * Studente, file name non corretto
   * 
   * Azienda, file name valido
   * Azienda, file name non valido
   */

  /** Test Carica Documento // Studente, filename valido
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testCaricaDocumentoStudenteFilenameValido() {

    Studente studente = new StudenteDaoImpl().getStudenteByMatricola("0512103459");
    DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();

    assertEquals(true, documentoDAO.saveFile("FileName", studente.getMatricola(), "Studente"));

  }

  /** Test Carica Documento // Studente, filename non valido
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testCaricaDocumentoStudenteFilenameNonValido() {


    Studente studente = new StudenteDaoImpl().getStudenteByMatricola("0512103459");
    DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();

    /* Inserisco un carattere non valido per i nomi dei file (Ex: '/', '\', ':' ecc)*/
    assertEquals(false, documentoDAO.saveFile("File/Name", studente.getMatricola(), "Studente"));


  }

  /** Test Carica Documento // Azienda, filename valido
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testCaricaDocumentoAziendaFilenameValido() {

    Azienda azienda = new AziendaDaoImpl().getAziendaBypiva("000111232334");
    DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();

    assertEquals(true, documentoDAO.saveFile("FileName", azienda.getP_iva(), "Azienda"));


  }

  /** Test Carica Documento // Azienda, filename non valido
   * 
   * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
   * */

  @Test
  public void testCaricaDocumentoAziendaFilenameNonValido() {

    Azienda azienda = new AziendaDaoImpl().getAziendaBypiva("000111232334");
    DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();

    /* Inserisco un carattere non valido per i nomi dei file (Ex: '/', '\', ':' ecc)*/
    assertEquals(false, documentoDAO.saveFile("File/Name", azienda.getP_iva(), "Azienda"));

  }


  /* Due test hanno fallito con successo: dobbiamo gestire i nomi dei file
   * al fine non permettere all'utente di caricare file con caratteri non validi
   * (Ex: '/', '\', ':' ecc)
   */

}
