package dao;

import bean.Convenzione;

import java.util.ArrayList;



public interface ConvenzioneDaoInterface {
  
  public boolean approvazioneRichiestaConvenzione(String piva);
  
  public boolean invioRichiestaConvenzione(Convenzione convenzione, String email, String piva);
  
  public ArrayList<Convenzione> getRichiesteConvenzione();
  
  public Convenzione getConvenzione(String piva);

  public boolean rifiutoRichiestaConvenzione(String piva);
}
