package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AziendaDaoImpl;

public class TestVisualizzaProfiloAzienda {
	
	/** Test visualizza Profilo Azienda // Email esistente
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */

	@Test
	public void testGetAziendaByEmailEsistente () {
		String email =  "hsoftware@gmail.com";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		assertNotNull (aziendaDao.getAziendaByEmail(email));
	}
	
	//Test email non esistente 
	
	@Test
	public void testGetAziendaByEmailNonEsistente () {
		String email =  "PROVA";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		assertEquals (null, aziendaDao.getAziendaByEmail(email).getEmail());
	}
	
	//Test P_Iva esistente

	@Test
	public void testGetAziendaByPivaEsistente () {
		String piva =  "0983732387";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		assertNotNull (aziendaDao.getAziendaByEmail(piva));
	}
	
	//Test P_Iva non esistente
	
	@Test
	public void testGetAziendaByPivaNonEsistente () {
		String piva =  "PROVA";
		AziendaDaoImpl aziendaDao = new AziendaDaoImpl ();
		assertEquals (null, aziendaDao.getAziendaBypiva(piva).getP_iva());
	}
}
