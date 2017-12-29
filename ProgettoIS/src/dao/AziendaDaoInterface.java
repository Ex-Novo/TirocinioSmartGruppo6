package dao;

import java.util.ArrayList;

import bean.Azienda;

public interface AziendaDaoInterface {
	
	/**
	 * registra un'azienda
	 * @return ritorna true se ha registrato l'utente nel database, altrimenti false
	 */
	public boolean registerUser(Azienda user);
	
	/**
	 * controllo login
	 * @return ritorna true se ha trovato l'utente nel db, altrimenti false
	 */
	public boolean loginUser(Azienda user);
	
	/**
	 * Effettua una query nel database per cercare tutti le aziende registrate
	 * @return ritorna la lista delle aziende registrate
	 */
	public ArrayList<Azienda> getAziende();

}
