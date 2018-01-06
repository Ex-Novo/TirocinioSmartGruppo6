package dao;

import java.util.ArrayList;

import bean.Convenzione;

public interface ConvenzioneDaoInterface {
	
	/** 
	 * Approva una richiesta di convenzione usando come chiave la partita iva
	 * @param piva: Partita Iva dell'azienda
	 * 
	 * @return true se l'approvazione ha successo, false altrimenti
	 */
	
	public boolean approvazioneRichiestaConvenzione(String piva);
	
	/**
	 * Invia una richiesta di convenzione prendendo in input tre parametri
	 * @param convenzione: Un oggetto di tipo Convenzione
	 * @param email: L'e-mail appartiene al direttore
	 * @param piva: la Partita Iva dell'azienda che vuole convenzionarsi
	 * 
	 * @return true se la richiesta è stata inviata correttamente, false altrimenti
	 */
	
	public boolean invioRichiestaConvenzione(Convenzione convenzione, String email ,String piva);
	
	public ArrayList<Convenzione> getRichiesteConvenzione();
}
