package dao;

import bean.Studente;

import java.util.ArrayList;

public interface StudenteDaoInterface {

  public boolean registerUser(Studente user);
  
  public boolean loginUser(Studente user);
  
  public ArrayList<Studente> getStudenti();
 
  public Studente getStudenteByEmail(String email);
  
  public ArrayList<Studente> getTirocinanti(String p);
  
  public Studente getStudenteByMatricola(String matricola);
  
}
