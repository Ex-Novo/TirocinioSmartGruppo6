package dao;

import java.util.ArrayList;

import bean.Registro;

public interface RegistroDaoInterface {
	
	public boolean inserisciRegistro(String matricola , String piva);
	
	public Registro getRegistroByMatricola(String matricola);
	
	public ArrayList<Registro>getRegistriByP_IVA(String piva); 

}
