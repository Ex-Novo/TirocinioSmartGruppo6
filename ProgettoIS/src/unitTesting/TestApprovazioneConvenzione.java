package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Convenzione;
import dao.ConvenzioneDaoImpl;

public class TestApprovazioneConvenzione {

	/* Un'approvazione di convenzione può avere solo due categorie:
	 * 
	 * - Avvenuta con successo -> ritorna true
	 * - Fallita (per un qualsiasi motivo) -> ritorna false
	 */
	
	/** Test Approvazione Convenzione // Avvenuta
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	
	@Test
	public void TestApprovazioneConvenzioneAvvenuta() {
		
		Convenzione convenzione= new Convenzione();
		/*Partita iva di un'azienda già esistente */
		convenzione.setP_iva("0983732387");
		
		/* E-mail di chi approva la convenzione */
		convenzione.setEmail("fverdi@unisa.it");
		
		convenzione.setStato("in attesa");
		
		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();
		convenzioneDAO.invioRichiestaConvenzione(convenzione, convenzione.getEmail(), convenzione.getP_iva());
		
		assertEquals(true, convenzioneDAO.approvazioneRichiestaConvenzione(convenzione.getP_iva()));
	}

	/** Test Approvazione Convenzione // Fallita
	 * 
	 * @author Luca Lamberti, Simone Torluccio, Francesco D'Auria
	 * */
	
	
	@Test
	public void TestApprovazioneConvenzioneFallita() {

		ConvenzioneDaoImpl convenzioneDAO = new ConvenzioneDaoImpl();
	
		/* Inserisco un a partita iva che non esiste */
		assertEquals(false, convenzioneDAO.approvazioneRichiestaConvenzione("0"));
	
	} 
}
