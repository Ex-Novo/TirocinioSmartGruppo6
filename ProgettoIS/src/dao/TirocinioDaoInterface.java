package dao;

import java.util.ArrayList;

import bean.Tirocinio;

public interface TirocinioDaoInterface {
	
	/**
	 * 
	 * Effettua una query nel database per cercare tutti i tirocini offerti dalle aziende
	 * convenzionate
	 * @return ritorna la lista dei tirocini
	 */
	
	public ArrayList<Tirocinio> getDettagliAziendeConvenzionate();
	

}
