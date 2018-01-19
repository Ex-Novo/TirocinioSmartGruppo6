package dao;

import bean.Documento;

import java.util.ArrayList;

public interface DocumentoDaoInterface {
  
  
  public ArrayList<Documento> getDocumenti(String chiave);
  
  public boolean saveFile(String nome, String chiave,String tipoUtente);

}
