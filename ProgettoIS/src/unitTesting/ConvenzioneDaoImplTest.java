/**
 * Classe di test per ConvenzioneDaoImpl
 * 
 * @author Luca Lamberti , Simone Torluccio
 */

package unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.*;

public class ConvenzioneDaoImplTest  {

  @Test
  public void testApprovazioneRichiestaConvenzioneAziendaRegistrataNonConvenzionata() {
    
    ConvenzioneDaoImpl c = new ConvenzioneDaoImpl();
    assertEquals(true, c.approvazioneRichiestaConvenzione("111111"));
  }
  
  @Test
  public void testApprovazioneRichiestaConvenzioneAziendaRegistrataConvenzionata () {
    
    ConvenzioneDaoImpl c = new ConvenzioneDaoImpl();
    assertEquals(true, c.approvazioneRichiestaConvenzione("000111232334"));
  }
  
  @Test
  public void testApprovazioneRichiestaConvenzioneAziendaNonRegistrata() {
    
    ConvenzioneDaoImpl c = new ConvenzioneDaoImpl();
    assertEquals(false, c.approvazioneRichiestaConvenzione("011232334"));
  }
  
  @Test
  public void testGetRichiesteConvenzioneInAttesaDiApprovazione() {
    //Nel database devono esserci convenzioni in stato di attesa
    ConvenzioneDaoImpl c = new ConvenzioneDaoImpl();
    
    assertNotNull(c.getRichiesteConvenzione());
  }
  
  @Test
  public void testGetRichiesteConvenzione() {
    //Nel database non devono esserci convenzioni in stato di attesa
    ConvenzioneDaoImpl c = new ConvenzioneDaoImpl();
    
    assertNull(c.getRichiesteConvenzione());
  }
  
  
  
  
}
