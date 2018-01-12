package dao;

import java.util.ArrayList;

import bean.Attivita;

public interface AttivitaDaoInterface {
	
	public boolean inserisciAttivita(Attivita a);
	
	public ArrayList<Attivita> getAttivitaByIdRegistro(int idRegistro);

}
