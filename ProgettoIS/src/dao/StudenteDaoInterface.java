package dao;

import java.util.ArrayList;

import bean.Studente;

public interface StudenteDaoInterface {

	/**
	 *  registra uno studente
	 *  @return Ritorna true se la registrazione è riuscita, altrimenti false.
	 */
	public boolean registerUser(Studente user);
	
	/**
	 * controllo login
	 * @return Ritorna true se il login è riuscito, altrimenti false
	 */
	public boolean loginUser(Studente user);
	
	/**
	 * Effettua una query nel database per cercare tutti gli studenti registrati
	 * @return ritorna la lista di studenti registrati
	 */
	public ArrayList<Studente> getStudenti();
	
	/**
	 * Effettua una query nel database con l'email dello studente per trovare le informazioni associate da
	 * inserire nel profilo.
	 * @return ritorna un istanza del bean studente
	 */
	public Studente getStudenteByEmail(String email);
}
