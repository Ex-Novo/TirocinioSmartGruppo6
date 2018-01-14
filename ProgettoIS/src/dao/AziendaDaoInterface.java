package dao;

import java.util.ArrayList;

import bean.Azienda;
import bean.Studente;
import bean.Tirocinio;

public interface AziendaDaoInterface {
	
	public boolean registerUser(Azienda user);
	
	public boolean loginUser(Azienda user);
	
	public ArrayList<Azienda> getAziende();
	
	public ArrayList<Azienda> getAziendeConvenzionate();
	
	public Azienda getAziendaByEmail(String email);
	
	public Azienda getAziendaBypiva(String piva);
	
	public boolean addTutorAziendale(String tutor,String piva);

	
	
	
}


