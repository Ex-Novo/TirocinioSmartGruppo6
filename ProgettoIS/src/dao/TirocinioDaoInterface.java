package dao;

import bean.Tirocinio;

public interface TirocinioDaoInterface {
	
	/**
	 * 
	 * Effettua una query nel database per cercare tutti i tirocini offerti dalle aziende
	 * convenzionate
	 * @return ritorna la lista dei tirocini
	 */
	
	public Tirocinio getDettagliAziendeConvenzionate(String piva);
	
	
	/**
	 * 
	 * Effettua una query nel database per l' inserimento di un nuovo tirocinio
	 * @return ritorna true se l' inserimento avviene con successo false altrimenti
	 */
	public boolean creaTirocinio(Tirocinio t);
	

}
