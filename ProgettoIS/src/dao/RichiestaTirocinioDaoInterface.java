package dao;

import java.util.ArrayList;

import bean.RichiestaTirocinio;

public interface RichiestaTirocinioDaoInterface {
	
	public boolean invioRichiestaTirocinio( RichiestaTirocinio richiestaTirocinio);
	
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);
	
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio();

}
