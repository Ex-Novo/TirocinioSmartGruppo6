package dao;

import java.util.ArrayList;

import bean.Azienda;
import bean.Studente;

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
	
	/**
	 * Effettua una query nel database per cercare tutti le aziende convenzionate
	 * @return ritorna la lista delle aziende convenzionate
	 */
	public ArrayList<Azienda> getAziendeConvenzionate();
	
	/**
	 * Effettua una query nel database con l'email dell'azienda per trovare le informazioni associate da
	 * inserire nel profilo.
	 * @return ritorna un istanza del bean azienda
	 */
	public Azienda getAziendaByEmail(String email);
	
	public Azienda getAziendaBypiva(String piva);
	
	
	public boolean addTutorAziendale(String tutor,String piva);
	
	
}


