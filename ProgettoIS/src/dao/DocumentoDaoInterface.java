package dao;

import java.util.ArrayList;

import bean.Documento;

public interface DocumentoDaoInterface {
	
	/**
	 * Il metodo effettua una query per ricercare i documenti caricati dall'utente
	 * @return Arraylist di tutti i documenti caricati dall'utente
	 */
	public ArrayList<Documento> getDocumenti(String chiave);

}
