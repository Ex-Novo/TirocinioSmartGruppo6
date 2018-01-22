package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public interface PdfCreator {
  
  public ByteArrayOutputStream  creaPdfConv(String nomeAz, String piva, String descrizione,
      String numPosti, String data, String logo) throws MalformedURLException, IOException;
  
  public ByteArrayOutputStream creaPdfTir(String nome, String cognome, String matricola,
      String nomeAzienda, String tutor, String data, String logo) throws MalformedURLException, IOException;

}
