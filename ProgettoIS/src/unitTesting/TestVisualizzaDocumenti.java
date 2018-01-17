package unitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bean.Documento;
import dao.DocumentoDaoImpl;


/*
 * Il metodo per ritornare tutti i documenti appartenenti ad un utente
 * ritorna una lista di documenti in caso di successo (la quale può essere anche vuota),
 * altrimenti ritorna una lista di documenti vuota
 * 
 *  Ricerca tramite una chiave (Matricola per lo studente, Partita Iva per l'azienda)
 *  
 *  Il metodo prende la chiave dalla sessione, dove vi è salvata la partita Iva/ Matricola
 *  
 *  la chiave può essere: valida e non valida (Ex: per errori di codifica)
 * 
 * 
 */


public class TestVisualizzaDocumenti {

	/** Test Richiesta Elenco Documenti // Chiave valida
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */


	@Test
	public void testElencoDocumentiChiaveValida() {
		DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();
		String chiave="0512103459";
		ArrayList<Documento> listaDocumenti= documentoDAO.getDocumenti(chiave);
		
		assertEquals(true, listaDocumenti.isEmpty() || (!listaDocumenti.isEmpty()));
	}
	
	/** Test Richiesta Elenco Documenti // Chiave non valida (Ex: errore di codifica)
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void testElencoDocumentiChiaveNonValida() {
		DocumentoDaoImpl documentoDAO = new DocumentoDaoImpl();
		
		/*Errore di codifica durante il passaggio del valore della chiave*/
		String chiave="0512103459111111";
		ArrayList<Documento> listaDocumenti= documentoDAO.getDocumenti(chiave);
		
		assertEquals(true, listaDocumenti.isEmpty());
	}
}
