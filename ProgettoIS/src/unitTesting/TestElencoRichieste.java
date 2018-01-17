package unitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bean.Convenzione;
import bean.RichiestaTirocinio;
import dao.ConvenzioneDaoImpl;
import dao.RichiestaTirocinioDaoImpl;

public class TestElencoRichieste {

	/* Per i due tipi di elenchi di richieste (Tirocinio e Convenzione) 
	 * possiamo avere due casi:
	 * 
	 * - Avvengono con successo -> Tornano una ArrayList<RichiestaTirocinio>/
	 * 										   ArrayList<Convenzione>
	 * 
	 * - Falliscono (per un qualsiasi motivo) -> 
	 * 
	 */


	/** Test Ritorno Elenco Richieste Tirocinio // Avvenuta con successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */


	@Test
	public void testElencoRichiesteTirocinioAvvenuta() {
		RichiestaTirocinioDaoImpl richiesteTirocinioDAO = new RichiestaTirocinioDaoImpl();
		ArrayList<RichiestaTirocinio> listaRichiesteTirocinio = richiesteTirocinioDAO.getRichiesteTirocinio();

		assertEquals(true, !listaRichiesteTirocinio.isEmpty());
	}

	/** Test Ritorno Elenco Richieste Tirocinio // Fallita
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testElencoRichiesteTirocinioFallita() {

		/* Se fallisce il metodo per ottenere la lista, ritorna un "new ArraList<RichiestaTirocinio>" */ 
		ArrayList<RichiestaTirocinio> listaRichiesteTirocinio = new ArrayList<RichiestaTirocinio>();

		assertEquals(true, listaRichiesteTirocinio.isEmpty());
	}


	/** Test Ritorno Elenco Richieste Convenzione // Avvenuta con successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testElencoRichiesteConvenzioneAvvenuta() {
		ConvenzioneDaoImpl richiesteConvenzioneDAO = new ConvenzioneDaoImpl();
		ArrayList<Convenzione> listaRichiesteConvenzione = richiesteConvenzioneDAO.getRichiesteConvenzione();

		assertEquals(true, !listaRichiesteConvenzione.isEmpty());
	}


	/** Test Ritorno Elenco Richieste Convenzione // Fallita
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	@Test

	public void testElencoRichiesteConvenzioneFallita() {

		/* Se fallisce il metodo per ottenere la lista, ritorna un "new ArraList<Convenzione>" */ 
		ArrayList<Convenzione> listaRichiesteConvenzione = new ArrayList<Convenzione>();

		assertEquals(true, listaRichiesteConvenzione.isEmpty());
	}
}
