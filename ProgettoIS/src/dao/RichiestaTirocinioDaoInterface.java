package dao;

import java.util.ArrayList;

import bean.RichiestaTirocinio;

public interface RichiestaTirocinioDaoInterface {
	
	/**
	 *	Invia una richiesta di tirocinio
	 * 
	 * @param richiestaTirocinio: la Richiesta di Tirocinio da inviare
	 * 
	 * @return true se la richiesta di tirocinio è stata inviata con successo, false altrimenti
	 */
	
	public boolean invioRichiestaTirocinio( RichiestaTirocinio richiestaTirocinio);
	
	/**
	 *  *  Approva una richiesta di tirocinio
	 * 
	 * @param richiestaTirocinio:
	 * @return true se la richiesta è stata approvata con successo, false altrimenti
	 */
	
	public boolean approvazioneRichiestaTirocinio(String matricola);
	
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio();

	public RichiestaTirocinio getRichTirocinio(String matricola);

	public boolean rifiutoRichiestaTirocinio(String matricola);

}
