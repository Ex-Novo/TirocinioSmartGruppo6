package dao;

import bean.RichiestaTirocinio;

import java.util.ArrayList;

public interface RichiestaTirocinioDaoInterface {
  
 
  public boolean invioRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);
 
  public boolean approvazioneRichiestaTirocinio(String matricola);
  
  public ArrayList<RichiestaTirocinio> getRichiesteTirocinio();

  public RichiestaTirocinio getRichTirocinio(String matricola);

  public boolean rifiutoRichiestaTirocinio(String matricola);

}
