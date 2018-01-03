package dao;

import java.util.ArrayList;

import bean.Documento;

public interface DocumentoDaoInterface {
	
	
	public ArrayList<Documento> getDocumenti(String chiave);
	
	public boolean saveFile(String nome, String chiave,String tipoUtente);

}
