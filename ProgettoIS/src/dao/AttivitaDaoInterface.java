package dao;

import bean.Attivita;

import java.util.ArrayList;


public interface AttivitaDaoInterface {
  
  public boolean inserisciAttivita(Attivita a);
  
  public ArrayList<Attivita> getAttivitaByIdRegistro(int idRegistro);

}
