package dao;

import bean.Tirocinio;

public interface TirocinioDaoInterface {
  
  
  public Tirocinio getDettagliAziendeConvenzionate(String piva);
  
  public boolean creaTirocinio(Tirocinio t);

  public Tirocinio getPivaByIdTirocinio(int id);
  
  

}
