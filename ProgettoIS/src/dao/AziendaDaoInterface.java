package dao;

import bean.Azienda;

public interface AziendaDaoInterface {
	
	/**
	 * registra un'azienda
	 */
	public boolean registerUser(Azienda user);
	
	/**
	 * controllo login
	 */
	public boolean loginUser(Azienda user);

}
