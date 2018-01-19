package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Questa classe crea il pdf della richiesta di convenzione/tirocinio e viene chiamata tramite l'adapter interface.
 * @author Mario Procida
 *
 */
public class PdfCreator implements PdfCreatorAdapter{

  /**
   * Questo metodo crea un pdf per la richiesta di convenzione 
   * prendendo come parametri i vari dati della richiesta inoltrata tramite form.
   * @author Mario Procida
   */
  @Override
  public ByteArrayOutputStream creaPdfConv(String nomeAz, String piva, String descrizione,
      String numPosti, String data, String logo) throws MalformedURLException, IOException {
    
   
    //font da utilizzare
    Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD,
        new BaseColor(0, 0, 0)); 
    
    Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC,
        new BaseColor(0, 0, 0)); 
    
    Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12,Font.BOLD); 
     
    Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    try {   
        
      //proprietà header
      doc.addAuthor("utente");
      doc.addCreationDate();
      doc.addProducer();
      doc.addCreator("TirocinioSmart");
      doc.addTitle("Richiesta");
      doc.setPageSize(PageSize.LETTER);
      PdfWriter.getInstance(doc, baos);
      doc.open();
        
      //aggiunta paragraph 
      Image logoDip = Image.getInstance(logo);
      logoDip.setAlignment(logoDip.MIDDLE);
      doc.add(logoDip);
        
      Paragraph dipInf = new Paragraph("Università degli Studi di Salerno -"
          + "Dipartimento di Informatica", bfBold12);
      dipInf.setAlignment(dipInf.ALIGN_CENTER);
      doc.add(dipInf);
        
      Paragraph title = new Paragraph("Dati Richiesta di Convenzione", bfBold18);
      title.setAlignment(title.ALIGN_CENTER);
        
      doc.add(title);
        
      doc.add(new Paragraph("Nome Azienda:  " + nomeAz, bf12));
      
      doc.add(new Paragraph("Partita Iva:  " + piva, bf12));
      
      doc.add(new Paragraph("Descrizione Tirocinio:  "
          + descrizione, bf12));
      
      doc.add(new Paragraph("Numeri Posti Tirocinio:  "
          + numPosti, bf12));
      doc.add(new Paragraph("Data:  " + data,bf12));
        
      Paragraph firma = new Paragraph("Firma:", bf12);
      firma.setAlignment(firma.ALIGN_BOTTOM);
      firma.setAlignment(firma.ALIGN_RIGHT);
      doc.add(firma);
      
      doc.close(); 
      
        
    } catch (DocumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return baos;
   
  }

  /**
   * Questo metodo crea un pdf per la richiesta di tirocinio 
   * prendendo come parametri i vari dati della richiesta inoltrata tramite form.
   * @author Mario Procida
   */
  @Override
  public ByteArrayOutputStream creaPdfTir(String nome, String cognome, String matricola, String nomeAzienda,
      String tutor, String data, String logo) throws MalformedURLException, IOException{
  //font da utilizzare
    Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD,
          new BaseColor(0, 0, 0));
    
    Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC,
          new BaseColor(0, 0, 0)); 
    Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12,Font.BOLD); 
     
    Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    try {
       
      //proprietà header
      doc.addAuthor("utente");
      doc.addCreationDate();
      doc.addProducer();
      doc.addCreator("TirocinioSmart");
      doc.addTitle("Richiesta");
      doc.setPageSize(PageSize.LETTER);
      PdfWriter.getInstance(doc, baos);
      doc.open();
        
      //aggiunta paragraph
      Image logoDip = Image.getInstance(logo);
      logoDip.setAlignment(logoDip.MIDDLE);
      doc.add(logoDip);
        
      Paragraph dipInf = new Paragraph("Università degli Studi di Salerno -"
          + "Dipartimento di Informatica", bfBold12);
      
      dipInf.setAlignment(dipInf.ALIGN_CENTER);
      doc.add(dipInf);
        
      Paragraph title = new Paragraph("Dati Richiesta di Tirocinio", bfBold18);
      title.setAlignment(title.ALIGN_CENTER);
      doc.add(title);
        
      doc.add(new Paragraph("Nome:  " + nome, bf12));
      doc.add(new Paragraph("Cognome:  " + cognome, bf12));
      doc.add(new Paragraph("Matricola: " + matricola, bf12));
      doc.add(new Paragraph("Nome azienda scelta che offre il tirocinio:  " + nomeAzienda, bf12));
      doc.add(new Paragraph("Tutor Accademico scelto:  "
          + tutor, bf12));
      
      doc.add(new Paragraph("Data:  " + data,bf12));
        
      Paragraph firma = new Paragraph("Firma:", bf12);
      firma.setAlignment(firma.ALIGN_BOTTOM);
      firma.setAlignment(firma.ALIGN_RIGHT);
      doc.add(firma);
        
      doc.close(); 
        
        
    } catch (DocumentException e) {
      
      e.printStackTrace();
    }
    
    return baos;
  }
  
}
