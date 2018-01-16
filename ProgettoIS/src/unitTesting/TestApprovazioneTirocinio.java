package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.RichiestaTirocinio;
import dao.RichiestaTirocinioDaoImpl;

public class TestApprovazioneTirocinio {

	/* Un'approvazione di tirocinio può avere solo due categorie:
	 * 
	 * - matricola esiste:
	 * - matricola non esiste o è errata:
	 */
	
	/** Test Approvazione Tirocinio // Avvenuta con Successo
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void TestApprovazioneTirocinioAvvenuta() {
		
		RichiestaTirocinio richiesta = new RichiestaTirocinio();
		richiesta.setMatricola("0512101111");
		richiesta.setNomeFile("Nome File");
		richiesta.setStatus("in attesa");
		richiesta.setIdTirocinio(1);
		
		RichiestaTirocinioDaoImpl richiestaTirocinioDAO = new RichiestaTirocinioDaoImpl();
		richiestaTirocinioDAO.invioRichiestaTirocinio(richiesta);
		
		
		
		assertEquals(true, richiestaTirocinioDAO.approvazioneRichiestaTirocinio(richiesta.getMatricola()));
		
	
	}
	
	/** Test Approvazione Tirocinio // Fallita
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	@Test
	public void TestApprovazioneTirocinioFallita() {
		
		/* Provo ad approvare una richiesta di tirocinio ad una richiesta che non esiste */
		
		
		RichiestaTirocinioDaoImpl richiestaTirocinioDAO = new RichiestaTirocinioDaoImpl();
	
		
		assertEquals(false, richiestaTirocinioDAO.approvazioneRichiestaTirocinio("0"));
		
	
	
	}

}
